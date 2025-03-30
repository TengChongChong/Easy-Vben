package com.easy.admin.auth.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.easy.admin.auth.model.SysMenu;
import com.easy.admin.auth.model.vo.SysMenuVO;
import com.easy.admin.auth.service.SysMenuService;
import com.easy.admin.common.core.annotation.ResponseResult;
import com.easy.admin.common.core.common.tree.Tree;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜单
 *
 * @author 系统管理员
 * @date 2025-03-21
 */
@Tag(name = "菜单")
@RestController
@ResponseResult
@RequestMapping("/api/auth/sys/menu")
public class SysMenuController {

    /**
     * 菜单 service
     */
    @Autowired
    private SysMenuService service;

    /**
     * 查询数据（无分页）
     *
     * @param sysMenu 查询条件
     * @return List<SysMenuVO>
     */
    @Operation(summary = "查询数据（无分页）")
    @GetMapping()
    @SaCheckPermission("sys:menu:select")
    public List<SysMenuVO> select(SysMenuVO sysMenu) {
        return service.select(sysMenu);
    }

    /**
     * 查询所有数据（Tree）
     *
     * @return List<Tree>
     */
    @Operation(summary = "查询所有数据（Tree）")
    @GetMapping("all")
    @SaCheckPermission("sys:menu:select")
    public List<Tree> selectAll() {
        return service.selectAll();
    }

    /**
     * 查询详情
     *
     * @param id id
     * @return SysMenuVO
     */
    @Operation(summary = "查询详情")
    @GetMapping("{id}")
    @SaCheckPermission("sys:menu:select")
    public SysMenuVO get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 新增或新增下级
     *
     * @param parentId 上级id
     * @return SysMenuVO
     */
    @Operation(summary = "新增或新增下级")
    @GetMapping({"/add/{parentId}", "/add"})
    @SaCheckPermission("sys:menu:save")
    public SysMenuVO add(@PathVariable(value = "parentId", required = false) String parentId) {
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
    @SaCheckPermission("sys:menu:remove")
    public boolean delete(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存/修改
     *
     * @param sysMenuVO 表单内容
     * @return SysMenuVO
     */
    @Operation(summary = "保存/修改")
    @PostMapping()
    @SaCheckPermission("sys:menu:save")
    public SysMenuVO saveData(@Valid @RequestBody SysMenuVO sysMenuVO) {
        return service.saveData(sysMenuVO);
    }

    /**
     * 设置状态
     *
     * @param id     权限id
     * @param status 状态
     * @param type   类型
     * @return true/false
     */
    @PostMapping("{id}/status/{status}/type/{type}")
    @SaCheckPermission("sys:menu:save")
    public boolean setStatus(@PathVariable("id") String id,
                             @PathVariable("status") String status,
                             @PathVariable("type") String type) {
        return service.setStatus(id, status, type);
    }

    /**
     * 保存排序&结构
     *
     * @param sysMenuList 排序&结构
     * @return true/false
     */
    @PostMapping("order")
    @SaCheckPermission("sys:menu:save")
    public boolean saveOrder(@RequestBody List<SysMenu> sysMenuList) {
        return service.saveOrder(sysMenuList);
    }
}
