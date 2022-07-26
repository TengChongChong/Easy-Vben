package com.easy.admin.sample.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.easy.admin.core.annotation.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.easy.admin.common.core.common.pagination.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import com.easy.admin.sample.model.SampleGeneral;
import com.easy.admin.sample.service.SampleGeneralService;

/**
 * 代码生成示例
 *
 * @author 系统管理员
 * @date 2022-07-18
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/sample/general")
public class SampleGeneralController {

    /**
     * 代码生成示例 service
     */
    @Autowired
    private SampleGeneralService service;

    /**
     * 列表
     *
     * @param sampleGeneral 查询条件
     * @return Page<SampleGeneral>
     */
    @GetMapping()
    @RequiresPermissions("sample:general:select")
    public Page<SampleGeneral> select(SampleGeneral sampleGeneral, Page<SampleGeneral> page){
        return service.select(sampleGeneral, page);
    }

    /**
     * 详情
     *
     * @param id id
     * @return SampleGeneral
     */
    @GetMapping("{id}")
    @RequiresPermissions("sample:general:select")
    public SampleGeneral get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 新增
     *
     * @return SampleGeneral
     */
    @GetMapping("add")
    @RequiresPermissions("sample:general:save")
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
     * @param sampleGeneral 表单内容
     * @return SampleGeneral
     */
    @PostMapping()
    @RequiresPermissions("sample:general:save")
    public SampleGeneral saveData(@Valid @RequestBody SampleGeneral sampleGeneral){
        return service.saveData(sampleGeneral);
    }

    /**
     * 导出数据
     *
     * @param sampleGeneral 查询条件
     * @return 文件下载id
     */
    @GetMapping("export/data")
    @RequiresPermissions("sample:general:select")
    public String exportData(SampleGeneral sampleGeneral){
        return service.exportData(sampleGeneral);
    }

}
