package com.easy.admin.scheduler.controller;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.scheduler.model.SchedulerJobLog;
import com.easy.admin.scheduler.service.SchedulerJobLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 定时任务执行日志
 *
 * @author TengChong
 * @date 2019-05-11
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/scheduler/job/log")
public class SchedulerJobLogController  {

    /**
     * 定时任务执行日志 service
     */
    @Autowired
    private SchedulerJobLogService service;


    /**
     * 列表
     *
     * @param schedulerJobLog 查询条件
     * @return Page<SchedulerJobLog>
     */
    @GetMapping()
    @RequiresPermissions("scheduler:job:select")
    public Page<SchedulerJobLog> select(SchedulerJobLog schedulerJobLog, Page<SchedulerJobLog> page) {
        return service.select(schedulerJobLog, page);
    }
}
