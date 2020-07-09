package com.easy.restful.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.restful.sys.model.SysRolePermissions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色权限
 *
 * @author tengchong
 * @date 2018/12/3
 */
public interface SysRolePermissionsMapper extends BaseMapper<SysRolePermissions> {

    /**
     * 查询所有角色权限
     *
     * @param status 状态
     * @return List<SysRolePermissions>
     */
    List<SysRolePermissions> selectAll(@Param("status") int status);
}