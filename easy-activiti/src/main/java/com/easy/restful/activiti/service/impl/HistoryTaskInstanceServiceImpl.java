package com.easy.restful.activiti.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.restful.activiti.constant.status.TaskStatus;
import com.easy.restful.activiti.dao.HistoryTaskInstanceMapper;
import com.easy.restful.activiti.model.HistoryTaskInstance;
import com.easy.restful.activiti.service.HistoryTaskInstanceService;
import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.sys.model.SysUser;
import com.easy.restful.util.ShiroUtil;
import org.springframework.stereotype.Service;

/**
 * 历史任务实例
 *
 * @author tengchong
 * @date 2020/5/14
 */
@Service
public class HistoryTaskInstanceServiceImpl extends ServiceImpl<HistoryTaskInstanceMapper, HistoryTaskInstance> implements HistoryTaskInstanceService {
    @Override
    public Page<HistoryTaskInstance> selectMy(HistoryTaskInstance task, Page<HistoryTaskInstance> page) {
        SysUser currentUser = ShiroUtil.getCurrentUser();
        QueryWrapper<HistoryTaskInstance> queryWrapper = getQueryWrapper(task);
        queryWrapper.eq("arv_applyUserId.text_", currentUser.getId());
        page.setDefaultDesc("start_time_");
        page.setRecords(getBaseMapper().select(page, queryWrapper, "asc"));
        return page;
    }

    @Override
    public Page<HistoryTaskInstance> selectParticipate(HistoryTaskInstance task, Page<HistoryTaskInstance> page) {
        SysUser currentUser = ShiroUtil.getCurrentUser();
        QueryWrapper<HistoryTaskInstance> queryWrapper = getQueryWrapper(task);
        queryWrapper.eq("aht.assignee_", currentUser.getId());
        page.setDefaultDesc("start_time_");
        page.setRecords(getBaseMapper().select(page, queryWrapper, "desc"));
        return page;
    }

    @Override
    public Page<HistoryTaskInstance> selectAll(HistoryTaskInstance task, Page<HistoryTaskInstance> page) {
        QueryWrapper<HistoryTaskInstance> queryWrapper = getQueryWrapper(task);
        page.setDefaultDesc("start_time_");
        page.setRecords(getBaseMapper().select(page, queryWrapper, "desc"));
        return page;
    }

    /**
     * 获取查询条件
     *
     * @param task 查询条件
     * @return QueryWrapper
     */
    private QueryWrapper<HistoryTaskInstance> getQueryWrapper(HistoryTaskInstance task) {
        QueryWrapper<HistoryTaskInstance> queryWrapper = new QueryWrapper<>();
        // 查询条件
        if (task != null) {
            // 名称
            if (StrUtil.isNotBlank(task.getBusinessTitle())) {
                queryWrapper.like("arv_businessTitle.text_", "%" + task.getBusinessTitle() + "%");
            }
            // 流水
            if (StrUtil.isNotBlank(task.getProcessInstanceId())) {
                queryWrapper.eq("aht.proc_inst_id_", task.getProcessInstanceId());
            }
            // 任务状态
            if (task.getTaskStatus() != null) {
                if (TaskStatus.IN_PROCESS.getCode() == task.getTaskStatus()) {
                    queryWrapper.isNull("ahp.end_time_");
                } else if (TaskStatus.COMPLETED.getCode() == task.getTaskStatus()) {
                    queryWrapper.isNotNull("ahp.end_time_").isNull("ahp.delete_reason_");
                } else if (TaskStatus.RESCINDED.getCode() == task.getTaskStatus()) {
                    queryWrapper.isNotNull("ahp.delete_reason_");
                }
            }
            // 流程
            if (StrUtil.isNotBlank(task.getProcessDefinitionId())) {
                queryWrapper.eq("aht.proc_def_id_", task.getProcessDefinitionId());
            }
        }
        return queryWrapper;
    }
}
