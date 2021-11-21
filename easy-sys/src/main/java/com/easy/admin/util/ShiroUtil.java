package com.easy.admin.util;

import com.easy.admin.auth.constant.SessionConst;
import com.easy.admin.sys.model.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Shiro工具类
 * 封装一些关于会话/权限的方法
 *
 * @author TengChongChong
 * @date 2018/9/11
 */
public class ShiroUtil {
    private ShiroUtil() {}

    private static Logger logger = LoggerFactory.getLogger(ShiroUtil.class);

    /**
     * 获取当前用户session
     *
     * @return Session
     */
    public static Session getSession() {
        Session session = null;
        try {
            Subject subject = SecurityUtils.getSubject();
            session = subject.getSession();
        } catch (Exception e) {
            logger.info("获取当前用户session发生异常", e);
        }
        return session;
    }

    /**
     * 将数据放到session中
     *
     * @param key key
     * @param value value
     */
    public static void setAttribute(String key, Object value) {
        try {
            Session session = getSession();
            if(session != null){
                session.setAttribute(key, value);
            }
        } catch (Exception e) {
            logger.info("将放key:" + key + "到session中发生异常", e);
            throw e;
        }
    }

    /**
     * 获取session中的数据
     *
     * @param key key
     * @return Object
     */
    public static Object getAttribute(Object key) {
        Object value = null;
        try {
            Session session = getSession();
            if(session != null){
                value = session.getAttribute(key);
            }
        } catch (Exception e) {
            logger.info("从session获取key:" + key + "发生异常", e);
            throw e;
        }
        return value;
    }

    /**
     * 删除session中的数据
     *
     * @param key key
     */
    public static void removeAttribute(Object key) {
        try {
            Session session = getSession();
            if(session != null){
                session.removeAttribute(key);
            }
        } catch (Exception e) {
            logger.info("从session删除key:" + key + "发生异常", e);
            throw e;
        }
    }

    /**
     * 设置当前用户
     *
     * @param sysUser 当前用户
     */
    public static void setCurrentUser(SysUser sysUser) {
        setAttribute(SessionConst.USER_SESSION_KEY, sysUser);
    }

    /**
     * 获取当前用户
     *
     * @return SysUser
     */
    public static SysUser getCurrentUser() {
        SysUser user = (SysUser) getAttribute(SessionConst.USER_SESSION_KEY);
        if (user == null) {
            PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
            if (principalCollection != null) {
                user = (SysUser) principalCollection.getPrimaryPrincipal();
            }
        }
        return user;
    }

    /**
     * 删除当前用户
     */
    public static void removeCurrentUser() {
        removeAttribute(SessionConst.USER_SESSION_KEY);
    }

}
