package com.easy.admin.sys.controller;

import com.easy.admin.common.core.annotation.ResponseResult;
import com.easy.admin.sys.service.SysSmsCaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 短信验证码
 *
 * @author TengChongChong
 * @date 2020/12/23
 */
@RestController
@ResponseResult
public class SysSmsCaptchaController {

    @Autowired
    private SysSmsCaptchaService service;

    /**
     * 绑定手机短信验证码
     *
     * @param phoneNumber         手机号
     * @param captchaVerification 验证码
     * @return 验证码
     */
    @GetMapping("/api/auth/sys/sms/captcha/binding/phone/number")
    public String sendBindingPhoneNumberSms(String phoneNumber, String captchaVerification) {
        // 注：此处仅为演示，实际场景勿返回验证码
        return service.sendBindingPhoneNumberSms(phoneNumber, captchaVerification);
    }
}
