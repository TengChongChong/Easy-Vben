package com.easy.admin.auth.service;

import com.easy.admin.auth.model.SysUserOnline;
import com.easy.admin.common.core.common.pagination.Page;

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
     * @return Page<SysUserOnline>
     */
    Page<SysUserOnline> select(SysUserOnline sysUserOnline, Page<SysUserOnline> page);

    /**
     * 根据token踢出用户
     *
     * @param token 会话id
     * @return true/false
     */
    boolean forceLogout(String token);
}
