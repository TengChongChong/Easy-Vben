package com.easy.restful.common.core.config.redis;

import com.easy.restful.common.core.config.properties.RedisProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis config
 *
 * @author tengchong
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisProperties redisProperties;

    @Bean
    public JedisPool redisPoolFactory() {
        logger.info("JedisPool注入成功");
        JedisPool jedisPool = new JedisPool(getJedisPoolConfig(), redisProperties.getHost(), redisProperties.getPort(),
                redisProperties.getTimeout(), redisProperties.getPassword());
        return jedisPool;
    }


    @Bean
    public JedisPoolConfig getJedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(redisProperties.getMaxIdle());
        jedisPoolConfig.setMaxWaitMillis(redisProperties.getMaxWait());
        return jedisPoolConfig;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        // 设置连接信息
        redisStandaloneConfiguration.setHostName(redisProperties.getHost());
        redisStandaloneConfiguration.setPassword(RedisPassword.of(redisProperties.getPassword()));
        redisStandaloneConfiguration.setPort(redisProperties.getPort());
        redisStandaloneConfiguration.setDatabase(redisProperties.getDatabase());
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration);
        logger.info("JedisConnectionFactory注入成功");
        return jedisConnectionFactory;
    }

    @Bean
    public CacheManager cacheManager(JedisConnectionFactory jedisConnectionFactory) {
        logger.info("cacheManager注入成功");
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig().disableCachingNullValues();
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(jedisConnectionFactory);
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
        return redisCacheManager;
    }

    @Bean(name = "redisTemplate")
    public RedisTemplate<String, Object> getRedisTemplate() {
        logger.info("redisTemplatet注入成功");
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer(Object.class));
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}

