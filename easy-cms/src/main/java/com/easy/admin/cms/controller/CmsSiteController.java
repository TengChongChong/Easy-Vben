package com.easy.admin.cms.controller;

import com.easy.admin.cms.model.CmsSite;
import com.easy.admin.cms.service.CmsSiteService;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.core.annotation.ResponseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 站点
 *
 * @author 系统管理员
 * @date 2023-06-19
 */
@Tag(name = "站点")
@RestController
@ResponseResult
@RequestMapping("/api/auth/cms/site")
public class CmsSiteController {

    /**
     * 站点 service
     */
    @Autowired
    private CmsSiteService service;

    /**
     * 查询数据（无分页）
     *
     * @param cmsSite 查询条件
     * @return List<CmsSite>
     */
    @Operation(summary = "查询数据（无分页）")
    @GetMapping()
    @RequiresPermissions("cms:site:select")
    public List<CmsSite> select(CmsSite cmsSite) {
        return service.select(cmsSite);
    }

    /**
     * 查询所有数据（Tree）
     *
     * @return List<Tree>
     */
    @Operation(summary = "查询所有数据（Tree）")
    @GetMapping("all")
    @RequiresPermissions("cms:site:select")
    public List<Tree> selectAll() {
        return service.selectAll();
    }

    /**
     * 查询详情
     *
     * @param id id
     * @return CmsSite
     */
    @Operation(summary = "查询详情")
    @GetMapping("{id}")
    @RequiresPermissions("cms:site:select")
    public CmsSite get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 新增或新增下级
     *
     * @param parentId 上级id
     * @return CmsSite
     */
    @Operation(summary = "新增或新增下级")
    @GetMapping({"/add/{parentId}", "/add"})
    @RequiresPermissions("cms:site:save")
    public CmsSite add(@PathVariable(value = "parentId", required = false) String parentId) {
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
    @RequiresPermissions("cms:site:remove")
    public boolean delete(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存/修改
     *
     * @param cmsSite 表单内容
     * @return CmsSite
     */
    @Operation(summary = "保存/修改")
    @PostMapping()
    @RequiresPermissions("cms:site:save")
    public CmsSite saveData(@Valid @RequestBody CmsSite cmsSite) {
        return service.saveData(cmsSite);
    }

    /**
     * 保存排序&结构
     *
     * @param cmsSiteList 排序&结构
     * @return true/false
     */
    @PostMapping("order")
    @RequiresPermissions("cms:site:save")
    public boolean saveOrder(@RequestBody List<CmsSite> cmsSiteList) {
        return service.saveOrder(cmsSiteList);
    }

    /**
     * 设置用户选中站点
     *
     * @param cmsSite 站点
     * @return true/false
     */
    @PostMapping("set/user/active/site")
    public boolean setUserActiveSite(@RequestBody CmsSite cmsSite) {
        return service.setUserActiveSite(cmsSite);
    }

    /**
     * 获取用户当前选中站点
     *
     * @return 站点信息
     */
    @GetMapping("get/user/active/site")
    public CmsSite getUserActiveSite() {
        return service.getUserActiveSite();
    }

    /**
     * 导出数据
     *
     * @param cmsSite 查询条件
     * @return 文件下载id
     */
    @Operation(summary = "导出数据")
    @GetMapping("export/data")
    @RequiresPermissions("cms:site:select")
    public String exportData(CmsSite cmsSite) {
        return service.exportData(cmsSite);
    }

}
