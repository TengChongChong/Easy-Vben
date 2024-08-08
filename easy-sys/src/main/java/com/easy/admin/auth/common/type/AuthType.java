package com.easy.admin.auth.common.type;

/**
 * 登录认证方式
 *
 * @author TengChongChong
 * @date 2024-08-06
 **/
public enum AuthType {
    /**
     * 认证方式
     * account    账号&密码
     * sms        手机号+验证码
     * scan_code  扫码登录
     */
    account, sms, scan_code;
}
