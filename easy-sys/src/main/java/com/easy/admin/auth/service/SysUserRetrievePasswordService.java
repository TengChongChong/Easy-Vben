package com.easy.admin.auth.service;

/**
 * 找回密码
 *
 * @author TengChongChong
 * @date 2019-03-28
 */
public interface SysUserRetrievePasswordService {
    /**
     * 发送重置密码邮件
     *
     * @param username 账号
     * @param email     邮箱
     * @return true/false
     */
    boolean sendEmail(String username, String email);

    /**
     * 发送重置密码短信
     *
     * @param username 账号
     * @param mobile     手机号
     * @return 验证码
     */
    String sendSms(String username, String mobile);

    /**
     * 验证验证码
     *
     * @param username 账号
     * @param code     验证码
     * @return true/false
     */
    boolean verifiesCode(String username, String code);

    /**
     * 重置密码
     *
     * @param username 账号
     * @param code     校验码
     * @param password 新密码
     * @return true/false
     */
    boolean resetPassword(String username, String code, String password);

}
