package com.easy.admin.activiti.controller;

import com.easy.admin.activiti.model.ActivitiHistoric;
import com.easy.admin.activiti.model.ActivitiTask;
import com.easy.admin.activiti.service.ActivitiHistoricService;
import com.easy.admin.core.annotation.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 流程历史活动记录
 *
 * @author TengChongChong
 * @date 2020/5/7
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/activiti/historic")
public class ActivitiHistoricController {

    @Autowired
    private ActivitiHistoricService service;

    /**
     * 查询数据
     *
     * @param processInstanceId 流程实例ID
     * @return List<Historic>
     */
    @GetMapping("processInstanceId/{processInstanceId}")
    public List<ActivitiHistoric> select(@PathVariable("processInstanceId") String processInstanceId) {
        return service.select(processInstanceId);
    }

    /**
     * 根据业务id查询流程实例
     *
     * @param businessKey 业务id
     * @return Task
     */
    @GetMapping("task")
    public ActivitiTask selectTask(String businessKey){
        return service.selectTask(businessKey);
    }
}
