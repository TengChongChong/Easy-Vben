package com.easy.admin.activiti.controller;

import com.easy.admin.core.annotation.ResponseResult;
import org.activiti.engine.HistoryService;
import org.activiti.engine.history.HistoricVariableInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 流程相关变量
 *
 * @author TengChongChong
 * @date 2020/5/7
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/activiti/variable")
public class ActivitiVariableController {

    @Autowired
    private HistoryService service;

    /**
     * 查询数据
     *
     * @param processInstanceId 流程实例ID
     * @return 数据
     */
    @GetMapping("processInstanceId/{processInstanceId}")
    public List<HistoricVariableInstance> select(@PathVariable("processInstanceId") String processInstanceId) {
        return service.createHistoricVariableInstanceQuery().processInstanceId(processInstanceId).orderByVariableName().asc().list();
    }
}
