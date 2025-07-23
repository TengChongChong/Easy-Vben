package com.easy.admin.workflow.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.easy.admin.common.core.annotation.ResponseResult;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.workflow.model.vo.WorkflowModelVO;
import com.easy.admin.workflow.service.WorkflowModelService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.activiti.engine.impl.persistence.entity.ModelEntity;
import org.activiti.engine.impl.persistence.entity.ModelEntityImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Workflow 流程模型
 *
 * @author TengChongChong
 * @date 2025-07-12
 */
@RestController
@RequestMapping("/api/auth/workflow/model")
public class WorkflowModelController {

    @Autowired
    private WorkflowModelService service;

    /**
     * 列表
     *
     * @param workflowModel 查询条件
     * @return Page<WorkflowModelVO>
     */
    @RequestMapping()
    @ResponseResult
    @SaCheckPermission("workflow:model:select")
    public Page<WorkflowModelVO> select(WorkflowModelVO workflowModel, Page<WorkflowModelVO> page) {
        return service.select(workflowModel, page);
    }

    /**
     * 详情
     *
     * @param id id
     * @return String
     */
    @GetMapping("{id}")
    @ResponseResult
    @SaCheckPermission("workflow:model:select")
    public ModelEntity get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 详情
     *
     * @param id id
     * @return String
     */
    @GetMapping("{id}/json")
    @ResponseResult
    @SaCheckPermission("workflow:model:select")
    public ObjectNode getModel(@PathVariable("id") String id) {
        return service.getModel(id);
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    @DeleteMapping("{ids}")
    @ResponseResult
    @SaCheckPermission("workflow:model:remove")
    public boolean remove(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存
     *
     * @param workflowModel 表单内容
     * @return ModelEntity
     */
    @PostMapping()
    @ResponseResult
    @SaCheckPermission("workflow:model:save")
    public ModelEntityImpl saveData(@RequestBody @Valid WorkflowModelVO workflowModel) {
        return service.saveData(workflowModel);
    }

    @PutMapping("{id}")
    @ResponseResult
    @SaCheckPermission("workflow:model:save")
    public boolean saveModel(@PathVariable("id") String id, String name,
                             String description,
                             @RequestParam("json_xml") String jsonXml) {
        service.saveModel(id, name, description, jsonXml);
        return true;
    }

    /**
     * 读取stencilset.json文件
     *
     * @return 文件内容
     */
    @GetMapping("stencilset")
    public String getStencilset() {
        return service.getStencilset();
    }

    /**
     * 部署流程
     *
     * @param id 模型id
     * @return true/false
     */
    @PostMapping("deployment/process/{id}")
    @ResponseResult
    @SaCheckPermission("workflow:model:save")
    public boolean deploymentProcess(@PathVariable("id") String id) {
        return service.deploymentProcess(id);
    }

    /**
     * 导出模型
     *
     * @param id 模型id
     * @return sys download id
     */
    @GetMapping("export/{id}")
    @ResponseResult
    @SaCheckPermission("workflow:model:select")
    public String export(@PathVariable("id") String id) {
        return service.export(id);
    }

    /**
     * 根据模型标识查询流程定义ID
     *
     * @param key 模型标识
     * @return 流程定义ID
     */
    @GetMapping("process/definition/id/{key}")
    @ResponseResult
    @SaCheckPermission("workflow:model:select")
    public String selectProcessDefinitionId(@PathVariable("key") String key) {
        return service.selectProcessDefinitionId(key);
    }
}
