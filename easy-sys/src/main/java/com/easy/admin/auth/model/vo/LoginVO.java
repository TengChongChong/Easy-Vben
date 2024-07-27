package com.easy.admin.auth.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 用户登录
 *
 * @author TengChongChong
 * @date 2020/12/11
 */
@Data
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

}
