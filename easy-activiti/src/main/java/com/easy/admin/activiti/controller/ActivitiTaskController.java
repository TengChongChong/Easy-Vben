package com.easy.admin.activiti.controller;

import cn.hutool.json.JSONObject;
import com.easy.admin.activiti.model.ActivitiTask;
import com.easy.admin.activiti.model.ActivitiTaskInfo;
import com.easy.admin.activiti.service.ActivitiTaskService;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.core.annotation.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 待办任务
 *
 * @author TengChongChong
 * @date 2020/3/26
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/activiti/task")
public class ActivitiTaskController {

    @Autowired
    private ActivitiTaskService service;

    /**
     * 查询数据
     *
     * @param status 任务状态
     * @param activitiTask 查询条件
     * @return Page<Task>
     */
    @GetMapping("status/{status}")
    public Page<ActivitiTask> select(@PathVariable("status") String status, ActivitiTask activitiTask, Page<ActivitiTask> page) {
        activitiTask.setStatus(status);
        return service.select(activitiTask, page);
    }

    /**
     * 签收任务
     *
     * @param taskId 任务id
     * @return true/false
     */
    @PostMapping("claim/task/{taskId}")
    public boolean claimTask(@PathVariable("taskId") String taskId) {
        service.claimTask(taskId);
        return true;
    }

    /**
     * 获取任务信息
     *
     * @param taskId 任务Id
     * @return ActivitiTaskInfo
     */
    @GetMapping("{taskId}")
    public ActivitiTaskInfo getTaskInfo(@PathVariable("taskId") String taskId) {
        return service.readTaskForm(taskId);
    }

    /**
     * 流转任务
     *
     * @param taskId  任务Id
     * @param params params
     * @return true/false
     */
    @PostMapping("complete/task/{taskId}")
    public boolean completeTask(@PathVariable("taskId") String taskId, @RequestBody JSONObject params) {
        service.completeTask(taskId, params);
        return true;
    }

    /**
     * 撤销申请
     *
     * @param processInstanceId 流程实例ID
     * @param params     {deleteReason: "xxx"}
     * @return true/false
     */
    @PostMapping("revoke/{processInstanceId}")
    public boolean revoke(@PathVariable("processInstanceId") String processInstanceId,
                          @RequestBody JSONObject params) {
        service.revoke(processInstanceId, params.getStr("deleteReason"));
        return true;
    }
}
