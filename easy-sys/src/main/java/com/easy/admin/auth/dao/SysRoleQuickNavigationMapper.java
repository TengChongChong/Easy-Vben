package com.easy.admin.auth.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.auth.model.SysRoleQuickNavigation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色快捷导航
 *
 * @author 系统管理员
 * @date 2025-07-09
 */
public interface SysRoleQuickNavigationMapper extends BaseMapper<SysRoleQuickNavigation> {

    /**
     * 查询数据（无分页）
     *
     * @param queryWrapper 查询条件
     * @return List<SysRoleQuickNavigation>
     */
    List<String> selectWithoutPage(@Param("ew") QueryWrapper<SysRoleQuickNavigation> queryWrapper);

}