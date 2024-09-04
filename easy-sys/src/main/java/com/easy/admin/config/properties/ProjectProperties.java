package com.easy.admin.config.properties;

import cn.hutool.core.convert.Convert;
import com.easy.admin.sys.common.constant.SysConfigConst;
import com.easy.admin.util.SysConfigUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 项目配置
 *
 * @author TengChongChong
 * @date 2020/8/20
 */
@Configuration
public class ProjectProperties {

    @Value("${project.url}")
    private String projectUrl;

    /**
     * 前端访问url
     */
    @Value("${project.front-end-url}")
    private String projectFrontEndUrl;

    /**
     * 主数据源名称
     */
    @Value("${spring.datasource.dynamic.primary}")
    private String dynamicPrimary;
    /**
     * 登录是密码错误尝试次数,超过5次后会被锁定
     */
    private Integer loginAttempts = 5;
    /**
     * 锁定时长,默认10分钟 单位: 秒
     */
    private Integer loginLockLength = 600;

    /**
     * profiles
     */
    @Value("${spring.profiles.active}")
    private String profilesActive;


    public Integer getLoginAttempts() {
        return Convert.toInt(SysConfigUtil.get(SysConfigConst.LOGIN_ATTEMPTS), loginAttempts);
    }

    public Integer getLoginLockLength() {
        return Convert.toInt(SysConfigUtil.get(SysConfigConst.LOGIN_LOCK_LENGTH), loginLockLength);
    }

    public String getProfilesActive() {
        return profilesActive;
    }

    public void setProfilesActive(String profilesActive) {
        this.profilesActive = profilesActive;
    }


    public String getProjectUrl() {
        return projectUrl;
    }

    public void setProjectUrl(String projectUrl) {
        this.projectUrl = projectUrl;
    }

    public String getProjectFrontEndUrl() {
        return projectFrontEndUrl;
    }

    public void setProjectFrontEndUrl(String projectFrontEndUrl) {
        this.projectFrontEndUrl = projectFrontEndUrl;
    }

    public String getDynamicPrimary() {
        return dynamicPrimary;
    }
}
