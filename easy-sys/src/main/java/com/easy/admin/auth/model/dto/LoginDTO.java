package com.easy.admin.auth.model.dto;

import com.easy.admin.auth.common.type.AuthType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 用户登录参数
 *
 * @author TengChongChong
 * @date 2020/12/11
 */
@Data
@Schema(description = "用户登录参数")
public class LoginDTO {

    /**
     * 登录认证方式，默认使用用户名+密码认证方式
     */
    private AuthType authType = AuthType.account;

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

}
