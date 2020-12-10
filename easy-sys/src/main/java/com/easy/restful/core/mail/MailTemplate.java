package com.easy.restful.core.mail;


import com.easy.restful.common.core.exception.EasyException;
import com.easy.restful.sys.common.constant.SysConst;
import com.easy.restful.util.SysConfigUtil;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 邮件模板
 *
 * @author tengchong
 * @date 2019-03-26
 */
public class MailTemplate {

    /**
     * 申请密保邮箱
     *
     * @param content 内容
     * @return html
     */
    public static String applicationBindingMail(String content) {
        return getMailContent(content, "如果你未申请密保邮箱");
    }

    /**
     * 发送重置密码验证码
     *
     * @param content 内容
     * @return html
     */
    public static String sendResetPasswordMail(String content) {
        return getMailContent(content, "如果你未申请重置密码");
    }

    /**
     * 发送重置密码验证码
     *
     * @param content 内容
     * @return html
     */
    private static String getMailContent(String content, String tips) {
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("mail/");
        Configuration cfg;
        try {
            cfg = Configuration.defaultConfiguration();
        } catch (IOException e) {
            throw new EasyException("获取defaultConfiguration失败[" + e.getMessage() + "]");
        }
        GroupTemplate groupTemplate = new GroupTemplate(resourceLoader, cfg);
        Template template = groupTemplate.getTemplate("default.html");
        // 设置共享变量
        Map<String,Object> shared = new HashMap<>(4);
        shared.put("content", content);
        shared.put("tips", tips);
        shared.put("projectName", SysConfigUtil.getProjectName());
        shared.put("projectUrl", SysConst.projectProperties.getProjectUrl());
        groupTemplate.setSharedVars(shared);
        return template.render();
    }
}
