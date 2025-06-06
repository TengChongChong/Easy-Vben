package com.easy.admin.auth.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.auth.common.constant.SysRoleConst;
import com.easy.admin.auth.common.status.SysDeptStatus;
import com.easy.admin.auth.common.status.SysUserStatus;
import com.easy.admin.auth.dao.SysUserMapper;
import com.easy.admin.auth.model.SysUser;
import com.easy.admin.auth.model.vo.SysUserVO;
import com.easy.admin.auth.model.vo.session.SessionUserVO;
import com.easy.admin.auth.service.SysUserRoleService;
import com.easy.admin.auth.service.SysUserService;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.config.sa.token.util.SessionUtil;
import com.easy.admin.exception.BusinessException;
import com.easy.admin.sys.common.constant.SexConst;
import com.easy.admin.sys.common.constant.WhetherConst;
import com.easy.admin.util.PasswordUtil;
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
 * @author TengChongChong
 * @date 2018/12/25
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Override
    public Page<SysUserVO> select(SysUserVO sysUser, Page<SysUserVO> page) {
        if (sysUser == null || StrUtil.isBlank(sysUser.getDeptId())) {
            // 不允许查询所有部门用户数据
            return null;
        }

        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        if (Validator.isNotEmpty(sysUser.getUsername())) {
            queryWrapper.like("t.username", sysUser.getUsername());
        }
        if (Validator.isNotEmpty(sysUser.getNickname())) {
            queryWrapper.like("t.nickname", sysUser.getNickname());
        }
        if (Validator.isNotEmpty(sysUser.getPhoneNumber())) {
            queryWrapper.like("t.phone_number", sysUser.getPhoneNumber());
        }
        if (Validator.isNotEmpty(sysUser.getSource())) {
            queryWrapper.eq("t.source", sysUser.getSource());
        }
        if (Validator.isNotEmpty(sysUser.getSex())) {
            if (sysUser.getSex().contains(CommonConst.SPLIT)) {
                queryWrapper.in("t.sex", sysUser.getSex().split(CommonConst.SPLIT));
            } else {
                queryWrapper.eq("t.sex", sysUser.getSex());
            }
        }
        if (Validator.isNotEmpty(sysUser.getStatus())) {
            if (sysUser.getStatus().contains(CommonConst.SPLIT)) {
                queryWrapper.in("t.status", sysUser.getStatus().split(CommonConst.SPLIT));
            } else {
                queryWrapper.eq("t.status", sysUser.getStatus());
            }
        }
        if (Validator.isNotEmpty(sysUser.getDeptId())) {
            queryWrapper.eq("t.dept_id", sysUser.getDeptId());
        }
        // 非系统管理员，仅显示非系统数据
        if (!SessionUtil.havRole(SysRoleConst.SYS_ADMIN)) {
            queryWrapper.eq("sr.sys", WhetherConst.NO);
        }
        page.setDefaultDesc("t.create_date");
        page.setRecords(baseMapper.select(page, queryWrapper));
        return page;
    }

    @Override
    public Page<SysUserVO> search(String keyword, String range, String deptId, String roleCode, Page<SysUserVO> page) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();


        if ("currentDept".equals(range)) {
            deptId = SessionUtil.getCurrentUser().getDeptId();
        } else if ("role".equals(range)) {
            queryWrapper.eq("sr.code", roleCode);
        }
        if (StrUtil.isNotBlank(deptId)) {
            queryWrapper.eq("u.dept_id", deptId);
        }
        if (StrUtil.isNotBlank(keyword)) {
            queryWrapper.and(i -> i.like("u.username", keyword).or().like("u.nickname", keyword).or().like("sd.name", keyword));
        }
        queryWrapper.eq("u.status", SysUserStatus.ENABLE.getCode())
                .eq("sd.status", SysDeptStatus.ENABLE.getCode())
                .eq("sdt.status", CommonStatus.ENABLE.getCode());

        page.setRecords(baseMapper.search(page, queryWrapper));
        return page;
    }

    @Override
    public List<SysUserVO> selectUsersByIds(String ids) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("u.id", ids.split(CommonConst.SPLIT));
        queryWrapper.eq("u.status", SysUserStatus.ENABLE.getCode());
        queryWrapper.eq("sd.status", SysDeptStatus.ENABLE.getCode());
        queryWrapper.eq("sdt.status", CommonStatus.ENABLE.getCode());
        return baseMapper.selectUsersByIds(queryWrapper);
    }

    @Override
    public SysUserVO get(String id) {
        SysUser sysUser = baseMapper.getById(id);
        if (sysUser == null) {
            return null;
        }
        SysUserVO sysUserVO = new SysUserVO();
        BeanUtil.copyProperties(sysUser, sysUserVO);

        sysUserVO.setRoleIdList(baseMapper.selectRoles(id));
        return sysUserVO;
    }

    @Override
    public SessionUserVO getSessionUserByUserName(String username) {
        return baseMapper.getSessionUserByUserName(username);
    }

    @Override
    public int updateUserLastLoginDate(String id, Date lastLogin) {
        return baseMapper.updateUserLastLoginDate(id, lastLogin);
    }

    @Override
    public SysUserVO add(String deptId) {
        SysUserVO sysUser = new SysUserVO();
        sysUser.setDeptId(deptId);
        sysUser.setStatus(SysUserStatus.ENABLE.getCode());
        sysUser.setSex(SexConst.BOY);
        sysUser.setRoleIdList(Collections.emptyList());
        return sysUser;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        boolean isSuccess = removeByIds(idList);
        if (isSuccess) {
            // 删除分配给用户的权限
            sysUserRoleService.removeUserRoleByUserIds(ids);
        }
        return isSuccess;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public SysUserVO saveData(SysUserVO sysUserVO, boolean updateAuthorization) {
        // 用户名不能重复
        if (checkHaving(sysUserVO.getId(), "username", sysUserVO.getUsername())) {
            throw new EasyException(BusinessException.USER_REGISTERED);
        }
        if (checkHaving(sysUserVO.getId(), "email", sysUserVO.getEmail())) {
            throw new EasyException("邮箱已注册");
        }
        if (checkHaving(sysUserVO.getId(), "phone_number", sysUserVO.getPhoneNumber())) {
            throw new EasyException("手机号已注册");
        }

        // 是否系统管理员
        boolean isAdmin = SessionUtil.havRole(SysRoleConst.SYS_ADMIN) || SessionUtil.havRole(SysRoleConst.ADMIN);

        // 新增用户时设置密码，用户密码不允许在用户管理里设置
        if (StrUtil.isBlank(sysUserVO.getId())) {
            // 生成随机的盐
            sysUserVO.setSalt(RandomUtil.randomString(10));
            sysUserVO.setPassword(PasswordUtil.generatingPasswords(sysUserVO.getPassword(), sysUserVO.getSalt()));

            // 普通用户只能管理自己部门的用户
            if (!isAdmin && !sysUserVO.getDeptId().equals(SessionUtil.getCurrentUser().getDeptId())) {
                throw new EasyException("你无权管理其他部门的用户");
            }
        } else {
            // 部门不允许修改
            sysUserVO.setDeptId(null);
            // 修改用户需检查是否有权限修改
            if (!isAdmin) {
                // 非管理员，只能修改自己部门的用户
                String userDeptId = baseMapper.getDeptIdByUserId(sysUserVO.getId());
                if (!SessionUtil.getCurrentUser().getDeptId().equals(userDeptId)) {
                    throw new EasyException("你无权管理其他部门的用户");
                }
            }
        }
        if (Validator.isEmpty(sysUserVO.getNickname())) {
            sysUserVO.setNickname(sysUserVO.getUsername());
        }

        SysUser sysUser = new SysUser();
        BeanUtil.copyProperties(sysUserVO, sysUser);

        boolean isSuccess = saveOrUpdate(sysUser);
        if (isSuccess && updateAuthorization) {
            sysUserVO.setId(sysUser.getId());
            sysUserRoleService.saveUserRole(sysUser.getId(), sysUserVO.getRoleIdList());
        }
        return sysUserVO;
    }

    /**
     * 检查数据是否已经存在
     *
     * @param id    数据id
     * @param field 字段
     * @param value 值
     * @return true/false
     */
    private boolean checkHaving(String id, String field, String value) {
        if (Validator.isNotEmpty(value)) {
            QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq(field, value);
            if (StrUtil.isNotBlank(id)) {
                queryWrapper.ne("id", id);
            }
            long count = baseMapper.selectCount(queryWrapper);
            return count > 0;
        }
        return false;
    }

    @Override
    public String resetPassword(String ids) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        // 是否系统管理员 || 管理员
        boolean isAdmin = SessionUtil.havRole(SysRoleConst.SYS_ADMIN) || SessionUtil.havRole(SysRoleConst.ADMIN);
        if (!isAdmin) {
            // 非管理员，只能重置自己部门的用户
            queryWrapper.eq("dept_id", SessionUtil.getCurrentUser().getDeptId());
        }
        String password = RandomUtil.randomString(16);
        // 生成随机的盐
        String salt = RandomUtil.randomString(10);
        String encryptionPassword = PasswordUtil.generatingPasswords(password, salt);
        queryWrapper.in("id", ids.split(CommonConst.SPLIT));
        boolean isSuccess = baseMapper.resetPassword(encryptionPassword, salt, queryWrapper) > 0;
        if (!isSuccess) {
            throw new EasyException("重置密码失败");
        }
        return password;
    }

    @Override
    public boolean resetPassword(String username, String password) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        // 生成随机的盐
        String salt = RandomUtil.randomString(10);
        password = PasswordUtil.encryptedPasswords(password, salt);
        queryWrapper.eq("username", username);
        return baseMapper.resetPassword(password, salt, queryWrapper) > 0;
    }

    @Override
    public boolean setStatus(String ids, String status) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", ids.split(CommonConst.SPLIT));
        int count = baseMapper.updateUserStatus(status, queryWrapper);
        return count > 0;
    }

    @Override
    public SysUser getSysUserByUserName(String username) {
        if (Validator.isNotEmpty(username)) {
            QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("username", username);
            return baseMapper.selectOne(queryWrapper);
        }
        return null;
    }

    @Override
    public SysUser getSysUserMailAndPhoneByUserName(String username) {
        if (Validator.isNotEmpty(username)) {
            QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.select("email, phone_number");
            queryWrapper.eq("username", username);
            return baseMapper.selectOne(queryWrapper);
        }
        return null;
    }

    @Override
    public boolean updateUserLastLoginDate(String userId) {
        SysUser sysUser = new SysUser();
        sysUser.setId(userId);
        sysUser.setLastLoginDate(new Date());
        return baseMapper.updateById(sysUser) > 0;
    }


    @Override
    public long countUser(String deptIds) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("dept_id", deptIds.split(CommonConst.SPLIT));
        return baseMapper.selectCount(queryWrapper);
    }


    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean setUserMail(String userId, String mail) {
        // 解绑该邮箱以前绑定的用户名，防止一个邮箱绑定多个用户名
        UpdateWrapper<SysUser> untyingMail = new UpdateWrapper<>();
        untyingMail.eq("email", mail);
        untyingMail.set("email", null);
        update(untyingMail);

        // 绑定新用户
        UpdateWrapper<SysUser> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("email", mail);
        updateWrapper.eq("id", userId);
        return update(updateWrapper);
    }

    @Override
    public SysUser getUser(String id) {
        return baseMapper.getById(id);
    }

    @Override
    public SysUser selectPasswordAndSalt(String id) {
        return baseMapper.selectPasswordAndSalt(id);
    }

    @Override
    public SysUser selectEmailAndPhone(String id) {
        // 由于密保邮箱&手机可能会发生变动,这里重新从数据库查询
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("email", "phone_number");
        queryWrapper.eq("id", id);
        return getOne(queryWrapper);
    }

    @Override
    public boolean setPhone(String id, String phone) {
        UpdateWrapper<SysUser> setPhone = new UpdateWrapper<>();
        setPhone.eq("id", id);
        setPhone.set("phone_number", phone);
        return update(setPhone);
    }
}
