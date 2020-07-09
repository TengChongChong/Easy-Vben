package com.easy.restful.common.security.service;

/**
 * 登录
 *
 * @author tengchong
 * @date 2020/7/8
 */
public interface AuthService {
    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    String login(String username, String password);
}
