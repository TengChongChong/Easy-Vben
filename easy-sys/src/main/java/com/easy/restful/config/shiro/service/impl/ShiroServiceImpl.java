package com.easy.restful.config.shiro.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.easy.restful.auth.constant.SessionConst;
import com.easy.restful.common.core.common.status.CommonStatus;
import com.easy.restful.common.core.common.status.ResultCode;
import com.easy.restful.common.core.exception.EasyException;
import com.easy.restful.common.core.util.Response;
import com.easy.restful.common.core.util.WebUtils;
import com.easy.restful.common.redis.constant.RedisPrefix;
import com.easy.restful.common.redis.util.RedisUtil;
import com.easy.restful.config.shiro.service.ShiroService;
import com.easy.restful.config.shiro.session.RedisSessionDAO;
import com.easy.restful.exception.BusinessException;
import com.easy.restful.sys.common.constant.SysConst;
import com.easy.restful.sys.common.status.UserStatus;
import com.easy.restful.sys.dao.SysDeptMapper;
import com.easy.restful.sys.dao.SysUserMapper;
import com.easy.restful.sys.model.SysUser;
import com.easy.restful.sys.service.SysDeptTypeService;
import com.easy.restful.sys.service.SysUserRoleService;
import com.easy.restful.util.PasswordUtil;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Shiro 相关接口
 *
 * @author tengchong
 * @date 2020/9/26
 */
@Service
public class ShiroServiceImpl implements ShiroService {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysDeptMapper departmentMapper;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysDeptTypeService sysDeptTypeService;

    @Autowired
    private RedisSessionDAO sessionDAO;

    /**
     * 获取用户剩余尝试次数
     *
     * @param username 用户名
     * @return true/false
     */
    private int getRetryCount(String username) {
        String isLockKey = RedisPrefix.ACCOUNT + "is_lock_" + username;
        // 检查是否已被锁定
        if (checkIsLock(username)) {
            throw new EasyException(Response.SILENT, ResultCode.UNAUTHORIZED.getCode(), "帐号[" + username + "]已被锁定，请" + RedisUtil.getExpire(isLockKey) / 60 + "分钟后重试");
        }
        // 累加尝试次数
        int loginCount = getTrialFrequency(username, true);
        return SysConst.projectProperties.getLoginAttempts() - loginCount;
    }

    /**
     * 检查用户是否因多次密码错误被锁定
     *
     * @param username 用户名
     * @return true/false
     */
    private boolean checkIsLock(String username) {
        String isLockKey = RedisPrefix.ACCOUNT + "is_lock_" + username;
        return RedisUtil.hasKey(isLockKey);
    }

    /**
     * 锁定账号
     *
     * @param username 用户名
     * @return true/false
     */
    private boolean lockUser(String username) {
        String loginCountKey = RedisPrefix.ACCOUNT + "login_count_" + username;
        String isLockKey = RedisPrefix.ACCOUNT + "is_lock_" + username;
        RedisUtil.set(isLockKey, "lock", SysConst.projectProperties.getLoginLockLength());
        RedisUtil.setExpire(loginCountKey, SysConst.projectProperties.getLoginLockLength());
        throw new EasyException(Response.SILENT, ResultCode.UNAUTHORIZED.getCode(), "由于密码输入错误次数过多，帐号[" + username + "]已被锁定" + SysConst.projectProperties.getLoginLockLength() / 60 + "分钟");
    }

    /**
     * 获取尝试登录次数
     *
     * @param username   用户名
     * @param cumulative 是否累加
     * @return 当前第*次尝试登录
     */
    private int getTrialFrequency(String username, boolean cumulative) {
        String loginCountKey = RedisPrefix.ACCOUNT + "login_count_" + username;
        // 登录尝试次数
        return getRedisValue(cumulative, loginCountKey);
    }

    /**
     * 获取尝试登录次数
     *
     * @param sessionId  用户名
     * @param cumulative 是否累加
     * @return 当前第*次尝试登录
     */
    private int getClientTrialFrequency(String sessionId, boolean cumulative) {
        String loginCountKey = RedisPrefix.SESSION + "login_count_" + sessionId;
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
     * 检查验证码
     *
     * @return true/false
     */
    private boolean checkVerificationCode() {
        // 如果开启了验证码验证
        if (SysConst.projectProperties.getLoginVerificationCode()) {
            HttpServletRequest request = WebUtils.getRequest();
            // 检查验证码
            String code = (String) RedisUtil.get(RedisPrefix.VERIFICATION_CODE + request.getAttribute(SessionConst.CODE_ID));
            if (StrUtil.isBlank(code)) {
                // 如果验证码为空，说明验证码过期了，需要刷新验证码
                throw new EasyException(Response.SILENT, "03014", "验证码已过期，请重新输入");
            }
            String receivedCode = (String) request.getAttribute(SessionConst.VERIFICATION_CODE);
            if (StrUtil.isNotBlank(receivedCode)) {
                if (!receivedCode.equalsIgnoreCase(code)) {
                    throw new EasyException(Response.SILENT, "03012", "验证码错误，请重新输入");
                }
            } else {
                throw new EasyException(Response.SILENT, "03013", "请输入验证码");
            }
        }
        return true;
    }

    /**
     * 验证账户
     * 1.检查是否锁定
     * 2.用户名&密码是否匹配
     * 3.账号状态
     * 4.部门状态
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @Override
    public SysUser validateUser(String username, String password) {
        // 检查验证码
        if (checkVerificationCode()) {
            // 检查尝试次数
            int retryCount = getRetryCount(username);
            if (retryCount >= 0) {
                SysUser sysUser = getSysUserByUserName(username);
                // 用户不存在或密码错误
                if (sysUser == null || !PasswordUtil.encryptedPasswords(password, sysUser.getSalt()).equals(sysUser.getPassword())) {
                    if (retryCount > 0) {
                        throw new EasyException(Response.SILENT, ResultCode.UNAUTHORIZED.getCode(), "用户名或密码错误，你还剩" + retryCount + "次重试的机会");
                    } else {
                        lockUser(username);
                    }
                    // 如果不需提示还有多少次机会使用下面提示
                    // throw new EasyException(BusinessException.INVALID_USERNAME_OR_PASSWORD);
                }
                // 账号被禁用
                if (UserStatus.DISABLE.getCode().equals(sysUser.getStatus())) {
                    logger.debug("账号[" + username + "]被禁用");
                    throw new EasyException(Response.SILENT, BusinessException.USER_DISABLED);
                }
                // 查询用户部门信息并验证
                sysUser.setDept(departmentMapper.selectById(sysUser.getDeptId()));
                // 部门被删除
                if (sysUser.getDept() == null) {
                    logger.debug("账号[" + username + "]所在部门[" + sysUser.getDeptName() + "]被删除");
                    throw new EasyException(Response.SILENT, BusinessException.DEPT_NON_EXISTENT);
                }
                // 部门被禁用
                if (CommonStatus.DISABLE.getCode().equals(sysUser.getDept().getStatus())) {
                    logger.debug("账号[" + username + "]所在部门[" + sysUser.getDeptName() + "]被禁用");
                    throw new EasyException(Response.SILENT, BusinessException.DEPT_DISABLED);
                }
                // 检查部门类型是否被禁用
                if (StrUtil.isBlank(sysUser.getDept().getTypeCode())) {
                    throw new EasyException(Response.SILENT, "部门[" + sysUser.getDept().getName() + "]未设置类型，请联系管理员");
                }
                sysDeptTypeService.checkDeptTypeIsDisabled(sysUser.getDept().getTypeCode());

                return sysUser;
            }
        }
        throw new EasyException(Response.SILENT, "未知错误，请联系管理员");
    }

    @Override
    public SysUser getSysUserByUserName(String username) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username).or().eq("email", username).or().eq("phone", username);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public SysUser queryUserPermissions(SysUser sysUser) {
        List<String> permissions = sysUserRoleService.selectPermissionsByUserId(sysUser.getId());

        // str: 添加一些默认权限
        permissions.add("sys:current:user");
        permissions.add("sys:index");
        // end: 添加一些默认权限

        // 设置权限
        sysUser.setPermissionList(permissions);
        // 设置角色
        sysUser.setRoles(sysUserRoleService.selectRoleByUserId(sysUser.getId()));
        // 设置角色id
        sysUser.setRoleIds(sysUserRoleService.selectRoleIdByUserId(sysUser.getId()));
        // 设置角色名称
        sysUser.setRoleNames(sysUserRoleService.selectRoleNameByUserId(sysUser.getId()));
        // 设置菜单
        sysUser.setMenus(sysUserRoleService.selectMenusByUserId(sysUser.getId()));
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
        if (sessions != null && sessions.size() > 0) {
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
        if (loginedSession != null && loginedSession.size() > 0) {
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
