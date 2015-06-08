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
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SignatureException;

import oauth.signpost.OAuthConsumer;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RestClientHelper {

	private final Log log = LogFactory.getLog(getClass());

	private EncryptionHelper encryptionHelper;

	private ThreadLocal<PostMethod> postHolder = new ThreadLocal<PostMethod>();

	private OAuthHelper oauthHelper;

	public void setOauthHelper(OAuthHelper oauthHelper) {
		this.oauthHelper = oauthHelper;
	}

	public void setEncryptionHelper(EncryptionHelper encryptionHelper) {
		this.encryptionHelper = encryptionHelper;
	}

	/**
	 * 
	 * 
	 * @param strURL
	 * @param xml
	 * @return
	 */
	public String postXml(String strURL, String xml) {
		// either get the previously stored post or create a new one
		PostMethod post = this.postHolder.get() != null ? this.postHolder.get()
				: new PostMethod(strURL);
		InputStream xmlStream = null;
		String responseStr = null;
		try {
			xmlStream = new ByteArrayInputStream(xml.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			log.error("Unsupport encoding for string: " + xml);
		}
		try {
			post.setRequestEntity(new InputStreamRequestEntity(xmlStream, xml
					.length()));
			post.addRequestHeader("Content-type",
					"text/xml; charset=ISO-8859-1");
			HttpClient httpclient = new HttpClient();
			int result = httpclient.executeMethod(post);
			log.debug("Response status code: " + result);
			log.debug("Response body: ");
			responseStr = convertStreamToString(post.getResponseBodyAsStream());
			log.debug(responseStr);
		} catch (IOException e) {
			log.error("error occurred.", e);
		} finally {
			post.releaseConnection();
			// clean up the holder
			postHolder.remove();
		}
		return responseStr;
	}

	/**
	 * Calculate a signature using the given key and the xml.
	 * 
	 * Add the calculated signature into header.
	 * 
	 * @param strURL
	 * @param xml
	 * @param key
	 * @return
	 */
	public String postXml(String strURL, String xml, String key) {
		// create a new PostMethod and place it in the holder
		postHolder.set(new PostMethod(strURL));
		if (StringUtils.isNotEmpty(key)) {
			try {
				// add the calculated signature into header
				postHolder.get().addRequestHeader(
						"Signature",
						this.encryptionHelper.calculateHMAC(xml,
								this.encryptionHelper.key));
			} catch (SignatureException e) {
				log.error("Unable to generate sigature", e);
			}
		}
		return postXml(strURL, xml);
	}

	@SuppressWarnings("resource")
	static String convertStreamToString(java.io.InputStream is) {
		java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
		return s.hasNext() ? s.next() : "";
	}

	public String getFromService(String serviceName, String urlStr)
			throws Exception {

		OAuthConsumer consumer = oauthHelper.getConsumer(serviceName);
		URL url;
		url = new URL(urlStr);
		HttpURLConnection request = (HttpURLConnection) url.openConnection();

		consumer.sign(request);

		log.info("Sending request...");
		request.connect();

		InputStream in = (InputStream) request.getContent();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String result, line = reader.readLine();
		result = line;
		while ((line = reader.readLine()) != null) {
			result += line;
		}
		log.debug("Respone: " + result);
		log.info("Response: " + request.getResponseCode() + " "
				+ request.getResponseMessage());

		return result;
	}
}
