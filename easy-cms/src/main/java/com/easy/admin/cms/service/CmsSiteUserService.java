package com.easy.admin.cms.service;

import com.easy.admin.cms.model.CmsSite;
import com.easy.admin.cms.model.CmsSiteUser;

import java.util.List;

/**
 * 站点用户权限
 *
 * @author TengChongChong
 * @date 2021-11-18
 */
public interface CmsSiteUserService {
    /**
     * 查询有某站点权限的用户
     *
     * @param siteId 站点
     * @return List<CmsSiteUser>
     */
    List<CmsSiteUser> selectUsersBySiteId(String siteId);

    /**
     * 查询某用户拥有的站点权限
     *
     * @param userId 用户id
     * @return List<CmsSiteUser>
     */
    List<CmsSite> selectSitesByUserId(String userId);

    /**
     * 查询某用户拥有权限的最后创建的站点
     *
     * @param userId 用户id
     * @return CmsSiteUser
     */
    CmsSite getSitesByUserId(String userId);

    /**
     * 获取当前编辑的站点
     *
     * @return 站点id
     */
    String getCurrentEditSiteId();

    /**
     * 设置当前编辑的站点
     *
     * @param siteId 站点id
     * @return true/false
     */
    boolean setCurrentEditSiteId(String siteId);
}
