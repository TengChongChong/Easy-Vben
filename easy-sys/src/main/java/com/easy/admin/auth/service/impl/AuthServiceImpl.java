package com.easy.admin.auth.service.impl;

import cn.hutool.core.convert.Convert;
import com.easy.admin.auth.common.constant.SessionConst;
import com.easy.admin.auth.model.dto.LoginAccountDTO;
import com.easy.admin.auth.model.dto.LoginQrCodeDTO;
import com.easy.admin.auth.model.dto.LoginSmsDTO;
import com.easy.admin.auth.model.vo.session.SessionUserVO;
import com.easy.admin.auth.service.AuthService;
import com.easy.admin.common.redis.constant.RedisPrefix;
import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.config.shiro.authc.EasyAccountAuthenticationToken;
import com.easy.admin.config.shiro.service.ShiroService;
import com.easy.admin.sys.common.constant.SysConfigConst;
import com.easy.admin.util.ShiroUtil;
import com.easy.admin.util.SysConfigUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
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

    @Override
    public Subject loginAccount(LoginAccountDTO loginAccount) {
        Subject subject = SecurityUtils.getSubject();

        // 将登录参数转为 AuthenticationToken
        AuthenticationToken authenticationToken = new EasyAccountAuthenticationToken(loginAccount);

        // 登录
        subject.login(authenticationToken);

        // 是否记住我方式登录
        subject.getSession().setAttribute(SessionConst.REMEMBER_ME, loginAccount.getRememberMe());

        // 登录成功后的一些处理
        afterLogin(subject);

        return subject;
    }

    @Override
    public Subject loginQrCode(LoginQrCodeDTO loginQrCode) {
        // todo: 待实现
        return null;
    }

    @Override
    public Subject loginSms(LoginSmsDTO loginSms) {
        // todo: 待实现
        return null;
    }

    @Override
    public SessionUserVO getCurrentUser() {
        SessionUserVO currentUser = ShiroUtil.getCurrentUser();
        // 如果没有授权,从数据库查询权限
        if (currentUser.getRoleList() == null) {
            shiroService.setUserPermissions(currentUser);
            // 更新会话中用户信息
            ShiroUtil.setAttribute(SessionConst.USER_SESSION_KEY, currentUser);
        }
        return currentUser;
    }

    /**
     * 登录成功后的一些处理
     *
     * @param subject subject
     */
    private void afterLogin(Subject subject) {

        SessionUserVO sessionUser = (SessionUserVO) subject.getPrincipals().getPrimaryPrincipal();

        // 清空登录计数
        RedisUtil.del(RedisPrefix.LOGIN_LOCK + sessionUser.getUsername());

        // 更新最后登录时间
        shiroService.updateUserLastLoginDate(sessionUser.getId());

        // 检查是否允许用户在多处登录，默认false
        if (!Convert.toBool(SysConfigUtil.get(SysConfigConst.LOGIN_MULTIPOINT), false)) {
            shiroService.kickOutSession(sessionUser);
        }

    }
}
