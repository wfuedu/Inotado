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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URL;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.sakaiproject.component.cover.ComponentManager;
import org.simpleframework.http.core.ContainerServer;
import org.simpleframework.transport.Server;
import org.simpleframework.transport.connect.Connection;
import org.simpleframework.transport.connect.SocketConnection;
import org.springframework.test.AbstractTransactionalSpringContextTests;

import edu.wfu.inotado.dao.InotadoDao;
import edu.wfu.inotado.dao.SchoolChaptersDao;
import edu.wfu.inotado.helper.EncryptionHelper;
import edu.wfu.inotado.helper.MarshalHelper;
import edu.wfu.inotado.helper.NotificationHelper;
import edu.wfu.inotado.helper.OAuthHelper;
import edu.wfu.inotado.helper.RestClientHelper;
import edu.wfu.inotado.win.WinProfileService;
import edu.wfu.inotado.api.SyncResourcesService;
import edu.wfu.inotado.mock.EhCacheFactoryBeanMock;
import edu.wfu.inotado.mock.GradebookServiceMock;
import edu.wfu.inotado.mock.ServerConfigurationServiceMock;
import edu.wfu.inotado.mock.SessionManagerMock;
import edu.wfu.inotado.mock.SiteServiceMock;
import edu.wfu.inotado.mock.UserDirectoryServiceMock;

public class InotadoTestBase extends AbstractTransactionalSpringContextTests {

	private final Log log = LogFactory.getLog(this.getClass());

	// the web port of mock server. e.g., 9999. then the server address would be
	// http://localhost:9999/
	private static int SERVER_PORT = 9999;

	// The mock server address
	public final String MOCK_URL = "http://localhost:9999";

	protected RestClientHelper restClientHelper;

	protected MarshalHelper marshHelper;

	protected WinProfileService winProfileService;

	private WakeServMockServer container;

	private Server server;

	private Connection connection;

	private SocketAddress address;

	protected boolean isWakeServMocServerRunning = false;

	protected EncryptionHelper encryptionHelper;

	protected OAuthHelper oauthHelper;

	protected InotadoDao inotadoDao;

	protected SchoolChaptersDao schoolChaptersDao;

	protected SyncResourcesService syncResourcesService;

	protected NotificationHelper notificationHelper;

	// instance init block
	{
		setUpLogger();
	}

	private void setUpLogger() {
		ConsoleAppender console = new ConsoleAppender(); // create appender
		// configure the appender
		String PATTERN = "%d [%p|%c|%C{1}] %m%n";
		console.setLayout(new PatternLayout(PATTERN));
		// modify the logger level as needed
		console.setThreshold(Level.DEBUG);
		console.activateOptions();

		Logger.getRootLogger().setAdditivity(false);
		// Logger.getRootLogger().addAppender(console);
		Logger.getLogger("org.hibernate").addAppender(console);
		Logger.getLogger("org.hibernate").setAdditivity(false);

		Logger.getLogger("edu.wfu").addAppender(console);
		Logger.getLogger("edu.wfu").setAdditivity(false);

	}

	@Override
	protected String[] getConfigLocations() {
		return new String[] { "logic-beans.xml", "hibernate-test.xml",
				"logic-beans-test.xml", "hibernate-spring.xml"

		};
	}

	@Override
	protected void onSetUpBeforeTransaction() throws Exception {
		this.startWakeServMockServer();

	}

	@Override
	protected void endTransaction() {
		this.shutdownWakeServMockServer();
		// super.endTransaction();
	}

	@Override
	protected void onSetUpInTransaction() throws Exception {
		// turn componentmanager into testing mode.
		ComponentManager.testingMode = true;
		ComponentManager.shutdown();
		assertTrue(ComponentManager.isTestingMode());
		setupMockBeans();

		this.restClientHelper = (RestClientHelper) applicationContext
				.getBean("edu.wfu.inotado.helper.RestClientHelper");
		assertNotNull(this.restClientHelper);
		this.marshHelper = (MarshalHelper) applicationContext
				.getBean("edu.wfu.inotado.helper.MarshalHelper");
		assertNotNull(this.marshHelper);
		this.winProfileService = (WinProfileService) applicationContext
				.getBean("edu.wfu.inotado.win.WinProfileService");
		assertNotNull(this.winProfileService);
		this.encryptionHelper = (EncryptionHelper) applicationContext
				.getBean("edu.wfu.inotado.helper.EncryptionHelper");
		assertNotNull(this.encryptionHelper);
		this.oauthHelper = (OAuthHelper) applicationContext
				.getBean("edu.wfu.inotado.helper.OAuthHelper");
		assertNotNull(this.oauthHelper);
		this.inotadoDao = (InotadoDao) applicationContext
				.getBean("edu.wfu.inotado.dao.InotadoDao");
		assertNotNull(this.inotadoDao);
		this.syncResourcesService = (SyncResourcesService) applicationContext
				.getBean("edu.wfu.inotado.api.SyncResourcesService");
		assertNotNull(this.syncResourcesService);
		this.notificationHelper = (NotificationHelper) applicationContext
				.getBean("edu.wfu.inotado.helper.NotificationHelper");
		assertNotNull(this.notificationHelper);
		this.schoolChaptersDao = (SchoolChaptersDao) applicationContext
				.getBean("edu.wfu.inotado.dao.SchoolChaptersDao");

		this.loadTestData();
	}

	/**
	 * Load all mock beans that we need in the testing. Those mock beans do not
	 * need to be defined in the Spring context.
	 */
	private void setupMockBeans() {
		ComponentManager.loadComponent(
				"org.sakaiproject.service.gradebook.GradebookService",
				new GradebookServiceMock());
		ComponentManager.loadComponent(
				"org.sakaiproject.user.api.UserDirectoryService",
				new UserDirectoryServiceMock());
		ComponentManager.loadComponent("org.sakaiproject.site.api.SiteService",
				new SiteServiceMock());
		ComponentManager.loadComponent(
				"org.sakaiproject.tool.api.SessionManager",
				new SessionManagerMock());
		ComponentManager.loadComponent("edu.wfu.inotado.oauthConsumerCache",
				new EhCacheFactoryBeanMock());
		ComponentManager.loadComponent(
				"org.sakaiproject.component.api.ServerConfigurationService",
				new ServerConfigurationServiceMock());
	}

	protected void setWakeServResponse(String xmlFileName) {
		// Start the server first
		if (!this.isWakeServMocServerRunning) {
			startWakeServMockServer();
		} else {
			this.container.setBodyText(readXmlFromFile(xmlFileName));
		}

	}

	private void startWakeServMockServer() {
		if (this.container == null) {
			container = new WakeServMockServer();
		}
		try {
			this.server = new ContainerServer(container);
			this.connection = new SocketConnection(this.server);
			this.address = new InetSocketAddress(SERVER_PORT);
			this.connection.connect(address);
			this.isWakeServMocServerRunning = true;
		} catch (IOException e) {
			log.error("Unable to start the mock server. ", e);
		}
	}

	private void shutdownWakeServMockServer() {
		try {
			if (this.connection != null) {
				this.connection.close();
				this.isWakeServMocServerRunning = false;
			}
		} catch (IOException e) {
			log.error("Unable to shutdown the mock server. ", e);
		}
	}

	/**
	 * Reads a XML file from directory - inotado-api/api/resources/xml
	 * 
	 * @param fileName
	 */
	@SuppressWarnings("resource")
	protected String readXmlFromFile(String fileName) {
		BufferedReader br;
		String xmlStr = "No content available!";
		// get the file location
		URL location = this.getClass().getProtectionDomain().getCodeSource()
				.getLocation();
		String pathCurrent = location.getFile();
		String pathToXml = StringUtils.substringBefore(pathCurrent,
				"inotado-") + "/inotado-api/api/resources/xml/";
		String file = pathToXml + fileName;
		try {
			br = new BufferedReader(new FileReader(file));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append('\n');
				line = br.readLine();
			}
			xmlStr = sb.toString();
		} catch (FileNotFoundException e) {
			log.error("Unalbe to read the file:" + file, e);
		} catch (IOException e) {
			log.error("Erorr occurred while reading file:" + file, e);
		}
		return xmlStr;
	}

	/**
	 * Reads a Json file from directory - inotado-api/api/resources/json
	 * 
	 * @param fileName
	 */
	@SuppressWarnings("resource")
	protected String readJsonFromFile(String fileName) {
		BufferedReader br;
		String jsonStr = "No content available!";
		// get the file location
		URL location = this.getClass().getProtectionDomain().getCodeSource()
				.getLocation();
		String pathCurrent = location.getFile();
		String pathToXml = StringUtils.substringBefore(pathCurrent,
				"inotado-") + "/inotado-api/api/resources/json/";
		String file = pathToXml + fileName;
		try {
			br = new BufferedReader(new FileReader(file));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append('\n');
				line = br.readLine();
			}
			jsonStr = sb.toString();
		} catch (FileNotFoundException e) {
			log.error("Unalbe to read the file:" + file, e);
		} catch (IOException e) {
			log.error("Erorr occurred while reading file:" + file, e);
		}
		return jsonStr;
	}

	public void loadTestData() {

	}

}
