package com.easy.admin.auth.common.type;

import lombok.Getter;

/**
 * 菜单
 *
 * @author TengChongChong
 * @date 2025/03/21
 **/
@Getter
public enum MenuType {

    CATALOG("catalog", "目录"),
    MENU("menu", "菜单"),
    BUTTON("button", "按钮"),
    EMBEDDED("embedded", "内嵌"),
    LINK("link", "外链");

    final String code;
    final String desc;

    MenuType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
