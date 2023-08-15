package com.easy.admin.cms.config.beetl;

import com.easy.admin.common.core.exception.EasyException;
import org.beetl.core.resource.FileResourceLoader;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * beetl的配置
 *
 * @author TengChongChong
 * @date 2021-11-22
 */
@Configuration
public class BeetlConfig {

    @Autowired
    private BeetlProperties beetlProperties;

    @Bean(initMethod = "init")
    public BeetlConfiguration beetlConfiguration() {

        File themeRoot = new File(beetlProperties.getThemeRoot());
        if (!themeRoot.isDirectory() || !themeRoot.exists()) {
            throw new EasyException("CMS主题目录不存在，请检查beetl-config.yml中beetl.theme-root配置是否正确");
        }
        FileResourceLoader fileResourceLoader = new FileResourceLoader(beetlProperties.getThemeRoot());
        BeetlConfiguration beetlConfiguration = new BeetlConfiguration();
        beetlConfiguration.setResourceLoader(fileResourceLoader);
        // config
        beetlConfiguration.setConfigProperties(beetlProperties.getProperties());
        // 自定义异常处理类
        beetlConfiguration.setErrorHandler(new WebErrorHandler());
        return beetlConfiguration;
    }

    @Bean
    public BeetlSpringViewResolver getBeetlSpringViewResolver() {
        BeetlSpringViewResolver viewResolver = new BeetlSpringViewResolver();
        viewResolver.setSuffix(beetlProperties.getSuffix());
        viewResolver.setContentType("text/html;charset=UTF-8");
        viewResolver.setOrder(0);
        viewResolver.setConfig(beetlConfiguration());
        return viewResolver;
    }
}
