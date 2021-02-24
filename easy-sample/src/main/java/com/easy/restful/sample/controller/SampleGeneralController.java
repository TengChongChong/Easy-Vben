package com.easy.restful.sample.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.easy.restful.core.annotation.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.easy.restful.common.core.common.pagination.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import javax.validation.Valid;
import com.easy.restful.sample.model.SampleGeneral;
import com.easy.restful.sample.service.SampleGeneralService;

/**
 * 代码生成示例
 *
 * @author 系统管理员
 * @date 2021-02-23
 */
@RestController
@ResponseResult
@RequestMapping("/auth/sample/general")
public class SampleGeneralController {

    /**
     * 代码生成示例 service
     */
    @Autowired
    private SampleGeneralService service;

    /**
     * 列表
     *
     * @param object 查询条件
     * @return Page<SampleGeneral>
     */
    @GetMapping()
    @RequiresPermissions("sample:general:select")
    public Page<SampleGeneral> select(SampleGeneral object, Page<SampleGeneral> page){
        return service.select(object, page);
    }

    /**
     * 详情
     *
     * @param id id
     * @return SampleGeneral
     */
    @GetMapping("{id}")
    @RequiresPermissions("sample:general:select")
    public SampleGeneral input(@PathVariable("id") String id) {
        return service.input(id);
    }

    /**
     * 新增
     *
     * @return SampleGeneral
     */
    @GetMapping("add")
    @RequiresPermissions("sample:general:add")
    public SampleGeneral add() {
        return service.add();
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    @DeleteMapping("{ids}")
    @RequiresPermissions("sample:general:remove")
    public boolean delete(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return SampleGeneral
     */
    @PostMapping()
    @RequiresPermissions("sample:general:save")
    public SampleGeneral saveData(@Valid @RequestBody SampleGeneral object){
        return service.saveData(object);
    }
    /**
     * 导出数据
     *
     * @param object 查询条件
     * @return 文件下载id
     */
    @GetMapping("export/data")
    @RequiresPermissions("sample:general:select")
    public String exportData(SampleGeneral object){
        return service.exportData(object);
    }
}
