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

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sakaiproject.component.api.ServerConfigurationService;
import org.sakaiproject.component.cover.ComponentManager;
import org.sakaiproject.email.api.EmailService;
import org.sakaiproject.user.api.User;

public class NotificationHelper {
	private final Log log = LogFactory.getLog(this.getClass());

	private EmailService emailService;
	private ServerConfigurationService serverConfigurationService;

	public void init() {
		emailService = (EmailService) ComponentManager.get(EmailService.class);
		serverConfigurationService = (ServerConfigurationService) ComponentManager
				.get(ServerConfigurationService.class);
	}

	public boolean sendEmail(User toUser, String subject, String body) {
		boolean status = false;
		InternetAddress fromAddress = null;
		String email = toUser.getEmail();

		// skip the reset if no email address found from the user
		if (StringUtils.isBlank(email)) {
			log.warn("No email address found from user " + toUser.getEid());
			return false;
		}

		try {
			String noReplyEmaillAddress = "no-reply@"
					+ serverConfigurationService.getServerName();
			InternetAddress[] noReply = new InternetAddress[1];
			noReply[0] = new InternetAddress(noReplyEmaillAddress);

			String fromAd = serverConfigurationService
					.getString("smtpFrom@org.sakaiproject.email.api.EmailService");
			if (StringUtils.isBlank(fromAd)) {
				fromAd = noReplyEmaillAddress;
			}
			fromAddress = new InternetAddress(fromAd);
			InternetAddress[] toAddresses = new InternetAddress[1];
			toAddresses[0] = new InternetAddress(toUser.getEmail());
			List<String> headers = new ArrayList<String>();
			headers.add("Content-Type: text/html");
			emailService.sendMail(fromAddress, toAddresses, subject, body,
					noReply, noReply, headers);

		} catch (AddressException e) {
			log.warn("Unable to process the address ", e);
		}

		return status;
	}
}
