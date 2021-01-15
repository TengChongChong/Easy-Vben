package com.easy.restful.activiti.controller;

import com.easy.restful.core.annotation.ResponseResult;
import org.activiti.engine.HistoryService;
import org.activiti.engine.history.HistoricVariableInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 流程相关变量
 *
 * @author tengchong
 * @date 2020/5/7
 */
@RestController
@ResponseResult
@RequestMapping("/auth/activiti/variable")
public class VariableController {

    @Autowired
    private HistoryService service;

    /**
     * 查询数据
     *
     * @param processInstanceId 流程实例ID
     * @return 数据
     */
    @GetMapping()
    public List<HistoricVariableInstance> select(String processInstanceId) {
        return service.createHistoricVariableInstanceQuery().processInstanceId(processInstanceId).orderByVariableName().asc().list();
    }
}
