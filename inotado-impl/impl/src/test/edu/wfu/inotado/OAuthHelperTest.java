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

import edu.wfu.inotado.api.OAuthProperties;
import edu.wfu.inotado.model.AuthStore;

public class OAuthHelperTest extends InotadoTestBase {

	private final Log log = LogFactory.getLog(this.getClass());

	/**
	 * Disable this test if it causes any error in the future
	 */
	public void testSchoolChapters() {
		String providerName = "schoolchapters";
		OAuthProperties oauthProperties = new OAuthProperties();
		oauthProperties
				.setAccessTokenUrl("https://vigrior.schoolchapters.com/oauth/access_token");
		oauthProperties.setApplicationName("API-Test");
		oauthProperties
				.setAuthorizeUrl("https://vigrior.schoolchapters.com/oauth/authorize");
		oauthProperties
				.setRequestTokenUrl("https://vigrior.schoolchapters.com/oauth/request_token");

		AuthStore authStore = new AuthStore("user1", "schoolchapters",
				"0TMbbIx0CcLzEQqrINWM5oPAPUse9IHhR3USNuZj",
				"QdtIrDaqftj1Xi9AQDmURsbQBO9UFkDYIuXSskdF");
		/*
		try {
			String authUrl = super.oauthHelper.getAuthUrl(authStore,
					oauthProperties);
			log.info("Auth URL: \n" + authUrl);
			assertNotNull(authUrl);
			super.oauthHelper.sendRequest(authStore);

		} catch (Exception e) {
			log.error(e);
		}
		*/
	}
}
