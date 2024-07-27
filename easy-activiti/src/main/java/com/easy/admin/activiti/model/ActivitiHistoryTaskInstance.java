package com.easy.admin.activiti.model;

import lombok.Data;

import java.util.Date;

/**
 * 历史任务实例
 *
 * @author TengChongChong
 * @date 2020/5/14
 */
@Data
public class ActivitiHistoryTaskInstance {
    /**
     * id
     */
    protected String id;
    /**
     * 流程定义ID
     */
    private String processDefinitionId;
    /**
     * 流程名称
     */
    private String processDefinitionName;

    /**
     * 流程版本
     */
    private Integer processVersion;
    /**
     * key
     */
    private String taskDefinitionKey;
    /**
     * 执行实例ID
     */
    private String executionId;
    /**
     * 流程实例ID
     */
    private String processInstanceId;
    /**
     * 节点名称
     */
    private String name;
    /**
     * 父任务id
     */
    private String parentTaskId;
    /**
     * 节点说明
     */
    private String description;
    /**
     * 实际签收人 任务的拥有者：签收人（默认为空，只有在委托时才有值）
     */
    private String owner;
    /**
     * 签收人或委托人
     */
    private String assignee;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 签收时间
     */
    private Date claimTime;
    /**
     * 办结时间
     */
    private Date endTime;
    /**
     * 耗时
     */
    private String duration;
    /**
     * 删除原因
     */
    private String deleteReason;
    /**
     * 优先级别，默认为：50
     */
    private int priority = 50;
    /**
     * 应完成时间：过期时间，表明任务应在多长时间内完成
     */
    private Date dueDate;
    /**
     * 外置表单key
     */
    private String formKey;
    /**
     * 分类
     */
    private String category;
    /**
     * 租户id
     */
    private String tenantId;

    /**
     * 业务数据ID
     */
    private String businessKey;
    /**
     * 业务标题
     */
    private String businessTitle;
    /**
     * 业务数据详情url
     */
    private String businessDetailsPath;
    /**
     * 发起人
     */
    private String applyUser;

    /**
     * 流程状态
     */
    private Integer processSuspensionState;

    /**
     * 任务状态
     */
    private String taskStatus;

}
