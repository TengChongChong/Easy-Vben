package com.easy.admin.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.easy.admin.auth.model.SysRoleQuickNavigation;

import java.util.List;

/**
 * 角色快捷导航
 *
 * @author 系统管理员
 * @date 2025-07-09
 */
public interface SysRoleQuickNavigationService extends IService<SysRoleQuickNavigation> {

    /**
     * 查询数据
     *
     * @param roleId roleId
     * @return List<SysRoleQuickNavigationVO>
     */
    List<String> selectByRoleId(String roleId);

    /**
     * 根据roleId删除
     *
     * @param roleId roleId
     * @return true/false
     */
    boolean removeByRoleId(String roleId);

    /**
     * 根据navigationId删除
     *
     * @param navigationId navigationId
     * @return true/false
     */
    boolean removeByNavigationId(String navigationId);

    /**
     * 批量保存
     *
     * @param roleId           roleId
     * @param navigationIdList navigationIdList
     * @return true/false
     */
    boolean saveBatchData(String roleId, List<String> navigationIdList);
}
