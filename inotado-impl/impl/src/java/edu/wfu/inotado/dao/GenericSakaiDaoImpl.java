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

package edu.wfu.inotado.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class GenericSakaiDaoImpl extends JdbcDaoSupport implements
		GenericSakaiDao {
	private String query_grade_record_id = "SELECT * FROM gb_grade_record_t gr WHERE GR.STUDENT_ID = ? AND GR.GRADABLE_OBJECT_ID = ?";

	private String update_assignment = "UPDATE GB_GRADABLE_OBJECT_T gbot SET GBOT.EXTERNAL_APP_NAME = ? WHERE GBOT.ID = ?";

	@Override
	public long getGradeRecordIdByUser(String studentId, Long gradableObjectId) {
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(studentId);
		parameters.add(gradableObjectId);
		@SuppressWarnings("unchecked")
		List<Long> gradeRecordIds = (List<Long>) getJdbcTemplate().query(
				query_grade_record_id, parameters.toArray(), new RowMapper() {

					@Override
					public Object mapRow(ResultSet result, int arg1)
							throws SQLException {
						return result.getLong("ID");
					}
				});
		if (gradeRecordIds != null && gradeRecordIds.size() > 0) {
			return gradeRecordIds.get(0);
		} else {
			return 0;
		}

	}

	public void updateAssignment(long id, String externalName) {
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(externalName);
		parameters.add(id);
		getJdbcTemplate().update(update_assignment, parameters.toArray());
	}
}
