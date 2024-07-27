package com.easy.admin.activiti.model;

import lombok.Data;

import java.util.Date;

/**
 * 流程历史活动记录
 *
 * @author TengChongChong
 * @date 2020/5/7
 */
@Data
public class ActivitiHistoric {
    /**
     * id
     */
    protected String id;
    /**
     * 执行实例ID
     */
    private String executionId;
    /**
     * 流程实例ID
     */
    private String processInstanceId;
    /**
     * 流程定义ID
     */
    private String processDefinitionId;
    /**
     * 流程名称
     */
    private String processDefinitionName;
    /**
     * 活动ID：节点定义ID
     */
    private String activityId;
    /**
     * 活动名称：节点定义名称
     */
    protected String activityName;
    /**
     * 活动类型：如startEvent、userTask
     */
    protected String activityType;
    /**
     * 代理人员：节点签收人
     */
    protected String assignee;
    /**
     * 任务ID：任务实例ID
     */
    protected String taskId;
    /**
     * 请求流程实例ID：调用外部流程的流程实例ID
     */
    protected String calledProcessInstanceId;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 耗时：毫秒
     */
    private long duration;

}
