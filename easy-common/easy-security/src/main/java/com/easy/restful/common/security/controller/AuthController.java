package com.easy.restful.common.security.controller;

import com.easy.restful.common.core.util.Tips;
import com.easy.restful.common.security.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return Tips
     */
    @PostMapping(value = "/auth/login")
    public Tips login(String username, String password) {
        return Tips.success(authService.login(username, password));
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping(value = "/auth/user/info")
    public Tips getUserInfo() {
        return Tips.success(authService.getUserInfo());
    }

    @PostMapping(value = "/auth/logout")
    public Tips logout() {
        return Tips.success();
    }

    /**
     * 使用refreshToken刷新accessToken
     *
     * @param refreshToken 刷新 Token
     * @return Token
     */
    @GetMapping(value = "/auth/refresh/token")
    public Tips refreshToken(String refreshToken){
        // 登录成功会返回Token给用户
        return Tips.success(authService.refreshToken(refreshToken));
    }

}
