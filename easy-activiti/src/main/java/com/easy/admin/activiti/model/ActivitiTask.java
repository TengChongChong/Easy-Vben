package com.easy.admin.activiti.model;

import java.util.Date;

/**
 * 待办任务 Task
 *
 * @author TengChongChong
 * @date 2020/3/27
 */
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

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getParentTaskId() {
        return parentTaskId;
    }

    public void setParentTaskId(String parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocalizedDescription() {
        return localizedDescription;
    }

    public void setLocalizedDescription(String localizedDescription) {
        this.localizedDescription = localizedDescription;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getExecutionId() {
        return executionId;
    }

    public void setExecutionId(String executionId) {
        this.executionId = executionId;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public String getTaskDefinitionKey() {
        return taskDefinitionKey;
    }

    public void setTaskDefinitionKey(String taskDefinitionKey) {
        this.taskDefinitionKey = taskDefinitionKey;
    }

    public String getFormKey() {
        return formKey;
    }

    public void setFormKey(String formKey) {
        this.formKey = formKey;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public boolean isForcedUpdate() {
        return forcedUpdate;
    }

    public void setForcedUpdate(boolean forcedUpdate) {
        this.forcedUpdate = forcedUpdate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBusinessTitle() {
        return businessTitle;
    }

    public void setBusinessTitle(String businessTitle) {
        this.businessTitle = businessTitle;
    }

    public String getProcessDefinitionName() {
        return processDefinitionName;
    }

    public void setProcessDefinitionName(String processDefinitionName) {
        this.processDefinitionName = processDefinitionName;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getBusinessDetailsPath() {
        return businessDetailsPath;
    }

    public void setBusinessDetailsPath(String businessDetailsPath) {
        this.businessDetailsPath = businessDetailsPath;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(String applyUserId) {
        this.applyUserId = applyUserId;
    }

    public Integer getProcessVersion() {
        return processVersion;
    }

    public void setProcessVersion(Integer processVersion) {
        this.processVersion = processVersion;
    }
}
