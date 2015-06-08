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

import edu.wfu.inotado.api.WinUserType;

public class WinUserTypeTest extends InotadoTestBase {
	
	public void testUserTypes() {
		assertTrue(WinUserType.faculty.toString().equals("FAC"));
		assertTrue(WinUserType.student.toString().equals("STU"));
		assertTrue(WinUserType.staff.toString().equals("STF"));
		assertTrue(WinUserType.guest.toString().equals("GST"));
		
		// type with mixed case
		assertTrue(WinUserType.student.equals("sTu"));
		
		assertFalse(WinUserType.student.equals(null));
	}

}
