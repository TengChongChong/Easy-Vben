package com.easy.restful.activiti.controller;

import com.easy.restful.activiti.model.Historic;
import com.easy.restful.activiti.model.Task;
import com.easy.restful.activiti.service.HistoricService;
import com.easy.restful.core.annotation.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 流程历史活动记录
 *
 * @author tengchong
 * @date 2020/5/7
 */
@RestController
@ResponseResult
@RequestMapping("/auth/activiti/historic")
public class HistoricController {

    @Autowired
    private HistoricService service;

    /**
     * 查询数据
     *
     * @param historic 查询条件
     * @return List<Historic>
     */
    @GetMapping()
    public List<Historic> select(Historic historic) {
        return service.select(historic);
    }

    /**
     * 根据业务id查询流程实例
     *
     * @param businessKey 业务id
     * @return Task
     */
    @GetMapping("task")
    public Task selectTask(String businessKey){
        return service.selectTask(businessKey);
    }
}
