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

package edu.wfu.inotado.helper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.sakaiproject.api.app.scheduler.DelayedInvocation;
import org.sakaiproject.api.app.scheduler.ScheduledInvocationCommand;
import org.sakaiproject.api.app.scheduler.ScheduledInvocationManager;
import org.sakaiproject.component.cover.ComponentManager;
import org.sakaiproject.time.api.TimeService;

public class JobScheduleHelper {
	private final Log log = LogFactory.getLog(this.getClass());

	private ScheduledInvocationManager scheduledInvocationManager;
	private TimeService timeService;

	public static String JOB_CONTEXT = "inotado";

	public void init() {
		if (scheduledInvocationManager == null) {
			scheduledInvocationManager = (ScheduledInvocationManager) ComponentManager
					.get(ScheduledInvocationManager.class);
		}

		if (timeService == null) {
			timeService = (TimeService) ComponentManager.get(TimeService.class);
		}
	}

	public boolean executeSyncJob(Class<?> jobBean) {
		boolean status = false;
		String beanName = jobBean.getName();
		// Delete all existing job
		DelayedInvocation[] invocations = scheduledInvocationManager
				.findDelayedInvocations(beanName, JOB_CONTEXT);
		for (DelayedInvocation invocation : invocations) {
			scheduledInvocationManager.deleteDelayedInvocation(invocation.uuid);
		}

		// Add the new job
		scheduledInvocationManager.createDelayedInvocation(
				timeService.newTime(), beanName, JOB_CONTEXT);
		// Execute job
		for (DelayedInvocation invocation : invocations) {
			ScheduledInvocationCommand command = (ScheduledInvocationCommand) ComponentManager
					.get(invocation.componentId);
			command.execute(JOB_CONTEXT);
			scheduledInvocationManager.deleteDelayedInvocation(invocation.uuid);
		}
		status = true;

		return status;
	}

	public boolean executeAsyncJob(String jobBeanName, int delayInSeconds) {
		// Execute the job in a separate thread
		ReflectiveExecuter executer = new ReflectiveExecuter(jobBeanName,
				delayInSeconds);
		executer.start();

		return true;
	}

	class ReflectiveExecuter extends Thread {
		private String jobBeanName = null;
		private int delayInSeconds = 0;

		public ReflectiveExecuter(String jobBeanName) {
			this.jobBeanName = jobBeanName;
		}

		public ReflectiveExecuter(String jobBeanName, int delayInSeconds) {
			this.jobBeanName = jobBeanName;
			this.delayInSeconds = delayInSeconds;
		}

		@Override
		public void run() {
			Object jobObj = ComponentManager.get(jobBeanName);

			if (jobObj != null) {
				try {
					log.info("Execute job " + jobBeanName + " in "
							+ delayInSeconds + " seconds.");
					Thread.sleep(this.delayInSeconds * 1000);
					Method method = jobObj.getClass().getMethod("execute",
							JobExecutionContext.class);
					method.invoke(jobObj, new Object[] { null });
				} catch (NoSuchMethodException e) {
					log.error(e);
				} catch (SecurityException e) {
					log.error(e);
				} catch (IllegalAccessException e) {
					log.error(e);
				} catch (IllegalArgumentException e) {
					log.error(e);
				} catch (InvocationTargetException e) {
					log.error(e);
				} catch (InterruptedException e) {
					log.error(e);
				}
			} else {
				log.warn("No DelegatedAccessSiteHierarchyJob instance found. No direct execution occurrs.");
			}
		}
	}

}
