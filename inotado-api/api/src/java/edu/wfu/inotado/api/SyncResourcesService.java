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

package edu.wfu.inotado.api;

import java.util.Date;
import java.util.List;

import org.sakaiproject.service.gradebook.shared.Assignment;

import edu.wfu.inotado.marshalobj.sc.ScAssignment;
import edu.wfu.inotado.marshalobj.sc.ScAssignmentSubmitssion;
import edu.wfu.inotado.marshalobj.sc.ScRubric;
import edu.wfu.inotado.marshalobj.sc.ScSchool;

public interface SyncResourcesService {

	boolean login(String pin);

	boolean getCourses(String url);

	List<ScSchool> getSchools(String json);

	void updateAssignmentWithGrades(ScAssignment assignment);

	public Assignment getOrMakeAssignment(ScAssignment assignment, String siteId);

	public boolean syncAssignments() throws Exception;

	public void saveAssignmentSubmittion(
			ScAssignmentSubmitssion assignmentSubmitssion, String siteId,
			String assignmentName, String userId);

	public void saveRubric(ScRubric rubric);

	public Date getDateFromScString(String dateTimeStr);

}
