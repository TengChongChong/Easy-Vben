package com.easy.admin.auth.common.type;

/**
 * 权限类型
 *
 * @author TengChongChong
 * @date 2018/10/31
 **/
public enum PermissionType {
    // 目录
    CATALOGUE("catalogue", "目录"),
    // 菜单
    MENU("menu", "菜单"),
    // 权限
    BUTTON("button", "权限");

    String code;
    String message;

    PermissionType(String code, String message) {
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
