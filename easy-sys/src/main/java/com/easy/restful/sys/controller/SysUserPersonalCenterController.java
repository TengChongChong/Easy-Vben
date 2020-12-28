package com.easy.restful.sys.controller;

import cn.hutool.json.JSONObject;
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
     * @param json {oldPassword: '', password: '', passwordStrength: ''}
     */
    @PostMapping("change/password")
    public Response changePassword(@RequestBody JSONObject json) {
        return Response.success(service.changePassword(json));
    }

    /**
     * 保存用户头像
     *
     * @param json {path: ''}
     */
    @PostMapping("user/avatar")
    public Response saveUserAvatar(@RequestBody JSONObject json) {
        return Response.success(service.saveUserAvatar(json.getStr("path")));
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
     * @param json {email: ''}
     */
    @PostMapping("email")
    public Response applicationBindingEmail(@RequestBody JSONObject json) {
        return Response.success(service.applicationBindingEmail(json.getStr("email")));
    }

    /**
     * 绑定密保手机
     *
     * @param json {phone: *, captcha: *}
     */
    @PostMapping("phone")
    public Response bindingPhone(@RequestBody JSONObject json) {
        return Response.success(service.bindingPhone(json.getStr("phone"), json.getStr("captcha")));
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
