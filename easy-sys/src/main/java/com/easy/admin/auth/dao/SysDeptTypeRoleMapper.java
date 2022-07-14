package com.easy.admin.auth.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.auth.model.SysDeptTypeRole;
import com.easy.admin.auth.model.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 部门类型角色管理
 *
 * @author TengChongChong
 * @date 2018/12/3
 */
public interface SysDeptTypeRoleMapper extends BaseMapper<SysDeptTypeRole> {

    /**
     * 根据部门类型获取可分配的角色数据
     *
     * @param deptId 部门类型id
     * @return List<SysRole>
     */
    List<SysRole> selectRoleByDept(@Param("deptId") String deptId);
}