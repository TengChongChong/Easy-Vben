package com.easy.restful.sys.controller;

import com.easy.restful.common.core.base.BaseController;
import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.common.core.util.Response;
import com.easy.restful.core.annotation.SysLog;
import com.easy.restful.sys.model.SysUser;
import com.easy.restful.sys.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 用户管理
 *
 * @author tengchong
 * @date 2018/12/6
 */
@RestController
@RequestMapping("/auth/sys/user")
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService service;

    /**
     * 列表
     *
     * @param object 查询条件
     */
    @GetMapping
    @RequiresPermissions("sys:user:select")
    public Response select(SysUser object, Page<SysUser> page) {
        return Response.success(service.select(object, page));
    }

    /**
     * 搜索用户
     *
     * @param keyword 关键字
     */
    @GetMapping("search")
    @RequiresPermissions("sys:user:search")
    public Response search(String keyword, Page<SysUser> page) {
        return Response.success(service.search(keyword, page));
    }

    /**
     * 新增
     *
     * @param deptId 部门id
     */
    @GetMapping({"add/{id}"})
    @RequiresPermissions("sys:user:save")
    public Response add(@PathVariable(value = "id", required = false) String deptId) {
        return Response.success(service.add(deptId));
    }

    /**
     * 删除
     *
     * @param id 用户id
     */
    @DeleteMapping("{id}")
    @RequiresPermissions("sys:user:remove")
    public Response remove(@PathVariable("id") String id) {
//        return Response.success(service.remove(id));
        return Response.success(true);
    }

    /**
     * 禁用用户
     *
     * @param ids 用户ids
     */
    @PostMapping("disable/user/{ids}")
    @RequiresPermissions("sys:user:disable")
    public Response disableUser(@PathVariable("ids") String ids) {
        return Response.success(service.disableUser(ids));
    }

    /**
     * 启用用户
     *
     * @param ids 用户ids
     */
    @PostMapping("enable/user/{ids}")
    @RequiresPermissions("sys:user:enable")
    public Response enableUser(@PathVariable("ids") String ids) {
        return Response.success(service.enableUser(ids));
    }

    /**
     * 重置密码
     *
     * @param ids 用户ids
     */
    @PostMapping("reset/password/{ids}")
    @RequiresPermissions("sys:user:reset:password")
    public Response resetPassword(@PathVariable("ids") String ids) {
        return Response.success(service.resetPassword(ids));
    }

    /**
     * 保存
     *
     * @param object 表单内容
     */
    @PostMapping
    @RequiresPermissions("sys:user:save")
    public Response save(@RequestBody @Valid SysUser object) {
        return Response.success(service.saveData(object, true));
    }

    /**
     * 详情
     *
     * @param id id
     */
    @GetMapping("{id}")
    @RequiresPermissions("sys:user:select")
    public Response get(@PathVariable("id") String id) {
        return Response.success(service.get(id));
    }

    /**
     * 获取当前登录用户
     */
    @GetMapping("current")
    @SysLog(modular = "sys", method = "获取当前登录用户")
    public Response getCurrent() {
        return Response.success(service.getCurrentUser());
    }

    /**
     * 查询用户列表 Activiti
     *
     * @param sysUser  查询条件
     * @param isSelect 是否为查找
     * @param keywords 关键字
     */
    @GetMapping("/users")
    @RequiresPermissions("sys:user:select")
    public Response selectUser(SysUser sysUser, Page<SysUser> page,
                               @RequestParam(name = "isSelect", required = false) boolean isSelect,
                               @RequestParam(name = "keywords", required = false) String keywords) {
        return Response.success(service.selectUser(sysUser, page, isSelect, keywords));
    }
}
