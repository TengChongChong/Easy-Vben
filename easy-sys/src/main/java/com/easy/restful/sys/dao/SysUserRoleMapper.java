package com.easy.restful.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.restful.sys.model.SysUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户角色
 *
 * @author tengchong
 * @date 2018/12/3
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

    /**
     * 根据用户ID查询角色标识
     *
     * @param userId 用户id
     * @param status 角色状态
     * @return 角色标识
     */
    List<String> selectUserRoleCodesByUserId(@Param("userId") String userId, @Param("status") int status);
}