package com.easy.admin.sys.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.sys.model.SysDictType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 字典类型管理
 * @author TengChongChong
 */
public interface SysDictTypeMapper extends BaseMapper<SysDictType> {

    /**
     * 获取列表数据
     *
     * @param queryWrapper 查询条件
     * @return List<SysDictType>
     */
    List<SysDictType> select(Page<SysDictType> page, @Param("ew") QueryWrapper<SysDictType> queryWrapper);

    /**
     * 获取字典类型
     *
     * @param queryWrapper 查询条件
     * @return List<Select>
     */
    List<Select> selectType(@Param("ew") QueryWrapper<SysDictType> queryWrapper);

    /**
     * 查询字典数量
     * @param queryWrapper 查询条件
     * @return int
     */
    int countDict(@Param("ew") QueryWrapper<SysDictType> queryWrapper);

    /**
     * 查询导出数据
     *
     * @param queryWrapper 查询条件
     * @return List<SysDictType>
     */
    List<SysDictType> exportData(@Param("ew") QueryWrapper<SysDictType> queryWrapper);

    /**
     * 导入时验证业务表中是否已存在
     *
     * @param templateId 导入模板id
     * @param status     状态
     * @return 更新条数
     */
    Integer updateDuplicateData(@Param("templateId") String templateId, @Param("status") String status);
}