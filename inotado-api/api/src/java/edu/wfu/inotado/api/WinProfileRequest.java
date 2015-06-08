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

import java.util.ArrayList;
import java.util.List;

/**
 * This is an object to hold properties 
 * 
 * @author zhuy
 *
 */
public class WinProfileRequest {

	private String webServiceUrl;
	private String remotePhotoLocation;
	private String requesterUserId;
	private String requesterUserType;
	
	private List<String> winUsers = new ArrayList<String>();

	public String getWebServiceUrl() {
		return webServiceUrl;
	}

	public void setWebServiceUrl(String webServiceUrl) {
		this.webServiceUrl = webServiceUrl;
	}

	public String getRequesterUserId() {
		return requesterUserId;
	}

	public void setRequesterUserId(String requesterUserId) {
		this.requesterUserId = requesterUserId;
	}

	public String getRequesterUserType() {
		return requesterUserType;
	}

	public void setRequesterUserType(String requesterUserType) {
		this.requesterUserType = requesterUserType;
	}

	public List<String> getWinUsers() {
		return winUsers;
	}

	public void setWinUsers(List<String> users) {
		this.winUsers = users;
	}

	public String getRemotePhotoLocation() {
		return remotePhotoLocation;
	}

	public void setRemotePhotoLocation(String remotePhotoLocation) {
		this.remotePhotoLocation = remotePhotoLocation;
	}
	
}
