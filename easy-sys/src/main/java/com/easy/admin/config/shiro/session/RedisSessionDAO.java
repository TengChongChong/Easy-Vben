package com.easy.admin.config.shiro.session;

import cn.hutool.core.lang.Validator;
import com.easy.admin.auth.common.constant.SessionConst;
import com.easy.admin.common.core.util.WebUtils;
import com.easy.admin.common.redis.constant.RedisPrefix;
import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.sys.common.constant.SysConfigConst;
import com.easy.admin.util.SysConfigUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * redis实现共享session
 *
 * @author TengChongChong
 * @date 2018/09/07
 */
@Repository("redisSessionDAO")
public class RedisSessionDAO extends AbstractSessionDAO {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private String getKey(String originalKey) {
        return RedisPrefix.SHIRO_SESSION + originalKey;
    }

    /**
     * 请求不更新session最后访问时间
     */
    private static final String IGNORE = "1";

    private static final long DAY = 60 * 60 * 24;

    /**
     * 创建会话
     *
     * @param session 会话
     * @return 会话id
     */
    @Override
    protected Serializable doCreate(Session session) {
        HttpServletRequest request = WebUtils.getRequest();
        String uri = request.getServletPath();
        // 如果是静态文件 不创建session
        if (WebUtils.isStaticRequest(uri)) {
            return null;
        }
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        return sessionId;
    }

    /**
     * 根据会话id获取session
     *
     * @param sessionId 会话id
     * @return 会话
     */
    @Override
    protected Session doReadSession(Serializable sessionId) {
        HttpServletRequest request = WebUtils.getRequest();
        String uri = request.getServletPath();
        // 如果是静态文件 不读取session
        if (WebUtils.isStaticRequest(uri)) {
            return null;
        }
        logger.debug("readSession({}):{}", request.getServletPath(), sessionId.toString());
        // 从缓存中获取session
        return (Session) RedisUtil.get(getKey(sessionId.toString()));
    }

    @Override
    public Session readSession(Serializable sessionId) throws UnknownSessionException {
        try {
            return super.readSession(sessionId);
        } catch (UnknownSessionException e) {
            return null;
        }
    }

    /**
     * 更新session的最后一次访问时间
     *
     * @param session 会话
     */
    @Override
    public void update(Session session) {
        if (checkSession(session)) {
            HttpServletRequest request = WebUtils.getRequest();
            logger.debug("updateSession({}):{}", request.getServletPath(), session.getId().toString());
            String uri = request.getServletPath();
            if (WebUtils.isStaticRequest(uri)) {
                return;
            }
            String ignore = request.getParameter("ignore");
            if (!IGNORE.equals(ignore)) {
                // 如请求不需要更新session会话有效期,请在url中传入ignore=1
                String key = getKey(session.getId().toString());
                RedisUtil.set(key, session, getSessionInvalidateTime(session));
            }
        }
    }

    /**
     * 删除session
     *
     * @param session 会话
     */
    @Override
    public void delete(Session session) {
        if (checkSession(session)) {
            logger.debug("delSession:{}", session.getId());
            RedisUtil.del(getKey(session.getId().toString()));
        }
    }

    /**
     * 获取当前有效会话
     *
     * @return 有效会话列表
     */
    @Override
    public Collection<Session> getActiveSessions() {
        logger.debug("activeSession");
        Set<String> sessionKeys = RedisUtil.selectKeysByPrefix(RedisPrefix.SHIRO_SESSION);
        if (sessionKeys != null && !sessionKeys.isEmpty()) {
            Collection<Session> sessions = new ArrayList<>();
            for (String sessionKey : sessionKeys) {
                sessions.add((Session) RedisUtil.get(sessionKey));
            }
            return sessions;
        }
        return null;
    }

    private boolean checkSession(Session session) {
        return session != null && Validator.isNotEmpty(session.getId());
    }


    /**
     * 获取会话有效期
     *
     * @param session 会话
     * @return 有效期
     */
    private long getSessionInvalidateTime(Session session) {
        if (session.getAttribute(SessionConst.REMEMBER_ME) != null && (Boolean) session.getAttribute(SessionConst.REMEMBER_ME)) {
            return (Long) SysConfigUtil.get(SysConfigConst.REMEMBER_ME_SESSION_INVALIDATE_TIME) * DAY;
        } else {
            return (Long) SysConfigUtil.get(SysConfigConst.SESSION_INVALIDATE_TIME);
        }
    }
}

