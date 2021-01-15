package com.easy.restful.activiti.service;

import com.easy.restful.activiti.model.HistoryTaskInstance;
import com.easy.restful.common.core.common.pagination.Page;

/**
 * 历史任务实例
 *
 * @author tengchong
 * @date 2020/5/14
 */
public interface HistoryTaskInstanceService {
    /**
     * 我发起的办理中+已办结的任务
     *
     * @param object 查询条件
     * @param page   分页
     * @return Page
     */
    Page<HistoryTaskInstance> selectMy(HistoryTaskInstance object, Page<HistoryTaskInstance> page);

    /**
     * 用户参与过的任务
     *
     * @param object 查询条件
     * @param page   分页
     * @return Page
     */
    Page<HistoryTaskInstance> selectParticipate(HistoryTaskInstance object, Page<HistoryTaskInstance> page);

    /**
     * 所有任务，包含办理中和已办结，一般分配给管理员
     *
     * @param object 查询条件
     * @param page   分页
     * @return Page
     */
    Page<HistoryTaskInstance> selectAll(HistoryTaskInstance object, Page<HistoryTaskInstance> page);
}
