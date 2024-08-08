package com.easy.admin.util;

import com.easy.admin.auth.common.constant.SessionConst;
import com.easy.admin.auth.model.vo.session.SessionUserRoleVO;
import com.easy.admin.auth.model.vo.session.SessionUserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Shiro工具类
 * 封装一些关于会话/权限的方法
 *
 * @author TengChongChong
 * @date 2018/9/11
 */
public class ShiroUtil {
    private ShiroUtil() {
    }

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
     * @param key   key
     * @param value value
     */
    public static void setAttribute(String key, Object value) {
        try {
            Session session = getSession();
            if (session != null) {
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
            if (session != null) {
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
            if (session != null) {
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
     * @param currentUser 当前用户
     */
    public static void setCurrentUser(SessionUserVO currentUser) {
        setAttribute(SessionConst.USER_SESSION_KEY, currentUser);
    }

    /**
     * 获取当前用户
     *
     * @return SessionUserVO
     */
    public static SessionUserVO getCurrentUser() {
        SessionUserVO currentUser = (SessionUserVO) getAttribute(SessionConst.USER_SESSION_KEY);
        if (currentUser == null) {
            PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
            if (principalCollection != null) {
                currentUser = (SessionUserVO) principalCollection.getPrimaryPrincipal();
            }
        }
        return currentUser;
    }

    /**
     * 是否拥有某个角色标识
     *
     * @param roleCode 角色标识
     * @return true/false
     */
    public static boolean havRole(String roleCode) {
        SessionUserVO currentUser = getCurrentUser();
        return currentUser.getRoleCodeList().contains(roleCode);
    }

    /**
     * 删除当前用户
     */
    public static void removeCurrentUser() {
        removeAttribute(SessionConst.USER_SESSION_KEY);
    }


    /**
     * 获取角色Id
     *
     * @param roleList 权限list
     * @return 权限标识
     */
    public static List<String> getRoleIds(List<SessionUserRoleVO> roleList) {
        List<String> roleIds = new ArrayList<>();
        for (SessionUserRoleVO role : roleList) {
            roleIds.add(role.getId());
        }
        return roleIds;
    }

}
