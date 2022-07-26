package com.easy.admin.auth.service;

import com.easy.admin.auth.model.SysUserOnline;

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
     * @param sysUserOnline 在线用户
     * @return List<SysUserOnline>
     */
    List<SysUserOnline> select(SysUserOnline sysUserOnline);

    /**
     * 根据token踢出用户
     *
     * @param token 会话id
     * @return true/false
     */
    boolean forceLogout(String token);
}
