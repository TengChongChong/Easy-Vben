package com.easy.admin.cms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.cms.model.CmsColumn;
import com.easy.admin.common.core.common.tree.Tree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 栏目
 *
 * @author TengChongChong
 * @date 2021-11-18
 */
public interface CmsColumnMapper extends BaseMapper<CmsColumn> {
    /**
     * 根据父id查询数据
     *
     * @param pId 父id
     * @return List<JsTree>
     */
    List<Tree> selectByPId(@Param("siteId") String siteId, @Param("pId") String pId);

    /**
     * 获取所有数据
     *
     * @param status 状态
     * @return List<JsTree>
     */
    List<Tree> selectAll(@Param("siteId") String siteId, @Param("status") String status);

    /**
     * 查询所有栏目
     *
     * @param status 状态
     * @return List<CmsColumn>
     */
    List<CmsColumn> selectAllColumn(@Param("status") String status);

    /**
     * 获取详情信息
     *
     * @param id id
     * @return CmsColumn
     */
    CmsColumn selectInfo(@Param("id") String id);

    /**
     * 获取详情信息
     *
     * @param siteId 站点id
     * @param slug   slug
     * @return CmsColumn
     */
    CmsColumn selectBySlug(@Param("siteId") String siteId, @Param("slug") String slug);

    /**
     * 查询指定数据
     *
     * @param pId    父id
     * @param str    开始位置
     * @param length 长度
     * @return List<T>
     */
    List<CmsColumn> selectOrderInfo(@Param("siteId") String siteId, @Param("pId") String pId, @Param("str") Integer str, @Param("length") Integer length);

    /**
     * 根据关键字搜索数据
     *
     * @param title 关键字
     * @return List<JsTree>
     */
    List<Tree> selectByTitle(@Param("siteId") String siteId, @Param("title") String title);

    /**
     * 获取最大排序值
     *
     * @param id 父Id
     * @return Integer
     */
    Integer getMaxOrderNo(@Param("siteId") String siteId, @Param("pId") String id);

    /**
     * 根据站点id删除
     *
     * @param siteId 站点id
     * @return true/false
     */
    int deleteBySiteId(@Param("siteId") String siteId);

}