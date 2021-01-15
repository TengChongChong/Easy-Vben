package com.easy.restful.activiti.service;

import cn.hutool.json.JSONObject;
import com.easy.restful.activiti.model.Task;
import com.easy.restful.common.core.common.pagination.Page;

import javax.servlet.http.HttpServletRequest;

/**
 * 待办任务
 *
 * @author tengchong
 * @date 2020/3/27
 */
public interface TaskService {
    /**
     * 查询待办任务
     *
     * @param task 查询条件
     * @param page 分页
     * @return Page
     */
    Page<Task> select(Task task, Page<Task> page);

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
     * @return JSONObject
     */
    JSONObject readTaskForm(String taskId);

    /**
     * 流转任务
     *
     * @param taskId  任务Id
     * @param request request
     */
    void completeTask(String taskId, HttpServletRequest request);

    /**
     * 撤销申请
     *
     * @param processInstanceId 流程实例ID
     * @param deleteReason      撤销原因
     */
    void revoke(String processInstanceId, String deleteReason);
}
