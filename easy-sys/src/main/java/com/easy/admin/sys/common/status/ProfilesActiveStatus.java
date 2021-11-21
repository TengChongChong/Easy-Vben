package com.easy.admin.sys.common.status;

/**
 * 模式
 *
 * @author TengChongChong
 * @date 2018/10/23
 */
public enum ProfilesActiveStatus {
    // 开发模式
    DEV("dev", "开发模式"),
    // 生产模式
    PROD("prod", "生产模式");

    private String profilesActive;
    private String name;

    ProfilesActiveStatus(String profilesActive, String name) {
        this.profilesActive = profilesActive;
        this.name = name;
    }

    public String getProfilesActive() {
        return profilesActive;
    }

    public String getName() {
        return name;
    }
}
