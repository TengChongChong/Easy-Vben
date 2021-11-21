package com.easy.admin;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 * web 容器下启动类
 * war 方式部署情况下使用
 *
 * @author TengChongChong
 * @date 2020/06/12
 */
public class WebStartApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}
