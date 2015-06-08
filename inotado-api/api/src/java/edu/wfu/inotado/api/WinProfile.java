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

package edu.wfu.inotado.api;

/**
 * This object contains all necessary properties of a profile in win.
 * 
 * @author zhuy
 * 
 */
public class WinProfile {
	private String userId;

	// image as byte array
	private byte[] image;

	private String imageFileName;

	private String imageUrl;
	
	private boolean imagePrivacy;

	// create a copy of object
	public WinProfile copy() {
		WinProfile clonedWinProfile = new WinProfile();
		clonedWinProfile.setUserId(this.userId);
		clonedWinProfile.setImage(this.image);
		clonedWinProfile.setImageFileName(this.imageFileName);
		clonedWinProfile.setImageUrl(this.imageUrl);
		clonedWinProfile.setImagePrivacy(this.imagePrivacy);
		return clonedWinProfile;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isImagePrivacy() {
		return imagePrivacy;
	}

	public void setImagePrivacy(boolean imagePrivacy) {
		this.imagePrivacy = imagePrivacy;
	}

}