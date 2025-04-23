package com.easy.admin.auth.common.status;

import lombok.Getter;

/**
 * 用户状态
 *
 * @author TengChongChong
 * @date 2018/9/4
 */
@Getter
public enum SysUserStatus {
    // 启用
    ENABLE("1", "启用"),
    // 禁用
    DISABLE("2", "禁用"),
    // 已删除
    DELETED("0", "已删除");

    final String code;
    final String desc;

    SysUserStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
