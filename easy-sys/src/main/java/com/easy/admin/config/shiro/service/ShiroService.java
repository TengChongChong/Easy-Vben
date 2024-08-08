package com.easy.admin.config.shiro.service;

import com.easy.admin.auth.model.vo.session.SessionUserVO;
import com.easy.admin.config.shiro.authc.EasyAccountAuthenticationToken;
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
     * 账号密码认证
     *
     * @param authenticationToken authenticationToken
     * @return 用户信息
     */
    SessionUserVO validateAccountAuthenticationToken(EasyAccountAuthenticationToken authenticationToken);

    /**
     * 根据账号获取用户
     *
     * @param username 账号
     * @return 用户信息
     */
    SessionUserVO getSysUserByUserName(String username);

    /**
     * 设置用户权限
     *
     * @param sessionUser 用户信息
     */
    void setUserPermissions(SessionUserVO sessionUser);

    /**
     * 更新用户最后登录时间
     *
     * @param userId 用户id
     */
    void updateUserLastLoginDate(String userId);

    /**
     * 根据用户获取相同账号会话
     *
     * @param sessionUser 正在登录的用户
     * @return 会话列表
     */
    List<Session> getLoginedSession(SessionUserVO sessionUser);

    /**
     * 根据用户踢出相同账号其他会话
     *
     * @param sessionUser 正在登录的用户
     * @return boolean
     */
    boolean kickOutSession(SessionUserVO sessionUser);
}
