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

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.wfu.inotado.api.WinProfileRequest;
import edu.wfu.inotado.api.WinProfileResponse;

public class WinProfileServiceImplTest extends InotadoTestBase {

	private final Log log = LogFactory.getLog(this.getClass());

	private String remoteLocation = "https://win.wfu.edu/images/dir/";

	private String outPutPhotoName = "/tmp/image.jpg";

	public void testgetWinProfileXml() throws IOException {
		super.setWakeServResponse("WinProfileResponse.xml");
		WinProfileRequest request = new WinProfileRequest();
		request.setWebServiceUrl(super.MOCK_URL);
		request.setWinUsers(getTestUsers());
		request.setRemotePhotoLocation(remoteLocation);

		request.setRequesterUserType("STF");
		WinProfileResponse response = super.winProfileService
				.getWinProfiles(request);
		log.info("send request to remote: " + super.MOCK_URL);
		assertNotNull(response);
		assertEquals(4, response.getProfiles().size());
	}

	public void testgetWinProfileXmlNoSuchUser() throws IOException {
		super.setWakeServResponse("WinProfileResponse.xml");
		WinProfileRequest request = new WinProfileRequest();
		request.setWebServiceUrl(super.MOCK_URL);
		request.setWinUsers(getTestUsers());
		request.setRemotePhotoLocation(remoteLocation);
		request.setRequesterUserType("STF");
		WinProfileResponse response = super.winProfileService
				.getWinProfiles(request);
		log.info("send request to remote: " + super.MOCK_URL);
		assertNotNull(response);

		// get image for valid user
		assertNotNull(response.getProfiles().get("user1").getImage());
		// no image for unknown user
		assertNull(response.getProfiles().get("unknownuser1").getImage());

		// FileOutputStream output = new FileOutputStream(new
		// File(outPutPhotoName));
		// BufferedOutputStream bos = new BufferedOutputStream(output);
		// bos.write(response.getProfiles().get("zhuy").getImage());
		// bos.close();

	}

	public void testgetWinProfileForStudentUser() throws IOException {
		super.setWakeServResponse("WinProfileResponse.xml");
		WinProfileRequest request = new WinProfileRequest();
		request.setWebServiceUrl(super.MOCK_URL);
		request.setWinUsers(getTestUsers());
		request.setRemotePhotoLocation(remoteLocation);

		request.setRequesterUserType("STU");
		request.setRequesterUserId("user2");
		WinProfileResponse response = super.winProfileService
				.getWinProfiles(request);
		log.info("send request to remote: " + super.MOCK_URL);
		assertNotNull(response);

		// student user should still see the photo		
		// the privacy control is in InotadoService
		assertNotNull(response.getProfiles().get("user1").getImage());

		// image should be allowed to display for same user regardless the
		// privacy indicator
		request.setRequesterUserId("user1");
		response = super.winProfileService.getWinProfiles(request);
		assertNotNull(response);
		assertNotNull(response.getProfiles().get("user1").getImage());

	}
	
	public void testgetWinProfileForUnknownUser() throws IOException {
		super.setWakeServResponse("WinProfileResponse.xml");
		WinProfileRequest request = new WinProfileRequest();
		request.setWebServiceUrl(super.MOCK_URL);
		request.setWinUsers(getTestUsers());
		request.setRemotePhotoLocation(remoteLocation);
		
		// image should not be set for unknown user
		// it will be removed from response in InotadoService
		request.setRequesterUserType("unknown type");
		request.setRequesterUserId("user-unknown");
		WinProfileResponse response = super.winProfileService.getWinProfiles(request);
		assertNotNull(response);
		assertNotNull(response.getProfiles().get("user1").getImage());
	}

	public void testGetRemotePhotoAsByteArray() throws IOException {
		byte[] image = super.winProfileService
				.getRemotePhotoAsByteArray("https://win.wfu.edu/images/dir/JGBFBGK.JPG");
		assertNotNull(image);
		FileOutputStream output = new FileOutputStream(
				new File(outPutPhotoName));
		BufferedOutputStream bos = new BufferedOutputStream(output);
		bos.write(image);
		bos.close();

	}

	private List<String> getTestUsers() {
		List<String> users = new ArrayList<String>();
		users.add("user1");
		users.add("user2");
		users.add("unknownuser1");
		return users;
	}

}
