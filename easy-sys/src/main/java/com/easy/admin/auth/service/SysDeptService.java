package com.easy.admin.auth.service;


import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.auth.model.SysDept;

import java.util.List;

/**
 * 部门管理
 *
 * @author TengChongChong
 * @date 2018/12/3
 */
public interface SysDeptService {

    /**
     * 获取指定parentId下的数据
     *
     * @param parentId 父id
     * @return List<JsTree>
     */
    List<Tree> selectByParentId(String parentId);

    /**
     * 根据名称搜索
     *
     * @param title 关键字
     * @return List<JsTree>
     */
    List<Tree> selectByTitle(String title);

    /**
     * 列表
     *
     * @param object 查询条件
     * @param page   分页
     * @return Page<SysDept>
     */
    Page<SysDept> select(SysDept object, Page<SysDept> page);

    /**
     * 详情
     *
     * @param id id
     * @return SysDept
     */
    SysDept get(String id);

    /**
     * 查询部门名称
     *
     * @param id id
     * @return name
     */
    String getName(String id);

    /**
     * 新增
     *
     * @param parentId      上级id
     * @param deptType 类型
     * @return SysDept
     */
    SysDept add(String parentId, String deptType);

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
     * 根据部门类型id获取部门数量
     *
     * @param typeIds 1,2,3 或 1
     * @return int
     */
    int selectCountByTypeIds(String typeIds);

    /**
     * 更新部门类型代码
     *
     * @param oldCode 原代码
     * @param newCode 新代码
     * @return true/false
     */
    boolean updateDeptTypeCode(String oldCode, String newCode);

    /**
     * 新增/修改页面获取部门类型option
     *
     * @param parentId      上级id
     * @param deptType 类型
     * @return option
     */
    List<Select> selectDeptTypeOption(String parentId, String deptType);

    /**
     * 新增/修改页面获取父部门option
     *
     * @param parentId      上级部门id
     * @param deptType 部门类型
     * @return List<Select>
     */
    List<Select> selectUpDeptOption(String parentId, String deptType);

    /**
     * 查询部门 Activiti
     *
     * @param sysDept 查询条件
     * @return List<SysDept>
     */
    List<SysDept> selectDepartments(SysDept sysDept);
}