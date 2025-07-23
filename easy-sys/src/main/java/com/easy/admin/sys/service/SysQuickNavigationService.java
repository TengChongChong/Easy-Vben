package com.easy.admin.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.easy.admin.sys.model.SysQuickNavigation;
import com.easy.admin.sys.model.vo.SysQuickNavigationVO;

import java.util.List;

/**
 * 快捷导航
 *
 * @author 系统管理员
 * @date 2025-07-09
 */
public interface SysQuickNavigationService extends IService<SysQuickNavigation> {

    /**
     * 查询数据
     *
     * @param sysQuickNavigation 查询条件
     * @return List<SysQuickNavigationVO>
     */
    List<SysQuickNavigationVO> select(SysQuickNavigationVO sysQuickNavigation);

    /**
     * 查询当前登录用户的快捷菜单
     *
     * @param roleIds roleIds
     * @return List<SysQuickNavigationVO>
     */
    List<SysQuickNavigationVO> selectQuickNavigationByRole(List<String> roleIds);

    /**
     * 查询详情
     *
     * @param id id
     * @return SysQuickNavigationVO
     */
    SysQuickNavigationVO get(String id);

    /**
     * 新增
     *
     * @return SysQuickNavigationVO
     */
    SysQuickNavigationVO add();

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    boolean remove(String ids);

    /**
     * 保存/修改
     *
     * @param sysQuickNavigationVO 表单内容
     * @return SysQuickNavigationVO
     */
    SysQuickNavigationVO saveData(SysQuickNavigationVO sysQuickNavigationVO);

    /**
     * 保存排序
     *
     * @param sysQuickNavigationList 排序数据
     * @return true/false
     */
    boolean saveOrderNo(List<SysQuickNavigation> sysQuickNavigationList);

}
