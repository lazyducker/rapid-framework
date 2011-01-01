package cn.org.rapid_framework.distributed.threadlocal;

import java.util.HashMap;
import java.util.Map;

public class DistributedThreadLocal {
	public static String DISTRIBUTED_THREAD_LOCAL_KEY_PREFIX = "tl_";
	
	public static ThreadLocal<Map<String, String>> threadLocal = new ThreadLocal<Map<String, String>>();

	public static void putAll(Map<String, String> map) {
		getMap().putAll(map);
	}
	
	public static void put(String key, String value) {
		getMap().put(key, value);
	}

	public static String get(String key) {
		Map<String, String> map = threadLocal.get();
		if (map == null)
			return null;
		return (String) map.get(key);
	}

	public static Map<String, String> getMap() {
		Map<String, String> map = threadLocal.get();
		if (map == null) {
			map = new HashMap();
			threadLocal.set(map);
		}
		return map;
	}

	public static void clear() {
		threadLocal.set(null);
	}



}