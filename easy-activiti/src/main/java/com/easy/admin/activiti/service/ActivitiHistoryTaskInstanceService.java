package com.easy.admin.activiti.service;

import com.easy.admin.activiti.model.ActivitiHistoryTaskInstance;
import com.easy.admin.common.core.common.pagination.Page;

/**
 * 历史任务实例
 *
 * @author TengChongChong
 * @date 2020/5/14
 */
public interface ActivitiHistoryTaskInstanceService {
    /**
     * 我发起的办理中+已办结的任务
     *
     * @param object 查询条件
     * @param page   分页
     * @return Page
     */
    Page<ActivitiHistoryTaskInstance> selectMy(ActivitiHistoryTaskInstance object, Page<ActivitiHistoryTaskInstance> page);

    /**
     * 用户参与过的任务
     *
     * @param object 查询条件
     * @param page   分页
     * @return Page
     */
    Page<ActivitiHistoryTaskInstance> selectParticipate(ActivitiHistoryTaskInstance object, Page<ActivitiHistoryTaskInstance> page);

    /**
     * 所有任务，包含办理中和已办结，一般分配给管理员
     *
     * @param object 查询条件
     * @param page   分页
     * @return Page
     */
    Page<ActivitiHistoryTaskInstance> selectAll(ActivitiHistoryTaskInstance object, Page<ActivitiHistoryTaskInstance> page);
}
