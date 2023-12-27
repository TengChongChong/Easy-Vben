package com.easy.admin.sample.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.easy.admin.common.core.annotation.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
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
 * @date 2023-12-27
 */
@Tag(name = "代码生成示例")
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
     * 查询数据
     *
     * @param sampleGeneral 查询条件
     * @param page 分页
     * @return Page<SampleGeneral>
     */
    @Operation(summary ="查询数据")
    @GetMapping()
    @RequiresPermissions("sample:general:select")
    public Page<SampleGeneral> select(SampleGeneral sampleGeneral, Page<SampleGeneral> page){
        return service.select(sampleGeneral, page);
    }

    /**
     * 查询详情
     *
     * @param id id
     * @return SampleGeneral
     */
    @Operation(summary ="查询详情")
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
    @Operation(summary ="新增")
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
    @Operation(summary ="删除")
    @DeleteMapping("{ids}")
    @RequiresPermissions("sample:general:remove")
    public boolean delete(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存/修改
     *
     * @param sampleGeneral 表单内容
     * @return SampleGeneral
     */
    @Operation(summary ="保存/修改")
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
    @Operation(summary ="导出数据")
    @GetMapping("export/data")
    @RequiresPermissions("sample:general:select")
    public String exportData(SampleGeneral sampleGeneral){
        return service.exportData(sampleGeneral);
    }

}
