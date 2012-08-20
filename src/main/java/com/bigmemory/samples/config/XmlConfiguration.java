package com.bigmemory.samples.config;

import net.sf.ehcache.CacheManager;

/*
* Released to the public domain, as explained at  http://creativecommons.org/licenses/publicdomain
*/
public class XmlConfiguration {
  public static void main(String[] args) {
    CacheManager manager1 = CacheManager.newInstance("src/main/resources/ehcache.xml");

  }
}
