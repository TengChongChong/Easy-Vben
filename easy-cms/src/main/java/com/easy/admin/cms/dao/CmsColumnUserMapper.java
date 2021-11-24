package com.easy.admin.cms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.cms.model.CmsColumnUser;
import com.easy.admin.cms.model.CmsColumn;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 栏目用户权限
 *
 * @author TengChongChong
 * @date 2021-11-19
 */
public interface CmsColumnUserMapper extends BaseMapper<CmsColumnUser> {
    /**
     * 查询有某栏目权限的用户
     *
     * @param columnId     栏目
     * @param columnStatus 栏目状态
     * @return List<CmsColumnUser>
     */
    List<CmsColumnUser> selectUsersByColumnId(@Param("columnId") String columnId, @Param("columnStatus") String columnStatus);

    /**
     * 查询某用户拥有的栏目权限
     *
     * @param siteId       站点id
     * @param userId       用户id
     * @param columnStatus 栏目状态
     * @return List<CmsColumnUser>
     */
    List<CmsColumn> selectColumnsByUserId(@Param("siteId") String siteId, @Param("userId") String userId, @Param("columnStatus") String columnStatus);

    /**
     * 根据站点id删除
     *
     * @param siteId 站点id
     * @return true/false
     */
    int deleteBySiteId(@Param("siteId") String siteId);

    /**
     * 根据栏目id删除
     *
     * @param columnId 栏目id
     * @return true/false
     */
    int deleteByColumnId(@Param("columnId") String columnId);
}