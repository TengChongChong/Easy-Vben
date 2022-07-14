package com.easy.admin.auth.controller;

import com.easy.admin.auth.model.SysUser;
import com.easy.admin.auth.service.SysUserService;
import com.easy.admin.common.core.base.BaseController;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.core.annotation.SysLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户管理
 *
 * @author TengChongChong
 * @date 2018/12/6
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/sys/user")
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService service;

    /**
     * 列表
     *
     * @param object 查询条件
     * @return Page<SysUser>
     */
    @GetMapping
    @RequiresPermissions("sys:user:select")
    public Page<SysUser> select(SysUser object, Page<SysUser> page) {
        return service.select(object, page);
    }

    /**
     * 新增
     *
     * @param deptId 部门id
     * @return SysUser
     */
    @GetMapping({"add/{deptId}"})
    @RequiresPermissions("sys:user:save")
    public SysUser add(@PathVariable(value = "deptId", required = false) String deptId) {
        return service.add(deptId);
    }

    /**
     * 删除
     *
     * @param id 用户id
     * @return true/false
     */
    @DeleteMapping("{id}")
    @RequiresPermissions("sys:user:remove")
    public boolean remove(@PathVariable("id") String id) {
        return service.remove(id);
    }

    /**
     * 设置状态
     *
     * @param ids    角色ids
     * @param status 状态
     * @return true/false
     */
    @PostMapping("{id}/status/{status}")
    @RequiresPermissions("sys:user:save")
    public boolean setStatus(@PathVariable("id") String ids, @PathVariable("status") String status) {
        return service.setStatus(ids, status);
    }

    /**
     * 重置密码
     *
     * @param ids 用户ids
     * @return 重置后密码
     */
    @PostMapping("reset/password/{ids}")
    @RequiresPermissions("sys:user:save")
    public String resetPassword(@PathVariable("ids") String ids) {
        return service.resetPassword(ids);
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return SysUser
     */
    @PostMapping
    @RequiresPermissions("sys:user:save")
    public SysUser save(@RequestBody @Valid SysUser object) {
        return service.saveData(object, true);
    }

    /**
     * 详情
     *
     * @param id id
     * @return SysUser
     */
    @GetMapping("{id}")
    @RequiresPermissions("sys:user:select")
    public SysUser get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 获取当前登录用户
     *
     * @return SysUser
     */
    @GetMapping("current")
    @SysLog(modular = "sys", method = "获取当前登录用户")
    public SysUser getCurrent() {
        return service.getCurrentUser();
    }


    /**
     * 查询用户，用于用户选择
     *
     * @param keyword 关键字
     * @param range   数据范围，可以选择哪些用户 'all' | 'currentDept'
     * @param deptId 部门id，如传入range='currentDept'，此参数无效
     * @return Page<SysUser>
     */
    @GetMapping("search")
    public Page<SysUser> search(@RequestParam(value = "keyword", required = false) String keyword,
                                @RequestParam(value = "range", required = false) String range,
                                @RequestParam(value = "deptId", required = false) String deptId,
                                Page<SysUser> page) {
        return service.search(keyword, range, deptId, page);
    }

    /**
     * 获取指定用户信息，用于回显已选择的用户
     *
     * @param ids ids
     * @return List<SysUser>
     */
    @GetMapping("users/{ids}")
    @RequiresPermissions("sys:user:select")
    public List<SysUser> selectUsersByIds(@PathVariable("ids") String ids) {
        return service.selectUsersByIds(ids);
    }
}
