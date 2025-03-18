package com.easy.admin.sys.service.impl;

import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.sys.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 异步 Service
 *
 * @author tengchong
 * @date 2022/3/7
 */
@Slf4j
@Service
public class AsyncServiceImpl implements AsyncService {

    @Override
    @Async("asyncExecutor")
    public void removeRedis(String key, int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            // ignore
        }
        log.debug("延迟删除缓存{}", key);
        RedisUtil.del(key);
    }
}
