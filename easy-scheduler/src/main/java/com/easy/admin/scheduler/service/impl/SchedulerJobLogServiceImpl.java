package com.easy.admin.scheduler.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.scheduler.dao.SchedulerJobLogMapper;
import com.easy.admin.scheduler.model.SchedulerJobLog;
import com.easy.admin.scheduler.service.SchedulerJobLogService;
import com.easy.admin.util.ToolUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 定时任务执行日志
 *
 * @author TengChong
 * @date 2019-05-11
 */
@Service
public class SchedulerJobLogServiceImpl extends ServiceImpl<SchedulerJobLogMapper, SchedulerJobLog> implements SchedulerJobLogService {

    /**
     * 列表
     *
     * @param schedulerJobLog 查询条件
     * @param page   分页
     * @return 数据集合
     */
    @Override
    public Page<SchedulerJobLog> select(SchedulerJobLog schedulerJobLog, Page<SchedulerJobLog> page) {
        QueryWrapper<SchedulerJobLog> queryWrapper = new QueryWrapper<>();
        if (schedulerJobLog == null || StrUtil.isBlank(schedulerJobLog.getSchedulerJobId())) {
            return page;
        }
        queryWrapper.eq("scheduler_job_id", schedulerJobLog.getSchedulerJobId());
        page.setDefaultDesc("run_date");
        return page(page, queryWrapper);
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return 保存后信息
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SchedulerJobLog saveData(SchedulerJobLog object) {
        return (SchedulerJobLog) ToolUtil.checkResult(saveOrUpdate(object), object);
    }
}