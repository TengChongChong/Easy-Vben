package com.easy.restful.auth.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.easy.restful.auth.constant.SessionConst;
import com.easy.restful.auth.service.AuthService;
import com.easy.restful.common.core.util.Response;
import com.easy.restful.util.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 会话
 *
 * @author tengchong
 * @date 2020/9/26
 */
@RestController
public class AuthController {

    @Autowired
    private AuthService service;

    /**
     * 登录
     *
     * @param username    账号（用户名、手机号、邮箱）
     * @param password   密码
     * @param rememberMe 记住我
     * @return Response
     */
    @PostMapping("/auth/login")
    public Response login(String username, String password, String rememberMe) {
        Subject subject = service.login(username, password, rememberMe);
        return Response.success(subject.getSession().getId());
    }

    /**
     * 退出
     *
     * @return Response
     */
    @PostMapping("/auth/logout")
    public Response logout() {
        SecurityUtils.getSubject().logout();
        return Response.success();
    }

    @RequestMapping("/get/verification/code")
    public void getVerificationCode(HttpServletResponse response) throws IOException {
        // 定义图形验证码的长、宽、验证码字符数、干扰元素个数
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(100, 30, 4, 8);
        captcha.createCode();
        // 验证码放到session中
        ShiroUtil.setAttribute(SessionConst.VERIFICATION_CODE, captcha.getCode());
        captcha.write(response.getOutputStream());
    }
}
