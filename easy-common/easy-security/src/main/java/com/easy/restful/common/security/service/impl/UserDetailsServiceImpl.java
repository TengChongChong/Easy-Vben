package com.easy.restful.common.security.service.impl;

import com.easy.restful.common.core.exception.GlobalException;
import com.easy.restful.common.security.model.SecurityUser;
import com.easy.restful.sys.model.SysUser;
import com.easy.restful.sys.service.SysUserRoleService;
import com.easy.restful.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 自定义UserService
 *
 * @author tengchong
 * @date 2020/7/8
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 可使用 用户名|手机号|邮箱 登录
        SysUser sysUser = sysUserService.getUserByAccount(username);
        if (sysUser == null) {
            // 用户不存在
            throw new UsernameNotFoundException(GlobalException.USERNAME_NOT_FOUND.getMessage());
        }
        // 设置角色
        sysUser.setRoles(sysUserRoleService.selectUserRoleCodesByUserId(sysUser.getId()));
        return new SecurityUser(sysUser);
    }
}
