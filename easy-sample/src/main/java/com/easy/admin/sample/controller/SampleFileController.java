package com.easy.admin.sample.controller;

import com.easy.admin.common.core.annotation.ResponseResult;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.sample.model.SampleFile;
import com.easy.admin.sample.service.SampleFileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 文件示例
 *
 * @author tengchongchong
 * @date 2023-12-22
 */
@Tag(name = "文件示例")
@RestController
@ResponseResult
@RequestMapping("/api/auth/sample/file")
public class SampleFileController {

    /**
     * 文件示例 service
     */
    @Autowired
    private SampleFileService service;

    /**
     * 查询数据
     *
     * @param sampleFile 查询条件
     * @param page 分页
     * @return Page<SampleFile>
     */
    @Operation(summary ="查询数据")
    @GetMapping()
    @RequiresPermissions("sample:file:select")
    public Page<SampleFile> select(SampleFile sampleFile, Page<SampleFile> page){
        return service.select(sampleFile, page);
    }

    /**
     * 查询详情
     *
     * @param id id
     * @return SampleFile
     */
    @Operation(summary ="查询详情")
    @GetMapping("{id}")
    @RequiresPermissions("sample:file:select")
    public SampleFile get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 新增
     *
     * @return SampleFile
     */
    @GetMapping("add")
    @Operation(summary ="新增")
    @RequiresPermissions("sample:file:save")
    public SampleFile add() {
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
    @RequiresPermissions("sample:file:remove")
    public boolean delete(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存/修改
     *
     * @param sampleFile 表单内容
     * @return SampleFile
     */
    @Operation(summary ="保存/修改")
    @PostMapping()
    @RequiresPermissions("sample:file:save")
    public SampleFile saveData(@Valid @RequestBody SampleFile sampleFile){
        return service.saveData(sampleFile);
    }

    /**
     * 下载
     *
     * @param id id
     * @return 文件下载id
     */
    @Operation(summary ="下载")
    @GetMapping("download/{id}")
    public String download(@PathVariable("id") String id){
        return service.download(id);
    }
}
