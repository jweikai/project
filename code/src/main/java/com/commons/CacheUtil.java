package com.commons;

import java.net.URL;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CacheUtil {
	private static CacheManager manager = CacheManager.create(CacheUtil.class.getResource("/ehcache-config.xml"));
	/**
	 * 短时间缓存
	 */
	public static final String LEVEL01 = "c01";
	/**
	 * 长时间缓存
	 */
	public static final String LEVEL02 = "c02";
	/**
	 * 永久缓存
	 */
	public static final String LEVEL99 = "c99";
	public static void cacheSetObj(Object key, Object value, String type) {
		Cache cache = manager.getCache(type);
		cache.put(new Element(key, value));		
	}
	public static Object cacheGetObj(Object key, String type) {
		Cache cache = manager.getCache(type);
		Element e = cache.get(key);
		Object obj = null;
		if ( e != null ) {
			obj = e.getObjectValue();
		}
		return obj;
	}
	public static void cacheRemoveObj(Object key, String type) {
		Cache cache = manager.getCache(type);				
		cache.remove(key);
	}
}
