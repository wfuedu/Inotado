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

public enum WinUserType {
	
	// Those are the types set in LDAP
	student("STU"), faculty("FAC"), guest("GST"), staff("STF");

	private final String type;

	private WinUserType(String type) {
		this.type = type;
	}
	
	public boolean equals(String otherType) {
		return (otherType == null) ? false : this.type.equalsIgnoreCase(otherType);
	}
	
	@Override
	public String toString(){
		return this.type;
	}

}
