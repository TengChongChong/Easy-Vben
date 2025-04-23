package com.easy.admin.sys.common.status;

import lombok.Getter;

/**
 * 模式
 *
 * @author TengChongChong
 * @date 2018/10/23
 */
@Getter
public enum ProfilesActiveStatus {
    // 开发模式
    DEV("dev", "开发模式"),
    // 生产模式
    PROD("prod", "生产模式");

    private final String profilesActive;
    private final String name;

    ProfilesActiveStatus(String profilesActive, String name) {
        this.profilesActive = profilesActive;
        this.name = name;
    }
}
