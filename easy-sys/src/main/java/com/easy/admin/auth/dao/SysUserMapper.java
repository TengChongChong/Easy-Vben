package com.easy.admin.auth.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.auth.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 用户管理
 *
 * @author TengChongChong
 * @date 2018/12/6
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 获取列表数据
     *
     * @param page         分页
     * @param queryWrapper 查询条件
     * @return
     */
    List<SysUser> select(Page<SysUser> page, @Param("ew") QueryWrapper<SysUser> queryWrapper);

    /**
     * 查询用户列表 Activiti
     *
     * @param page         分页
     * @param queryWrapper 查询条件
     * @return List<SysUser>
     */
    List<SysUser> selectUser(Page<SysUser> page, @Param("ew") QueryWrapper<SysUser> queryWrapper);

    /**
     * 根据关键字搜索用户
     *
     * @param page         分页
     * @param queryWrapper 查询条件
     * @return List<SysUser>
     */
    List<SysUser> search(Page<SysUser> page, @Param("ew") QueryWrapper<SysUser> queryWrapper);

    /**
     * 根据查询条件查询用户信息
     *
     * @param queryWrapper 查询条件
     * @return List<SysUser>
     */
    List<SysUser> selectUsersByIds(@Param("ew") QueryWrapper<SysUser> queryWrapper);

    /**
     * 获取详情信息
     *
     * @param id 用户id
     * @return SysUser
     */
    SysUser getById(@Param("id") String id);

    /**
     * 获取用户信息，用于登录
     *
     * @param username 账号|邮箱|手机号
     * @return SysUser
     */
    SysUser getSysUserByUserName(@Param("account") String username);

    /**
     * 获取密码和盐，用于修改密码
     *
     * @param id 用户id
     * @return SysUser
     */
    SysUser selectPasswordAndSalt(@Param("id") String id);

    /**
     * 查询用户角色ids
     *
     * @param id 用户id
     * @return 角色集合
     */
    List<String> selectRoles(@Param("id") String id);

    /**
     * 更新用户状态
     *
     * @param status       状态
     * @param queryWrapper 条件
     * @return int
     */
    int updateUserStatus(@Param("status") String status, @Param("ew") QueryWrapper<SysUser> queryWrapper);

    /**
     * 重置密码
     *
     * @param password     密码
     * @param salt         盐
     * @param queryWrapper 条件
     * @return int
     */
    int resetPassword(
            @Param("password") String password,
            @Param("salt") String salt,
            @Param("ew") QueryWrapper<SysUser> queryWrapper);

    /**
     * 更新最后登录时间
     *
     * @param id        数据id
     * @param lastLogin 最后登录时间
     * @return int
     */
    int updateUserLastLoginDate(@Param("id") String id, @Param("lastLogin") Date lastLogin);

    /**
     * 查询用户所在部门
     *
     * @param id 用户id
     * @return 部门id
     */
    String getDeptIdByUserId(@Param("id") String id);
}