package com.easy.admin.auth.common.type;

import lombok.Getter;

/**
 * 数据权限类型
 *
 * @author TengChongChong
 * @date 2024/7/22
 **/
@Getter
public enum DataPermissionType {
    // 本人
    SELF("self", "本人"),
    // 本部门
    MY_DEPT("my-dept", "本部门"),
    // 本部门及子部门
    MY_AND_SUB_DEPT("my_and_sub_dept", "本部门及子部门"),
    // 自定义
    CUSTOM("custom", "自定义"),
    // 全部
    ALL("all", "全部");

    final String code;
    final String desc;

    DataPermissionType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
