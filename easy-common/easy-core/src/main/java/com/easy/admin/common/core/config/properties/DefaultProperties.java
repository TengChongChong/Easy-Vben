package com.easy.admin.common.core.config.properties;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 默认的配置
 * @author TengChongChong
 */
@Configuration
@PropertySource("classpath:/default-config.properties")
public class DefaultProperties {

}
