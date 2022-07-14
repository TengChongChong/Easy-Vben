package com.easy.admin.activiti.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.activiti.constant.status.ActivitiTaskStatus;
import com.easy.admin.activiti.dao.ActivitiHistoryTaskInstanceMapper;
import com.easy.admin.activiti.model.ActivitiHistoryTaskInstance;
import com.easy.admin.activiti.service.ActivitiHistoryTaskInstanceService;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.auth.model.SysUser;
import com.easy.admin.util.ShiroUtil;
import org.springframework.stereotype.Service;

/**
 * 历史任务实例
 *
 * @author TengChongChong
 * @date 2020/5/14
 */
@Service
public class ActivitiHistoryTaskInstanceServiceImpl extends ServiceImpl<ActivitiHistoryTaskInstanceMapper, ActivitiHistoryTaskInstance> implements ActivitiHistoryTaskInstanceService {
    @Override
    public Page<ActivitiHistoryTaskInstance> selectMy(ActivitiHistoryTaskInstance task, Page<ActivitiHistoryTaskInstance> page) {
        SysUser currentUser = ShiroUtil.getCurrentUser();
        QueryWrapper<ActivitiHistoryTaskInstance> queryWrapper = getQueryWrapper(task);
        queryWrapper.eq("arv_applyUserId.text_", currentUser.getId());
        page.setDefaultDesc("start_time_");
        page.setRecords(baseMapper.select(page, queryWrapper, "asc"));
        return page;
    }

    @Override
    public Page<ActivitiHistoryTaskInstance> selectParticipate(ActivitiHistoryTaskInstance task, Page<ActivitiHistoryTaskInstance> page) {
        SysUser currentUser = ShiroUtil.getCurrentUser();
        QueryWrapper<ActivitiHistoryTaskInstance> queryWrapper = getQueryWrapper(task);
        queryWrapper.eq("aht.assignee_", currentUser.getId());
        page.setDefaultDesc("start_time_");
        page.setRecords(baseMapper.select(page, queryWrapper, "desc"));
        return page;
    }

    @Override
    public Page<ActivitiHistoryTaskInstance> selectAll(ActivitiHistoryTaskInstance task, Page<ActivitiHistoryTaskInstance> page) {
        QueryWrapper<ActivitiHistoryTaskInstance> queryWrapper = getQueryWrapper(task);
        page.setDefaultDesc("start_time_");
        page.setRecords(baseMapper.select(page, queryWrapper, "desc"));
        return page;
    }

    /**
     * 获取查询条件
     *
     * @param task 查询条件
     * @return QueryWrapper
     */
    private QueryWrapper<ActivitiHistoryTaskInstance> getQueryWrapper(ActivitiHistoryTaskInstance task) {
        QueryWrapper<ActivitiHistoryTaskInstance> queryWrapper = new QueryWrapper<>();
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
                if (ActivitiTaskStatus.IN_PROCESS.getCode().equals(task.getTaskStatus()) ) {
                    queryWrapper.isNull("ahp.end_time_");
                } else if (ActivitiTaskStatus.COMPLETED.getCode().equals(task.getTaskStatus())) {
                    queryWrapper.isNotNull("ahp.end_time_").isNull("ahp.delete_reason_");
                } else if (ActivitiTaskStatus.RESCINDED.getCode().equals(task.getTaskStatus())) {
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
