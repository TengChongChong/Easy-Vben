package com.easy.admin.cms.controller;

import com.easy.admin.cms.model.CmsPage;
import com.easy.admin.cms.service.CmsPageService;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.core.annotation.ResponseResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 页面管理
 *
 * @author TengChongChong
 * @date 2021-11-24
 */
@RestController
@ResponseResult
@RequestMapping("/auth/cms/page")
public class CmsPageController {

    /**
     * 页面管理 service
     */
    @Autowired
    private CmsPageService service;

    /**
     * 列表
     *
     * @param object 查询条件
     * @return Page<CmsPage>
     */
    @GetMapping()
    @RequiresPermissions("cms:page:select")
    public Page<CmsPage> select(CmsPage object, Page<CmsPage> page){
        return service.select(object, page);
    }

    /**
     * 详情
     *
     * @param id id
     * @return CmsPage
     */
    @GetMapping("{id}")
    @RequiresPermissions("cms:page:select")
    public CmsPage get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 新增
     *
     * @return CmsPage
     */
    @GetMapping("add")
    @RequiresPermissions("cms:page:save")
    public CmsPage add() {
        return service.add();
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    @DeleteMapping("{ids}")
    @RequiresPermissions("cms:page:remove")
    public boolean delete(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return CmsPage
     */
    @PostMapping()
    @RequiresPermissions("cms:page:save")
    public CmsPage saveData(@Valid @RequestBody CmsPage object){
        return service.saveData(object);
    }



}
