package com.easy.admin.cms.start;

import com.easy.admin.cms.common.constant.CmsRedisKeyPrefix;
import com.easy.admin.common.redis.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 启动时将cms数据放到redis中
 *
 * @author tengchong
 * @date 2021-11-23
 */
@Component
public class InitCmsData implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(String... args) {
        logger.debug("清空CMS缓存数据");

        RedisUtil.delByPrefix(CmsRedisKeyPrefix.SITE);
        RedisUtil.delByPrefix(CmsRedisKeyPrefix.COLUMN);
    }
}
