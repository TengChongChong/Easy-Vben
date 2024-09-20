package com.easy.admin.auth.service;

import com.easy.admin.auth.model.vo.LoginResultVO;
import com.easy.admin.config.sa.token.model.LoginAccount;
import com.easy.admin.config.sa.token.model.LoginQrCode;
import com.easy.admin.config.sa.token.model.LoginSms;

/**
 * 会话
 *
 * @author TengChongChong
 * @date 2020/9/29
 */
public interface AuthService {

    /**
     * 用户登录 - 用户名+密码
     *
     * @param loginAccount 登录信息
     * @return LoginResultVO
     */
    LoginResultVO loginAccount(LoginAccount loginAccount);

    /**
     * 用户登录 - 扫码
     *
     * @param loginQrCode 登录信息
     * @return LoginResultVO
     */
    LoginResultVO loginQrCode(LoginQrCode loginQrCode);

    /**
     * 用户登录 - 手机号+短信验证码
     *
     * @param loginSms 登录信息
     * @return LoginResultVO
     */
    LoginResultVO loginSms(LoginSms loginSms);

}
