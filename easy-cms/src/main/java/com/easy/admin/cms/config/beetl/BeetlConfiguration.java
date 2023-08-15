package com.easy.admin.cms.config.beetl;

import cn.hutool.json.JSONUtil;
import com.easy.admin.cms.utils.CmsArticleUtil;
import com.easy.admin.cms.utils.CmsColumnUtil;
import com.easy.admin.cms.utils.CmsSiteUtil;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;

/**
 * beetl拓展
 * 绑定一些工具类/配置/常量
 *
 * @author TengChongChong
 * @date 2023-07-03
 */
public class BeetlConfiguration extends BeetlGroupUtilConfiguration {

    @Override
    public void initOther() {
        groupTemplate.registerFunctionPackage("ArticleUtil", CmsArticleUtil.class);
        groupTemplate.registerFunctionPackage("ColumnUtil", CmsColumnUtil.class);
        groupTemplate.registerFunctionPackage("SiteUtil", CmsSiteUtil.class);
        groupTemplate.registerFunctionPackage("JSONUtil", JSONUtil.class);
    }
}
