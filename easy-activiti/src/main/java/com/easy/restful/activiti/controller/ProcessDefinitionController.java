package com.easy.restful.activiti.controller;

import cn.hutool.json.JSONObject;
import com.easy.restful.activiti.constant.VariableConst;
import com.easy.restful.activiti.service.ProcessDefinitionService;
import com.easy.restful.core.annotation.ResponseResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 启动流程
 *
 * @author tengchong
 * @date 2020/3/26
 */
@RestController
@ResponseResult
@RequestMapping("/auth/activiti/process/definition")
public class ProcessDefinitionController {

    @Autowired
    private ProcessDefinitionService service;

    /**
     * 读取流程表单
     *
     * @param processDefinitionId 流程id
     * @param businessKey         业务数据ID
     * @param businessTitle       业务标题
     * @param businessDetailsUrl  业务数据详情url
     * @return view
     */
    @GetMapping("start/form/{processDefinitionId}")
    public JSONObject readStartForm(@PathVariable("processDefinitionId") String processDefinitionId,
                                    @RequestParam(value = VariableConst.BUSINESS_KEY, required = false) String businessKey,
                                    @RequestParam(value = VariableConst.BUSINESS_TITLE, required = false) String businessTitle,
                                    @RequestParam(value = VariableConst.BUSINESS_DETAILS_URL, required = false) String businessDetailsUrl) {
        JSONObject res = service.readStartForm(processDefinitionId);
        res.set(VariableConst.BUSINESS_KEY, businessKey);
        res.set(VariableConst.BUSINESS_TITLE, businessTitle);
        res.set(VariableConst.BUSINESS_DETAILS_URL, businessDetailsUrl);
        return res;
    }

    /**
     * 启动流程
     *
     * @param processDefinitionId 流程id
     * @param businessKey         业务id
     * @param businessTitle       业务标题
     * @return Tips
     */
    @PostMapping("process/instance/{processDefinitionId}")
    @RequiresPermissions("activiti:process:start")
    public String startProcessInstance(@PathVariable("processDefinitionId") String processDefinitionId,
                                     @RequestParam(value = VariableConst.BUSINESS_KEY, required = false) String businessKey,
                                     @RequestParam(value = VariableConst.BUSINESS_TITLE, required = false) String businessTitle,
                                     @RequestParam(value = VariableConst.BUSINESS_DETAILS_URL, required = false) String businessDetailsUrl,
                                     HttpServletRequest request) {
        return service.startProcessInstance(processDefinitionId, businessKey, businessTitle, businessDetailsUrl, request);
    }

    /**
     * 尝试启动流程
     * （先验证有无动态表单，如果没有自动提交返回流水号，如果有返回表单地址）
     *
     * @param processDefinitionId 流程id
     * @param businessKey         业务数据ID
     * @param businessTitle       业务标题
     * @param businessDetailsUrl  业务数据详情url
     * @param extentParams        扩展参数(注意此参数必须是JSON格式)
     * @return Tips
     */
    @PostMapping("attempt/start/process/instance/{processDefinitionId}")
    public JSONObject startProcessInstance(@PathVariable("processDefinitionId") String processDefinitionId,
                                     @RequestParam(value = VariableConst.BUSINESS_KEY, required = false) String businessKey,
                                     @RequestParam(value = VariableConst.BUSINESS_TITLE, required = false) String businessTitle,
                                     @RequestParam(value = VariableConst.BUSINESS_DETAILS_URL, required = false) String businessDetailsUrl,
                                     @RequestParam(required = false) String extentParams) {
        return service.startProcessInstance(processDefinitionId, businessKey, businessTitle, businessDetailsUrl, extentParams);
    }
}
