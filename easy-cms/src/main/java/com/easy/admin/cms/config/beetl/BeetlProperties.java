package com.easy.admin.cms.config.beetl;

import cn.hutool.core.util.StrUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Properties;

/**
 * beetl 配置
 *
 * @author TengChongChong
 * @date 2021/11/22
 */
@Configuration
@PropertySource("classpath:/cms-config.properties")
@ConfigurationProperties(prefix = "beetl")
public class BeetlProperties {
    /**
     * 页面文件Root目录
     * 默认 /view
     */
    private String prefix;
    /**
     * 文件后缀
     * 默认 html
     */
    private String suffix;
    /**
     * 开始标签
     * 默认 @
     */
    private String delimiterStatementStart;
    /**
     * 结束标签
     * 默认 无
     */
    private String delimiterStatementEnd;
    /**
     * 自定义标签文件Root目录
     * 默认 /common/tags
     */
    private String resourceTagRoot;
    /**
     * 自定义标签文件后缀
     * 默认 tag
     */
    private String resourceTagSuffix;
    /**
     * 是否检测文件变化
     * 默认 开发环境 true 生产环境 false
     */
    private String resourceAutoCheck;

    public Properties getProperties() {
        Properties properties = new Properties();
        if (StrUtil.isNotBlank(delimiterStatementStart)) {
            properties.setProperty("DELIMITER_STATEMENT_START", delimiterStatementStart);
        }
        if (StrUtil.isNotBlank(delimiterStatementEnd)) {
            properties.setProperty("DELIMITER_STATEMENT_END", delimiterStatementEnd);
        } else {
            properties.setProperty("DELIMITER_STATEMENT_END", "null");
        }
        if (StrUtil.isNotBlank(resourceTagRoot)) {
            properties.setProperty("RESOURCE.tagRoot", resourceTagRoot);
        }
        if (StrUtil.isNotBlank(resourceTagSuffix)) {
            properties.setProperty("RESOURCE.tagSuffix", resourceTagSuffix);
        }
        if (StrUtil.isNotBlank(resourceAutoCheck)) {
            properties.setProperty("RESOURCE.autoCheck", resourceAutoCheck);
        }
        return properties;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getDelimiterStatementStart() {
        return delimiterStatementStart;
    }

    public void setDelimiterStatementStart(String delimiterStatementStart) {
        this.delimiterStatementStart = delimiterStatementStart;
    }

    public String getDelimiterStatementEnd() {
        return delimiterStatementEnd;
    }

    public void setDelimiterStatementEnd(String delimiterStatementEnd) {
        this.delimiterStatementEnd = delimiterStatementEnd;
    }

    public String getResourceTagRoot() {
        return resourceTagRoot;
    }

    public void setResourceTagRoot(String resourceTagRoot) {
        this.resourceTagRoot = resourceTagRoot;
    }

    public String getResourceTagSuffix() {
        return resourceTagSuffix;
    }

    public void setResourceTagSuffix(String resourceTagSuffix) {
        this.resourceTagSuffix = resourceTagSuffix;
    }

    public String getResourceAutoCheck() {
        return resourceAutoCheck;
    }

    public void setResourceAutoCheck(String resourceAutoCheck) {
        this.resourceAutoCheck = resourceAutoCheck;
    }
}
