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

package edu.wfu.inotado;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.wfu.inotado.marshalobj.sc.ScAssignment;
import edu.wfu.inotado.marshalobj.sc.ScAssignmentSubmitssion;
import edu.wfu.inotado.marshalobj.sc.ScGrade;
import edu.wfu.inotado.marshalobj.sc.ScRubric;
import edu.wfu.inotado.marshalobj.sc.ScSchool;
import edu.wfu.inotado.marshalobj.sc.ScUser;
import edu.wfu.inotado.model.ScGradeScaleDTO;
import edu.wfu.inotado.model.ScRubricCriterionDTO;
import edu.wfu.inotado.model.ScRubricDTO;

public class SyncResourcesServiceTest extends InotadoTestBase {

	private final Log log = LogFactory.getLog(this.getClass());

	public void testGetSchools() {
		String json = super.readJsonFromFile("Schools.json");
		List<ScSchool> schools = super.syncResourcesService.getSchools(json);
		assertNotNull(schools);
		assertEquals(1, schools.size());

	}

	public void testupdateAssignmentWithGrades() {
		super.syncResourcesService
				.updateAssignmentWithGrades(getScAssignment());
	}

	public void testSaveRubric() {
		ScAssignment assignment = super.marshHelper.unmarshalJson(
				super.readJsonFromFile("Assignment.json"), ScAssignment.class);
		ScRubric rubric = assignment.getrubric();
		super.syncResourcesService.saveRubric(rubric);
		ScRubricDTO rubricDTO = super.schoolChaptersDao.findById(
				ScRubricDTO.class, 69);
		assertNotNull(rubricDTO);
		assertEquals(100.0, rubricDTO.getPrefectScore());
		assertNotNull(rubricDTO.getCreatedAt());
		assertEquals("Tue Feb 19 13:08:22 EST 2013", rubricDTO.getUpdatedAt()
				.toString());
		
		ScRubricCriterionDTO criterionDTO = super.schoolChaptersDao.findById(ScRubricCriterionDTO.class, 613);
		assertNotNull(criterionDTO);
		assertEquals("Grade", criterionDTO.getName());
		assertEquals(true, criterionDTO.isGradable());
		
		ScGradeScaleDTO gradeScaleDTO = super.schoolChaptersDao.findById(ScGradeScaleDTO.class, 2775);
		assertEquals(60.0, gradeScaleDTO.getScore());
		assertEquals("D", gradeScaleDTO.getName());
		gradeScaleDTO = super.schoolChaptersDao.findById(ScGradeScaleDTO.class, 2777);
		assertEquals(613, gradeScaleDTO.getRubricCriterionId());
	}

	private ScAssignment getScAssignment() {
		ScAssignment scAssignment = new ScAssignment();
		scAssignment.setname("School Chapter Assignment");
		ScRubric scRubric = new ScRubric();
		scRubric.setperfect_score(100.0);
		scAssignment.setrubric(scRubric);
		ScAssignmentSubmitssion scAssignmentSubmitssion = new ScAssignmentSubmitssion();
		ScGrade scGrade = new ScGrade();
		scGrade.settotal_score(85.0);
		scAssignmentSubmitssion.setgrade(scGrade);
		ScUser scUser = new ScUser();
		scUser.setlms_identifier("fulpc");
		scAssignmentSubmitssion.setuser(scUser);
		scAssignment.addassignment_submissions(scAssignmentSubmitssion);

		ScAssignment.course scCourse = new ScAssignment.course();
		// course site "ENG 100 A 201480"
		scCourse.setlms_identifier("7ebd7448-fcff-4884-ad58-e25f07ae8fb3");
		scAssignment.setcourse(scCourse);

		return scAssignment;

	}

}
