package com.easy.admin.auth.common.status;

/**
 * 用户状态
 *
 * @author TengChongChong
 * @date 2018/9/4
 */

public enum SysUserStatus {
    // 启用
    ENABLE("1", "启用"),
    // 禁用
    DISABLE("2", "禁用"),
    // 已删除
    DELETED("0", "已删除");

    String code;
    String message;

    SysUserStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
