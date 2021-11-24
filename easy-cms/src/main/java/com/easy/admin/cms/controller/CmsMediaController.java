package com.easy.admin.cms.controller;

import com.easy.admin.cms.model.CmsMedia;
import com.easy.admin.cms.service.CmsMediaService;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.core.annotation.ResponseResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 资源管理
 *
 * @author TengChongChong
 * @date 2021-11-21
 */
@RestController
@ResponseResult
@RequestMapping("/auth/cms/media")
public class CmsMediaController {

    /**
     * 资源管理 service
     */
    @Autowired
    private CmsMediaService service;

    /**
     * 列表
     *
     * @param object 查询条件
     * @return Page<CmsMedia>
     */
    @GetMapping()
    @RequiresPermissions("cms:media:select")
    public Page<CmsMedia> select(CmsMedia object, Page<CmsMedia> page){
        return service.select(object, page);
    }

    /**
     * 详情
     *
     * @param id id
     * @return CmsMedia
     */
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
    @DeleteMapping("{ids}")
    @RequiresPermissions("cms:media:remove")
    public boolean delete(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return CmsMedia
     */
    @PostMapping()
    @RequiresPermissions("cms:media:save")
    public CmsMedia saveData(@Valid @RequestBody CmsMedia object){
        return service.saveData(object);
    }

}
