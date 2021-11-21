package com.easy.admin.cms.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.easy.admin.core.annotation.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import com.easy.admin.common.core.common.pagination.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import javax.validation.Valid;
import com.easy.admin.cms.model.CmsArticle;
import com.easy.admin.cms.service.CmsArticleService;

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
    public Page<CmsArticle> select(CmsArticle object, Page<CmsArticle> page){
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
    public CmsArticle input(@PathVariable("id") String id) {
        return service.input(id);
    }

    /**
     * 新增
     *
     * @return CmsArticle
     */
    @GetMapping("add")
    @RequiresPermissions("cms:article:save")
    public CmsArticle add() {
        return service.add();
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
    public CmsArticle saveData(@Valid @RequestBody CmsArticle object){
        return service.saveData(object);
    }

}
