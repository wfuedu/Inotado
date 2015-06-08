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

package edu.wfu.inotado.tool.pages;

import org.apache.commons.lang.StringUtils;
import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.pages.RedirectPage;

import com.googlecode.wicket.kendo.ui.form.button.AjaxButton;
import com.googlecode.wicket.kendo.ui.widget.notification.Notification;

import edu.wfu.inotado.api.Constants;
import edu.wfu.inotado.model.AuthStore;

public class SchoolChaptersPage extends BasePage {

	public SchoolChaptersPage() {
		disableLink(schoolChaptersLink);

		// gets the authStore object
		AuthStore authStore = inotadoService
				.getAuthStoreForCurrentUser(Constants.SCHOOL_CHAPTERS);
		if (authStore == null) {
			authStore = new AuthStore();
		}

		final Notification notification = new Notification("scNotification");
		this.add(notification);

		// Form
		Form<?> authForm = new Form("authenticationForm");
		this.add(authForm);

		final SchoolChaptersAuthWindow settingWindow = new SchoolChaptersAuthWindow(
				"settingWindow", "Settings", authStore);
		this.add(settingWindow);

		final AjaxButton editAuthButton = new AjaxButton("editAuthButton") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				settingWindow.setAuthStore(inotadoService
						.getAuthStoreForCurrentUser(Constants.SCHOOL_CHAPTERS));
				settingWindow.open(target);
			}
		};
		authForm.add(editAuthButton);

		final ModalWindow authWindow = new ModalWindow("authWindow");
		this.add(authWindow);

		final AjaxButton authButton = new AjaxButton("authButton") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				// retrieve the url for OAuth authentication
				AuthStore authStore = inotadoService
						.getAuthStoreForCurrentUser(Constants.SCHOOL_CHAPTERS);
				final String authUrl = inotadoService
						.getSchoolChaptersAuthUrl(authStore);

				if (!StringUtils.isBlank(authUrl)) {
					notification.success(target,
							"Key and secret have been accepted");
					authWindow.setPageCreator(new ModalWindow.PageCreator() {
						@Override
						public Page createPage() {
							return new RedirectPage(authUrl);
						}
					});
					authWindow.show(target);
				} else {
					notification.error(target, "Invalid key or secret!");
				}
			}
		};

		authForm.add(authButton);

		final AjaxButton sendRequestButton = new AjaxButton("sendRequestButton") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				try {					
					syncResourcesService.syncAssignments();
					notification.success(target, "Data retrived successfully");
				} catch (Exception e) {
					notification.error(target, "Unable to process request. "
							+ e.getMessage());
				}
			}
		};

		authForm.add(sendRequestButton);

	}

}
