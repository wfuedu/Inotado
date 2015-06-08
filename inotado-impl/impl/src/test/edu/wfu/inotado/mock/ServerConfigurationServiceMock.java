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

package edu.wfu.inotado.mock;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.sakaiproject.component.api.ServerConfigurationService;

public class ServerConfigurationServiceMock implements
		ServerConfigurationService {

	@Override
	public String getAccessPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAccessUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getBoolean(String arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> getCategoryGroups(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getConfig(String arg0, T arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConfigData getConfigData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConfigItem getConfigItem(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getDefaultTools(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGatewaySiteId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHelpUrl(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getInt(String arg0, int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Locale getLocaleFromString(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLoggedOutUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPortalUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRawProperty(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSakaiHomePath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Locale[] getSakaiLocales() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServerId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServerIdInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServerInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServerName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServerUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getString(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getString(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getStrings(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getToolCategories(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, List<String>> getToolCategoriesAsMap(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getToolGroup(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getToolOrder(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getToolToCategoryMap(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getToolUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getToolsRequired(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserHomeUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConfigItem registerConfigItem(ConfigItem arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerListener(ConfigurationListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean toolGroupIsRequired(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean toolGroupIsSelected(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}}
