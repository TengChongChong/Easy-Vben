package com.easy.restful.config.shiro.check;

import com.easy.restful.auth.constant.SessionConst;
import com.easy.restful.common.redis.constant.RedisPrefix;
import com.easy.restful.common.redis.util.RedisUtil;
import com.easy.restful.config.shiro.service.ShiroService;
import com.easy.restful.sys.common.constant.SysConst;
import com.easy.restful.sys.model.SysUser;
import com.easy.restful.util.ShiroUtil;
import com.easy.restful.util.file.FileUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 凭证匹配器
 *
 * @author tengchong
 * @date 2018/9/6
 */
public class RetryLimitCredentialsMatcher extends SimpleCredentialsMatcher {

    @Autowired
    private ShiroService shiroService;

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        SysUser sysUser = (SysUser) info.getPrincipals().getPrimaryPrincipal();
        // 清空登录计数
        RedisUtil.del(RedisPrefix.ACCOUNT + "login_count_" + sysUser.getUsername());
        RedisUtil.del(RedisPrefix.ACCOUNT + "login_count_" + sysUser.getEmail());
        RedisUtil.del(RedisPrefix.ACCOUNT + "login_count_" + sysUser.getPhone());
        RedisUtil.del(RedisPrefix.SESSION + "login_count_" + ShiroUtil.getSession().getId().toString());
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
