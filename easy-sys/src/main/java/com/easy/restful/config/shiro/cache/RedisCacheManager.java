package com.easy.restful.config.shiro.cache;

import com.easy.restful.common.redis.config.RedisConfig;
import com.easy.restful.common.redis.model.RedisProperties;
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
 * @author tengchong
 */
public class RedisCacheManager implements CacheManager {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap<String, Cache>();

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RedisConfig redisConfig;

    @Autowired
    private RedisProperties redisProperties;

    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        logger.debug("获取名称为: " + name + " 的RedisCache实例");
        Cache c = caches.get(name);

        if(c == null){
            c =  new RedisShiroCache<K, V>(name, redisTemplate, redisConfig, redisProperties);
            caches.put(name, c);
        }

        return  c;
    }

}
