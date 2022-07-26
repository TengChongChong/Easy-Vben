package com.easy.admin.config.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * redis
 *
 * @author TengChongChong
 */
public class RedisCacheManager implements CacheManager {

    private final ConcurrentMap<String, Cache> cacheConcurrentMap = new ConcurrentHashMap<>();

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        Cache cache = cacheConcurrentMap.get(name);

        if (cache == null) {
            cache = new RedisShiroCache<K, V>(redisTemplate);
            cacheConcurrentMap.put(name, cache);
        }

        return cache;
    }

}
