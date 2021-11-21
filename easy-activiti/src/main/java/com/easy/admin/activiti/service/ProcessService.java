package com.easy.admin.activiti.service;


import com.easy.admin.activiti.model.Process;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;

import java.io.InputStream;
import java.util.List;

/**
 * 流程
 *
 * @author TengChongChong
 * @date 2019-07-12
 */
public interface ProcessService {
    /**
     * 查询数据
     *
     * @param process 查询条件
     * @param page    分页
     * @return 数据
     */
    Page<Process> select(Process process, Page<Process> page);

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    boolean remove(String ids);

    /**
     * 流程转模型
     *
     * @param process process
     * @return true/false
     */
    boolean convertToModel(Process process);

    /**
     * 查看流程图片
     *
     * @param id           流程id
     * @param resourceName 资源名称
     * @return true/false
     */
    InputStream getImageStream(String id, String resourceName);

    /**
     * 添加流程
     *
     * @param path 流程模型文件路径
     * @return true/false
     */
    boolean add(String path);

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
