package com.easy.admin.sys.service.impl;

import com.anji.captcha.service.CaptchaCacheService;
import com.easy.admin.common.redis.util.RedisUtil;

/**
 * 拖拽图形验证码
 *
 * @author tengchong
 * @date 2022/7/21
 */
public class SysDragCaptchaServiceImpl implements CaptchaCacheService {

    @Override
    public String type() {
        return "redis";
    }

    @Override
    public void set(String key, String value, long expiresInSeconds) {
        RedisUtil.set(key,value, expiresInSeconds);
    }

    @Override
    public boolean exists(String key) {
        return RedisUtil.hasKey(key);
    }

    @Override
    public void delete(String key) {
        RedisUtil.del(key);
    }

    @Override
    public String get(String key) {
        return (String) RedisUtil.get(key);
    }

    @Override
    public Long increment(String key, long val) {
        return RedisUtil.increment(key, val);
    }

    @Override
    public void setExpire(String key, long l) {
        RedisUtil.setExpire(key, l);
    }

}
