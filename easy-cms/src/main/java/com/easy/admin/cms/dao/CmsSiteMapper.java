package com.easy.admin.cms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.cms.model.CmsSite;
import com.easy.admin.common.core.common.tree.Tree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 站点
 *
 * @author TengChongChong
 * @date 2021-11-18
 */
public interface CmsSiteMapper extends BaseMapper<CmsSite> {
    /**
     * 根据父id查询数据
     *
     * @param pId 父id
     * @return List<JsTree>
     */
    List<Tree> selectByPId(@Param("pId") String pId);

    /**
     * 获取所有数据
     * @param status 状态
     * @return List<JsTree>
     */
    List<Tree> selectAll(@Param("status") String status);

    /**
     * 获取详情信息
     *
     * @param id 权限id
     * @return CmsSite
     */
    CmsSite selectInfo(@Param("id") String id);

    /**
     * 查询指定数据
     *
     * @param pId 父id
     * @param str    开始位置
     * @param length 长度
     * @return List<T>
     */
    List<CmsSite> selectOrderInfo(@Param("pId") String pId, @Param("str") Integer str, @Param("length") Integer length);

    /**
     * 根据关键字搜索数据
     *
     * @param title 关键字
     * @return List<JsTree>
     */
    List<Tree> selectByTitle(@Param("title") String title);

    /**
     * 获取最大排序值
     *
     * @param id 父Id
     * @return Integer
     */
    Integer getMaxOrderNo(@Param("pId") String id);

}