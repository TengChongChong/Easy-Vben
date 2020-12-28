package com.easy.restful.sys.service;

/**
 * 短信验证码
 *
 * @author tengchong
 * @date 2020/12/23
 */
public interface SysCaptchaService {
    /**
     * 申请绑定密保邮箱
     *
     * @param phone 手机号
     * @return true/false
     */
    String bindingPhone(String phone);
}
