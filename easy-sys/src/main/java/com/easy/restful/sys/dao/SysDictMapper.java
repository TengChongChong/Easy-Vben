package com.easy.restful.sys.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.common.core.common.select.Select;
import com.easy.restful.sys.model.SysDict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 字典管理
 * @author tengchong
 */
public interface SysDictMapper extends BaseMapper<SysDict> {

    /**
     * 获取列表数据
     *
     * @param page 分页
     * @param queryWrapper 查询条件
     * @return
     */
    List<SysDict> select(Page page, @Param("ew") QueryWrapper<SysDict> queryWrapper);

    /**
     * 根据类型获取数据
     *
     * @param dictType 字典类型
     * @param status 状态
     * @return
     */
    List<Select> selectByDictType(@Param("dictType") String dictType, @Param("status") String status);

    /**
     * 获取指定字典类型最大排序值
     *
     * @param dictType
     * @return
     */
    int getMaxOrderNo(@Param("dictType") String dictType);


    /**
     * 查询所有字典
     * 用户生成静态数据
     *
     * @param status 状态
     * @return
     */
    List<SysDict> generateDictData(@Param("status") String status);
}