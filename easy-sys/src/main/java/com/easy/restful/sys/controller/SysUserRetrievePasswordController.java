package com.easy.restful.sys.controller;

import cn.hutool.json.JSONObject;
import com.easy.restful.common.core.base.BaseController;
import com.easy.restful.core.annotation.ResponseResult;
import com.easy.restful.sys.service.SysUserRetrievePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 找回密码
 *
 * @author tengchong
 * @date 2019-03-28
 */
@RestController
@ResponseResult
@RequestMapping("/sys/user/retrieve/password")
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
     * 验证用户名与校验码是否匹配
     *
     * @param username 用户名
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
     * @param username 用户名
     * @param code     校验码
     * @param password 密码
     * @return true/false
     */
    @PostMapping("reset/password/{username}/{code}")
    public boolean resetPassword(@PathVariable("username") String username, @PathVariable("code") String code,
                                 @RequestParam("password") String password) {
        return service.resetPassword(username, code, password);
    }
}
