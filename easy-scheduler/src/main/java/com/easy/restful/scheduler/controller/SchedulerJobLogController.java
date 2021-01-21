package com.easy.restful.scheduler.controller;

import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.core.annotation.ResponseResult;
import com.easy.restful.scheduler.model.SchedulerJobLog;
import com.easy.restful.scheduler.service.SchedulerJobLogService;
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
@RequestMapping("/auth/scheduler/job/log")
public class SchedulerJobLogController  {

    /**
     * 定时任务执行日志 service
     */
    @Autowired
    private SchedulerJobLogService service;


    /**
     * 列表
     *
     * @param object 查询条件
     * @return Page<SchedulerJobLog>
     */
    @GetMapping()
    @RequiresPermissions("scheduler:job:log:select")
    public Page<SchedulerJobLog> select(SchedulerJobLog object, Page<SchedulerJobLog> page) {
        return service.select(object, page);
    }
}
