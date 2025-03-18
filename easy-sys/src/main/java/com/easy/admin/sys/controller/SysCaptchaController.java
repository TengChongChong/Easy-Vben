package com.easy.admin.sys.controller;

import com.anji.captcha.model.common.RepCodeEnum;
import com.anji.captcha.model.common.ResponseModel;
import com.anji.captcha.model.vo.CaptchaVO;
import com.anji.captcha.service.CaptchaService;
import com.easy.admin.common.core.annotation.ResponseResult;
import com.easy.admin.common.core.exception.EasyException;
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

    //@Autowired
    //private SysCaptchaService service;

    @Autowired
    private CaptchaService captchaService;

    @GetMapping({"/api/sys/captcha"})
    public CaptchaVO getCaptcha(CaptchaVO captcha) {
        return (CaptchaVO)captchaService.get(captcha).getRepData();
    }

    /**
     * 检查是否验证通过
     *
     * @param captcha CaptchaVO
     * @return ResponseModel
     */
    @PostMapping({"/api/sys/captcha/check"})
    public CaptchaVO checkCaptcha(@RequestBody CaptchaVO captcha) {
        ResponseModel responseModel = captchaService.check(captcha);
        if (!RepCodeEnum.SUCCESS.getCode().equals(responseModel.getRepCode())) {
            throw new EasyException("验证失败");
        }
        return (CaptchaVO)responseModel.getRepData();
    }
}
