package com.easy.restful.sys.model;

import javax.validation.constraints.NotBlank;

/**
 * 用户登录
 *
 * @author tengchong
 * @date 2020/12/11
 */
public class LoginVO {
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
    /**
     * 记住我
     */
    private Boolean rememberMe;

    /**
     * 验证码id
     */
    private String codeId;
    /**
     * 验证码
     */
    private String verificationCode;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    @Override
    public String toString() {
        return "LoginVO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rememberMe=" + rememberMe +
                ", codeId='" + codeId + '\'' +
                ", verificationCode='" + verificationCode + '\'' +
                '}';
    }
}
