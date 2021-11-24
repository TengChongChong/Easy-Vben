package com.easy.admin.cms.config.beetl;

import com.easy.admin.cms.core.beetl.BeetlConfiguration;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.beetl.ext.web.WebErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * beetl的配置
 *
 * @author TengChongChong
 * @date 2021/11/22
 */
@Configuration
public class BeetlConfig {

    @Autowired
    private BeetlProperties beetlProperties;

    @Bean(initMethod = "init")
    public BeetlConfiguration beetlConfiguration() {
        BeetlConfiguration beetlConfiguration = new BeetlConfiguration();
        beetlConfiguration.setResourceLoader(new ClasspathResourceLoader(BeetlConfig.class.getClassLoader(), beetlProperties.getPrefix()));
        // config
        beetlConfiguration.setConfigProperties(beetlProperties.getProperties());
        // 自定义异常处理类
        beetlConfiguration.setErrorHandler(new WebErrorHandler());
        return beetlConfiguration;
    }

    @Bean
    public BeetlSpringViewResolver getBeetlSpringViewResolver(){
        BeetlSpringViewResolver viewResolver = new BeetlSpringViewResolver();
        viewResolver.setSuffix(beetlProperties.getSuffix());
        viewResolver.setContentType("text/html;charset=UTF-8");
        viewResolver.setOrder(0);
        viewResolver.setConfig(beetlConfiguration());
        return viewResolver;
    }

}
