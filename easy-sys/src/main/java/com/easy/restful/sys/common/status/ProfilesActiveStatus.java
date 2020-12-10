package com.easy.restful.sys.common.status;

/**
 * 模式
 *
 * @author tengchong
 * @date 2018/10/23
 */
public enum ProfilesActiveStatus {
    // 开发模式
    dev("dev", "开发模式"),
    // 生产模式
    prod("prod", "生产模式");

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
