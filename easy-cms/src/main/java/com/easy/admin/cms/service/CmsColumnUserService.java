package com.easy.admin.cms.service;

import com.easy.admin.cms.model.CmsColumn;
import com.easy.admin.cms.model.CmsColumnUser;

import java.util.List;

/**
 * 栏目用户权限
 *
 * @author TengChongChong
 * @date 2021-11-19
 */
public interface CmsColumnUserService {
    /**
     * 查询有某栏目权限的用户
     *
     * @param columnId     栏目
     * @return List<CmsColumnUser>
     */
    List<CmsColumnUser> selectUsersByColumnId(String columnId);


    /**
     * 查询某用户拥有的栏目权限
     *
     * @param userId       用户id
     * @return List<CmsColumnUser>
     */
    List<CmsColumn> selectColumnsByUserId(String userId);

    /**
     * 根据站点id删除
     *
     * @param siteId 站点id
     * @return true/false
     */
    boolean removeBySiteId(String siteId);

    /**
     * 根据栏目id删除
     *
     * @param columnId 栏目id
     * @return true/false
     */
    boolean removeByColumnId(String columnId);

}
