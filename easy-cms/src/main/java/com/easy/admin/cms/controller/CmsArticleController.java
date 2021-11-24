package com.easy.admin.cms.controller;

import com.easy.admin.cms.common.status.CmsArticleStatus;
import com.easy.admin.cms.model.CmsArticle;
import com.easy.admin.cms.service.CmsArticleService;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.core.annotation.ResponseResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 文章管理
 *
 * @author TengChongChong
 * @date 2021-11-19
 */
@RestController
@ResponseResult
@RequestMapping("/auth/cms/article")
public class CmsArticleController {

    /**
     * 文章管理 service
     */
    @Autowired
    private CmsArticleService service;

    /**
     * 列表
     *
     * @param object 查询条件
     * @return Page<CmsArticle>
     */
    @GetMapping()
    @RequiresPermissions("cms:article:select")
    public Page<CmsArticle> select(CmsArticle object, Page<CmsArticle> page) {
        return service.select(object, page);
    }

    /**
     * 详情
     *
     * @param id id
     * @return CmsArticle
     */
    @GetMapping("{id}")
    @RequiresPermissions("cms:article:select")
    public CmsArticle get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 新增
     *
     * @param columnId 栏目id
     * @return CmsArticle
     */
    @GetMapping("add")
    @RequiresPermissions("cms:article:save")
    public CmsArticle add(@RequestParam(value = "columnId", required = false) String columnId) {
        return service.add(columnId);
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    @DeleteMapping("{ids}")
    @RequiresPermissions("cms:article:remove")
    public boolean delete(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return CmsArticle
     */
    @PostMapping()
    @RequiresPermissions("cms:article:save")
    public CmsArticle saveData(@Valid @RequestBody CmsArticle object) {
        return service.saveData(object);
    }


    /**
     * 发布
     *
     * @param ids 数据ids
     * @return true/false
     */
    @PostMapping("release/{ids}")
    @RequiresPermissions("cms:article:status")
    public boolean release(@PathVariable("ids") String ids) {
        return service.setStatus(ids, CmsArticleStatus.PUBLISHED.getCode());
    }

    /**
     * 撤销
     *
     * @param ids 数据ids
     * @return true/false
     */
    @PostMapping("revoke/{ids}")
    @RequiresPermissions("cms:article:status")
    public boolean revoke(@PathVariable("ids") String ids) {
        return service.setStatus(ids, CmsArticleStatus.RESCINDED.getCode());
    }
}
