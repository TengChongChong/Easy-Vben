package com.easy.restful.sys.controller;

import com.easy.restful.core.annotation.ResponseResult;
import com.easy.restful.sys.service.SysCaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 短信验证码
 *
 * @author tengchong
 * @date 2020/12/23
 */
@RestController
@ResponseResult
public class SysCaptchaController {

    @Autowired
    private SysCaptchaService service;

    /**
     * 绑定手机短信验证码
     *
     * @param phone 手机号
     * @return 验证码
     */
    @GetMapping("/auth/sys/binding/phone/captcha")
    public String bindingPhone(String phone){
        // 注：此处仅为演示，实际场景勿返回验证码
        return service.bindingPhone(phone);
    }
}
