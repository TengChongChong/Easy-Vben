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
 * @date 2021-11-22
 */
@Configuration
@PropertySource("classpath:beetl-config.properties")
@ConfigurationProperties(prefix = "beetl")
public class BeetlProperties {
    /**
     * 页面文件Root目录
     */
    private String themeRoot;
    /**
     * 文件后缀
     */
    private String suffix;
    /**
     * 开始标签
     */
    private String delimiterStatementStart;
    /**
     * 结束标签
     */
    private String delimiterStatementEnd;
    /**
     * 是否检测文件变化
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
        if (StrUtil.isNotBlank(resourceAutoCheck)) {
            properties.setProperty("RESOURCE.autoCheck", resourceAutoCheck);
        }
        return properties;
    }

    public String getThemeRoot() {
        return themeRoot;
    }

    public void setThemeRoot(String themeRoot) {
        this.themeRoot = themeRoot;
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

    public String getResourceAutoCheck() {
        return resourceAutoCheck;
    }

    public void setResourceAutoCheck(String resourceAutoCheck) {
        this.resourceAutoCheck = resourceAutoCheck;
    }
}
