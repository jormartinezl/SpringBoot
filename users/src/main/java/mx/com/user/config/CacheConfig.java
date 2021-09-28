package mx.com.user.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

	public CacheManager getCache() {
		return new ConcurrentMapCacheManager("users");//se configuran los nombres de los caches
	}
}
