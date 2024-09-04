package com.easy.admin.auth.model.vo;

import lombok.Data;

/**
 * 登录响应信息
 *
 * @author TengChongChong
 * @date 2024-08-20
 **/
@Data
public class LoginResultVO {

    /**
     * accessToken
     */
    private String accessToken;

    /**
     * accessToken 有效期，单位：秒
     */
    private Long accessTokenExpiresIn;

    /**
     * refreshToken
     */
    private String refreshToken;

    /**
     * refreshToken 有效期，单位：秒
     */
    private Long refreshTokenExpiresIn;
}
