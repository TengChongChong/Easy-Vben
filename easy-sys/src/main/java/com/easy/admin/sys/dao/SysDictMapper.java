package com.easy.admin.sys.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.sys.model.SysDict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 字典管理
 * @author TengChongChong
 */
public interface SysDictMapper extends BaseMapper<SysDict> {

    /**
     * 获取列表数据
     *
     * @param page 分页
     * @param queryWrapper 查询条件
     * @return List<SysDict>
     */
    List<SysDict> select(Page<SysDict> page, @Param("ew") QueryWrapper<SysDict> queryWrapper);

    /**
     * 根据类型获取数据
     *
     * @param dictType 字典类型
     * @param status 状态
     * @return List<Select>
     */
    List<Select> selectByDictType(@Param("dictType") String dictType, @Param("status") String status);

    /**
     * 获取指定字典类型最大排序值
     *
     * @param dictType 字典类型
     * @return 排序值
     */
    int getMaxOrderNo(@Param("dictType") String dictType);

    /**
     * 查询所有字典
     *
     * @param status 状态
     * @return List<SysDict>
     */
    List<SysDict> selectAll(@Param("status") String status);
}