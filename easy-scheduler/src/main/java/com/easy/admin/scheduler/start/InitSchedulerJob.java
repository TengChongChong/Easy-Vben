package com.easy.admin.scheduler.start;

import com.easy.admin.scheduler.service.QuartzService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Component
public class InitSchedulerJob implements CommandLineRunner {

    @Autowired
    private QuartzService quartzService;

    @Override
    public void run(String... args) {
        log.info("加载定时任务...");
        quartzService.timingTask();
    }
}
