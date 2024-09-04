package com.easy.admin.cms.controller;

import com.easy.admin.cms.common.status.CmsArticleStatus;
import com.easy.admin.cms.model.CmsArticle;
import com.easy.admin.cms.service.CmsArticleService;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.annotation.ResponseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 文章
 *
 * @author tengchongchong
 * @date 2023-06-21
 */
@Tag(name = "文章")
@RestController
@ResponseResult
@RequestMapping("/api/auth/cms/article")
public class CmsArticleController {

    /**
     * 文章 service
     */
    @Autowired
    private CmsArticleService service;

    /**
     * 查询数据
     *
     * @param cmsArticle 查询条件
     * @param page       分页
     * @return Page<CmsArticle>
     */
    @Operation(summary = "查询数据")
    @GetMapping()
    @SaCheckPermission("cms:article:select")
    public Page<CmsArticle> select(CmsArticle cmsArticle, Page<CmsArticle> page) {
        return service.select(cmsArticle, page);
    }

    /**
     * 查询详情
     *
     * @param id id
     * @return CmsArticle
     */
    @Operation(summary = "查询详情")
    @GetMapping("{id}")
    @SaCheckPermission("cms:article:select")
    public CmsArticle get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 新增
     *
     * @return CmsArticle
     */
    @GetMapping("add")
    @Operation(summary = "新增")
    @SaCheckPermission("cms:article:save")
    public CmsArticle add() {
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
    @SaCheckPermission("cms:article:remove")
    public boolean delete(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存/修改
     *
     * @param cmsArticle 表单内容
     * @return CmsArticle
     */
    @Operation(summary = "保存/修改")
    @PostMapping()
    @SaCheckPermission("cms:article:save")
    public CmsArticle saveData(@Valid @RequestBody CmsArticle cmsArticle) {
        return service.saveData(cmsArticle);
    }

    /**
     * 发布
     *
     * @param ids 数据ids
     * @return true/false
     */
    @Operation(summary = "发布")
    @PostMapping("release/{ids}")
    @SaCheckPermission("cms:article:status")
    public boolean release(@PathVariable("ids") String ids) {
        return service.setStatus(ids, CmsArticleStatus.PUBLISHED.getCode());
    }

    /**
     * 撤销
     *
     * @param ids 数据ids
     * @return true/false
     */
    @Operation(summary = "撤销")
    @PostMapping("revoke/{ids}")
    @SaCheckPermission("cms:article:status")
    public boolean revoke(@PathVariable("ids") String ids) {
        return service.setStatus(ids, CmsArticleStatus.RESCINDED.getCode());
    }
}
