package com.easy.admin.common.swagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenApiConfig
 *
 * @author tengchong
 * @date 2022/8/25
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI createOpenApiConfig() {
        return new OpenAPI()
                .info(new Info().title("Easy Vben API")
                        .description("Easy Vben API 使用文档")
                        .version("1.0.0"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("Easy Vben API")
                .pathsToMatch("/**")
                .build();
    }

}
