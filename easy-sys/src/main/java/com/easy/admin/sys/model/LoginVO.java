package com.easy.admin.sys.model;

import javax.validation.constraints.NotBlank;

/**
 * 用户登录
 *
 * @author TengChongChong
 * @date 2020/12/11
 */
public class LoginVO {
    @NotBlank(message = "账号不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
    /**
     * 记住我
     */
    private Boolean rememberMe;

    /**
     * 验证码
     */
    private String captchaVerification;

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

    public String getCaptchaVerification() {
        return captchaVerification;
    }

    public void setCaptchaVerification(String captchaVerification) {
        this.captchaVerification = captchaVerification;
    }

    @Override
    public String toString() {
        return "LoginVO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rememberMe=" + rememberMe +
                ", captchaVerification='" + captchaVerification + '\'' +
                '}';
    }
}
