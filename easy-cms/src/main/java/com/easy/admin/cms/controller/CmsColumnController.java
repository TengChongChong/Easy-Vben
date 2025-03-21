package com.easy.admin.cms.controller;

import com.easy.admin.cms.model.CmsColumn;
import com.easy.admin.cms.service.CmsColumnService;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.common.core.annotation.ResponseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

/**
 * 栏目
 *
 * @author tengchongchong
 * @date 2023-06-19
 */
@Tag(name = "栏目")
@RestController
@ResponseResult
@RequestMapping("/api/auth/cms/column")
public class CmsColumnController {

    /**
     * 栏目 service
     */
    @Autowired
    private CmsColumnService service;

    /**
     * 查询数据（无分页）
     *
     * @param cmsColumn 查询条件
     * @return List<CmsColumn>
     */
    @Operation(summary = "查询数据（无分页）")
    @GetMapping()
    @SaCheckPermission("cms:column:select")
    public List<CmsColumn> select(CmsColumn cmsColumn) {
        return service.select(cmsColumn);
    }

    /**
     * 查询所有数据（Tree）
     *
     * @return List<Tree>
     */
    @Operation(summary = "查询所有数据（Tree）")
    @GetMapping("all")
    @SaCheckPermission("cms:column:select")
    public List<Tree> selectAll() {
        return service.selectAll();
    }

    /**
     * 查询详情
     *
     * @param id id
     * @return CmsColumn
     */
    @Operation(summary = "查询详情")
    @GetMapping("{id}")
    @SaCheckPermission("cms:column:select")
    public CmsColumn get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 新增或新增下级
     *
     * @param parentId 上级id
     * @return CmsColumn
     */
    @Operation(summary = "新增或新增下级")
    @GetMapping({"/add/{parentId}", "/add"})
    @SaCheckPermission("cms:column:save")
    public CmsColumn add(@PathVariable(value = "parentId", required = false) String parentId) {
        return service.add(parentId);
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    @Operation(summary = "删除")
    @DeleteMapping("{ids}")
    @SaCheckPermission("cms:column:remove")
    public boolean delete(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存/修改
     *
     * @param cmsColumn 表单内容
     * @return CmsColumn
     */
    @Operation(summary = "保存/修改")
    @PostMapping()
    @SaCheckPermission("cms:column:save")
    public CmsColumn saveData(@Valid @RequestBody CmsColumn cmsColumn) {
        return service.saveData(cmsColumn);
    }

    /**
     * 保存排序&结构
     *
     * @param cmsColumnList 排序&结构
     * @return true/false
     */
    @PostMapping("order")
    @SaCheckPermission("cms:column:save")
    public boolean saveOrder(@RequestBody List<CmsColumn> cmsColumnList) {
        return service.saveOrder(cmsColumnList);
    }

    /**
     * 导出数据
     *
     * @param cmsColumn 查询条件
     * @return 文件下载id
     */
    @Operation(summary = "导出数据")
    @GetMapping("export/data")
    @SaCheckPermission("cms:column:select")
    public String exportData(CmsColumn cmsColumn) {
        return service.exportData(cmsColumn);
    }

}
