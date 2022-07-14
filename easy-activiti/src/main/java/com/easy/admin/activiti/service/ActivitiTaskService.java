package com.easy.admin.activiti.service;

import cn.hutool.json.JSONObject;
import com.easy.admin.activiti.model.ActivitiTask;
import com.easy.admin.activiti.model.ActivitiTaskInfo;
import com.easy.admin.common.core.common.pagination.Page;

/**
 * 待办任务
 *
 * @author TengChongChong
 * @date 2020/3/27
 */
public interface ActivitiTaskService {
    /**
     * 查询待办任务
     *
     * @param activitiTask 查询条件
     * @param page 分页
     * @return Page
     */
    Page<ActivitiTask> select(ActivitiTask activitiTask, Page<ActivitiTask> page);

    /**
     * 签收任务
     *
     * @param taskId 任务id
     */
    void claimTask(String taskId);

    /**
     * 读取用户任务的表单字段
     *
     * @param taskId 任务Id
     * @return ActivitiTaskInfo
     */
    ActivitiTaskInfo readTaskForm(String taskId);

    /**
     * 流转任务
     *
     * @param taskId  任务Id
     * @param params params
     */
    void completeTask(String taskId, JSONObject params);

    /**
     * 撤销申请
     *
     * @param processInstanceId 流程实例ID
     * @param deleteReason      撤销原因
     */
    void revoke(String processInstanceId, String deleteReason);
}
