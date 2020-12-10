package com.easy.restful.sys.controller;

import com.easy.restful.common.core.base.BaseController;
import com.easy.restful.common.core.util.Response;
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
     * @param username 用户名
     * @param mail     邮箱
     */
    @PostMapping("send/mail")
    public Response sendMail(String username, String mail) {
        return Response.success(service.sendMail(username, mail));
    }

    /**
     * 验证用户名与校验码是否匹配
     *
     * @param username 用户名
     * @param code     校验码
     */
    @GetMapping("verifies/{username}/{code}")
    public Response verifiesCode(@PathVariable("username") String username, @PathVariable("code") String code) {
        return Response.success(service.verifiesCode(username, code));
    }

    /**
     * 重设密码
     *
     * @param username 用户名
     * @param code     校验码
     * @param password 密码
     */
    @PostMapping("reset/password/{username}/{code}")
    public Response resetPassword(@PathVariable("username") String username, @PathVariable("code") String code,
                                  @RequestParam("password") String password) {
        return Response.success(service.resetPassword(username, code, password));
    }
}
