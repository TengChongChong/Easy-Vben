package com.easy.restful.sys.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.restful.auth.constant.SessionConst;
import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.common.core.constant.CommonConst;
import com.easy.restful.common.core.exception.EasyException;
import com.easy.restful.common.redis.constant.RedisPrefix;
import com.easy.restful.common.redis.util.RedisUtil;
import com.easy.restful.config.shiro.service.ShiroService;
import com.easy.restful.exception.BusinessException;
import com.easy.restful.sys.common.constant.SexConst;
import com.easy.restful.sys.common.constant.SysConfigConst;
import com.easy.restful.sys.common.constant.SysConst;
import com.easy.restful.sys.common.status.UserStatus;
import com.easy.restful.sys.dao.SysUserMapper;
import com.easy.restful.sys.model.SysUser;
import com.easy.restful.sys.service.SysDeptService;
import com.easy.restful.sys.service.SysUserRoleService;
import com.easy.restful.sys.service.SysUserService;
import com.easy.restful.util.PasswordUtil;
import com.easy.restful.util.ShiroUtil;
import com.easy.restful.util.SysConfigUtil;
import com.easy.restful.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 用户管理
 *
 * @author tengchong
 * @date 2018/12/25
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private ShiroService shiroService;

    @Autowired
    private SysDeptService sysDeptService;


    @Override
    public Page<SysUser> select(SysUser sysUser, Page<SysUser> page) {
        if (sysUser == null || StrUtil.isBlank(sysUser.getDeptId())) {
            // 不允许查询所有部门用户数据
            return null;
        }

        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        if (Validator.isNotEmpty(sysUser.getUsername())) {
            queryWrapper.like("username", sysUser.getUsername());
        }
        if (Validator.isNotEmpty(sysUser.getNickname())) {
            queryWrapper.like("nickname", sysUser.getNickname());
        }
        if (Validator.isNotEmpty(sysUser.getSex())) {
            queryWrapper.eq("sex", sysUser.getSex());
        }
        if (Validator.isNotEmpty(sysUser.getStatus())) {
            queryWrapper.eq("status", sysUser.getStatus());
        }
        if (Validator.isNotEmpty(sysUser.getPhone())) {
            queryWrapper.like("phone", sysUser.getPhone());
        }
        if (Validator.isNotEmpty(sysUser.getSource())) {
            queryWrapper.eq("source", sysUser.getSource());
        }
        if (Validator.isNotEmpty(sysUser.getDeptId())) {
            queryWrapper.eq("dept_id", sysUser.getDeptId());
        }
        return page(page, queryWrapper);
    }

    @Override
    public Page<SysUser> search(String keyword, Page<SysUser> page) {
        if (StrUtil.isBlank(keyword)) {
            throw new EasyException("请输入关键字");
        }
        page.setRecords(getBaseMapper().search(page, UserStatus.ENABLE.getCode(), "%" + keyword + "%"));
        return page;
    }

    @Override
    public SysUser get(String id) {
        ToolUtil.checkParams(id);
        SysUser sysUser = getBaseMapper().selectInfo(id);
        if (sysUser != null) {
            sysUser.setRoles(getBaseMapper().selectRoles(id));
            if (Validator.isEmpty(sysUser.getRoles())) {
                sysUser.setRoles(Collections.emptyList());
            }
        }
        return sysUser;
    }

    @Override
    public SysUser add(String deptId) {
        ToolUtil.checkParams(deptId);
        SysUser sysUser = new SysUser();
        sysUser.setDeptId(deptId);
        sysUser.setStatus(UserStatus.ENABLE.getCode());
        sysUser.setSex(SexConst.BOY);
        sysUser.setDeptName(sysDeptService.getName(deptId));
        sysUser.setRoles(Collections.emptyList());
        return sysUser;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        ToolUtil.checkParams(ids);
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        boolean isSuccess = removeByIds(idList);
        if (isSuccess) {
            // 删除分配给用户的权限
            sysUserRoleService.deleteUserRoleByUserIds(ids);
        }
        return isSuccess;
    }

    @Override
    public SysUser saveData(SysUser object, boolean updateAuthorization) {
        ToolUtil.checkParams(object);
        // 用户名不能重复
        if (Validator.isNotEmpty(object.getUsername())) {
            QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("username", object.getUsername());
            if (object.getId() != null) {
                queryWrapper.ne("id", object.getId());
            }
            int count = getBaseMapper().selectCount(queryWrapper);
            if (count > 0) {
                throw new EasyException(BusinessException.USER_REGISTERED);
            }
        }
        // 新增时密码如果为空,则使用默认密码
        if (StrUtil.isBlank(object.getId()) && Validator.isEmpty(object.getPassword())) {
            // 生成随机的盐
            object.setSalt(RandomUtil.randomString(10));
            object.setPassword(PasswordUtil.generatingPasswords(SysConst.projectProperties.getDefaultPassword(), object.getSalt()));
        } else if (Validator.isNotEmpty(object.getPassword())) {
            // 生成随机的盐
            object.setSalt(RandomUtil.randomString(10));
            object.setPassword(PasswordUtil.generatingPasswords(object.getPassword(), object.getSalt()));
        }
        if (Validator.isEmpty(object.getNickname())) {
            object.setNickname(object.getUsername());
        }

        boolean isSuccess = saveOrUpdate(object);
        if (isSuccess && updateAuthorization) {
            sysUserRoleService.saveUserRole(object.getId(), object.getRoles());
            // 删除授权信息,下次请求资源重新授权
            RedisUtil.del(RedisPrefix.SHIRO_AUTHORIZATION + object.toString());
        }
        return (SysUser) ToolUtil.checkResult(isSuccess, object);
    }

    @Override
    public boolean resetPassword(String ids) {
        ToolUtil.checkParams(ids);
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        // 生成随机的盐
        String salt = RandomUtil.randomString(10);
        String password = PasswordUtil.generatingPasswords(SysConst.projectProperties.getDefaultPassword(), salt);
        queryWrapper.in("id", ids.split(CommonConst.SPLIT));
        return getBaseMapper().resetPassword(password, salt, Convert.toStr((SysConfigUtil.get(SysConfigConst.PASSWORD_SECURITY_LEVEL))), queryWrapper) > 0;
    }

    @Override
    public boolean resetPassword(String username, String password, String passwordStrength) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        // 生成随机的盐
        String salt = RandomUtil.randomString(10);
        if (StrUtil.isBlank(password)) {
            password = PasswordUtil.generatingPasswords(SysConst.projectProperties.getDefaultPassword(), salt);
        } else {
            password = PasswordUtil.encryptedPasswords(password, salt);
        }
        if(StrUtil.isBlank(passwordStrength)){
            // 如果密码强度为空，使用系统要求的强度
            passwordStrength = Convert.toStr((SysConfigUtil.get(SysConfigConst.PASSWORD_SECURITY_LEVEL)));
        }
        queryWrapper.eq("username", username);
        return getBaseMapper().resetPassword(password, salt, passwordStrength, queryWrapper) > 0;
    }

    @Override
    public boolean disableUser(String ids) {
        ToolUtil.checkParams(ids);
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", ids.split(CommonConst.SPLIT));
        int count = getBaseMapper().updateUserStatus(UserStatus.DISABLE.getCode(), queryWrapper);
        return ToolUtil.checkResult(count > 0);
    }

    @Override
    public boolean enableUser(String ids) {
        ToolUtil.checkParams(ids);
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", ids.split(CommonConst.SPLIT));
        int count = getBaseMapper().updateUserStatus(UserStatus.ENABLE.getCode(), queryWrapper);
        return ToolUtil.checkResult(count > 0);
    }

    @Override
    public SysUser getSysUserByUserName(String username) {
        if (Validator.isNotEmpty(username)) {
            QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("username", username);
            return getBaseMapper().selectOne(queryWrapper);
        }
        return null;
    }

    @Override
    public String getSysUserMailByUserName(String username) {
        if (Validator.isNotEmpty(username)) {
            QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.select("email");
            queryWrapper.eq("username", username);
            SysUser sysUser = getBaseMapper().selectOne(queryWrapper);
            if (sysUser != null) {
                return sysUser.getEmail();
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public boolean updateUserLastLoginDate(String userId) {
        SysUser sysUser = new SysUser();
        sysUser.setId(userId);
        sysUser.setLastLogin(new Date());
        return getBaseMapper().updateById(sysUser) > 0;
    }

    @Override
    public SysUser getCurrentUser() {
        SysUser sysUser = ShiroUtil.getCurrentUser();
        sysUser.setPassword(null);
        sysUser.setSalt(null);
        // 如果没有授权,从数据库查询权限
        if (sysUser.getPermissionList() == null) {
            sysUser = shiroService.queryUserPermissions(sysUser);
            ShiroUtil.setAttribute(SessionConst.USER_SESSION_KEY, sysUser);
        }
        // 由于密保邮箱&手机可能会发生变动,这里重新从数据库查询
        SysUser queryResult = selectEmailAndPhone(sysUser.getId());
        if (queryResult != null) {
            sysUser.setPhone(queryResult.getPhone());
            sysUser.setEmail(queryResult.getEmail());
        }
        return sysUser;
    }

    @Override
    public int countUser(String deptIds) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("dept_id", deptIds.split(CommonConst.SPLIT));
        return getBaseMapper().selectCount(queryWrapper);
    }

    @Override
    public boolean updateAvatar(String url) {
        UpdateWrapper<SysUser> updateWrapper = new UpdateWrapper<>();
        SysUser sysUser = ShiroUtil.getCurrentUser();
        updateWrapper.set("avatar", url);
        updateWrapper.eq("id", sysUser.getId());
        return update(updateWrapper);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean setUserMail(String userId, String mail) {
        // 解绑该邮箱以前绑定的账号，防止一个邮箱绑定多个账号
        UpdateWrapper<SysUser> untyingMail = new UpdateWrapper<>();
        untyingMail.eq("email", mail);
        untyingMail.set("email", null);
        update(untyingMail);

        // 绑定新账号
        UpdateWrapper<SysUser> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("email", mail);
        updateWrapper.eq("id", userId);
        return update(updateWrapper);
    }

    @Override
    public SysUser getUser(String id) {
        ToolUtil.checkParams(id);
        SysUser sysUser = getBaseMapper().selectInfo(id);
        if (sysUser != null) {
            sysUser.setDept(sysDeptService.get(sysUser.getDeptId()));
        }
        return sysUser;
    }

    @Override
    public Page<SysUser> selectUser(SysUser sysUser, Page<SysUser> page, boolean isSelect, String keywords) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        // 如果是查询用于显示已选择的用户列表，必须传入id
        boolean isInvalid = !isSelect && (sysUser == null || StrUtil.isBlank(sysUser.getId()));
        if (isInvalid) {
            return null;
        }
        if (sysUser != null) {
            if (Validator.isNotEmpty(sysUser.getUsername())) {
                queryWrapper.like("su.username", sysUser.getUsername());
            }
            if (Validator.isNotEmpty(sysUser.getNickname())) {
                queryWrapper.like("su.nickname", sysUser.getNickname());
            }
            if (Validator.isNotEmpty(sysUser.getDeptId())) {
                queryWrapper.eq("su.dept_id", sysUser.getDeptId());
            }
            if (Validator.isNotEmpty(sysUser.getRoles())) {
                queryWrapper.in("sur.role_id", sysUser.getRoles());
            }
        }

        if (StrUtil.isNotBlank(keywords)) {
            queryWrapper.and(i -> i.like("su.username", keywords).or().like("su.nickname", keywords));
        }
        if (sysUser != null && StrUtil.isNotBlank(sysUser.getId())) {
            if (sysUser.getId().contains(CommonConst.SPLIT)) {
                queryWrapper.in("su.id", sysUser.getId().split(CommonConst.SPLIT));
            } else {
                queryWrapper.eq("su.id", sysUser.getId());
            }
        }

        queryWrapper.eq("su.status", UserStatus.ENABLE.getCode());

        page.setRecords(getBaseMapper().selectUser(page, queryWrapper));
        return page;
    }

    @Override
    public SysUser selectPasswordAndSalt(String id) {
        return getBaseMapper().selectPasswordAndSalt(id);
    }

    @Override
    public SysUser selectEmailAndPhone(String id) {
        // 由于密保邮箱&手机可能会发生变动,这里重新从数据库查询
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("email", "phone");
        queryWrapper.eq("id", id);
        return getOne(queryWrapper);
    }

    @Override
    public boolean setPhone(String id, String phone) {
        UpdateWrapper<SysUser> setPhone = new UpdateWrapper<>();
        setPhone.eq("id", id);
        setPhone.set("phone", phone);
        return update(setPhone);
    }
}
