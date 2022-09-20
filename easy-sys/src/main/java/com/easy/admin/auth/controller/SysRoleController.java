package com.easy.admin.auth.controller;

import com.easy.admin.auth.model.SysRole;
import com.easy.admin.auth.service.SysRoleService;
import com.easy.admin.common.core.base.BaseController;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.core.annotation.ResponseResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 角色管理
 *
 * @author TengChongChong
 * @date 2018/11/2
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/sys/role")
public class SysRoleController extends BaseController {

    @Autowired
    private SysRoleService service;

    /**
     * 查询数据
     *
     * @param sysRole 查询条件
     * @param page 分页
     * @return Page<SysRole>
     */
    @GetMapping()
    @RequiresPermissions("sys:role:select")
    public Page<SysRole> select(SysRole sysRole, Page<SysRole> page) {
        return service.select(sysRole, page);
    }

    /**
     * 获取全部数据
     *
     * @return List<SysRole>
     */
    @GetMapping("all")
    @RequiresPermissions("sys:role:select")
    public List<SysRole> selectAll() {
        return service.selectAll();
    }

    /**
     * 新增
     *
     * @return SysRole
     */
    @GetMapping("add")
    public SysRole add() {
        return service.add();
    }


    /**
     * 批量删除
     *
     * @param ids 角色ids
     * @return true/false
     */
    @DeleteMapping("{id}")
    @RequiresPermissions("sys:role:remove")
    public boolean remove(@PathVariable("id") String ids) {
        return service.remove(ids);
    }

    /**
     * 设置状态
     *
     * @param ids    角色ids
     * @param status 状态
     * @return true/false
     */
    @PostMapping("{id}/status/{status}")
    @RequiresPermissions("sys:role:save")
    public boolean setStatus(@PathVariable("id") String ids, @PathVariable("status") String status) {
        return service.setStatus(ids, status);
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return SysRole
     */
    @PostMapping
    @RequiresPermissions("sys:role:save")
    public SysRole save(@RequestBody @Valid SysRole object) {
        return service.saveData(object);
    }

    /**
     * 详情
     *
     * @param id 菜单/权限 id
     * @return SysRole
     */
    @GetMapping("{id}")
    public SysRole get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 查询所有权限 Activiti
     *
     * @param sysRole  查询条件
     * @param isSelect 是否为查找
     * @return List<SysRole>
     */
    @GetMapping("role")
    public List<SysRole> selectRole(SysRole sysRole, @RequestParam(required = false) boolean isSelect) {
        return service.selectRole(sysRole, isSelect);
    }

    /**
     * 根据部门类型获取可分配的角色数据
     *
     * @param deptId 部门id
     * @return List<SysRole>
     */
    @GetMapping("select/role/by/dept")
    public List<SysRole> selectRoleByDept(String deptId) {
        return service.selectRoleByDept(deptId);
    }
}
