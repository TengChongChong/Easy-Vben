package com.easy.admin.common.core.common.status;

import lombok.Getter;

/**
 * 通用状态
 *
 * @author TengChongChong
 * @date 2018/11/14
 */
@Getter
public enum CommonStatus {
    // 启用
    ENABLE("1", "启用"),
    // 禁用
    DISABLE("2", "禁用");

    final String code;
    final String desc;

    CommonStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}