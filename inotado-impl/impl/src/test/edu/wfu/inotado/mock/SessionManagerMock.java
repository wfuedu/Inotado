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

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.sakaiproject.tool.api.Session;
import org.sakaiproject.tool.api.SessionManager;
import org.sakaiproject.tool.api.ToolSession;

public class SessionManagerMock implements SessionManager{

	@Override
	public int getActiveUserCount(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Session getCurrentSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCurrentSessionUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ToolSession getCurrentToolSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session getSession(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Session> getSessions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String makeSessionId(HttpServletRequest arg0, Principal arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCurrentSession(Session arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCurrentToolSession(ToolSession arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Session startSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session startSession(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
