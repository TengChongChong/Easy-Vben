package com.easy.admin.scheduler.quartz;

import cn.hutool.core.util.StrUtil;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.scheduler.common.constant.SchedulerConst;
import com.easy.admin.scheduler.model.SchedulerJob;
import com.easy.admin.scheduler.model.SchedulerJobLog;
import com.easy.admin.scheduler.service.SchedulerJobLogService;
import com.easy.admin.scheduler.service.SchedulerJobService;
import com.easy.admin.scheduler.util.SchedulerJobInvokeUtil;
import com.easy.admin.common.core.util.SpringContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

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
        SchedulerJob schedulerJob = (SchedulerJob) context.getMergedJobDataMap().get(SchedulerConst.SCHEDULER_JOB_KEY);
        if (schedulerJob == null) {
            log.warn("定时任务执行失败，未获取到任务信息");
            return;
        }
        if (StrUtil.isBlank(schedulerJob.getBean())) {
            log.warn("定时任务[{}]缺少bean", schedulerJob.getName());
            return;
        }
        try {
            Date startDate = new Date();
            SchedulerJobInvokeUtil.invoke(schedulerJob);
            updateLastRunDate(schedulerJob.getId());
            saveJobLog(schedulerJob, startDate);
        } catch (EasyException e) {
            log.warn("调用定时任务[{}] method[{}]失败: {}", schedulerJob.getName(), schedulerJob.getMethod(), e.getMessage());
        } catch (Exception e) {
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
