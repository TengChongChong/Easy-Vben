package com.easy.admin.sys.service;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.sys.model.SysDataSource;

import java.util.List;

/**
 * 数据源管理
 *
 * @author TengChongChong
 * @date 2021-12-18
 */
public interface SysDataSourceService {
    /**
     * 列表
     * @param object 查询条件
     * @param page   分页
     * @return Page<SysDataSource>
     */
    Page<SysDataSource> select(SysDataSource object, Page<SysDataSource> page);

    /**
     * 获取所有数据源
     *
     * @return List<SysDataSource>
     */
    List<SysDataSource> selectAll();

    /**
     * 获取数据源
     *
     * @return List<Select>
     */
    List<Select> selectOptions();

    /**
     * 详情
     *
     * @param id id
     * @return SysDataSource
     */
    SysDataSource get(String id);

    /**
     * 新增
     *
     * @return SysDataSource
     */
    SysDataSource add();

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    boolean remove(String ids);

    /**
     * 保存
     *
     * @param object 表单内容
     * @return SysDataSource
     */
    SysDataSource saveData(SysDataSource object);

    /**
     * 添加数据源
     *
     * @param dataSource 数据源
     */
    void addDataSource(SysDataSource dataSource);

}
