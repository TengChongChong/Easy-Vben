package com.easy.restful.auth.service;

import org.apache.shiro.subject.Subject;

/**
 * 会话
 *
 * @author tengchong
 * @date 2020/9/29
 */
public interface AuthService {

    /**
     * 登录
     *
     * @param username    账号（用户名、手机号、邮箱）
     * @param password   密码
     * @param rememberMe 记住我
     */
    Subject login(String username, String password, String rememberMe);
}
