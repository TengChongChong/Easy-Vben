package com.easy.restful.sys.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.restful.common.core.common.tree.Tree;
import com.easy.restful.sys.model.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色
 * @author tengchong
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
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
     * @param id 角色id
     * @return SysRole
     */
    SysRole selectInfo(@Param("id") String id);

    /**
     * 查询权限id集合
     *
     * @param id 角色id
     * @return 集合
     */
    List<String> selectPermissions(@Param("id") String id);

    /**
     * 查询指定数据
     *
     * @param pId 父id
     * @param str    开始位置
     * @param length 长度
     * @return List<T>
     */
    List<SysRole> selectOrderInfo(@Param("pId") String pId, @Param("str") Integer str, @Param("length") Integer length);

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

    /**
     * 根据用户id获取角色标识
     *
     * @param userId 用户id
     * @return 角色标识
     */
    List<String> selectRoleCodeByUserId(@Param("userId") String userId);

    /**
     * 查询所有权限标识
     *
     * @return List<String>
     */
    List<String> selectAllRoleCodes();

    /**
     * 查询所有权限 Activiti
     * @param queryWrapper 查询条件
     *
     * @return List<SysRole>
     */
    List<SysRole> selectRole(@Param("ew") QueryWrapper<SysRole> queryWrapper);
}