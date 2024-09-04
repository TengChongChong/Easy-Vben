package com.easy.admin.auth.model.vo;

import lombok.Data;

/**
 * 更改密码
 *
 * @author TengChongChong
 * @date 2024-08-31
 **/
@Data
public class ChangePasswordVO {

    /**
     * 当前密码（经过一次md5）
     */
    private String currentPassword;

    /**
     * 新密码（经过一次md5）
     */
    private String newPassword;
}
