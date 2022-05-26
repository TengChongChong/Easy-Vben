package com.easy.admin.auth.common.status;

/**
 * 部门状态
 *
 * @author TengChongChong
 * @date 2018/9/4
 */

public enum SysDeptStatus {
    // 启用
    ENABLE("1", "启用"),
    // 禁用
    DISABLE("2", "禁用");

    String code;
    String message;

    SysDeptStatus(String code, String message) {
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
