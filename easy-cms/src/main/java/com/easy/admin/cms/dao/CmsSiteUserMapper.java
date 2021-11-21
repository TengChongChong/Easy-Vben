package com.easy.admin.cms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.cms.model.CmsSite;
import com.easy.admin.cms.model.CmsSiteUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 站点用户权限
 *
 * @author TengChongChong
 * @date 2021-11-18
 */
public interface CmsSiteUserMapper extends BaseMapper<CmsSiteUser> {

    /**
     * 查询有某站点权限的用户
     *
     * @param siteId     站点
     * @param siteStatus 站点状态
     * @return List<CmsSiteUser>
     */
    List<CmsSiteUser> selectUsersBySiteId(@Param("siteId") String siteId, @Param("siteStatus") String siteStatus);


    /**
     * 查询某用户拥有权限的最后创建的站点
     *
     * @param userId     用户id
     * @param siteStatus 站点状态
     * @return CmsSite
     */
    CmsSite getSitesByUserId(@Param("userId") String userId, @Param("siteStatus") String siteStatus);

    /**
     * 查询某用户拥有的站点权限
     *
     * @param userId     用户id
     * @param siteStatus 站点状态
     * @return List<CmsSiteUser>
     */
    List<CmsSite> selectSitesByUserId(@Param("userId") String userId, @Param("siteStatus") String siteStatus);
}