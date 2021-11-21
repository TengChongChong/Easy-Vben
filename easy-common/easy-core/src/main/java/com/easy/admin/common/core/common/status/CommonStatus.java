package com.easy.admin.common.core.common.status;

/**
 * 通用状态
 *
 * @author TengChongChong
 * @date 2018/11/14
 */

public enum CommonStatus {
    // 启用
    ENABLE("1", "启用"),
    // 禁用
    DISABLE("2", "禁用");

    String code;
    String message;

    CommonStatus(String code, String message) {
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