package com.easy.restful.activiti.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.restful.activiti.model.Process;
import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.common.core.common.select.Select;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 流程管理
 *
 * @author tengchong
 * @date 2020/5/22
 */
public interface ProcessMapper extends BaseMapper<Process> {
    /**
     * 获取列表数据
     *
     * @param page 分页
     * @param queryWrapper 查询条件
     * @return 数据列表
     */
    List<Process> select(Page<Process> page, @Param("ew") QueryWrapper<Process> queryWrapper);

    /**
     * 查询详情
     *
     * @param id 流程实例ID
     * @return 流程详情
     */
    Process getById(@Param("id") String id);

    /**
     * 查询流程数据用于放到select的option中
     *
     * @return 数据集合
     */
    List<Select> selectProcessForSelect();
}
