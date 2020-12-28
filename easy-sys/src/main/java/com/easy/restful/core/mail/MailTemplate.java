package com.easy.restful.core.mail;


import com.easy.restful.common.core.exception.EasyException;
import com.easy.restful.sys.common.constant.SysConst;
import com.easy.restful.util.SysConfigUtil;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

import java.io.IOException;
import java.util.Map;

/**
 * 邮件模板
 *
 * @author tengchong
 * @date 2019-03-26
 */
public class MailTemplate {

    /**
     * 获取模板内容
     *
     * @param templatePath 模板路径
     * @param params 参数
     * @return 模板内容
     */
    public static String getContent(String templatePath, Map<String,Object> params) {
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();
        Configuration cfg;
        try {
            cfg = Configuration.defaultConfiguration();
        } catch (IOException e) {
            throw new EasyException("获取defaultConfiguration失败[" + e.getMessage() + "]");
        }
        GroupTemplate groupTemplate = new GroupTemplate(resourceLoader, cfg);
        Template template = groupTemplate.getTemplate(templatePath);
        params.put("projectName", SysConfigUtil.getProjectName());
        params.put("projectUrl", SysConst.projectProperties.getProjectUrl());
        params.put("projectFrontEndUrl", SysConst.projectProperties.getProjectFrontEndUrl());
        groupTemplate.setSharedVars(params);
        return template.render();
    }

    public static void main(String[] args) {
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();
        Configuration cfg;
        try {
            cfg = Configuration.defaultConfiguration();
        } catch (IOException e) {
            throw new EasyException("获取defaultConfiguration失败[" + e.getMessage() + "]");
        }
        GroupTemplate groupTemplate = new GroupTemplate(resourceLoader, cfg);
        Template template = groupTemplate.getTemplate("/mail/verify-mail.html");
        System.out.println(template.render());
    }
}
