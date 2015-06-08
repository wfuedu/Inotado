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

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;
import org.sakaiproject.api.app.scheduler.ScheduledInvocationCommand;

import edu.wfu.inotado.api.InotadoService;

public class HierarchyPropertyUpdateJob implements StatefulJob,
		ScheduledInvocationCommand {

	private final Log log = LogFactory.getLog(getClass());

	private ThreadLocal<Map<String, Object>> paramsLocal;

	private Map<String, Object> params;

	@Setter
	@Getter
	public InotadoService inotadoService;

	public void init() {
		// initialize to avoid NPE
		paramsLocal = new ThreadLocal<Map<String, Object>>();
		paramsLocal.set(new HashMap<String, Object>());
	}

	public void setParams(Map<String, Object> params) {
		paramsLocal.set(params);
		this.params = params;
	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		execute("");
	}

	@Override
	public void execute(String context) {
		log.info("Hierarchy Property Update job is running now.");
		Map<String, Object> params = paramsLocal.get() == null ? this.params
				: paramsLocal.get();
		String termEid = (String) params.get("termEid");
		if (termEid != null) {
			log.info("Update all sites in termEid: " + termEid);
			inotadoService.updateHierarchyPropertiesByTerm(termEid);
		} else {
			log.warn("No term was passed from caller.");
		}
		log.info("Finished updating hierarchy propertyes.");

	}

}
