package com.easy.restful.auth.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.easy.restful.auth.constant.SessionConst;
import com.easy.restful.auth.service.AuthService;
import com.easy.restful.core.annotation.ResponseResult;
import com.easy.restful.core.annotation.SysLog;
import com.easy.restful.sys.model.LoginVO;
import com.easy.restful.util.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

/**
 * 会话
 *
 * @author tengchong
 * @date 2020/9/26
 */
@RestController
@ResponseResult
public class AuthController {

    @Autowired
    private AuthService service;

    /**
     * 登录
     *
     * @param loginVO loginVO
     * @return token
     */
    @PostMapping(value = "/auth/login")
    @SysLog(modular = "sys", method = "用户登录")
    public String login(@RequestBody @Valid LoginVO loginVO) {
        Subject subject = service.login(loginVO);
        return subject.getSession().getId().toString();
    }

    /**
     * 退出
     *
     * @return Response
     */
    @SysLog(modular = "sys", method = "退出登录")
    @PostMapping("/logout")
    public void logout() {
        SecurityUtils.getSubject().logout();
    }

    @GetMapping("/get/verification/code")
    public void getVerificationCode(HttpServletResponse response) throws IOException {
        // 定义图形验证码的长、宽、验证码字符数、干扰元素个数
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(100, 30, 4, 8);
        captcha.createCode();
        // 验证码放到session中
        ShiroUtil.setAttribute(SessionConst.VERIFICATION_CODE, captcha.getCode());
        captcha.write(response.getOutputStream());
    }
}
