package com.easy.admin.activiti.model;

import java.util.Date;

/**
 * 历史任务实例
 *
 * @author TengChongChong
 * @date 2020/5/14
 */
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentTaskId() {
        return parentTaskId;
    }

    public void setParentTaskId(String parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getClaimTime() {
        return claimTime;
    }

    public void setClaimTime(Date claimTime) {
        this.claimTime = claimTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDeleteReason() {
        return deleteReason;
    }

    public void setDeleteReason(String deleteReason) {
        this.deleteReason = deleteReason;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getFormKey() {
        return formKey;
    }

    public void setFormKey(String formKey) {
        this.formKey = formKey;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getProcessDefinitionName() {
        return processDefinitionName;
    }

    public void setProcessDefinitionName(String processDefinitionName) {
        this.processDefinitionName = processDefinitionName;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getBusinessTitle() {
        return businessTitle;
    }

    public void setBusinessTitle(String businessTitle) {
        this.businessTitle = businessTitle;
    }

    public String getBusinessDetailsPath() {
        return businessDetailsPath;
    }

    public void setBusinessDetailsPath(String businessDetailsPath) {
        this.businessDetailsPath = businessDetailsPath;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public Integer getProcessSuspensionState() {
        return processSuspensionState;
    }

    public void setProcessSuspensionState(Integer processSuspensionState) {
        this.processSuspensionState = processSuspensionState;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Integer getProcessVersion() {
        return processVersion;
    }

    public void setProcessVersion(Integer processVersion) {
        this.processVersion = processVersion;
    }
}
