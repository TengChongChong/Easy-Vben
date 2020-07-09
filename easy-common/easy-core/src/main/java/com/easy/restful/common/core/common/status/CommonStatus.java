package com.easy.restful.common.core.common.status;

/**
 * 通用状态
 *
 * @author tengchong
 * @date 2018/11/14
 */

public enum CommonStatus {
    // 启用
    ENABLE(1, "启用"),
    // 禁用
    DISABLE(2, "禁用");

    int code;
    String message;

    CommonStatus(int code, String message) {
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