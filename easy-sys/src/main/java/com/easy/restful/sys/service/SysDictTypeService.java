package com.easy.restful.sys.service;

import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.sys.model.SysDictType;

import java.util.List;

/**
 * 字典类型
 *
 * @author tengchong
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
     * @return List<SysDictType>
     */
    List<SysDictType> selectAll();

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
