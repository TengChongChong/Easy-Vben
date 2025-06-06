package com.easy.admin.config.sa.token.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;

/**
 * 用户登录 - 扫码参数
 *
 * @author TengChongChong
 * @date 2024/08/08
 */
@Data
@Schema(description = "用户登录 - 扫码参数")
public class LoginQrCode extends BasisLogin {

    @NotBlank(message = "设备Id为空")
    @Schema(description = "设备Id", required = true)
    private String deviceId;

}
