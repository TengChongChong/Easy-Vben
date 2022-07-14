package com.easy.admin.activiti.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.activiti.model.ActivitiProcess;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 流程管理
 *
 * @author TengChongChong
 * @date 2020/5/22
 */
public interface ActivitiProcessMapper extends BaseMapper<ActivitiProcess> {
    /**
     * 获取列表数据
     *
     * @param page 分页
     * @param queryWrapper 查询条件
     * @return 数据列表
     */
    List<ActivitiProcess> select(Page<ActivitiProcess> page, @Param("ew") QueryWrapper<ActivitiProcess> queryWrapper);

    /**
     * 查询详情
     *
     * @param id 流程实例ID
     * @return 流程详情
     */
    ActivitiProcess getById(@Param("id") String id);

    /**
     * 查询流程数据用于放到select的option中
     *
     * @return 数据集合
     */
    List<Select> selectProcessForSelect();
}
