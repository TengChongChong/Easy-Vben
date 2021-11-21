package com.easy.admin.scheduler.quartz;

import cn.hutool.core.util.StrUtil;
import com.easy.admin.common.core.util.SpringContextHolder;
import com.easy.admin.scheduler.common.constant.SchedulerConst;
import com.easy.admin.scheduler.model.SchedulerJob;
import com.easy.admin.scheduler.model.SchedulerJobLog;
import com.easy.admin.scheduler.service.SchedulerJobLogService;
import com.easy.admin.scheduler.service.SchedulerJobService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 任务调度工厂
 *
 * @author TengChongChong
 * @date 2019-05-11
 */
@Component
public class QuartzFactory implements Job {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void execute(JobExecutionContext context) {
        // 获取定时任务
        SchedulerJob schedulerJob = (SchedulerJob) context.getMergedJobDataMap().get(SchedulerConst.SCHEDULER_JOB_KEY);
        if (StrUtil.isNotBlank(schedulerJob.getBean())) {
            Object object = SpringContextHolder.getBean(schedulerJob.getBean());
            if (object != null) {
                try {
                    // 获取方法
                    Method method = object.getClass().getMethod(schedulerJob.getMethod());
                    try {
                        Date startDate = new Date();
                        // 执行
                        method.invoke(object);
                        // 更新最后执行时间
                        updateLastRunDate(schedulerJob.getId());
                        // 保存执行日志
                        saveJobLog(schedulerJob, startDate);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        logger.warn("调用定时任务[" + schedulerJob.getName() + "] method[" + schedulerJob.getMethod() + "]失败", e);
                    }
                } catch (NoSuchMethodException e) {
                    logger.warn("定时任务[" + schedulerJob.getName() + "]获取method[" + schedulerJob.getMethod() + "]失败");
                }
            } else {
                logger.warn("定时任务[" + schedulerJob.getName() + "]bean不存在");
            }
        } else {
            logger.warn("定时任务[" + schedulerJob.getName() + "]缺少bean");
        }
    }

    /**
     * 更新最后执行时间
     *
     * @param id 任务id
     */
    private void updateLastRunDate(String id) {
        SchedulerJobService schedulerJobService = SpringContextHolder.getBean("schedulerJobServiceImpl");
        schedulerJobService.updateLastRunDate(id);
    }

    /**
     * 保存执行日志
     *
     * @param schedulerJob 任务详情
     * @param startDate    任务开始执行时间
     */
    private void saveJobLog(SchedulerJob schedulerJob, Date startDate) {
        SchedulerJobLogService schedulerJobLogService = SpringContextHolder.getBean("schedulerJobLogServiceImpl");
        schedulerJobLogService.saveData(new SchedulerJobLog(schedulerJob.getId(),
                startDate, System.currentTimeMillis() - startDate.getTime()));
    }
}
