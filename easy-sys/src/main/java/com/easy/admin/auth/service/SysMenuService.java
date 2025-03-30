package com.easy.admin.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.easy.admin.auth.model.SysMenu;
import com.easy.admin.auth.model.vo.SysMenuVO;
import com.easy.admin.common.core.common.tree.Tree;

import java.util.List;

/**
 * 菜单
 *
 * @author 系统管理员
 * @date 2025-03-21
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 查询数据（无分页）
     *
     * @param sysMenu 查询条件
     * @return List<SysMenuVO>
     */
    List<SysMenuVO> select(SysMenuVO sysMenu);

    /**
     * 查询所有数据（Tree）
     *
     * @return List<Tree>
     */
    List<Tree> selectAll();

    /**
     * 查询详情
     *
     * @param id id
     * @return SysMenuVO
     */
    SysMenuVO get(String id);

    /**
     * 新增或新增下级
     *
     * @param parentId 上级id
     * @return SysMenuVO
     */
    SysMenuVO add(String parentId);

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    boolean remove(String ids);

    /**
     * 设置状态
     *
     * @param id     角色id
     * @param status 状态
     * @param type   类型
     * @return true/false
     */
    boolean setStatus(String id, String status, String type);

    /**
     * 保存排序
     *
     * @param sysMenuList 排序
     * @return true/false
     */
    boolean saveOrder(List<SysMenu> sysMenuList);

    /**
     * 保存/修改
     *
     * @param sysMenuVO 表单内容
     * @return SysMenuVO
     */
    SysMenuVO saveData(SysMenuVO sysMenuVO);

    /**
     * 检查是否有此标题的菜单
     *
     * @param title 标题
     * @return true/false
     */
    boolean hasMenu(String title);
}
