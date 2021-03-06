package com.bigmemory.samples.config;
/*
 * Released to the public domain, as explained at  http://creativecommons.org/licenses/publicdomain
 */

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.Configuration;
import net.sf.ehcache.config.MemoryUnit;
import net.sf.ehcache.config.PersistenceConfiguration;
import net.sf.ehcache.config.TerracottaClientConfiguration;
import net.sf.ehcache.config.TerracottaConfiguration;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;

public class JavaConfiguration {

  public void ehcacheComplete() {

    Configuration managerConfiguration = new Configuration();
    managerConfiguration.updateCheck(true)
        .monitoring(Configuration.Monitoring.AUTODETECT)
        .name("cacheManagerCompleteExample")
        .dynamicConfig(true).terracotta(new TerracottaClientConfiguration().url("localhost:9510"));

    CacheManager manager = CacheManager.create(managerConfiguration);

    Cache testCache = new Cache(
        new CacheConfiguration("sample-offheap-cache", 10000)
            .timeToLiveSeconds(60)
            .timeToIdleSeconds(30)
            .maxMemoryOffHeap("1G")
            .terracotta(new TerracottaConfiguration().clustered(true)
                .consistency(TerracottaConfiguration.Consistency.STRONG)));
    manager.addCache(testCache);


    //your cache is now ready.


    manager.shutdown();
  }
}
