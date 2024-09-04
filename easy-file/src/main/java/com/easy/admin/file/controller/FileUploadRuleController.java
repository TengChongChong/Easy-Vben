package com.easy.admin.file.controller;

import com.easy.admin.common.core.annotation.ResponseResult;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.file.model.FileUploadRule;
import com.easy.admin.file.service.FileUploadRuleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 文件上传规则
 *
 * @author tengchongchong
 * @date 2023-11-17
 */
@Tag(name = "文件上传规则")
@RestController
@ResponseResult
@RequestMapping("/api/auth/file/upload/rule")
public class FileUploadRuleController {

    /**
     * 文件上传规则 service
     */
    @Autowired
    private FileUploadRuleService service;

    /**
     * 查询数据
     *
     * @param fileUploadRule 查询条件
     * @param page           分页
     * @return Page<FileUploadRule>
     */
    @Operation(summary = "查询数据")
    @GetMapping()
    @SaCheckPermission("file:upload:rule:select")
    public Page<FileUploadRule> select(FileUploadRule fileUploadRule, Page<FileUploadRule> page) {
        return service.select(fileUploadRule, page);
    }

    /**
     * 查询详情
     *
     * @param id id
     * @return FileUploadRule
     */
    @Operation(summary = "查询详情")
    @GetMapping("{id}")
    @SaCheckPermission("file:upload:rule:select")
    public FileUploadRule get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 新增
     *
     * @return FileUploadRule
     */
    @GetMapping("add")
    @Operation(summary = "新增")
    @SaCheckPermission("file:upload:rule:save")
    public FileUploadRule add() {
        return service.add();
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    @Operation(summary = "删除")
    @DeleteMapping("{ids}")
    @SaCheckPermission("file:upload:rule:remove")
    public boolean delete(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存/修改
     *
     * @param fileUploadRule 表单内容
     * @return FileUploadRule
     */
    @Operation(summary = "保存/修改")
    @PostMapping()
    @SaCheckPermission("file:upload:rule:save")
    public FileUploadRule saveData(@Valid @RequestBody FileUploadRule fileUploadRule) {
        return service.saveData(fileUploadRule);
    }

    /**
     * 设置状态
     *
     * @param id     id
     * @param status 状态
     * @return true/false
     */
    @PostMapping("{id}/status/{status}")
    @SaCheckPermission("file:upload:rule:save")
    public boolean setStatus(@PathVariable("id") String id,
                             @PathVariable("status") String status) {
        return service.setStatus(id, status);
    }

    /**
     * 获取上传规则
     *
     * @param slug 规则别名
     * @return FileUploadRule
     */
    @Operation(summary = "获取上传规则")
    @GetMapping("slug/{slug}")
    public FileUploadRule getBySlug(@PathVariable("slug") String slug) {
        return service.getBySlug(slug);
    }
}
