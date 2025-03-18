package com.easy.admin.sys.service;

/**
 * 验证码
 *
 * @author TengChongChong
 * @date 2020/12/23
 */
public interface SysCaptchaService {

    /**
     * 检查是否验证通过
     *
     * @param captchaVerification 服务端二次验证
     * @return true/false
     */
    boolean verification(String captchaVerification);
}
