package com.easy.admin.auth.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.easy.admin.auth.common.constant.SessionConst;
import com.easy.admin.auth.model.SysUser;
import com.easy.admin.auth.service.AuthService;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.redis.constant.RedisPrefix;
import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.config.shiro.service.ShiroService;
import com.easy.admin.sys.common.constant.SysConfigConst;
import com.easy.admin.sys.model.LoginVO;
import com.easy.admin.sys.service.SysCaptchaService;
import com.easy.admin.util.ShiroUtil;
import com.easy.admin.util.SysConfigUtil;
import com.easy.admin.util.file.FileUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 会话
 *
 * @author TengChongChong
 * @date 2020/9/29
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private ShiroService shiroService;

    @Autowired
    private SysCaptchaService service;

    @Override
    public Subject login(LoginVO loginVO) {
        Subject subject = SecurityUtils.getSubject();
        // 如果已登录，表示调用此方法是为了解除锁屏，则不验证验证码
        if (!subject.isAuthenticated()) {
            // 检查验证码
            captchaVerification(loginVO.getCaptchaVerification());
        }

        UsernamePasswordToken token = new UsernamePasswordToken(loginVO.getUsername(), loginVO.getPassword(), loginVO.getRememberMe() != null && loginVO.getRememberMe());
        subject.login(token);

        SysUser sysUser = (SysUser) subject.getPrincipals().getPrimaryPrincipal();
        // 清空登录计数
        RedisUtil.del(RedisPrefix.LOGIN_LOCK + loginVO.getUsername());

        // 是否为记住我
        if (loginVO.getRememberMe() == null) {
            loginVO.setRememberMe(false);
        }
        subject.getSession().setAttribute(SessionConst.REMEMBER_ME, loginVO.getRememberMe());

        // 更新最后登录时间
        shiroService.updateUserLastLoginDate(sysUser.getId());
        // 检查是否允许用户在多处登录，默认false
        if (!Convert.toBool(SysConfigUtil.get(SysConfigConst.LOGIN_MULTIPOINT), false)) {
            shiroService.kickOutSession(sysUser);
        }
        // 用户信息放在session里
        ShiroUtil.setAttribute(SessionConst.USER_SESSION_KEY, FileUtil.initAvatar(sysUser));
        return subject;
    }

    /**
     * 检查登录验证码
     *
     * @param code code
     */
    private void captchaVerification(String code) {
        Boolean loginVerificationCode = (Boolean) SysConfigUtil.get(SysConfigConst.LOGIN_VERIFICATION_CODE);
        if (!loginVerificationCode) {
            return;
        }
        if (StrUtil.isBlank(code)) {
            throw new EasyException("获取验证码数据失败，请重试");
        }
        if (!service.verification(code)) {
            throw new EasyException("验证码无效，请重试");
        }

    }
}
