package com.easy.admin.sample.job;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 示例定时任务
 *
 * @author TengChongChong
 * @date 2019-05-11
 */
@Slf4j
@Component
public class SampleJob {

    public void sampleJob1() {
        log.debug("示例定时任务1执行了[{}]", DateUtil.now());
    }

    public void sampleJob2() {
        log.debug("示例定时任务2执行了[{}]", DateUtil.now());
    }

    public void sampleJobWithParams(String name, Integer count) {
        log.debug("示例带参定时任务执行了[{}]，name={}，count={}", DateUtil.now(), name, count);
    }

    public void sampleJobWithJson(JSONObject params) {
        log.debug("示例JSON参数定时任务执行了[{}]，params={}", DateUtil.now(), params);
    }
}
