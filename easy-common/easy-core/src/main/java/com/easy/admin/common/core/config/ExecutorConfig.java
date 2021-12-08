package com.easy.admin.common.core.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池
 *
 * @author tengchong
 * @date 2021/12/1
 */
@Configuration
@EnableAsync
public class ExecutorConfig {
    private static final Logger logger = LoggerFactory.getLogger(ExecutorConfig.class);

    @Value("${async.executor.thread.core-pool-size}")
    private int corePoolSize;
    @Value("${async.executor.thread.max-pool-size}")
    private int maxPoolSize;
    @Value("${async.executor.thread.queue-capacity}")
    private int queueCapacity;
    @Value("${async.executor.thread.keep-alive-seconds}")
    private int keepAliveSeconds;
    @Value("${async.executor.thread.name-prefix}")
    private String namePrefix;

    @Bean(name = "asyncExecutor")
    public Executor asyncExecutor() {
        logger.info("开启SpringBoot的线程池！");

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        // 设置核心线程数
        executor.setCorePoolSize(corePoolSize);
        // 设置最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        // 设置缓冲队列大小
        executor.setQueueCapacity(queueCapacity);
        // 设置线程的最大空闲时间
        executor.setKeepAliveSeconds(keepAliveSeconds);
        // 设置线程名字的前缀
        executor.setThreadNamePrefix(namePrefix);
        // 设置拒绝策略：当线程池达到最大线程数时，如何处理新任务
        // CALLER_RUNS：在添加到线程池失败时会由主线程自己来执行这个任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        // 线程池初始化
        executor.initialize();


        return executor;
    }
}
