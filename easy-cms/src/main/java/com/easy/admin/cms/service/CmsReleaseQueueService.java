package com.easy.admin.cms.service;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.cms.model.CmsReleaseQueue;

import java.util.List;

/**
 * 发布列队详情
 *
 * @author 系统管理员
 * @date 2023-07-12
 */
public interface CmsReleaseQueueService {
    /**
     * 查询数据
     *
     * @param cmsReleaseQueue 查询条件
     * @param page            分页
     * @return Page<CmsReleaseQueue>
     */
    Page<CmsReleaseQueue> select(CmsReleaseQueue cmsReleaseQueue, Page<CmsReleaseQueue> page);

    /**
     * 获取列队数据
     *
     * @param parentId 父id
     * @param status   状态
     * @return 列队
     */
    List<CmsReleaseQueue> selectQueue(String parentId, String status);

    /**
     * 获取单个发布数据
     *
     * @param id id
     * @return CmsReleaseQueue
     */
    CmsReleaseQueue getQueueById(String id);

    /**
     * 更新数据状态
     *
     * @param id     id
     * @param status 状态
     * @return true/false
     */
    boolean setStatus(String id, String status);

    /**
     * 获取页面列队
     *
     * @param parentId 任务id
     * @param siteId   站点id
     * @param pageIds  页面ids
     * @return List<CmsReleaseQueue>
     */
    List<CmsReleaseQueue> generatePageQueue(String parentId, String siteId, String[] pageIds);

    /**
     * 获取栏目列队
     *
     * @param parentId       任务id
     * @param siteId         站点id
     * @param columnIds      栏目ids
     * @param releaseArticle 是否发布栏目下文章
     * @return List<CmsReleaseQueue>
     */
    List<CmsReleaseQueue> generateColumnQueue(String parentId, String siteId, String[] columnIds, boolean releaseArticle);

    /**
     * 保存列队
     *
     * @param queueList 列队
     * @return List<CmsReleaseQueue>
     */
    List<CmsReleaseQueue> saveQueue(List<CmsReleaseQueue> queueList);

    /**
     * 更新列队
     *
     * @param queueList 列队
     * @return List<CmsReleaseQueue>
     */
    List<CmsReleaseQueue> updateQueue(List<CmsReleaseQueue> queueList);

    /**
     * 查询任务数量
     *
     * @param parentId 任务id
     * @param status   状态
     * @return count
     */
    long selectCount(String parentId, String status);

}
