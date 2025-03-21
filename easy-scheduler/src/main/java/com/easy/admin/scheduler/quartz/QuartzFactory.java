package com.easy.admin.scheduler.quartz;

import cn.hutool.core.util.StrUtil;
import com.easy.admin.common.core.util.SpringContextHolder;
import com.easy.admin.scheduler.common.constant.SchedulerConst;
import com.easy.admin.scheduler.model.SchedulerJob;
import com.easy.admin.scheduler.model.SchedulerJobLog;
import com.easy.admin.scheduler.service.SchedulerJobLogService;
import com.easy.admin.scheduler.service.SchedulerJobService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
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
@Slf4j
@Component
public class QuartzFactory implements Job {

    @Override
    public void execute(JobExecutionContext context) {
        // 获取定时任务
        SchedulerJob schedulerJob = (SchedulerJob) context.getMergedJobDataMap().get(SchedulerConst.SCHEDULER_JOB_KEY);
        if (StrUtil.isBlank(schedulerJob.getBean())) {
            log.warn("定时任务[{}]缺少bean", schedulerJob.getName());
        }

        Object bean = SpringContextHolder.getBean(schedulerJob.getBean());
        if (bean == null) {
            log.warn("定时任务[{}]bean不存在", schedulerJob.getName());

        }

        try {
            // 获取方法
            Method method = bean.getClass().getMethod(schedulerJob.getMethod());
            Date startDate = new Date();
            // 执行
            method.invoke(bean);
            // 更新最后执行时间
            updateLastRunDate(schedulerJob.getId());
            // 保存执行日志
            saveJobLog(schedulerJob, startDate);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            log.warn("调用定时任务[{}] method[{}]失败", schedulerJob.getName(), schedulerJob.getMethod(), e);
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
