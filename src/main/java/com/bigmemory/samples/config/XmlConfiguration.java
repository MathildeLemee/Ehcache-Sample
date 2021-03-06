package com.bigmemory.samples.config;

import net.sf.ehcache.CacheManager;

/*
* Released to the public domain, as explained at  http://creativecommons.org/licenses/publicdomain
*/
public class XmlConfiguration {

  public void ehcacheComplete() {
    CacheManager manager = CacheManager.newInstance(getClass().getResource("/clustered/ehcache-complete.xml"));
    manager.getCache("sample-offheap-cache");

    //your cache is now ready.


    manager.shutdown();
  }
}
