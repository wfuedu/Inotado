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

import java.io.PrintStream;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.core.Container;

public class WakeServMockServer implements Container {

	private final Log log = LogFactory.getLog(this.getClass());

	private String bodyText = "Not set yet";

	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}

	public void handle(Request request, Response response) {
		try {
			String signature = request.getValue("Signature");
			if (StringUtils.isNotBlank(signature)) {
				log.info("Signature received on server: " + signature);
			}
			PrintStream body = response.getPrintStream();
			response.setValue("Content-Type", "application/xml");
			body.println(this.bodyText);
			body.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
