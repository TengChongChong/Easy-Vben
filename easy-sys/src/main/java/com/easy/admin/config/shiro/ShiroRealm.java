package com.easy.admin.config.shiro;

import com.easy.admin.auth.model.vo.session.SessionUserVO;
import com.easy.admin.config.shiro.authc.EasyAccountAuthenticationToken;
import com.easy.admin.config.shiro.service.ShiroService;
import com.easy.admin.util.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
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
        EasyAccountAuthenticationToken accountAuthenticationToken = (EasyAccountAuthenticationToken) authenticationToken;
        SessionUserVO sessionUser = shiroService.validateAccountAuthenticationToken(accountAuthenticationToken);
        return new SimpleAuthenticationInfo(sessionUser, sessionUser.getPassword().toCharArray(), ByteSource.Util.bytes(sessionUser.getSalt()), getName());
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
        SessionUserVO currentUser = (SessionUserVO) principalCollection.getPrimaryPrincipal();
        Subject subject = SecurityUtils.getSubject();
        if (subject.isRemembered()) {
            // 如果通过记住密码方式登录,从数据库中重新查询用户信息,防止用户信息变更cookie里保存的信息是旧的
            SessionUserVO sessionUser = shiroService.getSysUserByUserName(currentUser.getUsername());
            if (sessionUser == null) {
                subject.logout();
            }
        }

        // 由于修改用户角色或者修改角色权限导致权限变动,所以每次授权都要重新查询
        shiroService.setUserPermissions(currentUser);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        // 赋予权限标识
        simpleAuthorizationInfo.addStringPermissions(currentUser.getPermissionCodeList());

        // 赋予角色标识
        simpleAuthorizationInfo.addRoles(currentUser.getRoleCodeList());

        ShiroUtil.setCurrentUser(currentUser);
        return simpleAuthorizationInfo;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof EasyAccountAuthenticationToken;
    }
}
