package com.easy.restful.common.security.common.response;

/**
 * 用户
 *
 * @author tengchong
 * @date 2020/7/31
 */
public enum Dept {
    // 部门不存在
    NOT_FIND("301007", "部门不存在"),
    // 部门被禁用
    DISABLE("301008", "部门被禁用");

    String code;
    String message;

    Dept(String code, String message) {
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
