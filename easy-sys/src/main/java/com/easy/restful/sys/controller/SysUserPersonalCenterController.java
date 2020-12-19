package com.easy.restful.sys.controller;

import com.easy.restful.common.core.base.BaseController;
import com.easy.restful.common.core.util.Response;
import com.easy.restful.sys.model.SysUser;
import com.easy.restful.sys.model.SysUserSetting;
import com.easy.restful.sys.service.SysUserPersonalCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 个人中心
 *
 * @author TengChong
 * @date 2019-03-04
 */
@RestController
@RequestMapping("/auth/sys/user/personal/center")
public class SysUserPersonalCenterController extends BaseController {
    /**
     * 个人中心 service
     */
    @Autowired
    private SysUserPersonalCenterService service;

    /**
     * 当前用户
     */
    @GetMapping("current/user")
    public Response currentUser() {
        return Response.success(service.getCurrentUser());
    }

    /**
     * 密码修改
     *
     * @param oldPassword 原密码
     * @param password    新密码
     */
    @PostMapping("change/password/{oldPassword}/{password}")
    public Response changePassword(@PathVariable(value = "oldPassword") String oldPassword,
                                   @PathVariable(value = "password") String password) {
        return Response.success(service.changePassword(oldPassword, password));
    }

    /**
     * 保存用户头像
     *
     * @param path 文件路径
     */
    @PostMapping("user/avatar/{path}")
    public Response saveUserAvatar(@PathVariable("path") String path) {
        return Response.success(service.saveUserAvatar(path));
    }

    /**
     * 保存用户信息
     *
     * @param sysUser 用户信息
     */
    @PostMapping("user/info")
    public Response saveUserInfo(@RequestBody SysUser sysUser) {
        return Response.success(service.saveUserInfo(sysUser));
    }

    /**
     * 申请绑定密保邮箱
     *
     * @param mail 邮箱地址
     */
    @PostMapping("mail")
    public Response applicationBindingMail(String mail) {
        return Response.success(service.applicationBindingMail(mail));
    }

    /**
     * 保存用户设置
     *
     * @param sysUserSetting 用户设置
     */
    @PostMapping("user/setting")
    public Response saveUserSetting(SysUserSetting sysUserSetting) {
        return Response.success(service.saveUserSetting(sysUserSetting));
    }


}
