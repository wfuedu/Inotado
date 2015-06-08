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

import java.security.SignatureException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EncryptionHelperTest extends InotadoTestBase {

	private final Log log = LogFactory.getLog(this.getClass());

	public void testGoodHashing() {
		try {
			assertEquals("EEFSxb/coHvGM+69RhmfAlXJ9J0=", super.encryptionHelper.calculateHMAC("data", "key"));
			assertEquals(
					"tgYgkfkQSpdRKOcVKvOoQ3oQLIg=",
					super.encryptionHelper
							.calculateHMAC(
									"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><winrequest><users><user><id>knoxbl</id></user></users><usertype>STF</usertype><userid>zhuy</userid><format>xml</format></winrequest>",
									"WakeServ"));
		} catch (SignatureException e) {
			log.error(e);
		}
	}

	public void testBadHashing() {
		try {
			assertEquals("", super.encryptionHelper.calculateHMAC(null, null));
			assertEquals("", super.encryptionHelper.calculateHMAC("", ""));
			assertEquals("", super.encryptionHelper.calculateHMAC("", null));
			assertEquals("", super.encryptionHelper.calculateHMAC("  ", "key"));
			assertFalse("EEFSxb/coHvGM+69RhmfAlXJ9J0=".equals(super.encryptionHelper.calculateHMAC("data", "wrongkey")));
			assertFalse("EEFSxb/coHvGM+69RhmfAlXJ9J0=".equals(super.encryptionHelper.calculateHMAC("wrongdata", "key")));
		} catch (SignatureException e) {
			log.error(e);
		}
	}

	public void testUriSafeSignature() {
		String signature = super.encryptionHelper.getUriSafeSignature("data", "key");
		assertEquals("%45%45%46%53%78%62%2F%63%6F%48%76%47%4D%2B%36%39%52%68%6D%66%41%6C%58%4A%39%4A%30%3D", signature);
	}
	
}
