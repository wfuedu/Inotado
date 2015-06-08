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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.wfu.inotado.model.AuthStore;

public class InotadoDaoTest extends InotadoTestBase {
	private final Log log = LogFactory.getLog(this.getClass());

	public void testfindBySystemNameAndUser() {
/*		AuthStore authStore = new AuthStore();
		authStore.setConsumerKey("key1");
		authStore.setConsumerSecret("secret1");
		authStore.setSystemName("system1");
		authStore.setUserId("user1");
		// authStore.setId(100);
		log.info("hashcode: " + authStore.hashCode());
		inotadoDao.save(authStore);

		authStore = new AuthStore("user2", "system2", "key2", "secret2");
		// authStore.setId(101);
		log.info("hashcode: " + authStore.hashCode());

		super.inotadoDao.save(authStore);

		AuthStore result = inotadoDao.findBySystemNameAndUser("system1",
				"user1");
		assertEquals("key1", result.getConsumerKey());
		assertEquals("secret1", result.getConsumerSecret());*/

	}

}
