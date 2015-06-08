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

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.bootstrap.BootstrapCacheLoader;
import net.sf.ehcache.constructs.blocking.CacheEntryFactory;
import net.sf.ehcache.constructs.blocking.SelfPopulatingCache;
import net.sf.ehcache.constructs.blocking.UpdatingCacheEntryFactory;
import net.sf.ehcache.constructs.blocking.UpdatingSelfPopulatingCache;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class EhCacheFactoryBeanMock implements FactoryBean, BeanNameAware,
		InitializingBean {

	private final Log log = LogFactory.getLog(this.getClass());
	
	private int maxElementsInMemory = 10000;

	private int maxElementsOnDisk = 10000000;

	private MemoryStoreEvictionPolicy memoryStoreEvictionPolicy = MemoryStoreEvictionPolicy.LRU;

	private boolean overflowToDisk = false;

	private boolean eternal = false;

	private int timeToLive = 120;

	private int timeToIdle = 120;

	private boolean diskPersistent = false;

	private int diskExpiryThreadIntervalSeconds = 120;

	private int diskSpoolBufferSize = 0;

	private boolean clearOnFlush = true;

	private boolean blocking = false;
	
	private CacheEntryFactory cacheEntryFactory;

	private BootstrapCacheLoader bootstrapCacheLoader;

	private CacheManager cacheManager;
	
	private String cacheName;

	private String beanName;

	private Ehcache cache;

	public CacheEntryFactory getCacheEntryFactory() {
		return cacheEntryFactory;
	}

	public void setCacheEntryFactory(CacheEntryFactory cacheEntryFactory) {
		this.cacheEntryFactory = cacheEntryFactory;
	}

	public CacheManager getCacheManager() {
		return cacheManager;
	}

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	public String getCacheName() {
		return cacheName;
	}

	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		// If no CacheManager given, fetch the default.
		if (this.cacheManager == null) {
			if (log.isDebugEnabled()) {
				log.debug("Using default EHCache CacheManager for cache region '"
						+ this.cacheName + "'");
			}
			this.cacheManager = CacheManager.getInstance();
		}

		// If no cache name given, use bean name as cache name.
		if (this.cacheName == null) {
			this.cacheName = this.beanName;
		}

		// Fetch cache region: If none with the given name exists,
		// create one on the fly.
		Ehcache rawCache;
		
		/**
		if (this.cacheManager.cacheExists(this.cacheName)) {
			if (log.isDebugEnabled()) {
				log.debug("Using existing EHCache cache region '"
						+ this.cacheName + "'");
			}
			rawCache = this.cacheManager.getEhcache(this.cacheName);
		} else {
			if (log.isDebugEnabled()) {
				log.debug("Creating new EHCache cache region '"
						+ this.cacheName + "'");
			}
			rawCache = createCache();
			this.cacheManager.addCache(rawCache);
		}

		// Decorate cache if necessary.
		Ehcache decoratedCache = decorateCache(rawCache);
		if (decoratedCache != rawCache) {
			this.cacheManager.replaceCacheWithDecoratedCache(rawCache,
					decoratedCache);
		}
		
		this.cache = decoratedCache;
		**/
		
	}

	@Override
	public void setBeanName(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getObject() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class getObjectType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Decorate the given Cache, if necessary.
	 * @param cache the raw Cache object, based on the configuration of this FactoryBean
	 * @return the (potentially decorated) cache object to be registered with the CacheManager
	 */
	protected Ehcache decorateCache(Ehcache cache) {
		if (this.cacheEntryFactory != null) {
			if (this.cacheEntryFactory instanceof UpdatingCacheEntryFactory) {
				return new UpdatingSelfPopulatingCache(cache, (UpdatingCacheEntryFactory) this.cacheEntryFactory);
			}
			else {
				return new SelfPopulatingCache(cache, this.cacheEntryFactory);
			}
		}
		return cache;
	}
	
	/**
	 * Create a raw Cache object based on the configuration of this FactoryBean.
	 */
	protected Cache createCache() {
		// Only call EHCache 1.6 constructor if actually necessary (for compatibility with EHCache 1.3+)
		Cache cache = (!this.clearOnFlush) ?
				new Cache(this.cacheName, this.maxElementsInMemory, this.memoryStoreEvictionPolicy,
						this.overflowToDisk, null, this.eternal, this.timeToLive, this.timeToIdle,
						this.diskPersistent, this.diskExpiryThreadIntervalSeconds, null,
						this.bootstrapCacheLoader, this.maxElementsOnDisk, this.diskSpoolBufferSize,
						this.clearOnFlush) :
				new Cache(this.cacheName, this.maxElementsInMemory, this.memoryStoreEvictionPolicy,
						this.overflowToDisk, null, this.eternal, this.timeToLive, this.timeToIdle,
						this.diskPersistent, this.diskExpiryThreadIntervalSeconds, null,
						this.bootstrapCacheLoader, this.maxElementsOnDisk, this.diskSpoolBufferSize);

		net.sf.ehcache.config.CacheConfiguration config = cache.getCacheConfiguration();
		config.setMaxEntriesLocalHeap(maxElementsInMemory);
		return cache;
	}

}
