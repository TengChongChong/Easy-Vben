package com.easy.admin.config.shiro.check;

import com.easy.admin.auth.constant.SessionConst;
import com.easy.admin.common.redis.constant.RedisPrefix;
import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.config.shiro.service.ShiroService;
import com.easy.admin.sys.common.constant.SysConst;
import com.easy.admin.sys.model.SysUser;
import com.easy.admin.util.ShiroUtil;
import com.easy.admin.util.file.FileUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 凭证匹配器
 *
 * @author TengChongChong
 * @date 2018/9/6
 */
public class RetryLimitCredentialsMatcher extends SimpleCredentialsMatcher {

    @Autowired
    private ShiroService shiroService;

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        SysUser sysUser = (SysUser) info.getPrincipals().getPrimaryPrincipal();
        // 清空登录计数
        String loginCountKey = "login_count_";
        RedisUtil.del(RedisPrefix.ACCOUNT + loginCountKey + sysUser.getUsername());
        RedisUtil.del(RedisPrefix.ACCOUNT + loginCountKey + sysUser.getEmail());
        RedisUtil.del(RedisPrefix.ACCOUNT + loginCountKey + sysUser.getPhone());
        RedisUtil.del(RedisPrefix.SESSION + loginCountKey + ShiroUtil.getSession().getId().toString());
        // 更新最后登录时间
        shiroService.updateUserLastLoginDate(sysUser.getId());
        // 检查是否允许用户在多处登录
        if (!SysConst.projectProperties.getLoginMultipoint()) {
            shiroService.kickOutSession(sysUser);
        }
        // 用户信息放在session里
        ShiroUtil.setAttribute(SessionConst.USER_SESSION_KEY, FileUtil.initAvatar(sysUser));
        return true;
    }
}
