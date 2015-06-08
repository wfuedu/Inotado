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

import java.util.List;
import java.util.Properties;

import org.sakaiproject.user.api.UserDirectoryService;

import edu.wfu.inotado.model.AuthStore;

public interface InotadoService {

	public void init();

	/**
	 * Returns the properties value of "inotado.enabled". If this entry is not
	 * found, then return the value set in the components.xml. The default value
	 * is true.
	 * 
	 * @return
	 */
	public boolean isToolEnabled();

	/**
	 * @param currentUserType
	 * @param users
	 * @return
	 */
	public WinProfileResponse getWinProfiles(WinProfileRequest request);

	public String getWinImagePath();

	/**
	 * Use this method to get a userDirectoryService instead of wiring it in
	 * other places.
	 * 
	 * @return UserDirectoryService
	 */
	public UserDirectoryService getUserDirectoryService();

	/**
	 * Sakai internal user id could be different from its corresponding user id.
	 * Use this method to get a request object with user id which could be
	 * understood by WIN.
	 * 
	 * @param internalIds
	 * @return
	 */
	public WinProfileRequest createWinProfileRequestByInternalIds(
			List<String> internalIds);

	public WinProfileRequest createWinProfileRequestByDisplayIds(
			List<String> displayIds);

	/**
	 * Translates the internal id into a user id
	 * 
	 * @param internalId
	 * @return
	 */
	public String getUserIdFromInternalId(String internalId);

	public String getInternalUserId(String eid);

	public String getProfilePhotoURLByInternalId(String internalId);

	/**
	 * Returns the first found section id of the site for the current user.
	 * Otherwise, returns null.
	 * 
	 * @param siteId
	 * @return
	 */
	public String getSectionId(String siteId);

	/**
	 * Adds or Updates site property of a given site. Returns true if
	 * successful, otherwise returns false.
	 * 
	 * @param siteId
	 * @param properties
	 * @return
	 */
	public boolean addOrUpdateSiteProperties(String siteId,
			Properties properties);

	/**
	 * Adds or Updates Hierarchy properties (used by Delegated Access tool) of
	 * given site. Returns true if successful, otherwise returns false.
	 * 
	 * Hierarchy properties are stored in table CM_SEC_CATEGORY_T. They come in
	 * from category column in courseSections.csv file in a format of
	 * School|Department|Mode of Instruction.
	 * 
	 * @param siteId
	 * @return
	 */
	public boolean addOrUpdateHierarchyProperties(String siteId);

	/**
	 * Execute HierarchyPropertyUpdateJob.
	 * 
	 * @param term
	 * @return
	 */
	public InotadoResponse executeHierarchyPropertyUpdateJob(String term);

	/**
	 * Execute CustomPropertyUpdateJob.
	 * 
	 * @param text
	 * @return
	 */
	public InotadoResponse executeCustomPropertyUpdateJob(String text);

	/**
	 * Update course site hierarchy properties by term id.
	 * 
	 * @param term
	 * @return
	 */
	public boolean updateHierarchyPropertiesByTerm(String term);

	/**
	 * Execute DelegatedAccessSiteHierarchyJob. Note: this is a direct execution
	 * without using Quartz scheduler.
	 */
	public void executeDelegatedAccessSiteHierarchyJob();

	/**
	 * Get a URL for retrieving OAuth pin.
	 * 
	 * @return
	 */
	public String getSchoolChaptersAuthUrl(AuthStore authStore);

	public void sendRequest(AuthStore authStore) throws InotadoException;

	/**
	 * Get a unique AuthStore record by system name for the current user
	 * 
	 * @param systemName
	 * @return
	 */
	public AuthStore getAuthStoreForCurrentUser(String systemName);

	public void saveAuthStore(AuthStore authStore);
}
