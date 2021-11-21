package com.easy.admin.config.shiro.cache;

import com.easy.admin.common.redis.constant.RedisPrefix;
import com.easy.admin.common.redis.model.RedisProperties;
import com.easy.admin.sys.model.SysUser;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * session redis
 *
 * @author TengChongChong
 */
public class RedisShiroCache<K, V> implements Cache<K, V> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private RedisProperties redisProperties;


    private String cacheKey;

    private RedisTemplate<K, V> redisTemplate;

    @SuppressWarnings("rawtypes")
    public RedisShiroCache(String name, RedisTemplate redisTemplate, RedisProperties redisProperties) {
        this.cacheKey = RedisPrefix.SHIRO_AUTHORIZATION;
        this.redisTemplate = redisTemplate;
        this.redisProperties = redisProperties;
    }

    @Override
    public V get(K key) throws CacheException {
        logger.info("根据key从Redis中获取对象 key [" + key + "]");
        try {
            if (key == null) {
                return null;
            } else {
                redisTemplate.boundValueOps(getCacheKey(key)).expire(redisProperties.getExpire(), TimeUnit.SECONDS);
                V v = redisTemplate.boundValueOps(getCacheKey(key)).get();
                return v;
            }
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    @Override
    public V put(K key, V value) throws CacheException {
        logger.info("根据key从存储 key [" + key + "]");
        try {
            V v = get(key);
            redisTemplate.boundValueOps(getCacheKey(key)).set(value);
            System.out.println(redisTemplate.boundValueOps(getCacheKey(key)).get().toString());
            return v;
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    @Override
    public V remove(K key) throws CacheException {
        logger.info("从redis中删除 key [" + key + "]");
        try {
            V v = get(key);
            redisTemplate.delete(getCacheKey(key));
            return v;
        } catch (Throwable t) {
            throw new CacheException(t);
        }

    }

    @Override
    public void clear() throws CacheException {
        try {
            redisTemplate.delete(keys());
        } catch (Throwable t) {
            throw new CacheException(t);
        }
    }

    @Override
    public int size() {
        return keys().size();
    }

    @Override
    public Set<K> keys() {
        return redisTemplate.keys(getCacheKey("*"));
    }

    @Override
    public Collection<V> values() {
        Set<K> set = keys();
        List<V> list = new ArrayList<>();
        for (K s : set) {
            list.add(get(s));
        }
        return list;
    }

    private K getCacheKey(Object k) {
        if (k instanceof SimplePrincipalCollection) {
            return (K) (this.cacheKey + ((SysUser) ((SimplePrincipalCollection) k).getPrimaryPrincipal()).getId());
        }
        return (K) (this.cacheKey + k);
    }
}