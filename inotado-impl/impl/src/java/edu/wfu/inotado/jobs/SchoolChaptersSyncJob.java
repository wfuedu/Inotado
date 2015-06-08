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

package edu.wfu.inotado.jobs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.sakaiproject.component.api.ServerConfigurationService;
import org.sakaiproject.component.cover.ComponentManager;
import org.sakaiproject.tool.api.Session;
import org.sakaiproject.tool.api.SessionManager;
import org.sakaiproject.user.api.User;
import org.sakaiproject.user.api.UserDirectoryService;
import org.sakaiproject.user.api.UserNotDefinedException;

import edu.wfu.inotado.api.SyncResourcesService;
import edu.wfu.inotado.helper.NotificationHelper;
import edu.wfu.inotado.helper.SecurityHelper;

public class SchoolChaptersSyncJob implements Job {
	private final Log log = LogFactory.getLog(getClass());

	private SyncResourcesService syncResourcesService;

	private SessionManager sessionManager;

	private SecurityHelper securityHelper;

	private ServerConfigurationService serverConfigurationService;

	private UserDirectoryService userDirectoryService;

	private NotificationHelper notificationHelper;

	public void setNotificationHelper(NotificationHelper notificationHelper) {
		this.notificationHelper = notificationHelper;
	}

	public void setSecurityHelper(SecurityHelper securityHelper) {
		this.securityHelper = securityHelper;
	}

	public SyncResourcesService getSyncResourcesService() {
		return syncResourcesService;
	}

	public void setSyncResourcesService(
			SyncResourcesService syncResourcesService) {
		this.syncResourcesService = syncResourcesService;
	}

	public void init() {
		sessionManager = (SessionManager) ComponentManager
				.get(SessionManager.class);
		serverConfigurationService = (ServerConfigurationService) ComponentManager
				.get(ServerConfigurationService.class);
		userDirectoryService = (UserDirectoryService) ComponentManager
				.get(UserDirectoryService.class);
	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		Session session = sessionManager.getCurrentSession();
		boolean isSessionNew = false;
		String userId = null;
		User user = null;
		try {
			log.info("Execute schoolchapters Sync job.");
			securityHelper.pushAdvisor();
			if (session == null) {
				session = sessionManager.startSession();
				isSessionNew = true;
			}
			userId = serverConfigurationService.getString(
					"schoolchapters.job.userid", "admin");
			user = userDirectoryService.getUserByEid(userId);
			session.setUserEid(user.getEid());
			session.setUserId(user.getId());
			syncResourcesService.syncAssignments();
			log.info("Finished executing schoolchapters Sync job as user - "
					+ userId);
		} catch (UserNotDefinedException e) {
			log.warn("Unable to find user " + userId
					+ ". You'll need one valid user to execute the job.");
		} catch (Exception e) {
			log.warn("Unable to execute job due to error.", e);
			// Send notification
			notificationHelper.sendEmail(user,
					"Unable to Execute SchoolChapters Sync Job",
					"Check log for error details");
		} finally {
			if (isSessionNew) {
				session.invalidate();
			}
			securityHelper.popAdvisor();
		}

	}
}
