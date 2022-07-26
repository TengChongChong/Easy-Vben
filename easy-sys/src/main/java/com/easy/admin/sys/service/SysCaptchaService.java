package com.easy.admin.sys.service;

import com.anji.captcha.model.vo.CaptchaVO;

/**
 * 验证码
 *
 * @author TengChongChong
 * @date 2020/12/23
 */
public interface SysCaptchaService {
    /**
     * 获取验证码
     *
     * @return CaptchaVO
     */
    CaptchaVO getCaptcha();

    /**
     * 检查是否验证通过
     *
     * @param captchaVO CaptchaVO
     * @return CaptchaVO
     */
    CaptchaVO checkCaptcha(CaptchaVO captchaVO);

    /**
     * 检查是否验证通过
     *
     * @param captchaVerification 服务端二次验证
     * @return true/false
     */
    boolean verification(String captchaVerification);
}
