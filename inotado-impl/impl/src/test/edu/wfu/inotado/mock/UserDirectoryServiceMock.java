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
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.sakaiproject.entity.api.Entity;
import org.sakaiproject.entity.api.HttpAccess;
import org.sakaiproject.entity.api.Reference;
import org.sakaiproject.entity.api.ResourceProperties;
import org.sakaiproject.user.api.PasswordPolicyProvider;
import org.sakaiproject.user.api.User;
import org.sakaiproject.user.api.UserAlreadyDefinedException;
import org.sakaiproject.user.api.UserDirectoryService;
import org.sakaiproject.user.api.UserEdit;
import org.sakaiproject.user.api.UserIdInvalidException;
import org.sakaiproject.user.api.UserLockedException;
import org.sakaiproject.user.api.UserNotDefinedException;
import org.sakaiproject.user.api.UserPermissionException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class UserDirectoryServiceMock implements UserDirectoryService {

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
	public UserEdit addUser(String arg0, String arg1)
			throws UserIdInvalidException, UserAlreadyDefinedException,
			UserPermissionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User addUser(String arg0, String arg1, String arg2, String arg3,
			String arg4, String arg5, String arg6, ResourceProperties arg7)
			throws UserIdInvalidException, UserAlreadyDefinedException,
			UserPermissionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean allowAddUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean allowRemoveUser(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean allowUpdateUser(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean allowUpdateUserEmail(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean allowUpdateUserName(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean allowUpdateUserPassword(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean allowUpdateUserType(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User authenticate(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancelEdit(UserEdit arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void commitEdit(UserEdit arg0) throws UserAlreadyDefinedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countSearchUsers(String arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countUsers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void destroyAuthentication() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserEdit editUser(String arg0) throws UserNotDefinedException,
			UserPermissionException, UserLockedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<User> findUsersByEmail(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getAnonymousUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getCurrentUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PasswordPolicyProvider getPasswordPolicy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String arg0) throws UserNotDefinedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByEid(String arg0) throws UserNotDefinedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserEid(String arg0) throws UserNotDefinedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserId(String arg0) throws UserNotDefinedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers(Collection<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsersByEids(Collection<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEdit mergeUser(Element arg0) throws UserIdInvalidException,
			UserAlreadyDefinedException, UserPermissionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUser(UserEdit arg0) throws UserPermissionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> searchExternalUsers(String arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> searchUsers(String arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String userReference(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PasswordRating validatePassword(String arg0, User arg1) {
		// TODO Auto-generated method stub
		return null;
	}}
