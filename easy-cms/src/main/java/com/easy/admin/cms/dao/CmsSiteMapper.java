package com.easy.admin.cms.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.cms.model.CmsSite;
import com.easy.admin.common.core.common.tree.Tree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 站点
 *
 * @author 系统管理员
 * @date 2023-06-19
 */
public interface CmsSiteMapper extends BaseMapper<CmsSite> {
    /**
     * 查询数据（无分页）
     *
     * @param queryWrapper 查询条件
     * @return List<CmsSite>
     */
    List<CmsSite> select(@Param("ew") QueryWrapper<CmsSite> queryWrapper);

    /**
     * 查询所有数据（Tree）
     *
     * @return List<JsTree>
     */
    List<Tree> selectAll();

    /**
     * 获取所有数据
     *
     * @param status 状态
     * @return List<CmsSite>
     */
    List<CmsSite> selectAllSite(@Param("status") String status);

    /**
     * 查询详情
     *
     * @param id id
     * @return CmsSite
     */
    CmsSite getById(@Param("id") String id);

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
    Integer updateOrderBatch(List<CmsSite> list);

    /**
     * 查询导出数据
     *
     * @param queryWrapper 查询条件
     * @return List<CmsSite>
     */
    List<CmsSite> exportData(@Param("ew") QueryWrapper<CmsSite> queryWrapper);
}