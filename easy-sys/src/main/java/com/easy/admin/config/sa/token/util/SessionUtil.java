package com.easy.admin.config.sa.token.util;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import com.easy.admin.auth.common.constant.SessionConst;
import com.easy.admin.auth.model.vo.session.SessionUserVO;

/**
 * 会话 Util
 *
 * @author TengChongChong
 * @date 2024-09-03
 **/
public class SessionUtil {
    private SessionUtil() {
    }

    /**
     * 获取当前会话session
     *
     * @return Session
     */
    public static SaSession getTokenSession() {
        return StpUtil.getTokenSession();
    }

    /**
     * 将数据放到session中
     *
     * @param key   key
     * @param value value
     */
    public static void setAttribute(String key, Object value) {
        getTokenSession().set(key, value);
    }

    /**
     * 获取session中的数据
     *
     * @param key key
     * @return Object
     */
    public static Object getAttribute(String key) {
        return getTokenSession().get(key);
    }

    /**
     * 删除session中的数据
     *
     * @param key key
     */
    public static void removeAttribute(String key) {
        getTokenSession().delete(key);
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
        return (SessionUserVO) getTokenSession().get(SessionConst.USER_SESSION_KEY);
    }

    /**
     * 是否拥有某个角色标识
     *
     * @param roleCode 角色标识
     * @return true/false
     */
    public static boolean havRole(String roleCode) {
        return StpUtil.hasRole(roleCode);
    }

    /**
     * 删除当前用户
     */
    public static void removeCurrentUser() {
        removeAttribute(SessionConst.USER_SESSION_KEY);
    }

}
