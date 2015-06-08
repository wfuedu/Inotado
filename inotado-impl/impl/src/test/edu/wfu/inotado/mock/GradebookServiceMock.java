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

package edu.wfu.inotado.mock;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.sakaiproject.service.gradebook.shared.AssessmentNotFoundException;
import org.sakaiproject.service.gradebook.shared.Assignment;
import org.sakaiproject.service.gradebook.shared.AssignmentHasIllegalPointsException;
import org.sakaiproject.service.gradebook.shared.CategoryDefinition;
import org.sakaiproject.service.gradebook.shared.CommentDefinition;
import org.sakaiproject.service.gradebook.shared.ConflictingAssignmentNameException;
import org.sakaiproject.service.gradebook.shared.ConflictingExternalIdException;
import org.sakaiproject.service.gradebook.shared.GradeDefinition;
import org.sakaiproject.service.gradebook.shared.GradebookNotFoundException;
import org.sakaiproject.service.gradebook.shared.GradebookService;
import org.sakaiproject.service.gradebook.shared.InvalidGradeException;
import org.sakaiproject.service.gradebook.shared.StaleObjectModificationException;

public class GradebookServiceMock implements GradebookService{

	@Override
	public void addAssignment(String arg0, Assignment arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addExternalAssessment(String arg0, String arg1, String arg2,
			String arg3, double arg4, Date arg5, String arg6)
			throws GradebookNotFoundException,
			ConflictingAssignmentNameException, ConflictingExternalIdException,
			AssignmentHasIllegalPointsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addExternalAssessment(String arg0, String arg1, String arg2,
			String arg3, Double arg4, Date arg5, String arg6, Boolean arg7)
			throws GradebookNotFoundException,
			ConflictingAssignmentNameException, ConflictingExternalIdException,
			AssignmentHasIllegalPointsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addGradebook(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkStudentsNotSubmitted(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkStuendsNotSubmitted(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean currentUserHasEditPerm(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean currentUserHasGradeAllPerm(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean currentUserHasGradingPerm(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean currentUserHasViewOwnGradesPerm(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteGradebook(String arg0) throws GradebookNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizeGrades(String arg0) throws GradebookNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Assignment getAssignment(String arg0, String arg1)
			throws GradebookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Assignment getAssignment(String arg0, Long arg1)
			throws AssessmentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getAssignmentScore(String arg0, String arg1, String arg2)
			throws GradebookNotFoundException, AssessmentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getAssignmentScore(String arg0, Long arg1, String arg2)
			throws GradebookNotFoundException, AssessmentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentDefinition getAssignmentScoreComment(String arg0,
			String arg1, String arg2) throws GradebookNotFoundException,
			AssessmentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentDefinition getAssignmentScoreComment(String arg0, Long arg1,
			String arg2) throws GradebookNotFoundException,
			AssessmentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAssignmentScoreString(String arg0, String arg1, String arg2)
			throws GradebookNotFoundException, AssessmentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAssignmentScoreString(String arg0, Long arg1, String arg2)
			throws GradebookNotFoundException, AssessmentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAssignments(String arg0) throws GradebookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAverageCourseGrade(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map getCalculatedCourseGrade(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map getCalculatedCourseGrade(String arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getCategories(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDefinition> getCategoryDefinitions(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map getEnteredCourseGrade(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GradeDefinition getGradeDefinitionForStudentForItem(String arg0,
			Long arg1, String arg2) throws GradebookNotFoundException,
			AssessmentNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getGradeEntryType(String arg0) throws GradebookNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getGradeViewFunctionForUserForStudentForItem(String arg0,
			Long arg1, String arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGradeViewFunctionForUserForStudentForItem(String arg0,
			String arg1, String arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getGradebook(String arg0) throws GradebookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGradebookDefinitionXml(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GradeDefinition> getGradesForStudentsForItem(String arg0,
			Long arg1, List<String> arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map getImportCourseGrade(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map getImportCourseGrade(String arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLowestPossibleGradeForGbItem(String arg0, Long arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Assignment> getViewableAssignmentsForCurrentUser(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map getViewableSectionUuidToNameMap(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getViewableStudentsForItemForCurrentUser(
			String arg0, Long arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getViewableStudentsForItemForUser(String arg0,
			String arg1, Long arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> identifyStudentsWithInvalidGrades(String arg0,
			Map<String, String> arg1) throws GradebookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAssignmentDefined(String arg0, String arg1)
			throws GradebookNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExternalAssignmentDefined(String arg0, String arg1)
			throws GradebookNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGradableObjectDefined(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGradeValid(String arg0, String arg1)
			throws GradebookNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGradebookDefined(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PointsPossibleValidation isPointsPossibleValid(String arg0,
			Assignment arg1, Double arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUserAbleToGradeItemForStudent(String arg0, Long arg1,
			String arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUserAbleToGradeItemForStudent(String arg0, String arg1,
			String arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUserAbleToViewItemForStudent(String arg0, Long arg1,
			String arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUserAbleToViewItemForStudent(String arg0, String arg1,
			String arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUserAllowedToGrade(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUserAllowedToGradeAll(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void mergeGradebookDefinitionXml(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAssignment(Long arg0)
			throws StaleObjectModificationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCategory(Long arg0)
			throws StaleObjectModificationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeExternalAssessment(String arg0, String arg1)
			throws GradebookNotFoundException, AssessmentNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveGradeAndCommentForStudent(String arg0, Long arg1,
			String arg2, String arg3, String arg4)
			throws InvalidGradeException, GradebookNotFoundException,
			AssessmentNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveGradesAndComments(String arg0, Long arg1,
			List<GradeDefinition> arg2) throws InvalidGradeException,
			GradebookNotFoundException, AssessmentNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAssignmentScore(String arg0, String arg1, String arg2,
			Double arg3, String arg4) throws GradebookNotFoundException,
			AssessmentNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAssignmentScoreComment(String arg0, String arg1,
			String arg2, String arg3) throws GradebookNotFoundException,
			AssessmentNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAssignmentScoreString(String arg0, String arg1, String arg2,
			String arg3, String arg4) throws GradebookNotFoundException,
			AssessmentNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAvailableGradingScales(Collection arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDefaultGradingScale(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferGradebookDefinitionXml(String arg0, String arg1,
			String arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAssignment(String arg0, String arg1, Assignment arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateExternalAssessment(String arg0, String arg1, String arg2,
			String arg3, double arg4, Date arg5)
			throws GradebookNotFoundException, AssessmentNotFoundException,
			ConflictingAssignmentNameException,
			AssignmentHasIllegalPointsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateExternalAssessment(String arg0, String arg1, String arg2,
			String arg3, Double arg4, Date arg5)
			throws GradebookNotFoundException, AssessmentNotFoundException,
			ConflictingAssignmentNameException,
			AssignmentHasIllegalPointsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateExternalAssessmentScore(String arg0, String arg1,
			String arg2, Double arg3) throws GradebookNotFoundException,
			AssessmentNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateExternalAssessmentScores(String arg0, String arg1,
			Map arg2) throws GradebookNotFoundException,
			AssessmentNotFoundException {
		// TODO Auto-generated method stub
		
	}}
