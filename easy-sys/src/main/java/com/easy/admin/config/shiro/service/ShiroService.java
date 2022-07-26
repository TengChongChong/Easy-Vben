package com.easy.admin.config.shiro.service;

import com.easy.admin.auth.model.SysUser;
import org.apache.shiro.session.Session;

import java.util.List;

/**
 * Shiro 相关接口
 *
 * @author TengChongChong
 * @date 2018/9/4
 */
public interface ShiroService {

    /**
     * 验证用户
     *
     * @param username 账号
     * @param password 密码
     * @return 用户信息
     */
    SysUser validateUser(String username, String password);

    /**
     * 根据账号获取用户
     *
     * @param username 账号
     * @return 用户信息
     */
    SysUser getSysUserByUserName(String username);

    /**
     * 查询用户权限
     *
     * @param sysUser 用户信息
     * @return 用户信息
     */
    SysUser queryUserPermissions(SysUser sysUser);

    /**
     * 更新用户最后登录时间
     *
     * @param userId 用户id
     */
    void updateUserLastLoginDate(String userId);

    /**
     * 根据用户获取相同账号会话
     *
     * @param user 正在登录的用户
     * @return 会话列表
     */
    List<Session> getLoginedSession(SysUser user);

    /**
     * 根据用户踢出相同账号其他会话
     *
     * @param user 正在登录的用户
     * @return boolean
     */
    boolean kickOutSession(SysUser user);
}
