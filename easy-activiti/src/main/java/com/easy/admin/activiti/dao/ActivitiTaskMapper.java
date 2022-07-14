package com.easy.admin.activiti.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.activiti.model.ActivitiTask;
import com.easy.admin.common.core.common.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 流程跟踪
 *
 * @author TengChong
 * @date 2020-04-26
 */
public interface ActivitiTaskMapper extends BaseMapper<ActivitiTask> {
    /**
     * 获取列表数据
     *
     * @param page         分页
     * @param queryWrapper 查询条件
     * @return 数据列表
     */
    List<ActivitiTask> select(Page<ActivitiTask> page, @Param("ew") QueryWrapper<ActivitiTask> queryWrapper);

    /**
     * 根据任务ID查询流程定义ID
     *
     * @param taskId     任务ID
     * @param activation 激活流程状态
     * @return Task
     */
    ActivitiTask selectProcessDefinitionId(@Param("taskId") String taskId, @Param("activation") int activation);

    /**
     * 查询任务信息
     *
     * @param processInstanceId 流程实例ID
     * @return 任务信息
     */
    ActivitiTask selectTask(@Param("processInstanceId") String processInstanceId);
}