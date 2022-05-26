package com.easy.admin.sys.service;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.sys.model.SysDictType;

import java.util.List;

/**
 * 字典类型
 *
 * @author TengChongChong
 * @date 2018/11/4
 */
public interface SysDictTypeService {
    /**
     * 列表
     *
     * @param sysDict 查询条件
     * @param page    分页
     * @return Page<SysDictType>
     */
    Page<SysDictType> select(SysDictType sysDict, Page<SysDictType> page);

    /**
     * 查询所有
     *
     * @return List<Select>
     */
    List<Select> selectAll();

    /**
     * 详情
     *
     * @param id 字典id
     * @return SysDict
     */
    SysDictType get(String id);

    /**
     * 新增
     *
     * @return SysDictType
     */
    SysDictType add();

    /**
     * 删除
     *
     * @param id 字典类型ids
     * @return true/false
     */
    boolean remove(String id);

    /**
     * 保存
     *
     * @param object 表单内容
     * @return SysDictType
     */
    SysDictType saveData(SysDictType object);

}
