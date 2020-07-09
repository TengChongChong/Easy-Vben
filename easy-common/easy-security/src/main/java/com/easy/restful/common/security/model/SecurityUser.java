package com.easy.restful.common.security.model;

import cn.hutool.core.lang.Validator;
import com.easy.restful.sys.model.SysUser;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * SecurityUser
 *
 * @author tengchong
 * @date 2020/7/9
 */
public class SecurityUser implements UserDetails, CredentialsContainer {
    /**
     * 当前登录用户
     */
    private final transient SysUser sysUser;
    /**
     * 角色
     */
    private final transient List<String> roles;

    public SecurityUser(SysUser sysUser) {
        this.sysUser = sysUser;
        this.roles = sysUser.getRoles();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if (Validator.isNotEmpty(this.roles)) {
            this.roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return sysUser.getPassword();
    }

    @Override
    public String getUsername() {
        return sysUser.getUsername();
    }

    /**
     * 用户是否可用
     *
     * @return true/false
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * 用户是否未被锁定
     *
     * @return true/false
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 用户是否未过期
     *
     * @return true/false
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 用户凭据是否未过期
     *
     * @return true/false
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 清除凭据
     */
    @Override
    public void eraseCredentials() {
        this.sysUser.setPassword(null);
    }
}
