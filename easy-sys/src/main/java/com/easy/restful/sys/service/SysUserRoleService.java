package com.easy.restful.sys.service;

import java.util.List;

/**
 * 用户角色
 *
 * @author tengchong
 * @date 2020/7/9
 */
public interface SysUserRoleService {
    /**
     * 根据用户ID查询角色标识
     *
     * @param userId 用户id
     * @return 角色标识
     */
    List<String> selectUserRoleCodesByUserId(String userId);
}
