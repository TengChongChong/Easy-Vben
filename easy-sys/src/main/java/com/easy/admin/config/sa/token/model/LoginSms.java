package com.easy.admin.config.sa.token.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;

/**
 * 用户登录 - 手机号+短信验证码参数
 *
 * @author TengChongChong
 * @date 2024/08/08
 */
@Data
@Schema(description = "用户登录 - 手机号+短信验证码参数")
public class LoginSms extends BasisLogin {

    @NotBlank(message = "账号不能为空")
    @Schema(description = "手机号", required = true)
    private String phoneNumber;

    @NotBlank(message = "短信验证码不能为空")
    @Schema(description = "短信验证码", required = true)
    private String verificationCode;

    /**
     * 验证码
     */
    @Schema(description = "验证码，根据配置判断是否必须")
    private String captchaVerification;

}
