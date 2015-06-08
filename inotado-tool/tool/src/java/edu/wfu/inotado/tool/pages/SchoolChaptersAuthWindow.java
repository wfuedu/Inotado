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

import java.util.Date;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.googlecode.wicket.jquery.core.JQueryBehavior;
import com.googlecode.wicket.kendo.ui.form.button.AjaxButton;
import com.googlecode.wicket.kendo.ui.widget.notification.Notification;
import com.googlecode.wicket.kendo.ui.widget.window.AbstractWindow;

import edu.wfu.inotado.api.Constants;
import edu.wfu.inotado.api.InotadoService;
import edu.wfu.inotado.model.AuthStore;

class SchoolChaptersAuthWindow extends AbstractWindow<Void> {

	private static final long serialVersionUID = 1L;
	private AuthStore authStore;

	@SpringBean(name = "edu.wfu.inotado.api.InotadoService")
	private InotadoService inotadoService;

	final PasswordTextField consumerSecret = new PasswordTextField(
			"consumerSecret", Model.of(""));

	final TextField<String> consumerKey = new TextField<String>("consumerKey",
			Model.of(""));

	public SchoolChaptersAuthWindow(String id, String title,
			final AuthStore authStore) {
		super(id, title, true);
		this.authStore = authStore;

		final Notification notification = new Notification(
				"authWindowNotification");
		this.add(notification);

		// form
		final Form<?> authForm = new Form("authenticationForm");
		this.add(authForm);

		// TextFields
		Label consumerKeyLabel = new Label("consumerKeyLabel",
				new ResourceModel("label.consumer.key"));
		authForm.add(consumerKeyLabel);
		
		consumerKey.setMarkupId("consumerKey");
		consumerKey.setRequired(false);
		authForm.add(consumerKey);

		Label consumerSecretabel = new Label("consumerSecretLabel",
				new ResourceModel("label.consumer.secret"));
		authForm.add(consumerSecretabel);
		
		consumerSecret.setMarkupId("consumerSecret");
		consumerSecret.setRequired(false);
		consumerSecret.setResetPassword(false);
		authForm.add(consumerSecret);

		// set the values stored in authStore
		if (authStore != null) {
			consumerKey.setModel(Model.of(authStore.getConsumerKey()));
			consumerSecret.setModel(Model.of(authStore.getConsumerSecret()));
		} else {
			// blank out the values
			consumerKey.setModel(Model.of(""));
			consumerSecret.setModel(Model.of(""));
		}

		// Buttons
		authForm.add(new AjaxButton("closeButton") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				SchoolChaptersAuthWindow.this.close(target);
			}
		});

		authForm.add(new AjaxButton("saveButton") {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				String key = consumerKey.getModelObject();
				String secret = consumerSecret.getModelObject();
				authStore.setConsumerKey(key);
				authStore.setConsumerSecret(secret);
				authStore.setSystemName(Constants.SCHOOL_CHAPTERS);
				authStore.setModified(new Date());
				inotadoService.saveAuthStore(authStore);
				SchoolChaptersAuthWindow.this.close(target);
			}
		});
	}

	@Override
	public boolean isCloseEventEnabled() {
		return true;
	}

	@Override
	public void onConfigure(JQueryBehavior behavior) {
		super.onConfigure(behavior);
		behavior.setOption("actions", "['Close']");
	}

	@Override
	protected void onOpen(AjaxRequestTarget target) {
		// resets the value before openning the window
		if (authStore != null) {
			consumerKey.setModel(Model.of(authStore.getConsumerKey()));
			consumerSecret.setModel(Model.of(authStore.getConsumerSecret()));
			target.add(consumerKey);
			target.add(consumerSecret);
		}
		super.onOpen(target);
	}

	/**
	 * Resets the authStore
	 * 
	 * @param authStore
	 */
	public void setAuthStore(AuthStore authStore) {
		if (authStore != null) {
			this.authStore = authStore;
		}

	}

}
