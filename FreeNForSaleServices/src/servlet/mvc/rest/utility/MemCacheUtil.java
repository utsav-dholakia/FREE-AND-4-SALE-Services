package servlet.mvc.rest.utility;

import java.io.IOException;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;

public class MemCacheUtil {
	private static final MemcachedClient MEMCACHED_CLIENT= createMemCacheClient();

	//@SuppressWarnings("deprecation")
	private static MemcachedClient createMemCacheClient() {
	    try {
			MemcachedClient memcachedClient = new MemcachedClient(AddrUtil.getAddresses("localhost:11211"));
			return memcachedClient;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Initial MemCache creation failed." + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static MemcachedClient getMemCachedClient() {
		return MEMCACHED_CLIENT;
	}

}
