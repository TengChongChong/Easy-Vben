package com.easy.admin.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.sys.model.SysPermissions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单/权限
 * @author TengChongChong
 */
public interface SysPermissionsMapper extends BaseMapper<SysPermissions> {
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
     * @return SysPermissions
     */
    SysPermissions selectInfo(@Param("id") String id);

    /**
     * 查询指定数据
     *
     * @param pId 父id
     * @param str    开始位置
     * @param length 长度
     * @return List<T>
     */
    List<SysPermissions> selectOrderInfo(@Param("pId") String pId, @Param("str") Integer str, @Param("length") Integer length);

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