package com.easy.admin.cms.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.cms.model.CmsRelease;
import com.easy.admin.common.core.common.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 网站发布
 *
 * @author 系统管理员
 * @date 2023-07-12
 */
public interface CmsReleaseMapper extends BaseMapper<CmsRelease> {
    /**
     * 查询数据
     *
     * @param page         分页
     * @param queryWrapper 查询条件
     * @return List<CmsRelease>
     */
    List<CmsRelease> select(Page<CmsRelease> page, @Param("ew") QueryWrapper<CmsRelease> queryWrapper);


    /**
     * 获取发布进度
     *
     * @param id id
     * @return CmsRelease
     */
    CmsRelease getReleaseProgress(@Param("id") String id);

    /**
     * 设置任务为开始状态
     *
     * @param id          id
     * @param status      状态
     * @param releaseDate 发布时间
     * @return int
     */
    int setStartStatus(@Param("id") String id, @Param("status") String status, @Param("releaseDate") Date releaseDate);

    /**
     * 设置任务为已完成状态
     *
     * @param id      id
     * @param status  状态
     * @param endDate 完成时间
     * @param done    完成数量
     * @param fail    失败数量
     * @return int
     */
    int setEndStatus(@Param("id") String id, @Param("status") String status, @Param("endDate") Date endDate, @Param("done") Long done, @Param("fail") Long fail);

}