package com.easy.admin.sys.service;

import com.easy.admin.sys.model.SysUserOnline;

import java.util.List;

/**
 * 会话管理
 *
 * @author TengChongChong
 * @date 2018/9/12
 */
public interface SysUserOnlineService {
    /**
     * 查看在线用户列表
     *
     * @return List<SysUserOnline>
     */
    List<SysUserOnline> select();

    /**
     * 根据sessionId踢出用户
     *
     * @param sessionId 会话id
     * @return true/false
     */
    boolean forceLogout(String sessionId);
}
