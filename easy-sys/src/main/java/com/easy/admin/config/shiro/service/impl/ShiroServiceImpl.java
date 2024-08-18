package com.easy.admin.config.shiro.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.easy.admin.auth.common.constant.SessionConst;
import com.easy.admin.auth.common.status.SysUserStatus;
import com.easy.admin.auth.model.vo.SysRoleCacheVO;
import com.easy.admin.auth.model.vo.route.RouteVO;
import com.easy.admin.auth.model.vo.session.SessionDeptVO;
import com.easy.admin.auth.model.vo.session.SessionUserRoleVO;
import com.easy.admin.auth.model.vo.session.SessionUserVO;
import com.easy.admin.auth.service.*;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.common.status.ResultCode;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.redis.constant.RedisPrefix;
import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.config.shiro.authc.EasyAccountAuthenticationToken;
import com.easy.admin.config.shiro.service.ShiroService;
import com.easy.admin.config.shiro.session.RedisSessionDAO;
import com.easy.admin.exception.BusinessException;
import com.easy.admin.file.model.FileInfo;
import com.easy.admin.file.service.FileInfoService;
import com.easy.admin.sys.common.constant.SysConfigConst;
import com.easy.admin.sys.common.constant.SysConst;
import com.easy.admin.sys.service.SysCaptchaService;
import com.easy.admin.util.PasswordUtil;
import com.easy.admin.util.SysConfigUtil;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Shiro 相关接口
 *
 * @author TengChongChong
 * @date 2020/9/26
 */
@Service
public class ShiroServiceImpl implements ShiroService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysDeptService sysDeptService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysDeptTypeService sysDeptTypeService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private RedisSessionDAO sessionDAO;

    @Autowired
    private FileInfoService fileInfoService;

    /**
     * 验证码
     */
    @Autowired
    private SysCaptchaService sysCaptchaService;

    /**
     * 账号密码认证
     * 1.检查是否锁定
     * 2.账号&密码是否匹配
     * 3.账号状态
     * 4.部门状态
     *
     * @param authenticationToken authenticationToken
     * @return SessionUserVO
     */
    @Override
    public SessionUserVO validateAccountAuthenticationToken(EasyAccountAuthenticationToken authenticationToken) {

        // 验证验证码
        captchaVerification(authenticationToken.getCaptchaVerification());

        SessionUserVO sessionUser = getSysUserByUserName(authenticationToken.getUsername());
        if (sessionUser == null) {
            accountAuthenticationTokenFail(authenticationToken.getUsername());
        }
        // 密码是否正确
        boolean passwordMismatch = PasswordUtil.encryptedPasswords(authenticationToken.getPassword(), sessionUser.getSalt()).equals(sessionUser.getPassword());
        if (!passwordMismatch) {
            accountAuthenticationTokenFail(authenticationToken.getUsername());
        }

        // 账号被禁用
        if (SysUserStatus.DISABLE.getCode().equals(sessionUser.getStatus())) {
            logger.debug("账号[{}]被禁用", authenticationToken.getUsername());
            throw new EasyException(BusinessException.USER_DISABLED);
        }

        // 获取当前登录用户部门信息
        SessionDeptVO sessionDept = getUserDept(sessionUser.getDeptId(), sessionUser.getUsername());
        sessionUser.setDept(sessionDept);

        // 用户头像
        FileInfo avatarFile = fileInfoService.selectOne(sessionUser.getId(), "avatar");
        if (avatarFile != null) {
            sessionUser.setAvatar(avatarFile.getUrl());
        }

        return sessionUser;
    }

    /**
     * 获取当前登录用户部门信息
     *
     * @param deptId 部门id
     * @return SessionDeptVO
     */
    private SessionDeptVO getUserDept(String deptId, String username) {
        SessionDeptVO sessionDept = sysDeptService.getSessionDeptById(deptId);

        // 部门被删除
        if (sessionDept == null) {
            logger.debug("账号[{}]所在部门[{}]被删除", username, deptId);
            throw new EasyException(BusinessException.DEPT_NON_EXISTENT);
        }

        // 部门被禁用
        if (CommonStatus.DISABLE.getCode().equals(sessionDept.getStatus())) {
            logger.debug("账号[{}]所在部门[{}]被禁用", username, sessionDept.getName());
            throw new EasyException(BusinessException.DEPT_DISABLED);
        }

        // 检查部门类型是否被禁用
        if (StrUtil.isBlank(sessionDept.getTypeCode())) {
            throw new EasyException("部门[" + sessionDept.getName() + "]未设置类型，请联系管理员");
        }
        sysDeptTypeService.checkDeptTypeIsDisabled(sessionDept.getTypeCode());

        return sessionDept;
    }

    @Override
    public SessionUserVO getSysUserByUserName(String username) {
        return sysUserService.getSessionUserByUserName(username);
    }

    @Override
    public void setUserPermissions(SessionUserVO sessionUser) {

        // 用户角色
        sessionUser.setRoleList(sysUserRoleService.selectRoleByUserId(sessionUser.getId()));

        // 用户菜单，为避免放到SessionUserVO中频繁序列化，放到redis中，仅在用户首次加载页面时获取
        List<RouteVO> routeList = new ArrayList<>();
        List<String> roleCodeList = new ArrayList<>();
        List<String> permissionCodeList = new ArrayList<>();
        permissionCodeList.add("auth:current:user");

        if (sessionUser.getRoleList() != null && !sessionUser.getRoleList().isEmpty()) {
            // 用户数据权限
            sessionUser.setDataPermissionList(sysRoleService.convertToDataPermission(sessionUser.getRoleList()));
            // 遍历角色获取角色标识、权限标识、路由
            for (SessionUserRoleVO role : sessionUser.getRoleList()) {
                SysRoleCacheVO sysRoleCache = sysRoleService.getSysRoleCache(role.getId());
                if (sysRoleCache != null) {
                    roleCodeList.add(sysRoleCache.getCode());
                    permissionCodeList.addAll(sysRoleCache.getPermissionCodeList());
                    routeList.addAll(sysRoleCache.getRouteList());
                }
            }
            if (sessionUser.getRoleList().size() > 1) {
                // 如果有多个角色，对角色标识、权限标识、路由去重
                roleCodeList = CollUtil.distinct(roleCodeList);
                permissionCodeList = CollUtil.distinct(permissionCodeList);
                routeList = CollUtil.distinct(routeList, RouteVO::getId, false);
            }
        }
        // 角色标识
        sessionUser.setRoleCodeList((roleCodeList));
        // 权限标识
        sessionUser.setPermissionCodeList(CollUtil.distinct(permissionCodeList));
        // 用户路由集合
        sessionUser.setRouteList(routeList);
    }
    
    @Override
    public void updateUserLastLoginDate(String userId) {
        sysUserService.updateUserLastLoginDate(userId, new Date());
    }

    /**
     * 根据会话获取相同账号会话
     *
     * @param sessionUser 正在登录的用户
     * @return List<Session>
     */
    @Override
    public List<Session> getLoginedSession(SessionUserVO sessionUser) {
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        if (sessions != null && !sessions.isEmpty()) {
            List<Session> loginedSession = new ArrayList<>();
            for (Session session : sessions) {
                // 有效session
                if (checkSessionEffective(session)) {
                    SessionUserVO sysUser = (SessionUserVO) session.getAttribute(SessionConst.USER_SESSION_KEY);
                    if (sysUser != null && sysUser.getUsername().equals(sessionUser.getUsername())) {
                        loginedSession.add(session);
                    }
                }
            }
            return loginedSession;
        }
        return null;
    }

    /**
     * 根据会话踢出相同账号其他会话
     *
     * @param sessionUser 正在登录的用户
     * @return true/false
     */
    @Override
    public boolean kickOutSession(SessionUserVO sessionUser) {
        List<Session> loginedSession = getLoginedSession(sessionUser);
        if (loginedSession != null && !loginedSession.isEmpty()) {
            for (Session session : loginedSession) {
                session.setAttribute(SessionConst.LOGIN_ELSEWHERE, true);
                sessionDAO.update(session);
            }
            return true;
        }
        return false;
    }

    /**
     * 检查session有效性
     *
     * @param session
     * @return
     */
    private boolean checkSessionEffective(Session session) {
        return session.getAttribute(SessionConst.FORCE_LOGOUT) == null && session.getAttribute(SessionConst.LOGIN_ELSEWHERE) == null;
    }

    /**
     * 用户名密码认证失败
     *
     * @param username 用户名
     */
    private void accountAuthenticationTokenFail(String username) {
        // 检查尝试次数
        int retryCount = getRetryCount(username);
        if (retryCount > 0) {
            throw new EasyException(ResultCode.UNAUTHORIZED.getCode(), "账号或密码错误，你还剩" + retryCount + "次重试的机会");
        } else {
            lockUser(username);
        }
    }

    /**
     * 检查登录验证码
     *
     * @param captchaVerification captchaVerification
     */
    private void captchaVerification(String captchaVerification) {
        // 是否开启验证码
        Boolean loginVerificationCode = (Boolean) SysConfigUtil.get(SysConfigConst.LOGIN_VERIFICATION_CODE);
        if (!loginVerificationCode) {
            return;
        }
        if (StrUtil.isBlank(captchaVerification)) {
            throw new EasyException("获取验证码数据失败，请重试");
        }
        if (!sysCaptchaService.verification(captchaVerification)) {
            throw new EasyException("验证码无效，请重试");
        }
    }

    /**
     * 获取用户剩余尝试次数
     *
     * @param username 账号
     * @return true/false
     */
    private int getRetryCount(String username) {
        String isLockKey = RedisPrefix.LOGIN_LOCK + username;
        // 检查是否已被锁定
        if (checkIsLock(username)) {
            throw new EasyException(ResultCode.UNAUTHORIZED.getCode(), "帐号[" + username + "]已被锁定，请" + RedisUtil.getExpire(isLockKey) / 60 + "分钟后重试");
        }
        // 累加尝试次数
        int loginCount = getTrialFrequency(username, true);
        return SysConst.projectProperties.getLoginAttempts() - loginCount;
    }

    /**
     * 检查用户是否因多次密码错误被锁定
     *
     * @param username 账号
     * @return true/false
     */
    private boolean checkIsLock(String username) {
        String isLockKey = RedisPrefix.LOGIN_LOCK + username;
        return RedisUtil.hasKey(isLockKey);
    }

    /**
     * 锁定账号
     *
     * @param username 账号
     * @return true/false
     */
    private boolean lockUser(String username) {
        String loginCountKey = RedisPrefix.LOGIN_ATTEMPT + username;
        String isLockKey = RedisPrefix.LOGIN_LOCK + username;
        RedisUtil.set(isLockKey, "lock", SysConst.projectProperties.getLoginLockLength());
        RedisUtil.setExpire(loginCountKey, SysConst.projectProperties.getLoginLockLength());
        throw new EasyException(ResultCode.UNAUTHORIZED.getCode(), "由于密码输入错误次数过多，帐号[" + username + "]已被锁定" + SysConst.projectProperties.getLoginLockLength() / 60 + "分钟");
    }

    /**
     * 获取尝试登录次数
     *
     * @param username   账号
     * @param cumulative 是否累加
     * @return 当前第*次尝试登录
     */
    private int getTrialFrequency(String username, boolean cumulative) {
        String loginCountKey = RedisPrefix.LOGIN_ATTEMPT + username;
        // 登录尝试次数
        return getRedisValue(cumulative, loginCountKey);
    }

    /**
     * 从redis中获取值
     *
     * @param cumulative    是否累加
     * @param loginCountKey key
     * @return value
     */
    private int getRedisValue(boolean cumulative, String loginCountKey) {
        int loginCount = 0;
        if (RedisUtil.hasKey(loginCountKey)) {
            loginCount = Integer.parseInt(String.valueOf(RedisUtil.get(loginCountKey)));
        }
        if (cumulative) {
            loginCount++;
        }
        RedisUtil.set(loginCountKey, loginCount);
        return loginCount;
    }
}
