package com.easy.admin.auth.service;

import com.easy.admin.auth.model.SysDeptType;
import com.easy.admin.common.core.common.tree.Tree;

import java.util.List;

/**
 * 部门类型管理
 *
 * @author TengChongChong
 * @date 2018/12/3
 */
public interface SysDeptTypeService {
    /**
     * 查询
     *
     * @param sysDeptType 查询条件
     * @return List<SysDeptType>
     */
    List<SysDeptType> select(SysDeptType sysDeptType);

    /**
     * 获取所有数据
     *
     * @return List<JsTree>
     */
    List<Tree> selectAll();

    /**
     * 详情
     *
     * @param id id
     * @return SysDeptType
     */
    SysDeptType get(String id);

    /**
     * 新增
     *
     * @param parentId 上级id
     * @return SysDeptType
     */
    SysDeptType add(String parentId);

    /**
     * 删除
     *
     * @param ids String ids 示例 1,2,3,4
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
     * @return SysDeptType
     */
    SysDeptType saveData(SysDeptType object);

    /**
     * 保存排序
     *
     * @param sysDeptTypeList 排序
     * @return true/false
     */
    boolean saveOrder(List<SysDeptType> sysDeptTypeList);

    /**
     * 检查部门类型是否被禁用
     *
     * @param code 代码
     * @return true/false
     */
    boolean checkDeptTypeIsDisabled(String code);
}