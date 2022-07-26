package com.easy.admin.config.shiro.filter;

import com.easy.admin.auth.common.constant.SessionConst;
import com.easy.admin.common.core.exception.GlobalException;
import com.easy.admin.common.core.util.Response;
import com.easy.admin.common.redis.constant.RedisPrefix;
import com.easy.admin.common.redis.util.RedisUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 检查会话
 *
 * @author TengChongChong
 * @date 2018/9/17
 */
@Component
public class CheckSessionFilter extends AccessControlFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 直接过滤可以访问的请求类型
     */
    private static final String REQUET_TYPE = "OPTIONS";

    /**
     * 会话失效errorCode
     */
    private static final String CODE = "00401-1";

    /**
     * 表示是否允许访问;
     * 如果允许访问返回true,否则false
     *
     * @param servletRequest  servletRequest
     * @param servletResponse servletResponse
     * @param o               [urls]配置中拦截器参数部分
     * @return true/false
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) {
        return ((HttpServletRequest) servletRequest).getMethod().equalsIgnoreCase(REQUET_TYPE);
    }

    /**
     * 表示当访问拒绝时是否已经处理了
     * 如果返回true表示需要继续处理,如果返回false表示该拦截器实例已经处理了
     *
     * @param servletRequest  servletRequest
     * @param servletResponse servletResponse
     * @return true/false
     * @throws Exception exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        Subject subject = getSubject(servletRequest, servletResponse);
        // 是否认证
        if (subject.isAuthenticated()) {
            // 记住密码或已登录,检查账户是否被挤掉或者踢出
            Session session = (Session) RedisUtil.get(RedisPrefix.SHIRO_SESSION + subject.getSession().getId());
            // 检查是否被踢出
            if (session.getAttribute(SessionConst.FORCE_LOGOUT) != null && (boolean) session.getAttribute(SessionConst.FORCE_LOGOUT)) {
                logger.debug("管理员踢出会话[{}]", session.getId());
                RedisUtil.del(RedisPrefix.SHIRO_SESSION + session.getId());
                responseJson(subject, servletResponse, GlobalException.SESSION_FORCE_LOGOUT);
                return false;
            }

            // 检查是否在他处登录
            if (session.getAttribute(SessionConst.LOGIN_ELSEWHERE) != null && (boolean) session.getAttribute(SessionConst.LOGIN_ELSEWHERE)) {
                logger.debug("用户在其他地方登录会话[{}]被踢出", session.getId());
                RedisUtil.del(RedisPrefix.SHIRO_SESSION + session.getId());
                responseJson(subject, servletResponse, GlobalException.SESSION_LOGIN_ELSEWHERE);
                return false;
            }
            return true;
        }
        responseJson(subject, servletResponse, GlobalException.SESSION_INVALID);
        return false;
    }

    private void responseJson(Subject subject, ServletResponse servletResponse, GlobalException exception) {
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        Response.response(response, CheckSessionFilter.CODE, exception.getMessage());
        subject.logout();
    }
}
