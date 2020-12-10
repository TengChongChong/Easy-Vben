package com.easy.restful.sys.common.type;

/**
 * 权限类型
 *
 * @author tengchong
 * @date 2018/10/31
 **/
public enum PermissionsType {
    // 菜单
    ENABLE("1", "菜单"),
    // 权限
    DISABLE("2", "权限");

    String code;
    String message;

    PermissionsType(String code, String message) {
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
