package com.easy.admin.auth.common.status;

import lombok.Getter;

/**
 * 部门状态
 *
 * @author TengChongChong
 * @date 2018/9/4
 */
@Getter
public enum SysDeptStatus {
    // 启用
    ENABLE("1", "启用"),
    // 禁用
    DISABLE("2", "禁用");

    final String code;
    final String desc;

    SysDeptStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
