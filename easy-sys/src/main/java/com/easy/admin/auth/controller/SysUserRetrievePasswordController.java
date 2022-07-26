package com.easy.admin.auth.controller;

import cn.hutool.json.JSONObject;
import com.easy.admin.common.core.base.BaseController;
import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.auth.service.SysUserRetrievePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 找回密码
 *
 * @author TengChongChong
 * @date 2019-03-28
 */
@RestController
@ResponseResult
@RequestMapping("/api/sys/user/retrieve/password")
public class SysUserRetrievePasswordController extends BaseController {

    /**
     * 找回密码 service
     */
    @Autowired
    private SysUserRetrievePasswordService service;


    /**
     * 发送重置密码邮件
     *
     * @param json {username: '', email: ''}
     * @return true/false
     */
    @PostMapping("email")
    public boolean sendEmail(@RequestBody JSONObject json) {
        return service.sendEmail(json.getStr("username"), json.getStr("email"));
    }

    /**
     * 发送重置密码短信
     *
     * @param json {username: '', mobile: ''}
     * @return 验证码
     */
    @PostMapping("sms")
    public String sendSms(@RequestBody JSONObject json) {
        return service.sendSms(json.getStr("username"), json.getStr("mobile"));
    }

    /**
     * 验证账号与校验码是否匹配
     *
     * @param username 账号
     * @param code     校验码
     * @return true/false
     */
    @GetMapping("verifies/{username}/{code}")
    public boolean verifiesCode(@PathVariable("username") String username, @PathVariable("code") String code) {
        return service.verifiesCode(username, code);
    }

    /**
     * 重设密码
     *
     * @param username 账号
     * @param code     校验码
     * @param json {password: ''}
     * @return true/false
     */
    @PostMapping("reset/password/{username}/{code}")
    public boolean resetPassword(@PathVariable("username") String username, @PathVariable("code") String code,
                                 @RequestBody JSONObject json) {
        return service.resetPassword(username, code, json.getStr("password"));
    }
}
