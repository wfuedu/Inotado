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

package edu.wfu.inotado.win;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.wfu.inotado.api.WinProfile;
import edu.wfu.inotado.api.WinProfileRequest;
import edu.wfu.inotado.api.WinProfileResponse;
import edu.wfu.inotado.helper.EncryptionHelper;
import edu.wfu.inotado.helper.MarshalHelper;
import edu.wfu.inotado.helper.RestClientHelper;
import edu.wfu.inotado.marshalobj.win.ProfileUser;
import edu.wfu.inotado.marshalobj.win.Profiles;
import edu.wfu.inotado.marshalobj.win.User;
import edu.wfu.inotado.marshalobj.win.Users;
import edu.wfu.inotado.marshalobj.win.Winrequest;

public class WinProfileServiceImpl implements WinProfileService {

	private final Log log = LogFactory.getLog(this.getClass());

	private RestClientHelper restClientHelper;

	private MarshalHelper marshalHelper;

	private EncryptionHelper encryptionHelper;

	public void setMarshalHelper(MarshalHelper marshalHelper) {
		this.marshalHelper = marshalHelper;
	}

	public void setRestClientHelper(RestClientHelper restClientHelper) {
		this.restClientHelper = restClientHelper;
	}

	public void setEncryptionHelper(EncryptionHelper encryptionHelper) {
		this.encryptionHelper = encryptionHelper;
	}

	public WinProfileResponse getWinProfiles(WinProfileRequest request) {
		String response = "";
		Winrequest winrequest = new Winrequest();
		WinProfileResponse winresponse = new WinProfileResponse();

		// Transfer users to the user objects
		Users users = new Users();
		List<String> winUsers = request.getWinUsers();
		for (String userId : winUsers) {
			User user = new User();
			user.setId(userId);
			users.getUsers().add(user);
		}
		winrequest.setUsers(users);
		winrequest.setUsertype(request.getRequesterUserType());
		winrequest.setUserid(request.getRequesterUserId());
		winrequest.setFormat("xml");
		response = this.restClientHelper.postXml(request.getWebServiceUrl(), this.marshalHelper.marshal(winrequest),
				this.encryptionHelper.key);
		log.debug("response: " + response);
		Profiles profiles = this.marshalHelper.unmarshal(response);
		if (profiles != null) {
			List<ProfileUser> responseUsers = profiles.getUsers();
			// Transfer the users
			if (responseUsers != null) {

				for (ProfileUser profileUser : responseUsers) {
					WinProfile winProfile = new WinProfile();
					winProfile.setUserId(profileUser.getUserName());
					// only store image if found and photo is on
					if (StringUtils.isNotEmpty(profileUser.getPhotoName())) {
						winProfile.setImageFileName(profileUser.getPhotoName());
						winProfile.setImage(getRemotePhotoAsByteArray(request.getRemotePhotoLocation() + profileUser.getPhotoName()));
						winProfile.setImageUrl(request.getRemotePhotoLocation() + profileUser.getPhotoName());
						winProfile.setImagePrivacy(Boolean.parseBoolean(profileUser.getPhotoPrivacy()));
					}
					winresponse.getProfiles().put(profileUser.getUserName(), winProfile);
				}
			}
		}
		return winresponse;

	}	

	public byte[] getRemotePhotoAsByteArray(String photoUrl) {
		URL url;
		InputStream is = null;
		byte[] out = null;
		try {
			url = new URL(photoUrl);
			is = url.openStream();
			out = IOUtils.toByteArray(is);
		} catch (MalformedURLException e) {
			log.error("the photo url does not appears to be valid: " + photoUrl);
		} catch (IOException e) {
			log.error("Unable to read the photo: " + photoUrl);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					log.error("Unable to close the inputstream");
				}
			}
		}
		return out;
	}

}
