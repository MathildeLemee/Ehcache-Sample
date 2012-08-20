package com.bigmemory.samples.config;
/*
 * Released to the public domain, as explained at  http://creativecommons.org/licenses/publicdomain
 */

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.MemoryUnit;
import net.sf.ehcache.config.PersistenceConfiguration;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;

public class JavaConfiguration {

  public static void main(String[] args) {
    //Create a singleton CacheManager using defaults
    CacheManager manager = CacheManager.create();

    //Create a Cache specifying its configuration.
    int maxEntriesLocalHeap = 1000;
    Cache testCache = new Cache(
        new CacheConfiguration("sample-offheap-cache", 1000)
            .memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.LFU)
            .persistence(new PersistenceConfiguration().strategy(PersistenceConfiguration.Strategy.LOCALTEMPSWAP))
            .eternal(false)
            .timeToLiveSeconds(60)
            .timeToIdleSeconds(30)
            .overflowToOffHeap(true)  //enabled big memory
            .maxBytesLocalHeap(2, MemoryUnit.GIGABYTES) //define the size of the local heap
            .diskExpiryThreadIntervalSeconds(0));

    manager.addCache(testCache);
  }

}
