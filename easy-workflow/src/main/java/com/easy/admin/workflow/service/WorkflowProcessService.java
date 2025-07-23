package com.easy.admin.workflow.service;


import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.workflow.model.vo.WorkflowProcessVO;

import java.io.InputStream;
import java.util.List;

/**
 * 流程
 *
 * @author TengChongChong
 * @date 2025-07-12
 */
public interface WorkflowProcessService {
    /**
     * 查询数据
     *
     * @param workflowProcess 查询条件
     * @param page            分页
     * @return 数据
     */
    Page<WorkflowProcessVO> select(WorkflowProcessVO workflowProcess, Page<WorkflowProcessVO> page);

    /**
     * 删除
     *
     * @param deploymentIds 部署ids
     * @return true/false
     */
    boolean remove(String deploymentIds);

    /**
     * 流程转模型
     *
     * @param workflowProcess process
     * @return true/false
     */
    boolean convertToModel(WorkflowProcessVO workflowProcess);

    /**
     * 查看流程图片
     *
     * @param deploymentId 部署id
     * @param resourceName 资源名称
     * @return true/false
     */
    InputStream getImageStream(String deploymentId, String resourceName);

    /**
     * 挂起流程
     *
     * @param processDefinitionId     流程id
     * @param suspendProcessInstances 如果为true，将同时挂起此流程正在进行的任务
     */
    void suspend(String processDefinitionId, boolean suspendProcessInstances);

    /**
     * 激活流程
     *
     * @param processDefinitionId      流程id
     * @param activateProcessInstances 如果为true，将同时激活此流程正在进行的任务
     */
    void activation(String processDefinitionId, boolean activateProcessInstances);

    /**
     * 查询流程数据用于放到select的option中
     *
     * @return 数据集合
     */
    List<Select> selectProcessForSelect();
}
