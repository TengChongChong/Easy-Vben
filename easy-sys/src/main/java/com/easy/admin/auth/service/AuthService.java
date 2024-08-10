package com.easy.admin.auth.service;

import com.easy.admin.auth.model.dto.LoginAccountDTO;
import com.easy.admin.auth.model.dto.LoginQrCodeDTO;
import com.easy.admin.auth.model.dto.LoginSmsDTO;
import com.easy.admin.auth.model.vo.session.SessionUserVO;
import org.apache.shiro.subject.Subject;

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
     * @return Subject
     */
    Subject loginAccount(LoginAccountDTO loginAccount);

    /**
     * 用户登录 - 扫码
     *
     * @param loginQrCode 登录信息
     * @return Subject
     */
    Subject loginQrCode(LoginQrCodeDTO loginQrCode);

    /**
     * 用户登录 - 手机号+短信验证码
     *
     * @param loginSms 登录信息
     * @return Subject
     */
    Subject loginSms(LoginSmsDTO loginSms);

    /**
     * 获取当前登录用户
     *
     * @return SessionUserVO
     */
    SessionUserVO getCurrentUser();
}
