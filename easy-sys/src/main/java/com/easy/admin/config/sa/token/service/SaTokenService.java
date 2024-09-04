package com.easy.admin.config.sa.token.service;

import com.easy.admin.auth.model.vo.session.SessionUserVO;
import com.easy.admin.config.sa.token.model.LoginAccount;

/**
 * SaToken 相关接口
 *
 * @author TengChongChong
 * @date 2024/9/3
 */
public interface SaTokenService {

    /**
     * 账号密码认证
     *
     * @param loginAccount loginAccount
     * @return 用户信息
     */
    SessionUserVO validateAccount(LoginAccount loginAccount);

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

}
