package com.easy.admin.activiti.controller;

import cn.hutool.json.JSONObject;
import com.easy.admin.activiti.model.ActivitiProcessDefinitionVO;
import com.easy.admin.activiti.service.ActivitiProcessDefinitionService;
import com.easy.admin.core.annotation.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 启动流程
 *
 * @author TengChongChong
 * @date 2020/3/26
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/activiti/process/definition")
public class ActivitiProcessDefinitionController {

    @Autowired
    private ActivitiProcessDefinitionService service;

    /**
     * 读取流程表单
     *
     * @param processDefinitionId 流程id
     * @return JSONObject
     */
    @GetMapping("start/form/{processDefinitionId}")
    public JSONObject readStartForm(@PathVariable("processDefinitionId") String processDefinitionId) {
        return service.readStartForm(processDefinitionId);
    }

    /**
     * 启动流程
     *
     * @param activitiProcessDefinitionVO 流程数据
     * @return JSONObject
     */
    @PostMapping("process/instance")
    public JSONObject startProcessInstance(@RequestBody @Valid ActivitiProcessDefinitionVO activitiProcessDefinitionVO) {
        return service.startProcessInstance(activitiProcessDefinitionVO);
    }
}
