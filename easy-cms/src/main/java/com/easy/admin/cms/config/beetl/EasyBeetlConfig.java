package com.easy.admin.cms.config.beetl;

import cn.hutool.json.JSONUtil;
import com.easy.admin.cms.utils.CmsArticleUtil;
import com.easy.admin.cms.utils.CmsColumnUtil;
import com.easy.admin.cms.utils.CmsSiteUtil;
import lombok.extern.slf4j.Slf4j;
import org.beetl.ext.spring6.BeetlTemplateCustomize;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * beetl 配置
 *
 * @author TengChongChong
 * @date 2021-11-22
 */
@Slf4j
@Configuration
public class EasyBeetlConfig {

    @Bean
    public BeetlTemplateCustomize beetlTemplateCustomize() {
        return groupTemplate -> {
            groupTemplate.registerFunctionPackage("ArticleUtil", CmsArticleUtil.class);
            groupTemplate.registerFunctionPackage("ColumnUtil", CmsColumnUtil.class);
            groupTemplate.registerFunctionPackage("SiteUtil", CmsSiteUtil.class);
            groupTemplate.registerFunctionPackage("JSONUtil", JSONUtil.class);

            try {
                org.beetl.core.Configuration configuration = org.beetl.core.Configuration.defaultConfiguration();
                configuration.setErrorHandlerClass("easyBeetlWebErrorHandler");
                groupTemplate.setConf(configuration);
            } catch (IOException e) {
                log.debug("初始化Beetl Configuration 失败", e);
            }
        };
    }
}
