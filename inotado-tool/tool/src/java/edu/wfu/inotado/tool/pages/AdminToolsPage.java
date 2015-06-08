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

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.Model;
import org.sakaiproject.coursemanagement.api.AcademicSession;

import com.googlecode.wicket.jquery.core.Options;
import com.googlecode.wicket.kendo.ui.form.TextArea;
import com.googlecode.wicket.kendo.ui.form.button.AjaxButton;
import com.googlecode.wicket.kendo.ui.form.dropdown.DropDownList;
import com.googlecode.wicket.kendo.ui.panel.KendoFeedbackPanel;

import edu.wfu.inotado.api.InotadoResponse;

public class AdminToolsPage extends BasePage {

	private final Log log = LogFactory.getLog(getClass());

	public AdminToolsPage() {
		disableLink(adminToolsLink);

		// FeedbackConsole //
		Options options = new Options();
		options.set("button", true);

		final KendoFeedbackPanel updateFormFeedback = new KendoFeedbackPanel(
				"updateFormFeedback", options);
		this.add(updateFormFeedback);

		// current term selection dropdown
		List<AcademicSession> currentTerms = sakaiProxy
				.getCurrentAcademicSessions();

		final DropDownList<AcademicSession> termChoice = new DropDownList<AcademicSession>(
				"term", new Model(), currentTerms,
				new ChoiceRenderer<AcademicSession>("title", "eid"));
		termChoice.setOutputMarkupId(true);

		Form<?> hierarchyPropertyUpdateForm = new Form(
				"hierarchyPropertyUpdateForm");

		AjaxButton hierarchyPropertyUpdateButton = new AjaxButton(
				"hierarchyPropertyUpdateButton") {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				// get the term and execute job
				AcademicSession choice = termChoice.getModelObject();
				if (choice != null) {
					String term = choice.getEid();
					InotadoResponse response = inotadoService.executeHierarchyPropertyUpdateJob(term);
					if(response.isSuccess()){
						this.success(response.getSuccessMessage());
					}else{
						this.error(response.getErrorMessage());
					}									
				} else {
					this.error("No term selected");
				}

				// display message
				target.add(updateFormFeedback);
			}
		};

		hierarchyPropertyUpdateForm.add(hierarchyPropertyUpdateButton);

		add(hierarchyPropertyUpdateForm);

		hierarchyPropertyUpdateForm.add(termChoice);

		// Upload custom hierarchy properties section
		Form<?> customHierarchyPropertyUpdateForm = new Form(
				"customHierarchyPropertyUpdateForm");

		@SuppressWarnings("unchecked")
		final TextArea<?> customHierarchyProperties = new TextArea(
				"customHierarchyProperties", Model.of("")) {

			@Override
			protected void onComponentTag(ComponentTag tag) {
				super.onComponentTag(tag);
				// set the initial box size
				tag.getAttributes().put("style", "width:100%;height:220px");
			}
		};

		// FeedbackConsole //
		Options customUpdateOptions = new Options();
		customUpdateOptions.set("button", true);

		final KendoFeedbackPanel customUpdateformFeedback = new KendoFeedbackPanel(
				"customUpdateformFeedback", customUpdateOptions);
		this.add(customUpdateformFeedback);

		AjaxButton customHierarchyPropertyUpdateButton = new AjaxButton(
				"customHierarchyPropertyUpdateButton") {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				// get the text and execute job
				String text = (String) customHierarchyProperties
						.getModelObject();
				if (text != null) {
					log.debug("Captured text: " + text);
					InotadoResponse response = inotadoService.executeCustomPropertyUpdateJob(text);
					if(response.isSuccess()){
						this.success(response.getSuccessMessage());
					}else{
						this.error(response.getErrorMessage());
					}					
				} else {
					this.error("Text is blank");
				}

				// display message
				target.add(customUpdateformFeedback);
			}
		};

		add(customHierarchyPropertyUpdateForm);

		customHierarchyPropertyUpdateForm
				.add(customHierarchyPropertyUpdateButton);
		customHierarchyPropertyUpdateForm.add(customHierarchyProperties);

	}

}
