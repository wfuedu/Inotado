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

import org.apache.commons.lang.StringUtils;

import edu.wfu.inotado.marshalobj.sc.ScAssignment;
import edu.wfu.inotado.marshalobj.sc.ScAssignmentSubmitssion;
import edu.wfu.inotado.marshalobj.sc.ScCourse;
import edu.wfu.inotado.marshalobj.sc.ScCourseDocument;
import edu.wfu.inotado.marshalobj.sc.ScCourseStandard;
import edu.wfu.inotado.marshalobj.sc.ScEnrollment;
import edu.wfu.inotado.marshalobj.sc.ScGrade;
import edu.wfu.inotado.marshalobj.sc.ScGradePart;
import edu.wfu.inotado.marshalobj.sc.ScGradeScale;
import edu.wfu.inotado.marshalobj.sc.ScRubric;
import edu.wfu.inotado.marshalobj.sc.ScSchool;
import edu.wfu.inotado.marshalobj.win.Profiles;
import edu.wfu.inotado.marshalobj.win.User;
import edu.wfu.inotado.marshalobj.win.Users;
import edu.wfu.inotado.marshalobj.win.Winrequest;

public class MarshalHelperTest extends InotadoTestBase {

	public void testMarshalNull() {
		Winrequest request = null;
		String str = super.marshHelper.marshal(request);
		// a blank string is expected
		assertEquals("", str);
	}

	public void testUnmarshalNull() {
		Object obj = super.marshHelper.unmarshal(null);
		// a null object is expected
		assertNull(obj);
	}

	public void testMarshalRequest() {
		Users users = new Users();
		User user1 = new User();
		user1.setId("user1");
		User user2 = new User();
		user2.setId("user2");
		users.getUsers().add(user1);
		users.getUsers().add(user2);
		Winrequest request = new Winrequest();
		request.setUsers(users);
		request.setFormat("xml");
		request.setUsertype("student");
		String str = super.marshHelper.marshal(request);
		assertTrue(!StringUtils.isEmpty(str));
	}

	public void testUnmarshalRequest() {
		Winrequest requestObj = super.marshHelper.unmarshal(super
				.readXmlFromFile("WinProfileRequest.xml"));
		assertNotNull(requestObj);
		assertEquals("xml", requestObj.getFormat());
	}

	public void testUnmarshalResponse() {
		Profiles profiles = super.marshHelper.unmarshal(super
				.readXmlFromFile("WinProfileResponse.xml"));
		assertNotNull(profiles);
		assertEquals(4, profiles.getUsers().size());
	}

	public void testMarshalJson() {
		Users users = new Users();
		User user1 = new User();
		user1.setId("user1");
		User user2 = new User();
		user2.setId("user2");
		users.getUsers().add(user1);
		users.getUsers().add(user2);
		Winrequest request = new Winrequest();
		request.setUsers(users);
		String json = super.marshHelper.marshalJson(request);
		assertEquals(
				"{\"users\":{\"users\":[{\"id\":\"user1\"},{\"id\":\"user2\"}]}}",
				json);
	}

	public void testUnmarshalJson() {
		Winrequest request = super.marshHelper
				.unmarshalJson(
						"{\"users\":{\"users\":[{\"id\":\"user1\"},{\"id\":\"user2\"}]}}",
						Winrequest.class);
		assertEquals("user1", request.getUsers().getUsers().get(0).getId());
	}

	public void testUnmarshalSchool() {
		ScSchool school = super.marshHelper.unmarshalJson(
				super.readJsonFromFile("School.json"), ScSchool.class);
		assertNotNull(school);
		assertEquals(51, school.getid());
		assertEquals("false", school.getsandbox());
		assertEquals("sakai.schoolchapters.com",
				school.gettool_consumer_instance_guid());
		String str = super.marshHelper.marshalJson(school);
		System.out.println(str);
	}

	@SuppressWarnings("unchecked")
	public void testUnmarshalCourses() {
		List<ScCourse> list = (List<ScCourse>) super.marshHelper.unmarshalJson(
				super.readJsonFromFile("Courses.json"), ScCourse.class);
		assertNotNull(list);
		// assertEquals(1, courses.getCourse().size());
		String str = super.marshHelper.marshalJson(list);
		System.out.println(super.marshHelper.prettyPrintJson(str));
	}

	public void testUnmarshalCourse() {
		ScCourse course = super.marshHelper.unmarshalJson(
				super.readJsonFromFile("Course.json"), ScCourse.class);
		assertNotNull(course);

		assertEquals("2013-08-16T02:42:14-04:00", course.getupdated_at());
		assertEquals("college", course.getkind());

		// check enrollments
		List<ScEnrollment> enrollments = course.getenrollments();
		assertEquals(2, enrollments.size());
		ScEnrollment enrollment = enrollments.get(0);
		assertEquals(11919, enrollment.getid());
		assertEquals("false", enrollment.getstudent_peekable());

		// check course documents
		List<ScCourseDocument> courseDocuments = course.getcourse_documents();
		assertEquals(2, courseDocuments.size());
		ScCourseDocument courseDocument = courseDocuments.get(1);
		assertEquals(1005, courseDocument.getcourse_id());

		// check course standards
		List<ScCourseStandard> courseStandards = course.getcourse_standards();
		assertEquals(0, courseStandards.size());

		// check assignments
		List<ScAssignment> assignments = course.getassignments();
		assertEquals(5, assignments.size());
		ScAssignment assignment = assignments.get(2);
		assertEquals("Sakai Manual", assignment.getname());

	}

	public void testUnmarshalEnrollment() {
		ScEnrollment enrollment = super.marshHelper.unmarshalJson(
				super.readJsonFromFile("Enrollment.json"), ScEnrollment.class);
		assertNotNull(enrollment);
		// assertEquals(1, courses.getCourse().size());
		String str = super.marshHelper.marshalJson(enrollment);
		System.out.println(super.marshHelper.prettyPrintJson(str));
	}

	@SuppressWarnings("unchecked")
	public void testUnmarshalAssignments() {
		ScAssignment assignment = ((List<ScAssignment>) super.marshHelper
				.unmarshalJson(super.readJsonFromFile("Assignments.json"),
						ScAssignment.class)).get(0);

		assertEquals(1469, assignment.getcourse_id());
		assertEquals("CSC 101 10 Spring 2013", assignment.getcourse().getbbid());

		// check assignment submissions
		ScAssignmentSubmitssion assignmentSubmitssion = assignment
				.getassignment_submissions().get(0);

		assertEquals("http://sakai.schoolchapters.com:8080/imsblis/service/",
				assignmentSubmitssion.getpassback_url());

		ScGrade grade = assignmentSubmitssion.getgrade();
		assertEquals(100.0, grade.gettotal_score());

		ScGradePart gradePart = grade.getgrade_parts().get(0);
		assertEquals("2014-10-16T11:23:03-04:00", gradePart.getupdated_at());

		ScGradeScale gradeScale = gradePart.getrubric_criterion()
				.getgrade_scales().get(3);
		assertEquals(80.0, gradeScale.getscore());

		// check user
		assertEquals("Student", assignmentSubmitssion.getuser().getlast_name());

		// check rubric
		ScRubric rubric = assignment.getrubric();
		assertEquals(100.0, rubric.getperfect_score());
		ScGradeScale gradeScale2 = rubric.getrubric_criterions().get(0)
				.getgrade_scales().get(1);
		assertEquals(613, gradeScale2.getrubric_criterion_id());
	}

}
