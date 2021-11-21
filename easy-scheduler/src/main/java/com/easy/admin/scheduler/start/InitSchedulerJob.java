package com.easy.admin.scheduler.start;

import com.easy.admin.scheduler.service.QuartzService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 项目启动后加载定时任务
 *
 * @author TengChongChong
 * @date 2019-05-11
 */
@Component
public class InitSchedulerJob implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private QuartzService quartzService;

    @Override
    public void run(String... args) {
        logger.info("加载定时任务...");
        quartzService.timingTask();
    }
}
