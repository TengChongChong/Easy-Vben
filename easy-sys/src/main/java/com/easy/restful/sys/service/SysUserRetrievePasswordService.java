package com.easy.restful.sys.service;

/**
 * 找回密码
 *
 * @author tengchong
 * @date 2019-03-28
 */
public interface SysUserRetrievePasswordService {
    /**
     * 发送重置密码邮件
     *
     * @param username 用户名
     * @param mail     邮箱
     * @return true/false
     */
    boolean sendMail(String username, String mail);

    /**
     * 验证验证码
     *
     * @param username 用户名
     * @param code     验证码
     * @return true/false
     */
    boolean verifiesCode(String username, String code);

    /**
     * 重置密码
     *
     * @param username 用户名
     * @param code     校验码
     * @param password 新密码
     * @return true/false
     */
    boolean resetPassword(String username, String code, String password);

}
