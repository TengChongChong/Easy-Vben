package com.easy.admin.config.shiro.authc;

import com.easy.admin.auth.model.dto.LoginAccountDTO;
import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * 账号密码认证 AuthenticationToken
 *
 * @author tengchong
 * @date 2024/8/8
 */
@Data
public class EasyAccountAuthenticationToken extends LoginAccountDTO implements AuthenticationToken {

    public EasyAccountAuthenticationToken(LoginAccountDTO loginAccount) {
        this.setUsername(loginAccount.getUsername());
        this.setPassword(loginAccount.getPassword());
        this.setRememberMe(loginAccount.getRememberMe());
        this.setCaptchaVerification(loginAccount.getCaptchaVerification());
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
