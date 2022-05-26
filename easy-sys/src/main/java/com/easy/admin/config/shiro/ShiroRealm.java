package com.easy.admin.config.shiro;

import com.easy.admin.config.shiro.service.ShiroService;
import com.easy.admin.auth.model.SysUser;
import com.easy.admin.util.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义 Realm
 *
 * @author TengChongChong
 * @date 2018/9/4
 */
public class ShiroRealm extends AuthorizingRealm {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ShiroService shiroService;

    /**
     * 认证
     *
     * @param authenticationToken token
     * @return AuthenticationInfo
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) {
        logger.debug("=============> 认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        SysUser sysUser = shiroService.validateUser(token.getUsername(), String.valueOf(token.getPassword()));
        return new SimpleAuthenticationInfo(sysUser, sysUser.getPassword().toCharArray(), ByteSource.Util.bytes(sysUser.getSalt()), getName());
    }

    /**
     * 授权
     *
     * @param principalCollection principal
     * @return AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.debug("=============> 授权");
        // 当前登录用户
        SysUser currentUser = (SysUser) principalCollection.getPrimaryPrincipal();
        Subject subject = SecurityUtils.getSubject();
        if (subject.isRemembered()) {
            // 如果通过记住密码方式登录,从数据库中重新查询用户信息,防止用户信息变更cookie里保存的信息是旧的
            SysUser dbUser = shiroService.getSysUserByUserName(currentUser.getUsername());
            if (dbUser == null) {
                subject.logout();
            }
        }
        // 由于修改用户角色或者修改角色权限导致权限变动,所以每次授权都要重新查询
        SysUser sysUser = shiroService.queryUserPermissions(currentUser);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        // 赋予权限
        simpleAuthorizationInfo.addStringPermissions(ShiroUtil.getPermissionCodes(sysUser.getPermissionList()));
        // 赋予角色
        simpleAuthorizationInfo.addRoles(ShiroUtil.getRoleCodes(sysUser.getRoleList()));
        ShiroUtil.setCurrentUser(sysUser);
        return simpleAuthorizationInfo;
    }
}
