package com.easy.restful.activiti.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.restful.activiti.model.Model;
import com.easy.restful.common.core.common.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 流程模型
 *
 * @author TengChong
 * @date 2020-05-08
 */
public interface ModelMapper extends BaseMapper<Model> {

    /**
     * 获取列表数据
     *
     * @param page 分页
     * @param queryWrapper 查询条件
     * @return 数据列表
     */
    List<Model> select(Page<Model> page, @Param("ew") QueryWrapper<Model> queryWrapper);

    /**
     * 获取列表数据
     *
     * @param key 模型标识
     * @return 流程定义ID
     */
    String selectProcessDefinitionId(@Param("key") String key);

    /**
     * 检查流程标识是否存在
     *
     * @param queryWrapper 查询条件
     * @return true/false
     */
    Integer selectCountByKey(@Param("ew") QueryWrapper<Model> queryWrapper);
}