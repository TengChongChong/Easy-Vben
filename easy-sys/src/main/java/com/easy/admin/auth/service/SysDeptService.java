package com.easy.admin.auth.service;


import com.easy.admin.auth.model.SysDept;
import com.easy.admin.common.core.common.tree.Tree;

import java.util.List;

/**
 * 部门管理
 *
 * @author TengChongChong
 * @date 2018/12/3
 */
public interface SysDeptService {

    /**
     * 查询
     *
     * @param sysDept 查询条件
     * @return List<SysDept>
     */
    List<SysDept> select(SysDept sysDept);

    /**
     * 获取所有数据
     *
     * @return List<Tree>
     */
    List<Tree> selectAll();

    /**
     * 详情
     *
     * @param id id
     * @return SysDept
     */
    SysDept get(String id);

    /**
     * 新增
     *
     * @param parentId      上级id
     * @param typeCode 类型
     * @return SysDept
     */
    SysDept add(String parentId, String typeCode);

    /**
     * 删除
     *
     * @param ids 要删除的id 1,2,3 或 1
     * @return true/false
     */
    boolean remove(String ids);
    /**
     * 设置状态
     *
     * @param ids    角色id
     * @param status 状态
     * @return true/false
     */
    boolean setStatus(String ids, String status);
    /**
     * 保存
     *
     * @param object 表单内容
     * @return SysDept
     */
    SysDept saveData(SysDept object);

    /**
     * 保存排序
     *
     * @param sysDeptList 排序
     * @return true/false
     */
    boolean saveOrder(List<SysDept> sysDeptList);

    /**
     * 根据部门类型id获取部门数量 for 删除部门类型检查
     *
     * @param typeIds 1,2,3 或 1
     * @return int
     */
    int selectCountByTypeIds(String typeIds);

    /**
     * 更新部门类型代码 for 部门类型修改
     *
     * @param oldCode 原代码
     * @param newCode 新代码
     * @return true/false
     */
    boolean updateDeptTypeCode(String oldCode, String newCode);

    /**
     * 查询部门 Activiti
     *
     * @param sysDept 查询条件
     * @return List<SysDept>
     */
    List<SysDept> selectDepartments(SysDept sysDept);
}