package com.easy.admin.auth.controller;

import com.easy.admin.common.core.base.BaseController;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.auth.model.SysPermission;
import com.easy.admin.auth.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * 权限管理
 *
 * @author TengChongChong
 * @date 2018/10/30
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/sys/permission")
public class SysPermissionController extends BaseController {

    @Autowired
    private SysPermissionService service;

    /**
     * 获取全部数据
     *
     * @return List<JsTree>
     */
    @GetMapping()
//    @RequiresPermissions("sys:permissions:select")
    public List<SysPermission> select(SysPermission sysPermission) {
        return service.select(sysPermission);
    }


    /**
     * 获取全部数据
     *
     * @return List<JsTree>
     */
    @GetMapping("all")
//    @RequiresPermissions("sys:permissions:select")
    public List<Tree> selectAll() {
        return service.selectAll();
    }

    /**
     * 新增
     *
     * @param parentId 上级菜单/权限 id
     * @return SysPermissions
     */
    @GetMapping({"/add", "/add/{parentId}"})
    public SysPermission add(@PathVariable(value = "parentId", required = false) String parentId) {
        return service.add(parentId);
    }

    /**
     * 删除
     *
     * @param id 权限id
     * @return true/false
     */
    @DeleteMapping("{id}")
//    @RequiresPermissions("sys:permissions:remove")
    public boolean remove(@PathVariable("id") String id) {
        return service.remove(id);
    }

    /**
     * 设置状态
     *
     * @param ids    权限ids
     * @param status 状态
     * @return true/false
     */
    @PostMapping("{id}/status/{status}")
//    @RequiresPermissions("sys:permissions:status")
    public boolean setStatus(@PathVariable("id") String ids, @PathVariable("status") String status) {
        return service.setStatus(ids, status);
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return SysPermissions
     */
    @PostMapping
//    @RequiresPermissions("sys:permissions:save")
    public SysPermission save(@RequestBody @Valid SysPermission object) {
        return service.saveData(object);
    }

    /**
     * 保存排序
     *
     * @param sysPermissionList 排序
     * @return true/false
     */
    @PostMapping("order")
//    @RequiresPermissions("sys:permissions:save")
    public boolean saveOrder(@RequestBody List<SysPermission> sysPermissionList){
        return service.saveOrder(sysPermissionList);
    }

    /**
     * 详情
     *
     * @param id 菜单/权限 id
     * @return SysPermissions
     */
    @GetMapping("{id}")
    public SysPermission get(@PathVariable("id") String id) {
        return service.get(id);
    }

}
