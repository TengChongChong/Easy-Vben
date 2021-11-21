package com.easy.admin.common.core.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 获取spring容器中的bean
 *
 * @author TengChongChong
 * @date 2019-04-26
 */
@Component
public class SpringContextHolder implements ApplicationContextAware {
    private SpringContextHolder() {}

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }

    /**
     * 获取 ApplicationContext
     *
     * @return ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    /**
     * 通过name获取Bean
     *
     * @param beanName class
     * @return bean
     */
    public static <T> T getBean(String beanName) {
        checkApplicationContext();
        return (T) applicationContext.getBean(beanName);
    }

    /**
     * 通过Class获取Bean
     *
     * @param requiredType class eg: Sample.class
     * @return bean
     */
    public static <T> T getBean(Class<T> requiredType) {
        checkApplicationContext();
        return applicationContext.getBean(requiredType);
    }

    private static void checkApplicationContext() {
        if (SpringContextHolder.applicationContext == null) {
            throw new RuntimeException("applicationContext is null");
        }
    }
}

