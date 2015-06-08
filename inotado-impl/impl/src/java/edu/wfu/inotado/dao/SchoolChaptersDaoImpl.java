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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.genericdao.hibernate.HibernateGeneralGenericDao;

import edu.wfu.inotado.model.ScBaseDTO;

public class SchoolChaptersDaoImpl extends HibernateGeneralGenericDao implements
		SchoolChaptersDao {

	private final Log log = LogFactory.getLog(this.getClass());

	public void save(ScBaseDTO newObj, ScBaseDTO existingObj) {
		if (newObj == null) {
			return;
		}

		// continue the process only of newObj is not null
		if (existingObj != null) {
			if (newObj.equals(existingObj)) {
				log.debug("New object and existing object are the same. Skip saving");
			} else {
				// replace the existing object with new one
				getHibernateTemplate().delete(existingObj);
				getHibernateTemplate().save(newObj);
			}
		} else {
			getHibernateTemplate().save(newObj);
		}
	}

}
