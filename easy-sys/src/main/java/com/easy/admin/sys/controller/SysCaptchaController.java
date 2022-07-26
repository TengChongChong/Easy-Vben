package com.easy.admin.sys.controller;

import com.anji.captcha.model.vo.CaptchaVO;
import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.sys.service.SysCaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 验证码
 *
 * @author TengChongChong
 * @date 2020/12/23
 */
@RestController
@ResponseResult
public class SysCaptchaController {

    @Autowired
    private SysCaptchaService service;

    @GetMapping({"/api/sys/captcha"})
    public CaptchaVO getCaptcha() {
        return service.getCaptcha();
    }

    /**
     * 检查是否验证通过
     *
     * @param captchaVO CaptchaVO
     * @return ResponseModel
     */
    @PostMapping({"/api/sys/captcha/check"})
    public CaptchaVO checkCaptcha(@RequestBody CaptchaVO captchaVO) {
        return service.checkCaptcha(captchaVO);
    }
}
