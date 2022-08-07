package com.easy.admin.common.redis.model;

import cn.hutool.core.lang.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * redis属性配置文件
 *
 * @author TengChongChong
 * @date 2018/9/4
 */
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {
    private static final Logger logger = LoggerFactory.getLogger(RedisProperties.class);
    /**
     * Redis数据库编号
     */
    private Integer database = 0;
    /**
     * Redis服务器地址
     */
    private String host = "127.0.0.1";
    /**
     * Redis服务器连接端口
     */
    private Integer port = 6379;
    /**
     * Redis服务器连接密码
     */
    private String password = null;
    /**
     * 连接超时时间 单位: 秒
     */
    private Integer timeout = 10;
    /**
     * 默认的数据过期时间 30 分钟 单位: 秒
     */
    private Integer expire = 1800;
    /**
     * 连接池最大连接数（使用负值表示没有限制）
     */
    @Value("${spring.redis.jedis.pool.max-active}")
    private Integer maxActive = 8;
    /**
     * 连接池最大阻塞等待时间（使用负值表示没有限制）
     */
    @Value("${spring.redis.jedis.pool.max-wait}")
    private Integer maxWait = -1;
    /**
     * 连接池中的最大空闲连接
     */
    @Value("${spring.redis.jedis.pool.max-idle}")
    private Integer maxIdle = 8;
    /**
     * 连接池中的最小空闲连接
     */
    @Value("${spring.redis.jedis.pool.min-idle}")
    private Integer minIdle = 0;

    public Integer getDatabase() {
        return database;
    }

    public void setDatabase(Integer database) {
        this.database = database;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getPassword() {
        if(Validator.isEmpty(password)){
            return null;
        }
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getExpire() {
        return expire;
    }

    public void setExpire(Integer expire) {
        this.expire = expire;
    }

    public Integer getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(Integer maxActive) {
        this.maxActive = maxActive;
    }

    public Integer getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(Integer maxWait) {
        this.maxWait = maxWait;
    }

    public Integer getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }
}
