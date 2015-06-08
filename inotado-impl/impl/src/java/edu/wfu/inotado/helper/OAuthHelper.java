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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.sf.ehcache.Cache;
import oauth.signpost.OAuth;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.basic.DefaultOAuthProvider;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.wfu.inotado.api.OAuthProperties;
import edu.wfu.inotado.model.AuthStore;

public class OAuthHelper {
	private final Log log = LogFactory.getLog(this.getClass());

	// ConcurrentHashMap<Object, OAuthProperties> oauthPropsMap = new
	// ConcurrentHashMap<Object, OAuthProperties>();

	private Cache consumerCache;

	private CacheHelper cacheHelper;

	public void setCacheHelper(CacheHelper cacheHelper) {
		this.cacheHelper = cacheHelper;
	}

	public Cache getConsumerCache() {
		return consumerCache;
	}

	public void setConsumerCache(Cache consumerCache) {
		this.consumerCache = consumerCache;
	}

	public OAuthConsumer getConsumer(String key) {
		return cacheHelper.getFromCache(key, consumerCache);
	}

	/*
	 * This is only used to verify the connection to schoolchapters
	 */
	@Deprecated
	public void sendRequest(AuthStore authStore) throws Exception {
		OAuthConsumer consumer = cacheHelper.getFromCache(
				authStore.getSystemName(), consumerCache);
		URL url;
		url = new URL("https://vigrior.schoolchapters.com/api/v1/courses.json");
		HttpURLConnection request = (HttpURLConnection) url.openConnection();

		consumer.sign(request);

		System.out.println("Sending request...");
		request.connect();
		System.out.println(request.getContent());

		InputStream in = (InputStream) request.getContent();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String result, line = reader.readLine();
		result = line;
		while ((line = reader.readLine()) != null) {
			result += line;
		}
		System.out.println(result);
		System.out.println("Response: " + request.getResponseCode() + " "
				+ request.getResponseMessage());

	}

	public String getAuthUrl(AuthStore authStore, OAuthProperties op)
			throws Exception {
		String authUrl = null;

		if (authStore != null && authStore.getConsumerKey() != null
				&& authStore.getConsumerSecret() != null) {
			op.setConsumerKey(authStore.getConsumerKey());
			op.setConsumerSecret(authStore.getConsumerSecret());
		}

		// TODO add more error handling here
		if (op.isValid()) {
			// oauthPropsMap.put(authStore.getSystemName(), op);
		} else {
			log.error("The OAuthProperties object is invalid");
		}

		OAuthConsumer consumer = new DefaultOAuthConsumer(op.getConsumerKey(),
				op.getConsumerSecret());
		cacheHelper.saveToCache(authStore.getSystemName(), consumer,
				consumerCache);

		OAuthProvider provider = new DefaultOAuthProvider(
				op.getRequestTokenUrl(), op.getAccessTokenUrl(),
				op.getAuthorizeUrl());

		log.debug("Fetching request token ...");

		authUrl = provider.retrieveRequestToken(consumer, OAuth.OUT_OF_BAND);
		authUrl = OAuth.addQueryParameters(authUrl, OAuth.OAUTH_CONSUMER_KEY,
				op.getConsumerKey(), "application_name",
				op.getApplicationName());

		log.debug("Request token: " + consumer.getToken());
		log.debug("Token secret: " + consumer.getTokenSecret());

		log.debug("Auth URL: " + authUrl);
		return authUrl;
	}

}
