package com.easy.admin.sys.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.sys.model.SysQuickNavigation;
import com.easy.admin.sys.model.vo.SysQuickNavigationVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 快捷导航
 *
 * @author 系统管理员
 * @date 2025-07-09
 */
public interface SysQuickNavigationMapper extends BaseMapper<SysQuickNavigation> {

    /**
     * 查询数据
     *
     * @param queryWrapper 查询条件
     * @return List<SysQuickNavigation>
     */
    List<SysQuickNavigationVO> select(@Param("ew") QueryWrapper<SysQuickNavigation> queryWrapper);

    /**
     * 查询当前登录用户的快捷菜单
     *
     * @return List<SysQuickNavigationVO>
     */
    List<SysQuickNavigationVO> selectQuickNavigationByRole(@Param("ew") QueryWrapper<SysQuickNavigation> queryWrapper);

    /**
     * 查询详情
     *
     * @param id id
     * @return SysQuickNavigation
     */
    SysQuickNavigation getById(@Param("id") String id);

    /**
     * 查询导出数据
     *
     * @param queryWrapper 查询条件
     * @return List<SysQuickNavigation>
     */
    List<SysQuickNavigationVO> exportData(@Param("ew") QueryWrapper<SysQuickNavigation> queryWrapper);

    /**
     * 获取最大排序值
     *
     * @return 排序值
     */
    int getMaxOrderNo();

}