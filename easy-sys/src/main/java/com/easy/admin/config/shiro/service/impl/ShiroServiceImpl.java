package com.easy.admin.config.shiro.service.impl;

import cn.hutool.core.util.StrUtil;
import com.easy.admin.auth.common.constant.SessionConst;
import com.easy.admin.auth.common.status.SysUserStatus;
import com.easy.admin.auth.dao.SysDeptMapper;
import com.easy.admin.auth.dao.SysUserMapper;
import com.easy.admin.auth.model.SysUser;
import com.easy.admin.auth.service.SysDeptTypeService;
import com.easy.admin.auth.service.SysUserRoleService;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.common.status.ResultCode;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.util.Response;
import com.easy.admin.common.redis.constant.RedisPrefix;
import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.config.shiro.service.ShiroService;
import com.easy.admin.config.shiro.session.RedisSessionDAO;
import com.easy.admin.exception.BusinessException;
import com.easy.admin.sys.common.constant.SysConst;
import com.easy.admin.util.PasswordUtil;
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
    private SysUserMapper userMapper;

    @Autowired
    private SysDeptMapper deptMapper;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysDeptTypeService sysDeptTypeService;

    @Autowired
    private RedisSessionDAO sessionDAO;

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
            throw new EasyException(Response.SHOW_TYPE_WARNING, ResultCode.UNAUTHORIZED.getCode(), "帐号[" + username + "]已被锁定，请" + RedisUtil.getExpire(isLockKey) / 60 + "分钟后重试");
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
        throw new EasyException(Response.SHOW_TYPE_WARNING, ResultCode.UNAUTHORIZED.getCode(), "由于密码输入错误次数过多，帐号[" + username + "]已被锁定" + SysConst.projectProperties.getLoginLockLength() / 60 + "分钟");
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

    /**
     * 验证账户
     * 1.检查是否锁定
     * 2.账号&密码是否匹配
     * 3.账号状态
     * 4.部门状态
     *
     * @param username 账号
     * @param password 密码
     * @return SysUser
     */
    @Override
    public SysUser validateUser(String username, String password) {
        // 检查尝试次数
        int retryCount = getRetryCount(username);
        SysUser sysUser = getSysUserByUserName(username);
        // 用户不存在或密码错误
        if (sysUser == null || !PasswordUtil.encryptedPasswords(password, sysUser.getSalt()).equals(sysUser.getPassword())) {
            if (retryCount > 0) {
                throw new EasyException(Response.SHOW_TYPE_WARNING, ResultCode.UNAUTHORIZED.getCode(), "账号或密码错误，你还剩" + retryCount + "次重试的机会");
            } else {
                lockUser(username);
            }
            // 如果不需提示还有多少次机会使用下面提示
            // throw new EasyException(BusinessException.INVALID_USERNAME_OR_PASSWORD);
        }
        // 账号被禁用
        if (SysUserStatus.DISABLE.getCode().equals(sysUser.getStatus())) {
            logger.debug("账号[{}]被禁用", username);
            throw new EasyException(Response.SHOW_TYPE_WARNING, BusinessException.USER_DISABLED);
        }
        // 查询用户部门信息并验证
        sysUser.setDept(deptMapper.selectById(sysUser.getDeptId()));
        // 部门被删除
        if (sysUser.getDept() == null) {
            logger.debug("账号[{}]所在部门[{}]被删除", username, sysUser.getDeptId());
            throw new EasyException(Response.SHOW_TYPE_WARNING, BusinessException.DEPT_NON_EXISTENT);
        }
        // 部门被禁用
        if (CommonStatus.DISABLE.getCode().equals(sysUser.getDept().getStatus())) {
            logger.debug("账号[{}]所在部门[{}]被禁用", username, sysUser.getDept().getName());
            throw new EasyException(Response.SHOW_TYPE_WARNING, BusinessException.DEPT_DISABLED);
        }
        // 检查部门类型是否被禁用
        if (StrUtil.isBlank(sysUser.getDept().getTypeCode())) {
            throw new EasyException(Response.SHOW_TYPE_WARNING, "部门[" + sysUser.getDept().getName() + "]未设置类型，请联系管理员");
        }
        sysDeptTypeService.checkDeptTypeIsDisabled(sysUser.getDept().getTypeCode());

        return sysUser;
    }

    @Override
    public SysUser getSysUserByUserName(String username) {
        return userMapper.getSysUserByUserName(username);
    }

    @Override
    public SysUser queryUserPermissions(SysUser sysUser) {
        // 设置角色
        sysUser.setRoleList(sysUserRoleService.selectRoleByUserId(sysUser.getId()));

        // 设置菜单
        sysUser.setPermissionList(sysUserRoleService.selectPermissionByUserId(sysUser.getId()));
        return sysUser;
    }

    @Override
    public void updateUserLastLoginDate(String userId) {
        userMapper.updateUserLastLoginDate(userId, new Date());
    }

    /**
     * 根据会话获取相同账号会话
     *
     * @param user 正在登录的用户
     * @return List<Session>
     */
    @Override
    public List<Session> getLoginedSession(SysUser user) {
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        if (sessions != null && !sessions.isEmpty()) {
            List<Session> loginedSession = new ArrayList<>();
            for (Session session : sessions) {
                // 有效session
                if (checkSessionEffective(session)) {
                    SysUser sysUser = (SysUser) session.getAttribute(SessionConst.USER_SESSION_KEY);
                    if (sysUser != null && sysUser.getUsername().equals(user.getUsername())) {
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
     * @param user 正在登录的用户
     * @return true/false
     */
    @Override
    public boolean kickOutSession(SysUser user) {
        List<Session> loginedSession = getLoginedSession(user);
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
}
