package com.easy.admin.cms.controller;

import com.easy.admin.cms.model.CmsMedia;
import com.easy.admin.cms.service.CmsMediaService;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.core.annotation.ResponseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 资源
 *
 * @author 系统管理员
 * @date 2023-06-21
 */
@Tag(name = "资源")
@RestController
@ResponseResult
@RequestMapping("/api/auth/cms/media")
public class CmsMediaController {

    /**
     * 资源 service
     */
    @Autowired
    private CmsMediaService service;

    /**
     * 查询数据
     *
     * @param cmsMedia 查询条件
     * @param page     分页
     * @return Page<CmsMedia>
     */
    @Operation(summary = "查询数据")
    @GetMapping()
    @RequiresPermissions("cms:media:select")
    public Page<CmsMedia> select(CmsMedia cmsMedia, Page<CmsMedia> page) {
        return service.select(cmsMedia, page);
    }

    /**
     * 查询详情
     *
     * @param id id
     * @return CmsMedia
     */
    @Operation(summary = "查询详情")
    @GetMapping("{id}")
    @RequiresPermissions("cms:media:select")
    public CmsMedia get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 新增
     *
     * @return CmsMedia
     */
    @GetMapping("add")
    @Operation(summary = "新增")
    @RequiresPermissions("cms:media:save")
    public CmsMedia add() {
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
    @RequiresPermissions("cms:media:remove")
    public boolean delete(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存/修改
     *
     * @param cmsMedia 表单内容
     * @return CmsMedia
     */
    @Operation(summary = "保存/修改")
    @PostMapping()
    @RequiresPermissions("cms:media:save")
    public CmsMedia saveData(@Valid @RequestBody CmsMedia cmsMedia) {
        return service.saveData(cmsMedia);
    }
}
