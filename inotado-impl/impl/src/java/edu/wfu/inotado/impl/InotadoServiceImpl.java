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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.component.api.ServerConfigurationService;
import org.sakaiproject.coursemanagement.api.CourseManagementService;
import org.sakaiproject.coursemanagement.api.Membership;
import org.sakaiproject.coursemanagement.api.Section;
import org.sakaiproject.coursemanagement.api.exception.IdNotFoundException;
import org.sakaiproject.exception.IdUnusedException;
import org.sakaiproject.exception.PermissionException;
import org.sakaiproject.section.api.SectionAwareness;
import org.sakaiproject.section.api.SectionManager;
import org.sakaiproject.section.api.coursemanagement.CourseSection;
import org.sakaiproject.site.api.Site;
import org.sakaiproject.site.api.SiteService;
import org.sakaiproject.site.api.SiteService.SelectionType;
import org.sakaiproject.site.api.SiteService.SortType;
import org.sakaiproject.user.api.User;
import org.sakaiproject.user.api.UserDirectoryService;
import org.sakaiproject.user.api.UserNotDefinedException;

import edu.wfu.inotado.api.Constants;
import edu.wfu.inotado.api.InotadoException;
import edu.wfu.inotado.api.InotadoResponse;
import edu.wfu.inotado.api.InotadoService;
import edu.wfu.inotado.api.OAuthProperties;
import edu.wfu.inotado.api.SakaiProxy;
import edu.wfu.inotado.api.WakeUtils;
import edu.wfu.inotado.api.WinProfile;
import edu.wfu.inotado.api.WinProfileRequest;
import edu.wfu.inotado.api.WinProfileResponse;
import edu.wfu.inotado.api.WinUserType;
import edu.wfu.inotado.dao.InotadoDao;
import edu.wfu.inotado.helper.EncryptionHelper;
import edu.wfu.inotado.helper.JobScheduleHelper;
import edu.wfu.inotado.helper.OAuthHelper;
import edu.wfu.inotado.jobs.CustomPropertyUpdateJob;
import edu.wfu.inotado.jobs.HierarchyPropertyUpdateJob;
import edu.wfu.inotado.model.AuthStore;
import edu.wfu.inotado.win.WinProfileService;

public class InotadoServiceImpl implements InotadoService {

	private final Log log = LogFactory.getLog(getClass());

	private final String INOTADO_ENABLED = "inotado.enabled";
	private final String WIN_URL = "inotado.wakeserv.url";
	private final String WIN_IMAGE_PATH = "inotado.win.image.path";
	private final String WAKESERV_KEY = "inotado.wakeserv.key";
	private final String INOTADO_CACHE_LIVETIME = "inotado.cache.livetime";

	private final String DELIM_HIERARCHY = "|";

	private final String SC_SERVER_URL = "schoolchapters.url";

	// the default flag is set in components.xml and overwritten by
	// inotado.enabled property
	private boolean toolEnabled;

	@Setter
	private ServerConfigurationService configurationService;

	@Setter
	private UserDirectoryService userDirectoryService;

	@Setter
	@Getter
	private WinProfileService winProfileService;

	@Setter
	@Getter
	private EncryptionHelper encryptionHelper;

	@Setter
	@Getter
	private CourseManagementService cmService;

	@Setter
	@Getter
	private SectionAwareness sectionAwareness;

	@Setter
	@Getter
	private SiteService siteService;

	@Setter
	@Getter
	private SectionManager sectionManager;

	@Setter
	@Getter
	private HierarchyPropertyUpdateJob hierarchyPropertyUpdateJob;

	@Setter
	@Getter
	private CustomPropertyUpdateJob customPropertyUpdateJob;

	@Setter
	@Getter
	private JobScheduleHelper jobScheduleHelper;

	@Setter
	@Getter
	private OAuthHelper oauthHelper;

	@Setter
	@Getter
	private InotadoDao inotadoDao;

	@Setter
	@Getter
	private SakaiProxy sakaiProxy;

	// a local cache to store WinProfile objects
	private ConcurrentHashMap<String, WinProfile> cachedWinProfiles;

	private Calendar lastCleanTime;

	public void init() {
		String key = this.configurationService.getString(WAKESERV_KEY);
		// set the key from properties entry
		if (!StringUtils.isBlank(key)) {
			this.encryptionHelper.setKey(key);
		}
		this.cachedWinProfiles = new ConcurrentHashMap<String, WinProfile>();
		this.lastCleanTime = Calendar.getInstance();
	}

	public void destroy() {
		this.cachedWinProfiles.clear();
	}

	public UserDirectoryService getUserDirectoryService() {
		return this.userDirectoryService;
	}

	public void setToolEnabled(boolean enabled) {
		this.toolEnabled = enabled;
	}

	private boolean getToolEnabled() {
		return this.toolEnabled;
	}

	public boolean isToolEnabled() {
		return configurationService.getBoolean(INOTADO_ENABLED,
				this.getToolEnabled());
	}

	public void setConfigurationService(
			ServerConfigurationService configurationService) {
		this.configurationService = configurationService;
	}

	public String getWinImagePath() {
		return this.configurationService.getString(WIN_IMAGE_PATH);
	}

	public WinProfileResponse getWinProfiles(WinProfileRequest request) {
		this.clearCache();
		WinProfileResponse response = new WinProfileResponse();
		// set the URL if this has not been set in the request object
		if (request.getWebServiceUrl() == null) {
			String url = this.configurationService.getString(WIN_URL);
			request.setWebServiceUrl(url);
			log.debug("Remote WinProfile URL: " + url);
		}

		// default to student type if not set
		if (request.getRequesterUserType() == null) {
			request.setRequesterUserType(WinUserType.student.toString());
		}

		// default to the path set in the properties file
		if (request.getRemotePhotoLocation() == null) {
			request.setRemotePhotoLocation(getWinImagePath());
		}

		// check the cache
		List<String> userIds = request.getWinUsers();
		List<WinProfile> cachedWinProfiles = this.getCachedWinProfiles(userIds);
		for (WinProfile winProfile : cachedWinProfiles) {
			// remove from the id list if WinProfile object found from cache
			userIds.remove(winProfile.getUserId());
		}

		// transfer all cached objects into response
		for (WinProfile winProfile : cachedWinProfiles) {
			response.getProfiles().put(winProfile.getUserId(), winProfile);
		}

		if (userIds.size() > 0) { // make request if not all found in cache
			request.setWinUsers(userIds);
			WinProfileResponse subresponse = this.winProfileService
					.getWinProfiles(request);
			// replace the blank URLs with Profile Image URL
			addProfileImageUrl(subresponse);
			// append the result
			response.getProfiles().putAll(subresponse.getProfiles());
			// store the result in cache
			this.cachedWinProfiles.putAll(subresponse.getProfiles());
		}

		// modify the response based on requester's role
		response = getWinProfileByPrivacy(request, response);

		return response;
	}

	private WinProfileResponse getWinProfileByPrivacy(
			WinProfileRequest request, WinProfileResponse response) {
		for (Entry<String, WinProfile> profileEntry : response.getProfiles()
				.entrySet()) {
			response.getProfiles().put(profileEntry.getKey(),
					getWinProfileByPrivacy(request, profileEntry.getValue()));
		}
		return response;
	}

	private WinProfile getWinProfileByPrivacy(WinProfileRequest request,
			WinProfile profile) {
		WinProfile returnProfile = profile;
		if (StringUtils.equals(request.getRequesterUserId(),
				profile.getUserId())) {
			return returnProfile;
		} else if (!WinUserType.faculty.equals(request.getRequesterUserType())
				&& !WinUserType.staff.equals(request.getRequesterUserType())) {
			// photo privacy is turned on
			if (profile.isImagePrivacy()) {
				// copy blank out the images
				WinProfile copiedProfile = profile.copy();
				copiedProfile.setImage(null);
				copiedProfile.setImageFileName("");
				copiedProfile.setImageUrl("");
				// replace the return
				returnProfile = copiedProfile;
			}
		}
		return returnProfile;
	}

	private void addProfileImageUrl(WinProfileResponse response) {
		Map<String, WinProfile> profiles = response.getProfiles();
		for (String id : profiles.keySet()) {
			WinProfile profile = profiles.get(id);
			// replace the blank WIN image URL with profile2 image RUL
			if (StringUtils.isBlank(profile.getImageUrl())) {
				profile.setImageUrl(getProfilePhotoURLByInternalId(getInternalUserId(profile
						.getUserId())));
			}
		}
	}

	public WinProfileRequest createWinProfileRequestByInternalIds(
			List<String> internalIds) {
		WinProfileRequest request = new WinProfileRequest();
		// get the current user - the requester
		User currentUser = this.userDirectoryService.getCurrentUser();
		List<String> users = new ArrayList<String>();
		request.setRequesterUserId(currentUser.getDisplayId());
		request.setRequesterUserType(currentUser.getType());

		User user;
		for (String id : internalIds) {
			try {
				user = this.userDirectoryService.getUser(id);
				String displayId = user.getDisplayId();
				users.add(displayId);
				request.setWinUsers(users);
			} catch (UserNotDefinedException e) {
				log.error("Unable to find such user by id: " + id);
			}
		}
		return request;
	}

	public WinProfileRequest createWinProfileRequestByDisplayIds(
			List<String> displayIds) {
		WinProfileRequest request = new WinProfileRequest();
		// get the current user - the requester
		User currentUser = this.userDirectoryService.getCurrentUser();
		List<String> users = new ArrayList<String>();
		request.setRequesterUserId(currentUser.getDisplayId());
		request.setRequesterUserType(currentUser.getType());
		for (String id : displayIds) {
			users.add(id);
			request.setWinUsers(users);

		}
		return request;
	}

	public String getUserIdFromInternalId(String internalId) {
		String userId = "";
		try {
			User user = this.userDirectoryService.getUser(internalId);
			userId = user.getDisplayId();
		} catch (UserNotDefinedException e) {
			log.error("Unable to find such user by id: " + internalId);
		}
		return userId;
	}

	private void clearCache() {
		Calendar cal = Calendar.getInstance();
		long liveTime = configurationService.getInt(INOTADO_CACHE_LIVETIME,
				300);
		if ((lastCleanTime.getTimeInMillis() / 1000 + liveTime) < cal
				.getTimeInMillis() / 1000) {
			// cache expired, clear it
			this.cachedWinProfiles.clear();
			this.lastCleanTime = cal;
			log.info("WinProfile Cache has been cleared successfully.");
		}
	}

	/**
	 * Find all cached objects by user ids
	 * 
	 * @return
	 */
	private List<WinProfile> getCachedWinProfiles(List<String> ids) {
		List<WinProfile> winProfiles = new ArrayList<WinProfile>(0);
		for (String id : ids) {
			// store the winProfile if found and image name is not blank
			if (this.cachedWinProfiles.containsKey(id)
					&& !StringUtils.isBlank(this.cachedWinProfiles.get(id)
							.getImageFileName())) {
				winProfiles.add(this.cachedWinProfiles.get(id));
			}
		}
		return winProfiles;
	}

	public String getInternalUserId(String eid) {
		String internalId = "";
		try {
			org.sakaiproject.user.api.User user = this.userDirectoryService
					.getUserByEid(eid);
			internalId = user.getId();
		} catch (UserNotDefinedException e) {
			log.error("Unable to find such user by eid: " + eid);
		}
		return internalId;
	}

	public String getProfilePhotoURLByInternalId(String internalId) {
		return "/direct/profile/" + internalId + "/image";
	}

	@Override
	public String getSectionId(String siteId) {

		String sectionId = null;
		// user login id
		String userName = userDirectoryService.getCurrentUser().getEid();
		if (userName != null && StringUtils.isNotBlank(siteId)) {
			List<CourseSection> sections = sectionAwareness.getSections(siteId);
			log.debug("Number of sections contained in the site " + siteId
					+ "is: " + sections.size());

			// get the first section id for given user
			sectionLoop: for (CourseSection section : sections) {
				try {
					Set<Membership> memberships = cmService
							.getSectionMemberships(section.getEid());
					for (Membership membership : memberships) {
						String uid = membership.getUserId();
						if (userName.equals(uid)) {
							sectionId = section.getEid();
							break sectionLoop;
						}
					}
				} catch (RuntimeException e) {
					log.warn("skip processing following section due to error: "
							+ section.getTitle());
				}
				log.debug("section id:  " + sectionId);
			}

		}
		return sectionId;
	}

	@Override
	public boolean addOrUpdateSiteProperties(String siteId,
			Properties properties) {
		boolean status = false;
		if (properties == null) {
			log.debug("Properties appears to be blank");
			return status;
		}
		try {
			if (siteService.siteExists(siteId)) {
				Site site = siteService.getSite(siteId);
				site.getPropertiesEdit().addAll(properties);
				siteService.save(site);
				status = true;
			} else {
				log.warn("No such site exists with id: " + siteId);
			}
		} catch (IdUnusedException e) {
			log.warn("No such site exists with id: " + siteId);
		} catch (PermissionException e) {
			log.error("Unable to save site with id: " + siteId, e);
		} catch (IdNotFoundException e) {
			log.warn(e.getMessage());
		}
		return status;
	}

	@Override
	public boolean addOrUpdateHierarchyProperties(String siteId) {
		boolean status = false;
		Properties properties = null;

		String hierarchyPropNames[] = configurationService
				.getStrings("delegatedaccess.hierarchy.site.properties");
		log.debug("Found " + hierarchyPropNames.length
				+ " delegated access names from properties file");

		// Get all course sections from the site
		List<CourseSection> courseSections = sectionManager.getSections(siteId);
		if (courseSections != null && courseSections.size() > 0) {
			for (CourseSection courseSection : courseSections) {
				String sectionEid = courseSection.getEid();
				// get the first valid course section found in the list assuming
				// they are
				// under the same course offering.
				if (!StringUtils.isBlank(sectionEid)) {
					Section section = cmService.getSection(sectionEid);
					String category = section.getCategory();

					if (category.contains(DELIM_HIERARCHY)) {
						String[] hierarchies = StringUtils.split(category,
								DELIM_HIERARCHY);
						if (hierarchies.length == hierarchyPropNames.length) {
							properties = new Properties();

							// read property names dynamically
							for (int i = 0; i < hierarchyPropNames.length; i++) {
								properties.put(hierarchyPropNames[i],
										hierarchies[i]);
							}
						} else {
							log.warn("The hierarchy string - \"" + category
									+ "\" does not match the size "
									+ hierarchyPropNames.length
									+ "configured in configuration");
						}
					}
					// not need to go to next section
					break;
				}
			}
		}

		status = addOrUpdateSiteProperties(siteId, properties);
		return status;
	}

	@Override
	public boolean updateHierarchyPropertiesByTerm(String termEid) {
		boolean status = false;
		log.debug("Update Hierarchy Properties for term:" + termEid);

		// Update the course sites only
		List<Site> sites = getSitesByTerm(termEid);
		log.info("found total number of sites: " + sites.size());
		for (Site site : sites) {
			addOrUpdateHierarchyProperties(site.getId());
		}

		return status;
	}

	private List<Site> getSitesByTerm(String termEid) {
		Map propMap = new HashMap();
		propMap.put("term_eid", termEid);
		return siteService.getSites(SelectionType.ANY, "course", null, propMap,
				SortType.NONE, null);
	}

	/**
	 * Validate the input string and parse it
	 * 
	 * @param text
	 * @return
	 * @throws InotadoException
	 */
	private Map<String, Properties> getCustomProperties(String text)
			throws InotadoException {
		Map<String, Properties> propMap = new HashMap<String, Properties>();
		Scanner scanner = new Scanner(text);
		String[] propKeys = null;
		String[] propValues = null;
		int ln = 0;
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			ln++;

			if (ln == 1) {
				// process header
				if (!StringUtils.containsIgnoreCase(line, "siteid")) {
					log.error("\"siteId\" is not found in the header line. Aboard operation.");
					throw new InotadoException(
							"Header row is not properly specified");
				}
				propKeys = StringUtils.split(line, "\t");
			} else {
				// process content
				propValues = StringUtils.split(line, "\t");
				// skip to next if this line is not properly entered
				if (propValues.length < propKeys.length) {
					log.warn("There is no enough value contained in this line: "
							+ line);
					continue;
				}
				String siteId = propValues[1];

				if (!siteService.siteExists(siteId)) {
					// not site found, skip this line
					continue;
				}

				Properties props = new Properties();
				// get properties
				for (int i = 2; i < propValues.length; i++) {
					props.put(propKeys[i], propValues[i]);
				}
				propMap.put(siteId, props);
			}
		}
		return propMap;
	}

	@Override
	public InotadoResponse executeCustomPropertyUpdateJob(String text)
			throws InotadoException {
		InotadoResponse response = new InotadoResponse();
		try {
			Map<String, Properties> propMap = this.getCustomProperties(text);
			customPropertyUpdateJob.setPropMap(propMap);
			jobScheduleHelper.executeSyncJob(CustomPropertyUpdateJob.class);
			executeDelegatedAccessSiteHierarchyJob();
			response.setSuccess(true);
			response.setSuccessMessage("Processed " + propMap.size()
					+ " site(s)");
		} catch (InotadoException e) {
			response.setSuccess(false);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}

	@Override
	public InotadoResponse executeHierarchyPropertyUpdateJob(String termEid) {
		InotadoResponse response = new InotadoResponse();
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			params.put("termEid", termEid);
			hierarchyPropertyUpdateJob.setParams(params);
			jobScheduleHelper.executeSyncJob(HierarchyPropertyUpdateJob.class);
			executeDelegatedAccessSiteHierarchyJob();
			response.setSuccess(true);
			response.setSuccessMessage("Processed "
					+ getSitesByTerm(termEid).size() + " site(s)");
		} catch (InotadoException e) {
			response.setSuccess(false);
			response.setErrorMessage(e.getMessage());
		}
		return response;
	}

	@Override
	public void executeDelegatedAccessSiteHierarchyJob() {
		jobScheduleHelper
				.executeAsyncJob(
						"org.sakaiproject.delegatedaccess.jobs.DelegatedAccessSiteHierarchyJob",
						5);
	}

	@Override
	public String getSchoolChaptersAuthUrl(AuthStore authStore) {
		String authUrl = "";
		String ScServerUrl = configurationService.getString(SC_SERVER_URL);
		OAuthProperties op = new OAuthProperties();
		if (authStore != null) {
			op.setConsumerKey(authStore.getConsumerKey());
			op.setConsumerSecret(authStore.getConsumerSecret());
		} else {
			log.warn("The AuthStore object appears to be null.");
		}
		op.setAccessTokenUrl(WakeUtils.getInstance().getUrl(ScServerUrl,
				Constants.SCHOOL_CHAPTERS_ACCESS_TOKEN_URL));
		op.setApplicationName(Constants.SCHOOL_CHAPTERS);
		op.setAuthorizeUrl(WakeUtils.getInstance().getUrl(ScServerUrl,
				Constants.SCHOOL_CHAPTERS_AUTH_URL));
		op.setRequestTokenUrl(WakeUtils.getInstance().getUrl(ScServerUrl,
				Constants.SCHOOL_CHAPTERS_REQUEST_TOKEN_URL));

		try {
			authUrl = oauthHelper.getAuthUrl(authStore, op);
			log.info("Auth URL: \n" + authUrl);

		} catch (Exception e) {
			log.error(e);
		}
		return authUrl;
	}

	@Override
	public void sendRequest(AuthStore authStore) throws InotadoException {
		try {
			oauthHelper.sendRequest(authStore);
		} catch (Exception e) {
			log.error("Error occurred while sending request.", e);
			throw new InotadoException(e);
		}
	}

	@Override
	public AuthStore getAuthStoreForCurrentUser(String systemName) {
		return inotadoDao.findBySystemNameAndUser(systemName,
				this.getUserIdFromInternalId(sakaiProxy.getCurrentUserId()));
	}

	@Override
	public void saveAuthStore(AuthStore authStore) {
		authStore.setUserId(this.getUserIdFromInternalId(sakaiProxy
				.getCurrentUserId()));
		inotadoDao.save(authStore);
	}
}
