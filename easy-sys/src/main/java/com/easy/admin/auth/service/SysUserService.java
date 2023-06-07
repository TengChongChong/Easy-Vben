package com.easy.admin.auth.service;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.auth.model.SysUser;

import java.util.List;

/**
 * 用户管理
 *
 * @author TengChongChong
 * @date 2018/12/25
 */
public interface SysUserService {
    /**
     * 列表
     *
     * @param object 查询条件
     * @param page   分页
     * @return Page<SysUser>
     */
    Page<SysUser> select(SysUser object, Page<SysUser> page);

    /**
     * 根据关键字搜索用户
     *
     * @param keyword 关键字
     * @param range   数据范围，可以选择哪些用户 'all' | 'currentDept'
     * @param deptId 部门id，如传入range='currentDept'，此参数无效
     * @param page    分页
     * @return Page<SysUser>
     */
    Page<SysUser> search(String keyword, String range, String deptId, Page<SysUser> page);

    /**
     * 获取指定用户信息
     *
     * @param ids ids
     * @return List<SysUser>
     */
    List<SysUser> selectUsersByIds(String ids);

    /**
     * 详情
     *
     * @param id id
     * @return SysUser
     */
    SysUser get(String id);

    /**
     * 新增
     *
     * @param deptId 部门id
     * @return SysUser
     */
    SysUser add(String deptId);

    /**
     * 删除
     *
     * @param ids 要删除的id 1,2,3 或 1
     * @return true/false
     */
    boolean remove(String ids);

    /**
     * 保存
     *
     * @param object              表单内容
     * @param updateAuthorization 是否更新授权
     * @return SysUser
     */
    SysUser saveData(SysUser object, boolean updateAuthorization);

    /**
     * 重置密码
     *
     * @param ids 用户ids
     * @return 重置后密码
     */
    String resetPassword(String ids);

    /**
     * 重置密码
     *
     * @param username         账号，请确认是用户本人的username
     * @param password         新密码
     * @return true/false
     */
    boolean resetPassword(String username, String password);

    /**
     * 设置状态
     *
     * @param ids    id
     * @param status 状态
     * @return true/false
     */
    boolean setStatus(String ids, String status);

    /**
     * 根据账号查询用户
     *
     * @param username 账号
     * @return SysUser
     */
    SysUser getSysUserByUserName(String username);

    /**
     * 根据账号查询用户邮箱
     *
     * @param username 账号
     * @return SysUser
     */
    SysUser getSysUserMailAndPhoneByUserName(String username);

    /**
     * 更新用户最后登录时间
     *
     * @param userId 用户id
     * @return true/false
     */
    boolean updateUserLastLoginDate(String userId);

    /**
     * 获取当前登录用户
     *
     * @return SysUser
     */
    SysUser getCurrentUser();

    /**
     * 根据部门id查询用户数量
     *
     * @param deptIds 部门ids
     * @return long
     */
    long countUser(String deptIds);

    /**
     * 更新头像
     *
     * @param url 访问地址
     * @return true/false
     */
    boolean updateAvatar(String url);

    /**
     * 设置用户邮箱
     *
     * @param userId 用户id
     * @param mail   邮箱
     * @return true/false
     */
    boolean setUserMail(String userId, String mail);

    /**
     * 详情
     *
     * @param id id
     * @return SysUser
     */
    SysUser getUser(String id);

    /**
     * 获取密码和盐，用于修改密码
     *
     * @param id 用户id
     * @return SysUser
     */
    SysUser selectPasswordAndSalt(String id);

    /**
     * 查询邮箱和手机号
     *
     * @param id 用户id
     * @return SysUser
     */
    SysUser selectEmailAndPhone(String id);

    /**
     * 更新手机号
     *
     * @param id    用户id
     * @param phone 手机号
     * @return true/false
     */
    boolean setPhone(String id, String phone);

}