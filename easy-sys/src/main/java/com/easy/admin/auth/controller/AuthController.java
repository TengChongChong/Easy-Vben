package com.easy.admin.auth.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.easy.admin.auth.service.AuthService;
import com.easy.admin.common.redis.constant.RedisPrefix;
import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.core.annotation.SysLog;
import com.easy.admin.sys.model.LoginVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

/**
 * 会话
 *
 * @author TengChongChong
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
    @PostMapping(value = "/api/login")
    @SysLog(modular = "sys", method = "用户登录")
    public String login(@RequestBody @Valid LoginVO loginVO) {
        Subject subject = service.login(loginVO);
        return subject.getSession().getId().toString();
    }

    /**
     * 退出
     */
    @PostMapping("/api/logout")
    public void logout() {
        SecurityUtils.getSubject().logout();
    }

    /**
     * 验证码
     *
     * @param response response
     * @param codeId   验证码id
     */
    @GetMapping("/api/get/verification/code/{codeId}")
    public void getVerificationCode(HttpServletResponse response, @PathVariable("codeId") String codeId) throws IOException {
        // 定义图形验证码的长、宽、验证码字符数、干扰元素个数
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(100, 30, 4, 8);
        captcha.createCode();
        // 验证码放到redis中，有效期5分钟
        RedisUtil.set(RedisPrefix.VERIFICATION_CODE + codeId, captcha.getCode(), 60 * 5L);
        captcha.write(response.getOutputStream());
    }
}
