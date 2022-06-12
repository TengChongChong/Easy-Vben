package com.easy.admin.scheduler.service;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.scheduler.model.SchedulerJobLog;

/**
 * 定时任务执行日志
 *
 * @author TengChong
 * @date 2019-05-11
 */
public interface SchedulerJobLogService {
    /**
     * 列表
     *
     * @param schedulerJobLog 查询条件
     * @param page   分页
     * @return Page<SchedulerJobLog>
     */
    Page<SchedulerJobLog> select(SchedulerJobLog schedulerJobLog, Page<SchedulerJobLog> page);


    /**
     * 保存
     *
     * @param object 表单内容
     * @return 保存后信息
     */
    SchedulerJobLog saveData(SchedulerJobLog object);
}
