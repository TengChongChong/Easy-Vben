package com.easy.admin.auth.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.auth.model.SysMenu;
import com.easy.admin.auth.model.vo.SysMenuVO;
import com.easy.admin.common.core.common.tree.Tree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单
 *
 * @author 系统管理员
 * @date 2025-03-21
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 查询数据（无分页）
     *
     * @param queryWrapper 查询条件
     * @return List<SysMenu>
     */
    List<SysMenuVO> selectWithoutPage(@Param("ew") QueryWrapper<SysMenu> queryWrapper);

    /**
     * 查询所有数据（Tree）
     *
     * @return List<JsTree>
     */
    List<Tree> selectAll();

    /**
     * 查询详情
     *
     * @param id id
     * @return SysMenu
     */
    SysMenu getById(@Param("id") String id);

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
    Integer updateOrderBatch(List<SysMenu> list);

    /**
     * 检查是否有此标题的菜单
     *
     * @param title 标题
     * @return 条数
     */
    Integer countByTitle(@Param("title") String title);
}