package com.easy.admin.auth.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.auth.model.SysRole;
import com.easy.admin.common.core.common.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色
 * @author TengChongChong
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 获取列表数据
     *
     * @param page 分页
     * @param queryWrapper 查询条件
     * @return List<SysRole>
     */
    List<SysRole> select(Page<SysRole> page, @Param("ew") QueryWrapper<SysRole> queryWrapper);

    /**
     * 获取所有数据
     * @param status 状态
     * @return List<SysRole>
     */
    List<SysRole> selectAll(@Param("status") String status);

    /**
     * 获取详情信息
     *
     * @param id 角色id
     * @return SysRole
     */
    SysRole getById(@Param("id") String id);

    /**
     * 查询权限id集合
     *
     * @param id 角色id
     * @return 集合
     */
    List<String> selectPermissions(@Param("id") String id);

    /**
     * 获取最大排序值
     *
     * @return Integer
     */
    Integer getMaxOrderNo();

    /**
     * 根据用户id获取角色标识
     *
     * @param userId 用户id
     * @return 角色标识
     */
    List<String> selectRoleCodeByUserId(@Param("userId") String userId);

    /**
     * 查询所有权限标识
     *
     * @return List<String>
     */
    List<String> selectAllRoleCodes();

    /**
     * 查询所有权限 Activiti
     * @param queryWrapper 查询条件
     *
     * @return List<SysRole>
     */
    List<SysRole> selectRole(@Param("ew") QueryWrapper<SysRole> queryWrapper);
}