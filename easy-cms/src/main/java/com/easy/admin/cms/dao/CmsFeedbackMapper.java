package com.easy.admin.cms.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.cms.model.CmsFeedback;
import com.easy.admin.common.core.common.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户反馈
 *
 * @author 系统管理员
 * @date 2023-07-10
 */
public interface CmsFeedbackMapper extends BaseMapper<CmsFeedback> {
    /**
     * 查询数据
     *
     * @param page         分页
     * @param queryWrapper 查询条件
     * @return List<CmsFeedback>
     */
    List<CmsFeedback> select(Page<CmsFeedback> page, @Param("ew") QueryWrapper<CmsFeedback> queryWrapper);

    /**
     * 查询详情
     *
     * @param id id
     * @return CmsFeedback
     */
    CmsFeedback getById(@Param("id") String id);

    /**
     * 查询导出数据
     *
     * @param queryWrapper 查询条件
     * @return List<CmsFeedback>
     */
    List<CmsFeedback> exportData(@Param("ew") QueryWrapper<CmsFeedback> queryWrapper);
}