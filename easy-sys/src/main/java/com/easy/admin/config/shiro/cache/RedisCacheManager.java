package com.easy.admin.config.shiro.cache;

import com.easy.admin.common.redis.model.RedisProperties;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * redis
 * @author TengChongChong
 */
public class RedisCacheManager implements CacheManager {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap<>();

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RedisProperties redisProperties;

    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        logger.debug("获取名称为: " + name + " 的RedisCache实例");
        Cache c = caches.get(name);

        if(c == null){
            c =  new RedisShiroCache<K, V>(name, redisTemplate, redisProperties);
            caches.put(name, c);
        }

        return  c;
    }

}
