package com.easy.admin.workflow.service;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.workflow.model.vo.WorkflowModelVO;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.activiti.engine.impl.persistence.entity.ModelEntity;
import org.activiti.engine.impl.persistence.entity.ModelEntityImpl;

/**
 * 流程模型
 *
 * @author TengChongChong
 * @date 2025-07-14
 **/
public interface WorkflowModelService {

    /**
     * 列表
     *
     * @param workflowModel 查询条件
     * @param page          分页
     * @return page
     */
    Page<WorkflowModelVO> select(WorkflowModelVO workflowModel, Page<WorkflowModelVO> page);

    /**
     * 详情
     *
     * @param id 数据id
     * @return 详细信息
     */
    ModelEntity get(String id);

    /**
     * 获取模型信息
     *
     * @param id 数据id
     * @return 模型信息
     */
    ObjectNode getModel(String id);

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    boolean remove(String ids);

    /**
     * 保存
     *
     * @param workflowModel 提交数据
     * @return 保存后信息
     */
    ModelEntityImpl saveData(WorkflowModelVO workflowModel);

    /**
     * 保存模型
     *
     * @param id          模型id
     * @param name        名称
     * @param description 描述
     * @param jsonXml     json
     */
    void saveModel(String id, String name, String description, String jsonXml);

    /**
     * 读取stencilset.json文件
     *
     * @return 文件内容
     */
    String getStencilset();

    /**
     * 部署流程
     *
     * @param id 模型id
     * @return true/false
     */
    boolean deploymentProcess(String id);

    /**
     * 导出模型
     *
     * @param id 模型id
     * @return sys download id
     */
    String export(String id);

    /**
     * 根据模型标识查询流程定义ID
     *
     * @param key 模型标识
     * @return 流程定义ID
     */
    String selectProcessDefinitionId(String key);

    /**
     * 检查流程标识是否存在
     *
     * @param key 标识
     * @param id  id
     * @return true/false
     */
    boolean checkKeyIsExistence(String key, String id);
}
