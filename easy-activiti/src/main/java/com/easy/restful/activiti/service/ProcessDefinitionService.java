package com.easy.restful.activiti.service;

import cn.hutool.json.JSONObject;
import org.activiti.engine.repository.ProcessDefinition;

import javax.servlet.http.HttpServletRequest;

/**
 * 启动流程
 *
 * @author tengchong
 * @date 2020/3/26
 */
public interface ProcessDefinitionService {
    /**
     * 读取流程起点动态表单
     *
     * @param processDefinitionId 流程id
     * @return JSONObject
     */
    JSONObject readStartForm(String processDefinitionId);

    /**
     * 启动流程
     *
     * @param processDefinitionId 流程id
     * @param businessKey         业务数据ID
     * @param businessTitle       业务标题
     * @param businessDetailsUrl  业务数据详情url
     * @param request             request
     * @return 实例ID
     */
    String startProcessInstance(String processDefinitionId, String businessKey, String businessTitle, String businessDetailsUrl, HttpServletRequest request);

    /**
     * 启动流程
     * （先验证有无动态表单，如果没有自动提交，如果有返回表单地址）
     *
     * @param processDefinitionId 流程id
     * @param businessKey         业务数据ID
     * @param businessTitle       业务标题
     * @param businessDetailsUrl  业务数据详情url
     * @param extentParams        扩展参数(注意此参数必须是JSON格式)
     * @return 实例ID或动态表单url
     */
    JSONObject startProcessInstance(String processDefinitionId, String businessKey, String businessTitle, String businessDetailsUrl, String extentParams);

    /**
     * 检查任务是否满足自动签收条件
     * 如下一个节点角色+候选人总共为1个用户则自动签收
     *
     * @param processInstanceId 流程实例ID
     * @return true/false
     */
    boolean autoClaimTask(String processInstanceId);

    /**
     * 根据流程定义ID获取流程
     *
     * @param processDefinitionId 流程定义ID
     * @return ProcessDefinition
     */
    ProcessDefinition getProcessDefinition(String processDefinitionId);
}
