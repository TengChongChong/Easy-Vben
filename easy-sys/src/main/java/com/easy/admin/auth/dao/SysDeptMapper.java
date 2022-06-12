package com.easy.admin.auth.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.auth.model.SysDept;
import com.easy.admin.common.core.common.tree.Tree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 部门管理
 *
 * @author TengChongChong
 * @date 2018/12/3
 */
public interface SysDeptMapper extends BaseMapper<SysDept> {

    /**
     * 获取列表数据
     *
     * @param queryWrapper 查询条件
     * @return 数据列表
     */
    List<SysDept> select(@Param("ew") QueryWrapper<SysDept> queryWrapper);

    /**
     * 获取所有数据
     * @param status 状态
     * @return List<JsTree>
     */
    List<Tree> selectAll(@Param("status") String status);

    /**
     * 获取指定parentId最大排序值
     *
     * @param parentId parentId
     * @return int
     */
    int getMaxOrderNo(@Param("parentId") String parentId);

    /**
     * 根据部门类型id获取部门数量
     *
     * @param queryWrapper 条件构建器
     * @return int
     */
    int selectCountByTypeIds(@Param("ew") QueryWrapper<SysDept> queryWrapper);

    /**
     * 根据id查询详情
     *
     * @param id 数据id
     * @return 详情
     */
    SysDept getById(@Param("id") String id);

    /**
     * 查询部门 Activiti
     *
     * @param queryWrapper 查询条件
     * @return List<SysDept>
     */
    List<SysDept> selectDepartments(@Param("ew") QueryWrapper<SysDept> queryWrapper);

    /**
     * 批量更新排序&结构
     *
     * @param list 数据
     * @return 更新条数
     */
    Integer updateOrderBatch(List<SysDept> list);
}