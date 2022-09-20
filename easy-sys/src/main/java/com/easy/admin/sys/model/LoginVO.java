package com.easy.admin.sys.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;

/**
 * 用户登录
 *
 * @author TengChongChong
 * @date 2020/12/11
 */
@Schema(description = "用户登录")
public class LoginVO {
    @NotBlank(message = "账号不能为空")
    @Schema(description = "账号", required = true)
    private String username;
    @NotBlank(message = "密码不能为空")
    @Schema(description = "密码", required = true)
    private String password;
    /**
     * 记住我
     */
    @Schema(description = "记住我", required = true)
    private Boolean rememberMe;

    /**
     * 验证码
     */
    @Schema(description = "验证码，根据配置判断是否必须")
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
