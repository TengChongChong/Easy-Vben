package com.easy.admin.config.shiro.authc;

import com.easy.admin.auth.model.dto.LoginDTO;
import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * 账号密码认证 AuthenticationToken
 *
 * @author tengchong
 * @date 2024/8/6
 */
@Data
public class EasyAccountAuthenticationToken implements AuthenticationToken {

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    /**
     * 记住我
     */
    private boolean rememberMe;

    /**
     * 验证码
     */
    private String captchaVerification;

    public EasyAccountAuthenticationToken(LoginDTO login) {
        this.username = login.getUsername();
        this.password = login.getPassword();
        this.rememberMe = login.getRememberMe();
        this.captchaVerification = login.getCaptchaVerification();
    }

    @Override
    public Object getPrincipal() {
        return this.getUsername();
    }

    @Override
    public Object getCredentials() {
        return this.getPassword();
    }

}
