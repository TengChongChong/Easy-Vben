package com.easy.admin.cms.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.cms.model.CmsReleaseQueue;
import com.easy.admin.common.core.common.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 发布列队详情
 *
 * @author 系统管理员
 * @date 2023-07-12
 */
public interface CmsReleaseQueueMapper extends BaseMapper<CmsReleaseQueue> {
    /**
     * 查询数据
     *
     * @param page         分页
     * @param queryWrapper 查询条件
     * @return List<CmsReleaseQueue>
     */
    List<CmsReleaseQueue> select(Page<CmsReleaseQueue> page, @Param("ew") QueryWrapper<CmsReleaseQueue> queryWrapper);

    /**
     * 获取列队数据
     *
     * @param parentId 父id
     * @param status   状态
     * @return 列队
     */
    List<CmsReleaseQueue> selectQueue(@Param("parentId") String parentId, @Param("status") String status);

    /**
     * 获取单个发布数据
     *
     * @param id id
     * @return CmsReleaseQueue
     */
    CmsReleaseQueue getQueueById(@Param("id") String id);

    /**
     * 查询任务完成数量
     *
     * @param parentId 任务id
     * @param status   状态
     * @return count
     */
    long selectDoneCount(@Param("parentId") String parentId, @Param("status") String status);

}