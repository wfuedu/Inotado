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

import java.security.SignatureException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.util.URIUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This helper provides common routines for generating authentication signatures.
 * 
 * @author zhuy
 *
 */
public class EncryptionHelper {
	
	public String key = "WakeServ";
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	private final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
	
	/**
	 * Computes RFC 2104-compliant HMAC signature. * @param data The data to be
	 * signed.
	 * 
	 * @param key
	 *            The signing key.
	 * @return The Base64-encoded RFC 2104-compliant HMAC signature.
	 * @throws java.security.SignatureException
	 *             when signature generation fails
	 */
	
	/**
	 * Sets the key phrase. Default will be used if not set
	 * @param key
	 */
	public void setKey(String key){
		this.key = key;
	}
	
	
	public String calculateHMAC(String data, String key) throws java.security.SignatureException {
		String result = "";
		try {
			
			if(!StringUtils.isBlank(data)&&!StringUtils.isBlank(key)){
				// get an hmac_sha1 key from the raw key bytes
				SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);

				// get an hmac_sha1 Mac instance and initialize with the signing key
				Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
				mac.init(signingKey);

				// compute the hmac on input data bytes
				byte[] rawHmac = mac.doFinal(data.getBytes());

				// base64-encode the hmac
				result = new String(Base64.encodeBase64(rawHmac));
			}else{
				log.warn("data or key appears to be empty!");
			}
		} catch (Exception e) {
			throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
		}
		return result;
	}

	/**
	 * Returns an URI safe signature. So it can be safely used in URL.  
	 * 
	 * @param data
	 * @param key
	 * @return
	 */
	public String getUriSafeSignature(String data, String key) {
		String result = "";
		try {
			result = URIUtil.encodeAll(calculateHMAC(data, key));
		} catch (SignatureException e) {
			log.error("Unable to generate HMAC for data:  " + data, e);
		} catch (URIException e) {
			log.error("Unable to encode the signature of data: " + data, e);
		}
		return result;
	}

}
