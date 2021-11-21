package com.easy.admin.sys.common.status;

/**
 * 权限是否隐藏
 *
 * @author TengChongChong
 * @date 2018/9/4
 **/
public enum PermissionsHideStatus {
    // 显示
    ENABLE("0", "显示"),
    // 隐藏
    DISABLE("1", "隐藏");

    String code;
    String message;

    PermissionsHideStatus(String code, String message) {
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
