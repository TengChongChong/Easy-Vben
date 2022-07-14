package com.easy.admin.activiti.service;

import com.easy.admin.activiti.model.ActivitiModel;
import com.easy.admin.common.core.common.pagination.Page;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.activiti.engine.impl.persistence.entity.ModelEntity;

/**
 * Activiti 流程模型
 *
 * @author TengChongChong
 * @date 2019-07-02
 */
public interface ActivitiModelService {
    /**
     * 列表
     *
     * @param activitiModel 查询条件
     * @param page 分页
     * @return page
     */
    Page<ActivitiModel> select(ActivitiModel activitiModel, Page<ActivitiModel> page);

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
     * @param activitiModel 提交数据
     * @return 保存后信息
     */
    ModelEntity saveData(ActivitiModel activitiModel);

    /**
     * 保存模型
     *
     * @param id          模型id
     * @param name        名称
     * @param description 描述
     * @param jsonXml     json
     * @param svgXml      svg
     */
    void saveModel(String id, String name, String description, String jsonXml, String svgXml);

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
