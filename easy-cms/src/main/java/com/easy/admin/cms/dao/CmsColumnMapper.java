package com.easy.admin.cms.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.cms.model.CmsColumn;
import com.easy.admin.common.core.common.tree.Tree;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 栏目
 *
 * @author 系统管理员
 * @date 2023-06-19
 */
public interface CmsColumnMapper extends BaseMapper<CmsColumn> {
    /**
     * 查询数据（无分页）
     *
     * @param queryWrapper 查询条件
     * @return List<CmsColumn>
     */
    List<CmsColumn> select(@Param("ew") QueryWrapper<CmsColumn> queryWrapper);

    /**
     * 查询所有数据（Tree）
     *
     * @param siteId 站点id
     * @param status 状态
     * @return List<JsTree>
     */
    List<Tree> selectAll(@Param("siteId") String siteId, @Param("status") String status);

    /**
     * 查询详情
     *
     * @param id id
     * @return CmsColumn
     */
    CmsColumn getById(@Param("id") String id);

    /**
     * 根据站点id与别名获取栏目信息
     *
     * @param siteId 站点id
     * @param slug   别名
     * @return CmsColumn
     */
    CmsColumn selectBySlug(@Param("siteId") String siteId, @Param("slug") String slug);

    /**
     * 获取parentId下子级最大排序值
     *
     * @param parentId parentId
     * @return int
     */
    int getMaxOrderNo(@Param("parentId") String parentId);

    /**
     * 保存排序&结构
     *
     * @param list 数据
     * @return 更新条数
     */
    Integer updateOrderBatch(List<CmsColumn> list);

    /**
     * 导入时验证业务表中是否已存在
     *
     * @param templateId 导入模板id
     * @param status     状态
     * @return 更新条数
     */
    Integer updateDuplicateData(@Param("templateId") String templateId, @Param("status") String status);

    /**
     * 导入后查询需要更新父id的数据
     *
     * @return List<CmsColumn>
     */
    List<CmsColumn> selectNeedUpdateParentInfo();

    /**
     * 导入后设置父栏目id、创建人、创建时间等信息
     *
     * @param userId 用户id
     * @param date   时间
     * @return 更新条数
     */
    Integer updateAfterImport(@Param("userId") String userId, @Param("date") Date date);

    /**
     * 查询导出数据
     *
     * @param queryWrapper 查询条件
     * @return List<CmsColumn>
     */
    List<CmsColumn> exportData(@Param("ew") QueryWrapper<CmsColumn> queryWrapper);

    /**
     * 查询所有栏目
     *
     * @param siteId 站点id
     * @param status 状态
     * @return List<CmsColumn>
     */
    List<CmsColumn> selectAllColumn(@Param("siteId") String siteId, @Param("status") String status);

    /**
     * 查询栏目数据 for 网站发布
     *
     * @param queryWrapper 查询条件
     * @return List<CmsColumn>
     */
    List<CmsColumn> selectColumns(@Param("ew") QueryWrapper<CmsColumn> queryWrapper);

}