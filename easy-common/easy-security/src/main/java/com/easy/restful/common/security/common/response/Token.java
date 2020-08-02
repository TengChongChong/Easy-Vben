package com.easy.restful.common.security.common.response;

/**
 * Token
 *
 * @author tengchong
 * @date 2020/7/31
 */
public enum Token {
    // Token已过期
    EXPIRED_JWT("300001", "Token已过期"),
    // Token解析失败
    UNSUPPORTED_JWT("300001", "Token解析失败"),
    // Token格式错误
    MALFORMED_JWT("300003", "Token格式错误"),
    // Token格式错误
    ILLEGAL_ARGUMENT("300004", "Token格式错误"),
    // Token签名错误
    SIGNATURE("300005", "Token签名错误"),
    // Token已失效
    INVALID("300006", "Token已失效");

    String code;
    String message;

    Token(String code, String message) {
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
