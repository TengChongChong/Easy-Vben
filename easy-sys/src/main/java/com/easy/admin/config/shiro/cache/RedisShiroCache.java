package com.easy.admin.config.shiro.cache;

import com.easy.admin.auth.model.SysUser;
import com.easy.admin.common.redis.constant.RedisPrefix;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * session redis
 *
 * @author TengChongChong
 */
public class RedisShiroCache<K, V> implements Cache<K, V> {

    private RedisTemplate<K, V> redisTemplate;

    public RedisShiroCache(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            return null;
        }
        return redisTemplate.boundValueOps(getCacheKey(key)).get();
    }

    @Override
    public V put(K key, V value) throws CacheException {
        redisTemplate.boundValueOps(getCacheKey(key)).set(value);
        return value;
    }

    @Override
    public V remove(K key) throws CacheException {
        V value = get(key);
        redisTemplate.delete(getCacheKey(key));
        return value;
    }

    @Override
    public void clear() throws CacheException {
        redisTemplate.delete(keys());
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
            return (K) (RedisPrefix.SHIRO_AUTHORIZATION + ((SysUser) ((SimplePrincipalCollection) k).getPrimaryPrincipal()).getId());
        }
        return (K) (RedisPrefix.SHIRO_AUTHORIZATION + k);
    }
}