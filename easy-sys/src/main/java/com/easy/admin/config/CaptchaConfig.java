package com.easy.admin.config;

import com.anji.captcha.properties.AjCaptchaProperties;
import com.anji.captcha.service.CaptchaCacheService;
import com.anji.captcha.service.impl.CaptchaServiceFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
@ComponentScan(basePackages = {"com.anji.captcha"})
public class CaptchaConfig {

    @Bean
    @Primary
    public CaptchaCacheService captchaCacheService(AjCaptchaProperties config){
        return CaptchaServiceFactory.getCache(config.getCacheType().name());
    }

    @Bean
    @ConditionalOnMissingBean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("captcha/messages","captcha/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
