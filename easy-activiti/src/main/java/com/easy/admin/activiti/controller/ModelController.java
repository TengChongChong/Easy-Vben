package com.easy.admin.activiti.controller;

import com.easy.admin.activiti.model.Model;
import com.easy.admin.activiti.service.ModelService;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.core.annotation.ResponseResult;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.activiti.engine.impl.persistence.entity.ModelEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Activiti 流程模型
 *
 * @author TengChongChong
 * @date 2019-07-03
 */
@RestController
@RequestMapping("/auth/activiti/model")
public class ModelController {

    @Autowired
    private ModelService service;

    /**
     * 列表
     *
     * @param object 查询条件
     * @return Tips
     */
    @RequestMapping()
    @ResponseResult
    @RequiresPermissions("activiti:model:select")
    public Page<Model> select(Model object, Page<Model> page) {
        return service.select(object, page);
    }

    /**
     * 详情
     *
     * @param id id
     * @return String
     */
    @GetMapping("{id}")
    @ResponseResult
    @RequiresPermissions("activiti:model:select")
    public ModelEntity input(@PathVariable("id") String id) {
        return service.input(id);
    }

    /**
     * 详情
     *
     * @param id id
     * @return String
     */
    @GetMapping("{id}/json")
    @ResponseResult
    @RequiresPermissions("activiti:model:select")
    public ObjectNode getModel(@PathVariable("id") String id) {
        return service.getModel(id);
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return Tips
     */
    @DeleteMapping("{ids}")
    @ResponseResult
    @RequiresPermissions("activiti:model:remove")
    public boolean remove(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return Tips
     */
    @PostMapping()
    @ResponseResult
    @RequiresPermissions("activiti:model:save")
    public ModelEntity saveData(@RequestBody @Valid Model object) {
        return service.saveData(object);
    }

    @PutMapping("{id}")
    @ResponseResult
    @RequiresPermissions("activiti:model:save")
    public boolean saveModel(@PathVariable("id") String id, String name,
                          String description,
                          @RequestParam("json_xml") String jsonXml,
                          @RequestParam("svg_xml") String svgXml) {
        service.saveModel(id, name, description, jsonXml, svgXml);
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
    @RequiresPermissions("activiti:model:save")
    public boolean deploymentProcess(@PathVariable("id") String id) {
        return service.deploymentProcess(id);
    }

    /**
     * 导出模型
     *
     * @param id 模型id
     */
    @GetMapping("export/{id}")
    @ResponseResult
    @RequiresPermissions("activiti:model:select")
    public String export(@PathVariable("id") String id) {
        return service.export(id);
    }

    /**
     * 根据模型标识查询流程定义ID
     *
     * @param key 模型标识
     * @return Tips 流程定义ID
     */
    @GetMapping("process/definition/id/{key}")
    @ResponseResult
    @RequiresPermissions("activiti:model:select")
    public String selectProcessDefinitionId(@PathVariable("key") String key) {
        return service.selectProcessDefinitionId(key);
    }
}
