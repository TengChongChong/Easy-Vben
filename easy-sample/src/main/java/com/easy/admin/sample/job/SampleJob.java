package com.easy.admin.sample.job;

import cn.hutool.core.date.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 示例定时任务
 *
 * @author TengChongChong
 * @date 2019-05-11
 */
@Component
public class SampleJob {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void sampleJob1() {
        logger.debug("示例定时任务1执行了[{}]", DateUtil.now());
    }

    public void sampleJob2() {
        logger.debug("示例定时任务2执行了[{}]", DateUtil.now());
    }
}
