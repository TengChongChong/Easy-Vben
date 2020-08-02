package com.easy.restful.common.security.common.response;

/**
 * 用户
 *
 * @author tengchong
 * @date 2020/7/31
 */
public enum Access {
    // 用户名不存在
    ACCOUNT_NOT_FIND("302001", "用户名或密码错误"),
    // 密码错误
    PASSWORD_ERROR("302001", "用户名或密码错误"),
    // 用户过期
    ACCOUNT_EXPIRED("302003", "用户已过期"),
    // 密码过期
    PASSWORD_EXPIRED("302004", "密码已过期"),
    // 用户被禁用
    DISABLED("302005", "用户被禁用"),
    // 用户被锁定
    LOCKED("302006", "用户被锁定");

    String code;
    String message;

    Access(String code, String message) {
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
