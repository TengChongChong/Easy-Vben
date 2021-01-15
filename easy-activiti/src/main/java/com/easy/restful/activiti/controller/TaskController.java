package com.easy.restful.activiti.controller;

import cn.hutool.json.JSONObject;
import com.easy.restful.activiti.model.Task;
import com.easy.restful.activiti.service.TaskService;
import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.core.annotation.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 待办任务
 *
 * @author tengchong
 * @date 2020/3/26
 */
@RestController
@ResponseResult
@RequestMapping("/auth/activiti/task")
public class TaskController {

    @Autowired
    private TaskService service;

    /**
     * 查询数据
     *
     * @param status 任务状态
     * @param task 查询条件
     * @return 数据
     */
    @GetMapping("{status}")
    public Page<Task> select(@PathVariable("status") String status, Task task, Page<Task> page) {
        task.setStatus(status);
        return service.select(task, page);
    }

    /**
     * 签收任务
     *
     * @param taskId 任务id
     * @return Tips
     */
    @PostMapping("claim/task/{taskId}")
    public boolean claimTask(@PathVariable("taskId") String taskId) {
        service.claimTask(taskId);
        return true;
    }

    /**
     * 任务处理
     *
     * @param taskId 任务Id
     * @return JSONObject
     */
    @GetMapping("task/form/{taskId}")
    public JSONObject taskForm(@PathVariable("taskId") String taskId) {
        return service.readTaskForm(taskId);
    }

    /**
     * 流转任务
     *
     * @param taskId  任务Id
     * @param request request
     * @return true/false
     */
    @PostMapping("complete/task/{taskId}")
    public boolean completeTask(@PathVariable("taskId") String taskId, HttpServletRequest request) {
        service.completeTask(taskId, request);
        return true;
    }

    /**
     * 撤销申请
     *
     * @param processInstanceId 流程实例ID
     * @param deleteReason      撤销原因(可为空)
     *
     */
    @PostMapping("revoke/{processInstanceId}")
    public boolean revoke(@PathVariable("processInstanceId") String processInstanceId,
                       @RequestParam(value = "deleteReason", required = false) String deleteReason) {
        service.revoke(processInstanceId, deleteReason);
        return true;
    }
}
