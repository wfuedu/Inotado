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

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.sakaiproject.entity.api.Entity;
import org.sakaiproject.entity.api.HttpAccess;
import org.sakaiproject.entity.api.Reference;
import org.sakaiproject.entity.api.ResourceProperties;
import org.sakaiproject.exception.IdInvalidException;
import org.sakaiproject.exception.IdUnusedException;
import org.sakaiproject.exception.IdUsedException;
import org.sakaiproject.exception.PermissionException;
import org.sakaiproject.javax.PagingPosition;
import org.sakaiproject.site.api.AllowedJoinableAccount;
import org.sakaiproject.site.api.Group;
import org.sakaiproject.site.api.Site;
import org.sakaiproject.site.api.SiteAdvisor;
import org.sakaiproject.site.api.SitePage;
import org.sakaiproject.site.api.SiteService;
import org.sakaiproject.site.api.ToolConfiguration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SiteServiceMock implements SiteService {

	@Override
	public String archive(String arg0, Document arg1, Stack<Element> arg2,
			String arg3, List<Reference> arg4) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity getEntity(Reference arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<String> getEntityAuthzGroups(Reference arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEntityDescription(Reference arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResourceProperties getEntityResourceProperties(Reference arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEntityUrl(Reference arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpAccess getHttpAccess() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String merge(String arg0, Element arg1, String arg2, String arg3,
			Map<String, String> arg4, Map<String, String> arg5, Set<String> arg6) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean parseEntityReference(String arg0, Reference arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean willArchiveMerge() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Site addSite(String arg0, String arg1) throws IdInvalidException,
			IdUsedException, PermissionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Site addSite(String arg0, Site arg1) throws IdInvalidException,
			IdUsedException, PermissionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addSiteAdvisor(SiteAdvisor arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean allowAccessSite(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean allowAddCourseSite() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean allowAddPortfolioSite() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean allowAddProjectSite() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean allowAddSite(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean allowRemoveSite(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean allowRoleSwap(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean allowUnjoinSite(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean allowUpdateGroupMembership(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean allowUpdateSite(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean allowUpdateSiteMembership(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean allowViewRoster(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int countSites(SelectionType arg0, Object arg1, String arg2,
			Map<String, String> arg3) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Group findGroup(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SitePage findPage(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ToolConfiguration findTool(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedHashSet<String> getAllowedJoinableAccountTypeCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAllowedJoinableAccountTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AllowedJoinableAccount> getAllowedJoinableAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getJoinGroupId(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getLayoutNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Site getSite(String arg0) throws IdUnusedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SiteAdvisor> getSiteAdvisors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSiteDisplay(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getSiteIds(SelectionType arg0, Object arg1,
			String arg2, Map<String, String> arg3, SortType arg4,
			PagingPosition arg5) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSiteSkin(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSiteSpecialId(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getSiteTypeStrings(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getSiteTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSiteUserId(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Site getSiteVisit(String arg0) throws IdUnusedException,
			PermissionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Site> getSites(SelectionType arg0, Object arg1, String arg2,
			Map<String, String> arg3, SortType arg4, PagingPosition arg5) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Site> getSites(SelectionType arg0, Object arg1, String arg2,
			Map<String, String> arg3, SortType arg4, PagingPosition arg5,
			boolean arg6) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Site> getSoftlyDeletedSites() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSpecialSiteId(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserSiteId(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Site> getUserSites() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Site> getUserSites(boolean arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAllowedToJoin(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCurrentUserMemberOfSite(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGlobalJoinExcludedFromPublicListEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGlobalJoinFromSiteBrowserEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGlobalJoinGroupEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGlobalJoinLimitByAccountTypeEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLimitByAccountTypeEnabled(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSpecialSite(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUserSite(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void join(String arg0) throws IdUnusedException, PermissionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String merge(String arg0, Element arg1, String arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeSite(Site arg0) throws PermissionException,
			IdUnusedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean removeSiteAdvisor(SiteAdvisor arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void save(Site arg0) throws IdUnusedException, PermissionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveGroupMembership(Site arg0) throws IdUnusedException,
			PermissionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveSiteInfo(String arg0, String arg1, String arg2)
			throws IdUnusedException, PermissionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveSiteMembership(Site arg0) throws IdUnusedException,
			PermissionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSiteSecurity(String arg0, Set<String> arg1,
			Set<String> arg2, Set<String> arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUserSecurity(String arg0, Set<String> arg1,
			Set<String> arg2, Set<String> arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean siteExists(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String siteGroupReference(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sitePageReference(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String siteReference(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String siteToolReference(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unjoin(String arg0) throws IdUnusedException,
			PermissionException {
		// TODO Auto-generated method stub
		
	}}
