package com.easy.restful.sys.service;

import com.easy.restful.common.core.common.tree.Tree;
import com.easy.restful.common.core.common.select.Select;
import com.easy.restful.sys.model.SysDeptType;

import java.util.List;

/**
 * 部门类型管理
 *
 * @author tengchong
 * @date 2018/12/3
 */
public interface SysDeptTypeService {
    /**
     * 根据父id获取数据
     *
     * @param pId 父id
     * @return List<JsTree>
     */
    List<Tree> selectByPId(String pId);

    /**
     * 检查是否有子类型
     *
     * @param code 部门类型编码
     * @return true/false
     */
    boolean checkHasChild(String code);

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
     * @param pId 上级id
     * @return SysDeptType
     */
    SysDeptType add(String pId);

    /**
     * 删除
     *
     * @param id 部门类型id
     * @return true/false
     */
    boolean remove(String id);

    /**
     * 批量删除
     *
     * @param ids String ids 示例 1,2,3,4
     * @return true/false
     */
    boolean batchRemove(String ids);

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
     * 拖动菜单/权限改变目录或顺序
     *
     * @param id          拖动的菜单/权限id
     * @param parent      拖动后的父id
     * @param oldParent   拖动前的id
     * @param position    拖动前的下标
     * @param oldPosition 拖动后的下标
     * @return true/false
     */
    boolean move(String id, String parent, String oldParent, Integer position, Integer oldPosition);

    /**
     * 根据关键字搜索
     *
     * @param title 关键字
     * @return List<JsTree>
     */
    List<Tree> selectByTitle(String title);

    /**
     * 根据同级代码获取类型数据
     *
     * @param code 代码
     * @return List<Select>
     */
    List<Select> selectOptionBySameLevel(String code);

    /**
     * 根据父代码获取子类型数据
     *
     * @param parentCode 父代码
     * @return List<Select>
     */
    List<Select> selectOptionByParentCode(String parentCode);

    /**
     * 检查部门类型是否被禁用
     *
     * @param code 代码
     * @return true/false
     */
    boolean checkDeptTypeIsDisabled(String code);
}