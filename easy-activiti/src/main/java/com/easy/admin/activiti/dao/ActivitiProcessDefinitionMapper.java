package com.easy.admin.activiti.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.activiti.model.ActivitiProcess;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 启动流程
 *
 * @author TengChongChong
 * @date 2020/5/7
 */
public interface ActivitiProcessDefinitionMapper extends BaseMapper<ActivitiProcess> {
    /**
     * 检查业务数据是否提交过流程，一条数据只能提交一次
     *
     * @param businessKey 业务数据id
     * @return 数量
     */
    int countBusinessKey(@Param("businessKey") String businessKey);

    /**
     * 根据流程实例ID查询任务ID
     *
     * @param processInstanceId 流程实例ID
     * @return 任务ID
     */
    String selectTaskId(@Param("processInstanceId") String processInstanceId);

    /**
     * 根据任务id查询候选人列表
     *
     * @param taskId 任务ID
     * @return 候选人id列表
     */
    List<String> selectCandidate(@Param("taskId") String taskId);
}
