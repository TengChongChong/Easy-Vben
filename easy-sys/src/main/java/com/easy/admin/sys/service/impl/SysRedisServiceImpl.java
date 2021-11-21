package com.easy.admin.sys.service.impl;

import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.sys.model.SysRedisVO;
import com.easy.admin.sys.service.SysRedisService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * redis 管理
 *
 * @author TengChongChong
 * @date 2019-01-25
 */
@Service
public class SysRedisServiceImpl implements SysRedisService {

    @Override
    public Set<String> selectByPrefix(String prefix) {
        return RedisUtil.selectKeysByPrefix(prefix);
    }

    @Override
    public SysRedisVO get(String key) {
        SysRedisVO sysRedis = new SysRedisVO();
        sysRedis.setKey(key);
        sysRedis.setValue(RedisUtil.get(key));
        sysRedis.setExpire(RedisUtil.getExpire(key));
        return sysRedis;
    }

    @Override
    public boolean remove(String key) {
        RedisUtil.del(key);
        return true;
    }

    @Override
    public boolean save(SysRedisVO sysRedis) {
        RedisUtil.set(sysRedis.getKey(), sysRedis.getValue());
        return true;
    }
}
