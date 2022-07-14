package com.easy.admin.activiti.service;

import cn.hutool.json.JSONObject;
import com.easy.admin.activiti.model.ActivitiProcessDefinitionVO;
import org.activiti.engine.repository.ProcessDefinition;

/**
 * 启动流程
 *
 * @author TengChongChong
 * @date 2020/3/26
 */
public interface ActivitiProcessDefinitionService {
    /**
     * 读取流程起点动态表单
     *
     * @param processDefinitionId 流程id
     * @return JSONObject
     */
    JSONObject readStartForm(String processDefinitionId);

    /**
     * 启动流程
     * （先验证有无动态表单，如果没有自动提交，如果有返回表单地址）
     *
     * @param activitiProcessDefinitionVO 流程数据
     * @return 实例ID或动态表单url
     */
    JSONObject startProcessInstance(ActivitiProcessDefinitionVO activitiProcessDefinitionVO);

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
