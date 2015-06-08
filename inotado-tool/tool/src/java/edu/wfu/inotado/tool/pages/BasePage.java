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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.OnLoadHeaderItem;
import org.apache.wicket.markup.head.StringHeaderItem;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import edu.wfu.inotado.api.InotadoService;
import edu.wfu.inotado.api.SakaiProxy;
import edu.wfu.inotado.api.SyncResourcesService;

public class BasePage extends WebPage implements IHeaderContributor {

	private final Log log = LogFactory.getLog(getClass());

	@SpringBean(name = "edu.wfu.inotado.api.SakaiProxy")
	protected SakaiProxy sakaiProxy;
	
	@SpringBean(name = "edu.wfu.inotado.api.InotadoService")
	protected InotadoService inotadoService;
	
	@SpringBean(name="edu.wfu.inotado.api.SyncResourcesService")
	protected SyncResourcesService syncResourcesService;

	Link<Void> landingPageLink;
	Link<Void> schoolChaptersLink;
	Link<Void> adminToolsLink;

	FeedbackPanel feedbackPanel;

	public BasePage() {
		log.debug("BasePage loaded");

		// landingPage link
		landingPageLink = new Link<Void>("landingPageLink") {
			private static final long serialVersionUID = 1L;

			public void onClick() {
				setResponsePage(new LandingPage());
			}
		};
		landingPageLink.add(new Label("landingPageLinkLabel",
				new ResourceModel("link.landingPage")).setRenderBodyOnly(true));
		landingPageLink.add(new AttributeModifier("title", true,
				new ResourceModel("link.landingPage.tooltip")));
		add(landingPageLink);

		// schoolChapters link
		schoolChaptersLink = new Link<Void>("schoolChaptersLink") {
			private static final long serialVersionUID = 1L;

			public void onClick() {
				setResponsePage(new SchoolChaptersPage());
			}
		};
		schoolChaptersLink.add(new Label("schoolChaptersLinkLabel",
				new ResourceModel("link.schoolChapters"))
				.setRenderBodyOnly(true));
		schoolChaptersLink.add(new AttributeModifier("title", true,
				new ResourceModel("link.schoolChapters.tooltip")));
		schoolChaptersLink.setVisibilityAllowed(sakaiProxy.isSuperUser());
		add(schoolChaptersLink);

		// AdminTools link
		adminToolsLink = new Link<Void>("adminToolsLink") {
			private static final long serialVersionUID = 1L;

			public void onClick() {
				setResponsePage(new AdminToolsPage());
			}
		};
		adminToolsLink.add(new Label("adminToolsLinkLabel",
				new ResourceModel("link.adminTools"))
				.setRenderBodyOnly(true));
		adminToolsLink.add(new AttributeModifier("title", true,
				new ResourceModel("link.adminTools.tooltip")));
		add(adminToolsLink);
		
		adminToolsLink.setVisibilityAllowed(sakaiProxy.isSuperUser());

		// Add a FeedbackPanel for displaying our messages
		feedbackPanel = new FeedbackPanel("feedback") {

			@Override
			protected Component newMessageDisplayComponent(final String id,
					final FeedbackMessage message) {
				final Component newMessageDisplayComponent = super
						.newMessageDisplayComponent(id, message);

				if (message.getLevel() == FeedbackMessage.ERROR
						|| message.getLevel() == FeedbackMessage.DEBUG
						|| message.getLevel() == FeedbackMessage.FATAL
						|| message.getLevel() == FeedbackMessage.WARNING) {
					add(new AttributeModifier("class", "alertMessage"));
				} else if (message.getLevel() == FeedbackMessage.INFO) {
					add(new AttributeModifier("class", "success"));
				}

				return newMessageDisplayComponent;
			}
		};
		add(feedbackPanel);

	}

	/**
	 * Helper to clear the feedbackpanel display.
	 * 
	 * @param f
	 *            FeedBackPanel
	 */
	public void clearFeedback(FeedbackPanel f) {
		if (!f.hasFeedbackMessage()) {
			f.add(new AttributeModifier("class", ""));
		}
	}

	/**
	 * This block adds the required wrapper markup to style it like a Sakai
	 * tool. Add to this any additional CSS or JS references that you need.
	 * 
	 */
	public void renderHead(IHeaderResponse response) {

		// get Sakai skin
		String skinRepo = sakaiProxy.getSkinRepoProperty();
		String toolCSS = sakaiProxy.getToolSkinCSS(skinRepo);
		String toolBaseCSS = skinRepo + "/tool_base.css";		

		// Sakai additions
		response.render(JavaScriptHeaderItem.forUrl(("/library/js/headscripts.js")));
		response.render(CssHeaderItem.forUrl(toolBaseCSS));
		response.render(CssHeaderItem.forUrl(toolCSS));
		response.render(OnLoadHeaderItem.forScript("setMainFrameHeight( window.name )"));

		// Tool additions (at end so we can override if required)
		response.render(StringHeaderItem.forString("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />"));
		
		// Inotado js and css import
		response.render(CssHeaderItem.forUrl("css/inotado.tool.css"));


		//for datepicker
//		response.render(CssHeaderItem.forUrl("css/flora.datepicker.css"));
//		response.render(JavaScriptHeaderItem.forUrl("js/jquery.ui.core-1.5.2.min.js"));
//		response.render(JavaScriptHeaderItem.forUrl("js/jquery.datepicker-1.5.2.min.js"));
		
		//add jQWidgets
		// NOTE: do not load jquery-1.11.1.min.js as it is already a part of wicket-jquery-ui
		response.render(JavaScriptHeaderItem.forUrl("js/jqwidgets/jqxcore.js"));
		response.render(JavaScriptHeaderItem.forUrl("js/jqwidgets/jqxbuttons.js"));
		response.render(JavaScriptHeaderItem.forUrl("js/jqwidgets/jqxtabs.js"));
		response.render(JavaScriptHeaderItem.forUrl("js/jqwidgets/jqxcheckbox.js"));
		response.render(CssHeaderItem.forUrl("js/jqwidgets/styles/jqx.base.css"));
		response.render(CssHeaderItem.forUrl("js/jqwidgets/styles/jqx.darkblue.css"));

	}

	/**
	 * Helper to disable a link. Add the Sakai class 'current'.
	 */
	protected void disableLink(Link<Void> l) {
		l.add(new AttributeAppender("class", new Model<String>("current"), " "));
		l.setRenderBodyOnly(true);
		l.setEnabled(false);
	}

}
