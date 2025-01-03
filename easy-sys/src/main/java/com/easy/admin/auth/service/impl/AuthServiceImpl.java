package com.easy.admin.auth.service.impl;

import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.StpUtil;
import com.easy.admin.auth.model.vo.LoginResultVO;
import com.easy.admin.auth.model.vo.session.SessionUserVO;
import com.easy.admin.auth.service.AuthService;
import com.easy.admin.common.redis.constant.RedisPrefix;
import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.config.sa.token.model.LoginAccount;
import com.easy.admin.config.sa.token.model.LoginQrCode;
import com.easy.admin.config.sa.token.model.LoginSms;
import com.easy.admin.config.sa.token.service.SaTokenService;
import com.easy.admin.config.sa.token.util.SessionUtil;
import com.easy.admin.sys.common.constant.SysConfigConst;
import com.easy.admin.util.SysConfigUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 会话
 *
 * @author TengChongChong
 * @date 2020/9/29
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private SaTokenService saTokenService;


    @Override
    public LoginResultVO loginAccount(LoginAccount loginAccount) {

        // 用户名密码校验 & 用户相关检查
        SessionUserVO sessionUserVO = saTokenService.validateAccount(loginAccount);

        // 授权
        saTokenService.setUserPermissions(sessionUserVO);

        SaLoginModel saLoginModel = getSaLoginModel(loginAccount.getDevice(), loginAccount.getRememberMe());

        // 登录
        StpUtil.login(sessionUserVO.getId(), saLoginModel.getDevice());

        // 设置token有效期
        StpUtil.renewTimeout(StpUtil.getTokenValue(), saLoginModel.getTimeout());

        // 登录成功后的一些处理
        afterLogin(sessionUserVO);

        return getLoginResultVO();
    }

    /**
     * 获取SaLoginModel
     *
     * @param device     设备类型
     * @param rememberMe 记住我
     * @return SaLoginModel
     */
    private SaLoginModel getSaLoginModel(String device, boolean rememberMe) {
        SaLoginModel saLoginModel = new SaLoginModel();
        // 此次登录的客户端设备类型, 用于[同端互斥登录]时指定此次登录的设备类型
        saLoginModel.setDevice(device);
        if (rememberMe) {
            // 指定此次登录token的有效期, 单位:秒 （如未指定，自动取全局配置的 timeout 值）
            saLoginModel.setTimeout(60 * 60 * 24 * (Long) SysConfigUtil.get(SysConfigConst.REMEMBER_ME_SESSION_INVALIDATE_TIME));
        } else {
            // 系统参数中是否配置会话有效期
            Long sessionInvalidateTime = (Long) SysConfigUtil.get(SysConfigConst.SESSION_INVALIDATE_TIME);
            if (sessionInvalidateTime != null) {
                saLoginModel.setTimeout(sessionInvalidateTime);
            }
        }
        return saLoginModel;
    }

    @Override
    public LoginResultVO loginQrCode(LoginQrCode loginQrCode) {
        // todo: 待实现
        return null;
    }

    @Override
    public LoginResultVO loginSms(LoginSms loginSms) {
        // todo: 待实现
        return null;
    }

    private LoginResultVO getLoginResultVO() {
        LoginResultVO result = new LoginResultVO();
        result.setAccessToken(StpUtil.getTokenValue());
        result.setAccessTokenExpiresIn(StpUtil.getTokenTimeout());
        return result;
    }

    /**
     * 登录成功后的一些处理
     *
     * @param sessionUser sessionUser
     */
    private void afterLogin(SessionUserVO sessionUser) {

        // 清空登录计数
        RedisUtil.del(RedisPrefix.LOGIN_LOCK + sessionUser.getUsername());

        // 更新最后登录时间
        saTokenService.updateUserLastLoginDate(sessionUser.getId());

        // 登录时间
        sessionUser.setLastLoginDate(new Date());

        // 设置当前登录用户信息
        SessionUtil.setCurrentUser(sessionUser);
    }
}
