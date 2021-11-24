package com.easy.admin.cms.core.beetl;

import com.easy.admin.cms.utils.CmsArticleUtils;
import com.easy.admin.cms.utils.CmsColumnUtils;
import com.easy.admin.cms.utils.CmsSiteUtils;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * beetl拓展
 * 绑定一些工具类/配置/常量
 *
 * @author TengChongChong
 * @date 2021/11/22
 */
public class BeetlConfiguration extends BeetlGroupUtilConfiguration {

    @Override
    public void initOther(){
        groupTemplate.registerFunctionPackage("articleUtils", CmsArticleUtils.class);
        groupTemplate.registerFunctionPackage("columnUtils", CmsColumnUtils.class);
        groupTemplate.registerFunctionPackage("siteUtils", CmsSiteUtils.class);
    }

    /**
     * 获取类中的变量
     *
     * @param c class
     * @return map
     */
    private Map<String, Object> getVars(Class c){
        Field[] fields = c.getFields();
        Map<String, Object> property = new HashMap<>(fields.length);
        for( Field field : fields ){
            try {
                property.put(field.getName(), field.get(c));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        Map<String, Object> clazz = new HashMap<>(1);
        clazz.put(c.getSimpleName(), property);
        return clazz;
    }
}
