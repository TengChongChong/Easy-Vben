package com.easy.restful.sys.common.status;

/**
 * 权限状态
 *
 * @author tengchong
 * @date 2018/9/4
 **/
public enum PermissionsStatus {
    // 启用
    ENABLE(1, "启用"),
    // 禁用
    DISABLE(2, "禁用");

    int code;
    String message;

    PermissionsStatus(int code, String message) {
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
