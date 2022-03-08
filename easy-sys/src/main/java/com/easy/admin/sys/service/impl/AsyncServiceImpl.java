package com.easy.admin.sys.service.impl;

import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.sys.service.AsyncService;
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
@Service
public class AsyncServiceImpl implements AsyncService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    @Async("asyncExecutor")
    public void removeRedis(String key, int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            // ignore
        }
        logger.debug("延迟删除缓存{}", key);
        RedisUtil.del(key);
    }
}
