package com.demo;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.junit.Test;

public class EhcacheTest {
	@Test
	public void test() throws Exception{
		CacheManager manager = CacheManager.create("src/main/resources/ehcache-config.xml");
		Cache cache = manager.getCache("c99");
		cache.put(new Element("1", 1));
		Element e = cache.get("1");
		System.out.println(e.getObjectValue());
		manager.shutdown();		
		System.out.println(e.getObjectValue());
	}
}
