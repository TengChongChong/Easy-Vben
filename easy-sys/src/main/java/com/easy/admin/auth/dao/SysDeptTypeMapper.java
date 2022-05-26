package com.easy.admin.auth.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.auth.model.SysDeptType;
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
     * 根据父id查询数据
     *
     * @param parentId 父id
     * @return List<JsTree>
     */
    List<Tree> selectByParentId(@Param("parentId") String parentId);

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
    SysDeptType selectInfo(@Param("id") String id);

    /**
     * 查询用户角色ids
     *
     * @param id 用户id
     * @return 角色集合
     */
    List<String> selectRoles(@Param("id") String id);
    /**
     * 查询指定数据
     *
     * @param parentId 父id
     * @param str    开始位置
     * @param length 长度
     * @return List<T>
     */
    List<SysDeptType> selectOrderInfo(@Param("parentId") String parentId, @Param("str") Integer str, @Param("length") Integer length);

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
     * @return
     */
    Integer getMaxOrderNo(@Param("parentId") String id);

    /**
     * 根据同级代码获取类型数据
     *
     * @param code 代码
     * @return option
     */
    List<Select> selectOptionBySameLevel(@Param("code") String code);

    /**
     * 根据父代码获取子类型数据
     *
     * @param parentCode 父代码
     * @return option
     */
    List<Select> selectOptionByParentCode(@Param("parentCode") String parentCode);

    /**
     * 查询子类型数量
     *
     * @param code 部门类型编码
     * @return 数量
     */
    int selectChildCount(@Param("code") String code);
}