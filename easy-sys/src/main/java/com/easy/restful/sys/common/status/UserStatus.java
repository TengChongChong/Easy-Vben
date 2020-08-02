package com.easy.restful.sys.common.status;

/**
 * 用户状态
 *
 * @author tengchong
 * @date 2018/9/4
 */

public enum UserStatus {
    // 启用
    ENABLE(1, "启用"),
    // 禁用
    DISABLE(2, "禁用"),
    // 已删除
    DELETED(0, "已删除");

    int code;
    String message;

    UserStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
