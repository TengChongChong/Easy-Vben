package com.easy.restful.sys.controller;

import com.easy.restful.common.core.util.Response;
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
public class SysCaptchaController {

    @Autowired
    private SysCaptchaService service;

    /**
     * 申请绑定密保邮箱
     *
     * @param phone 手机号
     * @return true/false
     */
    @GetMapping("/auth/sys/binding/phone/captcha")
    public Response bindingPhone(String phone){
        // 注：此处仅为演示，实际场景勿返回验证码
        return Response.success(service.bindingPhone(phone));
    }
}
