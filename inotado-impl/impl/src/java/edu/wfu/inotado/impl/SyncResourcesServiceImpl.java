/*Licensed to The Apereo Foundation under one or more contributor license
agreements. See the NOTICE file distributed with this work for
additional information regarding copyright ownership.

The Apereo Foundation licenses this file to you under the Apache License,
Version 2.0 (the "License"); you may not use this file except in
compliance with the License. You may obtain a copy of the License at:

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.

See the License for the specific language governing permissions and
limitations under the License.*/

package edu.wfu.inotado.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.component.api.ServerConfigurationService;
import org.sakaiproject.component.cover.ComponentManager;
import org.sakaiproject.exception.IdUnusedException;
import org.sakaiproject.service.gradebook.shared.Assignment;
import org.sakaiproject.service.gradebook.shared.ConflictingAssignmentNameException;
import org.sakaiproject.service.gradebook.shared.GradebookNotFoundException;
import org.sakaiproject.service.gradebook.shared.GradebookService;
import org.sakaiproject.site.api.Site;
import org.sakaiproject.site.api.SiteService;
import org.sakaiproject.user.api.User;
import org.sakaiproject.user.api.UserDirectoryService;
import org.sakaiproject.user.api.UserNotDefinedException;

import edu.wfu.inotado.api.Constants;
import edu.wfu.inotado.api.SyncResourcesService;
import edu.wfu.inotado.api.WakeUtils;
import edu.wfu.inotado.dao.GenericSakaiDao;
import edu.wfu.inotado.dao.SchoolChaptersDao;
import edu.wfu.inotado.helper.MarshalHelper;
import edu.wfu.inotado.helper.RestClientHelper;
import edu.wfu.inotado.marshalobj.sc.ScAssignment;
import edu.wfu.inotado.marshalobj.sc.ScAssignmentSubmitssion;
import edu.wfu.inotado.marshalobj.sc.ScCourse;
import edu.wfu.inotado.marshalobj.sc.ScGrade;
import edu.wfu.inotado.marshalobj.sc.ScGradePart;
import edu.wfu.inotado.marshalobj.sc.ScGradeScale;
import edu.wfu.inotado.marshalobj.sc.ScRubric;
import edu.wfu.inotado.marshalobj.sc.ScRubricCriterion;
import edu.wfu.inotado.marshalobj.sc.ScSchool;
import edu.wfu.inotado.marshalobj.sc.ScUser;
import edu.wfu.inotado.model.ScGradeDTO;
import edu.wfu.inotado.model.ScGradePartDTO;
import edu.wfu.inotado.model.ScGradeScaleDTO;
import edu.wfu.inotado.model.ScRubricCriterionDTO;
import edu.wfu.inotado.model.ScRubricDTO;

public class SyncResourcesServiceImpl implements SyncResourcesService {

	private final Log log = LogFactory.getLog(this.getClass());

	private GradebookService gradebookService;

	private UserDirectoryService userDirectoryService;

	private SiteService siteService;

	private MarshalHelper marshalHelper;

	private RestClientHelper restClientHelper;

	private SchoolChaptersDao schoolChaptersDao;

	private GenericSakaiDao genericSakaiDao;

	private ServerConfigurationService configurationService;

	private final String SC_SERVER_URL = "schoolchapters.url";

	public void setRestClientHelper(RestClientHelper restClientHelper) {
		this.restClientHelper = restClientHelper;
	}

	public void setMarshalHelper(MarshalHelper marshalHelper) {
		this.marshalHelper = marshalHelper;
	}

	public void setSchoolChaptersDao(SchoolChaptersDao schoolChaptersDao) {
		this.schoolChaptersDao = schoolChaptersDao;
	}

	public void setGenericSakaiDao(GenericSakaiDao genericSakaiDao) {
		this.genericSakaiDao = genericSakaiDao;
	}

	public void init() {
		gradebookService = (GradebookService) ComponentManager
				.get("org.sakaiproject.service.gradebook.GradebookService");
		userDirectoryService = (UserDirectoryService) ComponentManager
				.get(UserDirectoryService.class);
		siteService = (SiteService) ComponentManager.get(SiteService.class);
		configurationService = (ServerConfigurationService) ComponentManager
				.get(ServerConfigurationService.class);

	}

	@Override
	public boolean login(String pin) {
		boolean isLoggedIn = false;

		return isLoggedIn;
	}

	@Override
	public boolean getCourses(String url) {
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ScSchool> getSchools(String json) {
		List<ScSchool> returnSchools = new ArrayList<ScSchool>();

		List<ScSchool> schools = (List<ScSchool>) this.marshalHelper
				.unmarshalJson(json, ScSchool.class);
		if (schools != null && schools.size() > 0) {
			returnSchools = schools;
		} else {
			log.warn("No schools exist in the reply.");
		}
		return returnSchools;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void updateAssignmentWithGrades(ScAssignment scAssignment) {
		String siteId = null;
		String siteName = null;
		String userId = null;
		String name = null;

		try {
			siteId = scAssignment.getcourse().getlms_identifier();
			siteName = scAssignment.getcourse().getname();

			// Skip the process if no site found
			Site site = siteService.getSite(siteId);
			if (site == null) {
				log.warn("Unable to find any site with id: " + siteId);
				log.warn("Skip updating assignment.");
				return;
			}

			// Save rubric
			this.saveRubric(scAssignment.getrubric());

			// Find existing assignment or create a new assignment if not found
			Assignment assignment = getOrMakeAssignment(scAssignment, siteId);
			// Skip the process if assignment was not found from previous step
			if (assignment == null) {
				return;
			}

			boolean isAssignmentUpdated = false;

			List<ScAssignmentSubmitssion> scAssignmentSubmitssions = scAssignment
					.getassignment_submissions();
			for (ScAssignmentSubmitssion scAssignmentSubmitssion : scAssignmentSubmitssions) {
				ScUser user = scAssignmentSubmitssion.getuser();
				userId = user.getlms_identifier();
				name = user.getfirst_name() + " " + user.getlast_name();
				User sakaiUser = null;
				if (StringUtils.isBlank(userId)
						|| StringUtils.equalsIgnoreCase(userId, "null")) {
					String email = user.getemail();
					List<User> users = (List<User>) userDirectoryService
							.findUsersByEmail(email);
					// get the first user with matching email
					if (users.size() > 0) {
						sakaiUser = users.get(0);
					} else {
						// Skip this user
						log.warn("No user found with email: " + email);
						continue;
					}
				} else {
					sakaiUser = userDirectoryService.getUserByEid(userId);
				}
				String sakaiUserId = sakaiUser.getId();
				userId = sakaiUser.getEid();

				double grade = scAssignmentSubmitssion.getgrade()
						.gettotal_score();

				// Skip if user does not exist in the site
				if (site.getMember(sakaiUserId) == null) {
					// User does not exist in this site
					log.warn("User " + userId + " is not a member of site \""
							+ site.getTitle() + "\"(" + siteId + ")");
					continue;
				}

				String assignmentName = assignment.getName();

				Double exGrade = gradebookService.getAssignmentScore(siteId,
						assignmentName, sakaiUserId);
				if (exGrade != null && exGrade == grade) {
					log.debug("Exact grade entry already exists for user "
							+ sakaiUserId);
				} else {
					gradebookService.setAssignmentScore(siteId, assignmentName,
							sakaiUserId, grade, "External Sync");

					// update the assignment to reflect its external properties
					if (!isAssignmentUpdated) {
						Assignment asm = gradebookService.getAssignment(siteId,
								assignmentName);
						// update external app name
						this.genericSakaiDao.updateAssignment(asm.getId(),
								Constants.SCHOOL_CHAPTERS);
						isAssignmentUpdated = true;
					}
				}

				// save to school chapters table
				this.saveAssignmentSubmittion(scAssignmentSubmitssion, siteId,
						assignmentName, sakaiUserId);
			}
			log.info("Successfully processed site \"" + site.getTitle() + "\"("
					+ site.getId() + ").");
		} catch (IdUnusedException e) {
			log.warn("Unable to find site \"" + siteName
					+ "\" with lms_identifier " + siteId);
		} catch (UserNotDefinedException e) {
			log.warn("Unalble to find user " + name + " with lms_identifier "
					+ userId);
		} catch (Exception e) {
			log.warn("Unexpected error occurred", e);
		}

	}

	@SuppressWarnings("rawtypes")
	public Assignment getOrMakeAssignment(ScAssignment scAssignment,
			String siteId) {
		Assignment assignmentObject = null;
		String assignmentName = scAssignment.getname();
		try {
			List gradebookAssignments = gradebookService.getAssignments(siteId);
			for (Iterator i = gradebookAssignments.iterator(); i.hasNext();) {
				Assignment gAssignment = (Assignment) i.next();
				if (gAssignment.isExternallyMaintained())
					continue;
				if (StringUtils.equals(assignmentName, gAssignment.getName())) {
					assignmentObject = gAssignment;
					break;
				}
			}
		} catch (Exception e) {
			assignmentObject = null; // Just to make double sure
		}

		// Attempt to add assignment to grade book
		if (assignmentObject == null
				&& gradebookService.isGradebookDefined(siteId)) {
			try {
				assignmentObject = new Assignment();
				assignmentObject.setPoints((double) scAssignment.getrubric()
						.getperfect_score());
				assignmentObject.setExternallyMaintained(false);
				assignmentObject.setName(scAssignment.getname());
				assignmentObject.setReleased(true);
				assignmentObject.setUngraded(false);
				gradebookService.addAssignment(siteId, assignmentObject);
				log.info("Added assignment: " + assignmentName);
			} catch (ConflictingAssignmentNameException e) {
				log.warn("ConflictingAssignmentNameException while adding assignment"
						+ e.getMessage());
				assignmentObject = null; // Just to make double sure
			} catch (GradebookNotFoundException e) {
				log.warn("GradebookNotFoundException (may be because GradeBook has not yet been added to the Site) "
						+ e.getMessage());
				log.warn(this + ":addGradeItem " + e.getMessage());
			} catch (Exception e) {
				log.warn("Unable to process the assignment. " + e);
			}
		}
		return assignmentObject;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean syncAssignments() throws Exception {
		boolean status = false;
		String response = restClientHelper.getFromService(
				Constants.SCHOOL_CHAPTERS,
				WakeUtils.getInstance().getUrl(
						configurationService.getString(SC_SERVER_URL),
						Constants.SCHOOL_CHAPTERS_WS_URL_COURSES));
		List<ScCourse> courses = (List<ScCourse>) marshalHelper.unmarshalJson(
				response, ScCourse.class);
		for (ScCourse course : courses) {
			int courseId = course.getid();
			String courseLmsIdentifier = course.getlms_identifier();
			// get assignment only when the site exists
			if (siteService.siteExists(courseLmsIdentifier)) {
				response = restClientHelper
						.getFromService(
								Constants.SCHOOL_CHAPTERS,
								WakeUtils
										.getInstance()
										.getUrl(configurationService
												.getString(SC_SERVER_URL),
												Constants.SCHOOL_CHAPTERS_WS_URL_ASSIGNMENT_BY_COURSE)
										+ courseId);
				List<ScAssignment> assignments = (List<ScAssignment>) marshalHelper
						.unmarshalJson(response, ScAssignment.class);
				for (ScAssignment assignment : assignments) {
					this.updateAssignmentWithGrades(assignment);
				}
			} else {
				log.warn("Unable to find site " + courseLmsIdentifier);
			}
		}
		return status;
	}

	@Override
	public void saveAssignmentSubmittion(
			ScAssignmentSubmitssion assignmentSubmitssion, String siteId,
			String assignmentName, String userId) {
		ScGrade scGrade = assignmentSubmitssion.getgrade();

		// save schoolchapters' grade
		if (scGrade != null) {
			ScGradeDTO gradeDTO = new ScGradeDTO();
			gradeDTO.setId(scGrade.getid());

			// find the id from gb_
			Assignment assignment = this.gradebookService.getAssignment(siteId,
					assignmentName);
			Long gradableObjectId = assignment.getId();
			long id = this.genericSakaiDao.getGradeRecordIdByUser(userId,
					gradableObjectId);

			gradeDTO.setGradeId((int) id);
			gradeDTO.setId(scGrade.getid());
			gradeDTO.setRubricId(scGrade.getrubric_id());
			gradeDTO.setCreatedAt(this.getDateFromScString(scGrade
					.getcreated_at()));
			gradeDTO.setUpdatedAt(this.getDateFromScString(scGrade
					.getupdated_at()));
			ScGradeDTO existingDTO = this.schoolChaptersDao.findById(
					ScGradeDTO.class, scGrade.getid());
			this.schoolChaptersDao.save(gradeDTO, existingDTO);

			// save grade parts
			List<ScGradePart> gradeParts = scGrade.getgrade_parts();
			for (ScGradePart gradePart : gradeParts) {
				this.saveGradePart(gradePart);
			}
		}

	}

	private void saveGradePart(ScGradePart gradePart) {
		ScGradePartDTO gradePartDTO = new ScGradePartDTO();
		gradePartDTO.setId(gradePart.getid());
		gradePartDTO.setGradeId(gradePart.getgrade_id());
		gradePartDTO.setGradeScaleId(gradePart.getgrade_scale_id());
		gradePartDTO.setRubricCriterionId(gradePart.getrubric_criterion_id());
		gradePartDTO.setScore(gradePart.getscore());
		gradePartDTO.setCreatedAt(this.getDateFromScString(gradePart
				.getcreated_at()));
		gradePartDTO.setUpdatedAt(this.getDateFromScString(gradePart
				.getupdated_at()));

		this.schoolChaptersDao.save(
				gradePartDTO,
				this.schoolChaptersDao.findById(ScGradePartDTO.class,
						gradePart.getid()));
	}

	@Override
	public void saveRubric(ScRubric rubric) {
		if (rubric == null) {
			log.debug("Rubric is null");
			return;
		} else {
			// process and save rubric
			ScRubricDTO rubricDTO = new ScRubricDTO();
			rubricDTO.setAnnotation(rubric.getannotation());
			rubricDTO.setBaseScore(rubric.getbase_score());
			rubricDTO.setPrefectScore(rubric.getperfect_score());
			rubricDTO.setCreatedAt(this.getDateFromScString(rubric
					.getcreated_at()));
			rubricDTO.setUpdatedAt(this.getDateFromScString(rubric
					.getupdated_at()));
			rubricDTO.setId(rubric.getid());
			rubricDTO.setId(rubric.getid());
			rubricDTO.setName(rubric.getname());
			this.schoolChaptersDao.save(rubricDTO, this.schoolChaptersDao
					.findById(ScRubricDTO.class, rubricDTO.getId()));
			// process and save rubric criterion
			List<ScRubricCriterion> rubricCriterionsList = rubric
					.getrubric_criterions();
			for (ScRubricCriterion rubricCriterion : rubricCriterionsList) {
				this.saveRubricCriterion(rubricCriterion);

				// process and save grade scale
				List<ScGradeScale> gradeScaleList = rubricCriterion
						.getgrade_scales();
				for (ScGradeScale gradeScale : gradeScaleList) {
					this.saveGradeScale(gradeScale);
				}
			}

		}
	}

	private void saveRubricCriterion(ScRubricCriterion rubricCriterion) {
		ScRubricCriterionDTO rubricCriterionDTO = new ScRubricCriterionDTO();
		rubricCriterionDTO.setId(rubricCriterion.getid());
		rubricCriterionDTO.setId(rubricCriterion.getid());
		rubricCriterionDTO.setGradable(Boolean.parseBoolean(rubricCriterion
				.getgradable()));
		rubricCriterionDTO.setMaxScore(rubricCriterion.getmax_score());
		rubricCriterionDTO.setMinScore(rubricCriterion.getmin_score());
		rubricCriterionDTO.setName(rubricCriterion.getname());
		rubricCriterionDTO.setRubricId(rubricCriterion.getrubric_id());
		rubricCriterionDTO.setCreatedAt(this
				.getDateFromScString(rubricCriterion.getcreated_at()));
		rubricCriterionDTO.setUpdatedAt(this
				.getDateFromScString(rubricCriterion.getupdated_at()));
		this.schoolChaptersDao.save(rubricCriterionDTO, this.schoolChaptersDao
				.findById(ScRubricCriterionDTO.class, rubricCriterion.getid()));

	}

	private void saveGradeScale(ScGradeScale gradeScale) {
		ScGradeScaleDTO gradeScaleDTO = new ScGradeScaleDTO();
		gradeScaleDTO.setId(gradeScale.getid());
		gradeScaleDTO.setName(gradeScale.getname());
		gradeScaleDTO.setRubricCriterionId(gradeScale.getrubric_criterion_id());
		gradeScaleDTO.setScore(gradeScale.getscore());
		gradeScaleDTO.setCreatedAt(this.getDateFromScString(gradeScale
				.getcreated_at()));
		gradeScaleDTO.setUpdatedAt(this.getDateFromScString(gradeScale
				.getupdated_at()));

		this.schoolChaptersDao.save(gradeScaleDTO, this.schoolChaptersDao
				.findById(ScGradeScaleDTO.class, gradeScale.getid()));

	}

	public Date getDateFromScString(String dateTimeStr) {
		Date date = null;
		SimpleDateFormat format = new SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ssXXX");
		try {
			date = format.parse(dateTimeStr);
		} catch (Exception e) {
			log.error("Unable to parse date String: " + dateTimeStr);
		}
		return date;
	}
}
