package com.easy.admin.auth.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.auth.model.SysDeptType;
import com.easy.admin.common.core.common.tree.Tree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 部门类型管理
 *
 * @author TengChongChong
 * @date 2018/12/3
 */
public interface SysDeptTypeMapper extends BaseMapper<SysDeptType> {
    /**
     * 获取列表数据
     *
     * @param queryWrapper 查询条件
     * @return List<SysDeptType>
     */
    List<SysDeptType> select(@Param("ew") QueryWrapper<SysDeptType> queryWrapper);

    /**
     * 获取所有数据
     * @param status 状态
     * @return List<JsTree>
     */
    List<Tree> selectAll(@Param("status") String status);

    /**
     * 获取详情信息
     *
     * @param id 部门类型id
     * @return SysDeptType
     */
    SysDeptType getById(@Param("id") String id);

    /**
     * 查询用户角色ids
     *
     * @param id 用户id
     * @return 角色集合
     */
    List<String> selectRoles(@Param("id") String id);
    /**
     * 获取最大排序值
     *
     * @param id 父Id
     * @return
     */
    Integer getMaxOrderNo(@Param("parentId") String id);

    /**
     * 查询子类型数量
     *
     * @param code 部门类型编码
     * @return 数量
     */
    int selectChildCount(@Param("code") String code);

    /**
     * 批量更新排序&结构
     *
     * @param list 数据
     * @return 更新条数
     */
    Integer updateOrderBatch(List<SysDeptType> list);
}