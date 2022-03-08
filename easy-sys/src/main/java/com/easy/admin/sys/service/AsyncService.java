package com.easy.admin.sys.service;

/**
 * 异步 Service
 *
 * @author tengchong
 * @date 2022/3/7
 */
public interface AsyncService {
    /**
     * 延迟移除redis中的key
     *
     * @param key key
     * @param delay 延迟
     */
    void removeRedis(String key, int delay);
}
