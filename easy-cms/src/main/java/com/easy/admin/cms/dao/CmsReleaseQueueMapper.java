package com.easy.admin.cms.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.cms.model.CmsReleaseQueue;
import com.easy.admin.common.core.common.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 发布列队
 *
 * @author TengChongChong
 * @date 2021-11-24
 */
public interface CmsReleaseQueueMapper extends BaseMapper<CmsReleaseQueue> {
    /**
     * 获取列表数据
     *
     * @param page 分页
     * @param queryWrapper 查询条件
     * @return List<CmsReleaseQueue>
     */
    List<CmsReleaseQueue> select(Page<CmsReleaseQueue> page, @Param("ew") QueryWrapper<CmsReleaseQueue> queryWrapper);

    /**
     * 获取列队数据
     *
     * @param pId    父id
     * @param status 状态
     * @return 列队
     */
    List<CmsReleaseQueue> selectQueue(@Param("pId") String pId, @Param("status") String status);

    /**
     * 获取单个发布数据
     *
     * @param id    id
     * @return CmsReleaseQueue
     */
    CmsReleaseQueue getQueueById(@Param("id") String id);

    /**
     * 查询任务完成数量
     *
     * @param pId    任务id
     * @param status 状态
     * @return count
     */
    long selectDoneCount(@Param("pId") String pId, @Param("status") String status);
}