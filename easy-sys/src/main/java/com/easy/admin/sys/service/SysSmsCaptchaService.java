package com.easy.admin.sys.service;

/**
 * 短信验证码
 *
 * @author TengChongChong
 * @date 2020/12/23
 */
public interface SysSmsCaptchaService {
    /**
     * 绑定手机短信验证码
     *
     * @param phone 手机号
     * @return 验证码
     */
    String bindingPhone(String phone);
}
