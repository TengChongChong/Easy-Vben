package com.easy.admin.auth.controller;

import cn.hutool.json.JSONObject;
import com.easy.admin.auth.model.SysUser;
import com.easy.admin.auth.model.vo.ChangePasswordVO;
import com.easy.admin.auth.model.vo.SysUserVO;
import com.easy.admin.auth.service.SysUserPersonalCenterService;
import com.easy.admin.common.core.annotation.ResponseResult;
import com.easy.admin.common.core.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 个人中心
 *
 * @author TengChong
 * @date 2019-03-04
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/sys/user/personal/center")
public class SysUserPersonalCenterController extends BaseController {
    /**
     * 个人中心 service
     */
    @Autowired
    private SysUserPersonalCenterService service;

    /**
     * 当前用户
     *
     * @return SessionUserVO
     */
    @GetMapping("current/user")
    public SysUser currentUser() {
        return service.getCurrentUser();
    }

    /**
     * 密码修改
     *
     * @param changePassword changePassword
     * @return true/false
     */
    @PostMapping("change/password")
    public boolean changePassword(@RequestBody ChangePasswordVO changePassword) {
        return service.changePassword(changePassword);
    }

    /**
     * 保存用户信息
     *
     * @param sysUser 用户信息
     * @return SysUser
     */
    @PostMapping("user/info")
    public SysUserVO saveUserInfo(@RequestBody SysUserVO sysUser) {
        return service.saveUserInfo(sysUser);
    }

    /**
     * 申请绑定密保邮箱
     *
     * @param json {email: ''}
     * @return true/false
     */
    @PostMapping("email")
    public boolean applicationBindingEmail(@RequestBody JSONObject json) {
        return service.applicationBindingEmail(json.getStr("email"));
    }

    /**
     * 绑定密保手机
     *
     * @param json {phone: *, captcha: *}
     * @return true/false
     */
    @PostMapping("phone")
    public boolean bindingPhone(@RequestBody JSONObject json) {
        return service.bindingPhone(json.getStr("phone"), json.getStr("captcha"));
    }
}
