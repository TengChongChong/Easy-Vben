package com.easy.restful.common.security.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.easy.restful.common.core.common.status.ResultCode;
import com.easy.restful.common.security.common.response.Access;
import com.easy.restful.common.security.common.response.Dept;
import com.easy.restful.common.security.constant.JwtConst;
import com.easy.restful.common.security.exception.EasyLoginAccessException;
import com.easy.restful.common.security.exception.EasyLoginDeptException;
import com.easy.restful.common.security.exception.EasyLoginException;
import com.easy.restful.common.security.exception.EasyTokenException;
import com.easy.restful.common.security.model.SecurityUser;
import com.easy.restful.common.security.model.Token;
import com.easy.restful.common.security.service.AuthService;
import com.easy.restful.common.security.util.JwtTokenUtils;
import com.easy.restful.sys.model.SysUser;
import com.easy.restful.sys.service.SysDeptService;
import com.easy.restful.sys.service.SysUserRoleService;
import com.easy.restful.sys.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 登录
 *
 * @author tengchong
 * @date 2020/7/8
 */
@Service
public class AuthServiceImpl implements AuthService {
    private final static Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysDeptService sysDeptService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private JwtTokenUtils jwtTokenUtils;

    @Override
    public SysUser getUserInfo() {
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();

        return securityUser.getSysUser();
    }

    @Override
    public Token login(String username, String password) {
        if(StrUtil.isBlank(username)){
            throw new EasyLoginException(ResultCode.INTERNAL_SERVER_ERROR.getCode(), "用户名不能为空");
        }
        if(StrUtil.isBlank(password)){
            throw new EasyLoginException(ResultCode.INTERNAL_SERVER_ERROR.getCode(), "密码不能为空");
        }
        SecurityUser userDetails = getUserByUsername(username);

        // 检查用户名与密码是否匹配
        checkPassword(userDetails, username, password);
        // 检查用户状态
        checkAccount(userDetails);
        // 查询部门
        if (StrUtil.isNotBlank(userDetails.getSysUser().getDeptId())) {
            userDetails.getSysUser().setDept(sysDeptService.getById(userDetails.getSysUser().getDeptId()));
        }
        checkDept(userDetails);
        // 授权
        userDetails.getSysUser().setRoles(sysUserRoleService.selectUserRoleCodesByUserId(userDetails.getSysUser().getId()));

        return new Token(
                // 认证 Token
                jwtTokenUtils.generateToken(userDetails, JwtConst.ACCESS_TOKEN),
                // 用于刷新"认证 Token"的Token
                jwtTokenUtils.generateToken(userDetails, JwtConst.REFRESH_TOKEN)
        );
    }

    /**
     * 检查用户名与密码是否匹配
     *
     * @param userDetails 用户
     * @param username    用户名
     * @param password    密码
     */
    private void checkPassword(SecurityUser userDetails, String username, String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            // 密码错误
            logger.debug("[登录失败] - 用户[{}]密码错误", username);
            throw new EasyLoginAccessException(Access.PASSWORD_ERROR);
        }
    }

    /**
     * 检查用户状态
     *
     * @param userDetails 用户
     */
    private void checkAccount(SecurityUser userDetails) {
        if (!userDetails.isAccountNonExpired()) {
            logger.debug("[登录失败] - 用户[{}]用户过期", userDetails.getUsername());
            throw new EasyLoginAccessException(Access.ACCOUNT_EXPIRED);
        }
        if (!userDetails.isCredentialsNonExpired()) {
            // 密码过期
            logger.debug("[登录失败] - 用户[{}]密码过期", userDetails.getUsername());
            throw new EasyLoginAccessException(Access.PASSWORD_EXPIRED);
        }
        if (!userDetails.isEnabled()) {
            // 用户被禁用
            logger.debug("[登录失败] - 用户[{}]被禁用", userDetails.getUsername());
            throw new EasyLoginAccessException(Access.DISABLED);
        }
        if (!userDetails.isAccountNonLocked()) {
            // 用户被锁定
            logger.debug("[登录失败] - 用户[{}]被锁定", userDetails.getUsername());
            throw new EasyLoginAccessException(Access.LOCKED);
        }
    }

    /**
     * 检查部门
     *
     * @param userDetails 用户
     */
    private void checkDept(SecurityUser userDetails) {
        if (userDetails.getSysUser().getDept() == null) {
            // 部门不存在
            logger.debug("[登录失败] - 部门[{}]不存在", userDetails.getSysUser().getDeptId());
            throw new EasyLoginDeptException(Dept.NOT_FIND);
        }
        if (!userDetails.getSysUser().getDept().isEnabled()) {
            // 部门被禁用
            logger.debug("[登录失败] - 部门[{}]被禁用", userDetails.getSysUser().getDept().getName());
            throw new EasyLoginDeptException(Dept.DISABLE);
        }
    }

    @Override
    public Token refreshToken(String refreshToken) {
        // 过期会抛出ExpiredJwtException，所以这里不做判断
        jwtTokenUtils.isTokenExpired(refreshToken);

        String username = jwtTokenUtils.getUsernameFromToken(refreshToken);
        SecurityUser securityUser = getUserByUsername(username);

        // 检查用户状态
        checkAccount(securityUser);

        // 检查用户名与与用户ID是否匹配
        if (jwtTokenUtils.getUserIdFromToken(refreshToken).equals(securityUser.getSysUser().getId())) {
            throw new EasyTokenException(com.easy.restful.common.security.common.response.Token.INVALID);
        }
        return new Token(
                // 认证 Token
                jwtTokenUtils.generateToken(securityUser, JwtConst.ACCESS_TOKEN),
                // 如果开启自动刷新Refresh Token，将在Refresh Token即将过期的时候（20分钟）下发新的Refresh Token
                JwtConst.AUTO_REFRESH_REFRESH_TOKEN && checkRefreshTokenExpirationTime(refreshToken) ?
                        refreshToken : jwtTokenUtils.generateToken(securityUser, JwtConst.REFRESH_TOKEN)
        );
    }

    /**
     * 根据用户名|手机号|邮箱获取用户
     *
     * @param username 用户名|手机号|邮箱
     * @return SecurityUser
     */
    private SecurityUser getUserByUsername(String username) {
        // 可使用 用户名|手机号|邮箱 登录
        SysUser sysUser = sysUserService.getUserByAccount(username);
        if (sysUser == null) {
            throw new EasyLoginAccessException(Access.ACCOUNT_NOT_FIND);
        }
        return new SecurityUser(sysUser);
    }

    /**
     * Token有效期是否大于20分钟
     *
     * @param refreshToken token
     * @return true/false
     */
    private boolean checkRefreshTokenExpirationTime(String refreshToken) {
        return jwtTokenUtils.getExpirationDateFromToken(refreshToken).getTime() > DateUtil.offsetMinute(new Date(), 20).getTime();
    }
}
