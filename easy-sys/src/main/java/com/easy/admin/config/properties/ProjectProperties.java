package com.easy.admin.config.properties;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Validator;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.sys.common.constant.SysConfigConst;
import com.easy.admin.util.SysConfigUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * 项目配置
 *
 * @author TengChongChong
 * @date 2020/8/20
 */
@Configuration
public class ProjectProperties {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 版本号
     */
    @Value("${project.version}")
    private String version;

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
     * 是否开启登录验证码,默认开启
     */
    private Boolean loginVerificationCode = false;
    /**
     * 登录是密码错误尝试次数,超过5次后会被锁定
     */
    private Integer loginAttempts = 5;
    /**
     * 锁定时长,默认10分钟 单位: 秒
     */
    private Integer loginLockLength = 600;

    /**
     * 缓存类型
     */
    private String cacheType = "redis";

    /**
     * 模式
     */
    @Value("${spring.profiles.active}")
    private String profilesActive;
    /**
     * 下换线转驼峰
     * 用于页面传回的排序字段驼峰转下划线
     */
    @Value("${mybatis-plus.configuration.map-underscore-to-camel-case}")
    private boolean underscoreToCamelCase;
    /**
     * 文件上传路径
     */
    @Value("${project.file-upload-path}")
    private String fileUploadPath;

    public String getFileUploadPath() {
        if (Validator.isNotEmpty(fileUploadPath)) {
            if (!fileUploadPath.endsWith(File.separator)) {
                fileUploadPath = fileUploadPath + File.separator;
            }
            File file = new File(fileUploadPath);
            if (!file.exists() && !file.mkdirs()) {
                logger.warn("创建文件上传保存目录失败");
            }
            return fileUploadPath;
        } else {
            throw new EasyException("请在yml中配置project.file-upload-path");
        }
    }

    public void setFileUploadPath(String fileUploadPath) {
        this.fileUploadPath = fileUploadPath;
    }

    public Boolean getLoginVerificationCode() {
        return Convert.toBool(SysConfigUtil.get(SysConfigConst.LOGIN_VERIFICATION_CODE), loginVerificationCode);
    }

    public Integer getLoginAttempts() {
        return Convert.toInt(SysConfigUtil.get(SysConfigConst.LOGIN_ATTEMPTS), loginAttempts);
    }

    public Integer getLoginLockLength() {
        return Convert.toInt(SysConfigUtil.get(SysConfigConst.LOGIN_LOCK_LENGTH), loginLockLength);
    }

    public String getCacheType() {
        return cacheType;
    }

    public void setCacheType(String cacheType) {
        this.cacheType = cacheType;
    }

    public String getProfilesActive() {
        return profilesActive;
    }

    public void setProfilesActive(String profilesActive) {
        this.profilesActive = profilesActive;
    }

    public boolean getUnderscoreToCamelCase() {
        return underscoreToCamelCase;
    }

    public void setUnderscoreToCamelCase(boolean underscoreToCamelCase) {
        this.underscoreToCamelCase = underscoreToCamelCase;
    }

    public String getProjectUrl() {
        return projectUrl;
    }

    public void setProjectUrl(String projectUrl) {
        this.projectUrl = projectUrl;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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
