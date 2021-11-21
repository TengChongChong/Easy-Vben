package com.easy.admin.sys.common.status;

/**
 * 角色状态
 *
 * @author TengChongChong
 * @date 2018/9/4
 */

public enum RoleStatus {
    // 启用
    ENABLE("1", "启用"),
    // 禁用
    DISABLE("2", "禁用");

    String code;
    String message;

    RoleStatus(String code, String message) {
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
