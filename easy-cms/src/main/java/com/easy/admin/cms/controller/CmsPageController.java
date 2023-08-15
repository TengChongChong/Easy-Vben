package com.easy.admin.cms.controller;

import com.easy.admin.cms.model.CmsPage;
import com.easy.admin.cms.service.CmsPageService;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.core.annotation.ResponseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 页面
 *
 * @author 系统管理员
 * @date 2023-06-27
 */
@Tag(name = "页面")
@RestController
@ResponseResult
@RequestMapping("/api/auth/cms/page")
public class CmsPageController {

    /**
     * 页面 service
     */
    @Autowired
    private CmsPageService service;

    /**
     * 查询数据
     *
     * @param cmsPage 查询条件
     * @param page    分页
     * @return Page<CmsPage>
     */
    @Operation(summary = "查询数据")
    @GetMapping()
    @RequiresPermissions("cms:page:select")
    public Page<CmsPage> select(CmsPage cmsPage, Page<CmsPage> page) {
        return service.select(cmsPage, page);
    }

    /**
     * 查询详情
     *
     * @param id id
     * @return CmsPage
     */
    @Operation(summary = "查询详情")
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
    @Operation(summary = "新增")
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
    @Operation(summary = "删除")
    @DeleteMapping("{ids}")
    @RequiresPermissions("cms:page:remove")
    public boolean delete(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存/修改
     *
     * @param cmsPage 表单内容
     * @return CmsPage
     */
    @Operation(summary = "保存/修改")
    @PostMapping()
    @RequiresPermissions("cms:page:save")
    public CmsPage saveData(@Valid @RequestBody CmsPage cmsPage) {
        return service.saveData(cmsPage);
    }

    /**
     * 查询主题中的页面模版
     *
     * @return 模版列表
     */
    @Operation(summary = "查询主题中的页面模版")
    @GetMapping("theme/page/template")
    @RequiresPermissions("cms:page:select")
    public List<Select> selectThemePageTemplate() {
        return service.selectThemePageTemplate();
    }
}
