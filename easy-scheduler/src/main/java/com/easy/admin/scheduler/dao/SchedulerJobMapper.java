package com.easy.admin.scheduler.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.scheduler.model.SchedulerJob;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 定时任务 
 *
 * @author TengChong
 * @date 2019-05-11
 */
public interface SchedulerJobMapper extends BaseMapper<SchedulerJob> {
    /**
     * 获取列表数据
     *
     * @param page 分页
     * @param queryWrapper 查询条件
     * @return List<SchedulerJob>
     */
    List<SchedulerJob> select(Page<SchedulerJob> page, @Param("ew") QueryWrapper<SchedulerJob> queryWrapper);

    /**
     * 根据任务id获取任务
     *
     * @param id 任务id
     * @return 任务名称
     */
    String getJobCodeById(@Param("id") String id);

    /**
     * 根据id获取详情
     *
     * @param id id
     * @return SchedulerJob
     */
    SchedulerJob getById(@Param("id") String id);

    /**
     * 根据查询条件查询任务代码
     *
     * @param queryWrapper 查询条件
     * @return 任务代码列表
     */
    List<SchedulerJob> selectSchedulerJobCodes(@Param("ew") QueryWrapper<SchedulerJob> queryWrapper);
}