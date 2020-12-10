package com.easy.restful.sys.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.restful.common.core.common.tree.Tree;
import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.common.core.common.select.Select;
import com.easy.restful.sys.model.SysDept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 部门管理
 *
 * @author tengchong
 * @date 2018/12/3
 */
public interface SysDeptMapper extends BaseMapper<SysDept> {

    /**
     * 根据关键字搜索数据
     *
     * @param title 关键字
     * @return List<JsTree>
     */
    List<Tree> selectByTitle(@Param("title") String title);

    /**
     * 根据父id查询数据
     *
     * @param pId 父id
     * @return List<JsTree>
     */
    List<Tree> selectByPId(@Param("pId") String pId);

    /**
     * 获取列表数据
     *
     * @param page 分页
     * @param queryWrapper 查询条件
     * @return 数据列表
     */
    List<SysDept> select(Page<SysDept> page, @Param("ew") QueryWrapper<SysDept> queryWrapper);

    /**
     * 获取指定pId最大排序值
     *
     * @param pId pId
     * @return int
     */
    int getMaxOrderNo(@Param("pId") String pId);

    /**
     * 根据部门类型id获取部门数量
     *
     * @param queryWrapper 条件构建器
     * @return int
     */
    int selectCountByTypeIds(@Param("ew") QueryWrapper<SysDept> queryWrapper);

    /**
     * 根据部门代码获取部门数据
     *
     * @param typeCode 部门代码
     * @return List<Select>
     */
    List<Select> selectOptionByTypeCode(@Param("typeCode") String typeCode);

    /**
     * 根据机父构代码获取部门数据
     *
     * @param typeCode 部门代码
     * @return List<Select>
     */
    List<Select> selectOptionByParentTypeCode(@Param("code") String typeCode);

    /**
     * 根据id查询详情
     *
     * @param id 数据id
     * @return 详情
     */
    SysDept selectById(@Param("id") String id);

    /**
     * 查询部门 Activiti
     *
     * @param queryWrapper 查询条件
     * @return List<SysDept>
     */
    List<SysDept> selectDepartments(@Param("ew") QueryWrapper<SysDept> queryWrapper);

}