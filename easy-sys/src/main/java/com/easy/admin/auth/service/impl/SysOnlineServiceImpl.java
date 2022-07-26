package com.easy.admin.auth.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.easy.admin.auth.common.constant.SessionConst;
import com.easy.admin.config.shiro.session.RedisSessionDAO;
import com.easy.admin.auth.model.SysUser;
import com.easy.admin.auth.model.SysUserOnline;
import com.easy.admin.auth.service.SysUserOnlineService;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 会话管理
 *
 * @author TengChongChong
 * @date 2018/9/12
 */
@Service
public class SysOnlineServiceImpl implements SysUserOnlineService {

    @Autowired
    private RedisSessionDAO sessionDAO;

    @Override
    public List<SysUserOnline> select(SysUserOnline sysUserOnline) {
        List<SysUserOnline> userOnlineList = new ArrayList<>();
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        if (sessions != null && !sessions.isEmpty()) {
            for (Session session : sessions) {
                SysUserOnline userOnline = new SysUserOnline();
                SimplePrincipalCollection principalCollection;
                // 管理员强制退出
                if (Convert.toBool(session.getAttribute(SessionConst.FORCE_LOGOUT), false)) {
                    continue;
                }
                // 在其他地方登录,被踢出
                if (Convert.toBool(session.getAttribute(SessionConst.LOGIN_ELSEWHERE), false)) {
                    continue;
                }
                if (session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY) == null) {
                    continue;
                }
                principalCollection = (SimplePrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
                SysUser sysUser = (SysUser) principalCollection.getPrimaryPrincipal();
                // 用户名
                if (StrUtil.isNotBlank(sysUserOnline.getUsername())) {
                    if (!sysUser.getUsername().contains(sysUserOnline.getUsername())) {
                        continue;
                    }
                }
                // 昵称
                if (StrUtil.isNotBlank(sysUserOnline.getNickname())) {
                    if (!sysUser.getNickname().contains(sysUserOnline.getNickname())) {
                        continue;
                    }
                }
                // 部门
                if (StrUtil.isNotBlank(sysUserOnline.getDeptName())) {
                    if (!sysUser.getDept().getName().contains(sysUserOnline.getDeptName())) {
                        continue;
                    }
                }
                userOnline.setUsername(sysUser.getUsername());
                userOnline.setNickname(sysUser.getNickname());
                userOnline.setDeptName(sysUser.getDept().getName());
                userOnline.setAvatar(sysUser.getAvatar());
                userOnline.setId(sysUser.getId());

                userOnline.setSessionId((String) session.getId());
                userOnline.setHost(session.getHost());
                userOnline.setStartTimestamp(session.getStartTimestamp());
                userOnline.setLastAccessTime(session.getLastAccessTime());
                userOnline.setTimeout(session.getTimeout());
                userOnlineList.add(userOnline);
            }
        }
        return userOnlineList;
    }

    @Override
    public boolean forceLogout(String token) {
        Session session = sessionDAO.readSession(token);
        if (session != null) {
            // 标记为管理员强制退出
            session.setAttribute(SessionConst.FORCE_LOGOUT, true);
            sessionDAO.update(session);
            return true;
        } else {
            return false;
        }
    }
}
