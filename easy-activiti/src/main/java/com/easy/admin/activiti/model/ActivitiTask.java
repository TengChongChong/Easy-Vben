package com.easy.admin.activiti.model;

import lombok.Data;

import java.util.Date;

/**
 * 待办任务 Task
 *
 * @author TengChongChong
 * @date 2020/3/27
 */
@Data
public class ActivitiTask {
    /**
     * 任务id
     */
    private String id;
    /**
     * 版本
     */
    private int revision;
    /**
     * 实际签收人 任务的拥有者：签收人（默认为空，只有在委托时才有值）
     */
    private String owner;
    /**
     * 签收人或委托人
     */
    private String assignee;
    /**
     * 父任务id
     */
    private String parentTaskId;
    /**
     * 任务标题
     */
    private String name;
    /**
     * 自定义名称
     */
    private String localizedName;
    /**
     * 任务说明
     */
    private String description;
    /**
     * 自定义任务说明
     */
    private String localizedDescription;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 优先级别，默认为：50
     */
    private int priority = 50;
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
     * 流程版本
     */
    private Integer processVersion;
    /**
     * 任务唯一id
     */
    private String taskDefinitionKey;
    /**
     * 表单 key
     */
    private String formKey;
    /**
     * 是否删除
     */
    private boolean isDeleted;
    /**
     * 事件名称
     */
    private String eventName;
    /**
     * 强制更新？
     */
    private boolean forcedUpdate;
    /**
     * 状态
     */
    private String status;

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
     * 发起人用户id
     */
    private String applyUserId;

    /**
     * 申请人头像
     */
    private String avatar;

}
