package com.easy.admin.sys.service.impl;

import com.anji.captcha.model.common.RepCodeEnum;
import com.anji.captcha.model.common.ResponseModel;
import com.anji.captcha.model.vo.CaptchaVO;
import com.anji.captcha.service.CaptchaService;
import com.easy.admin.sys.service.SysCaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 短信验证码
 *
 * @author TengChongChong
 * @date 2020/12/23
 */
@Service
public class SysCaptchaServiceImpl implements SysCaptchaService{

    /**
     * 验证码
     */
    @Autowired
    private CaptchaService captchaService;

    @Override
    public boolean verification(String captchaVerification) {
        CaptchaVO captchaVO  = new CaptchaVO();
        captchaVO.setCaptchaVerification(captchaVerification);
        ResponseModel responseModel = captchaService.verification(captchaVO);
        return  RepCodeEnum.SUCCESS.getCode().equals(responseModel.getRepCode());
    }
}
