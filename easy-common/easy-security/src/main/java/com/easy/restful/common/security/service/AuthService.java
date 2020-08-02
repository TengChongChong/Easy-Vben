package com.easy.restful.common.security.service;

import com.easy.restful.common.security.model.Token;
import com.easy.restful.sys.model.SysUser;

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
    Token login(String username, String password);

    /**
     * 获取用户信息
     *
     * @return SysUser
     */
    SysUser getUserInfo();

    /**
     * 使用refreshToken刷新accessToken
     *
     * @param refreshToken 刷新 Token
     * @return Token
     */
    Token refreshToken(String refreshToken);
}
