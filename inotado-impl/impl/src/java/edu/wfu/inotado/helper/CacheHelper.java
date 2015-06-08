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

package edu.wfu.inotado.helper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.Element;

public class CacheHelper {
	private final Log log = LogFactory.getLog(this.getClass());

	@SuppressWarnings("unchecked")
	public <T> T getFromCache(String key, Cache cache) {
		T obj = null;
		try {
			net.sf.ehcache.Element elem = null;
			if (key != null)
				elem = cache.get(key);
			if (cache != null && elem != null) {
				if (elem.getObjectValue() != null)
					obj = (T) elem.getObjectValue();
			}
		} catch (CacheException e) {
			log.warn("Unalble to check cache " + cache.getName(), e);
		}
		return obj;
	}

	public void saveToCache(String key, Object obj, Cache cache) {
		if (cache != null) {
			cache.put(new Element(key, obj));
		}
	}

}
