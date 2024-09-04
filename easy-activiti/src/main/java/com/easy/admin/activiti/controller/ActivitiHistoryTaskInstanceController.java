package com.easy.admin.activiti.controller;

import com.easy.admin.activiti.model.ActivitiHistoryTaskInstance;
import com.easy.admin.activiti.service.ActivitiHistoryTaskInstanceService;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.annotation.ResponseResult;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 历史任务实例
 *
 * @author TengChongChong
 * @date 2020/5/14
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/activiti/history/task-instance")
public class ActivitiHistoryTaskInstanceController {

    @Autowired
    private ActivitiHistoryTaskInstanceService service;

    /**
     * 我发起的
     *
     * @param task 查询条件
     * @return Page<HistoryTaskInstance>
     */
    @GetMapping("my")
    @SaCheckPermission("activiti:historic:select:my")
    public Page<ActivitiHistoryTaskInstance> selectMy(ActivitiHistoryTaskInstance task, Page<ActivitiHistoryTaskInstance> page) {
        return service.selectMy(task, page);
    }

    /**
     * 我办理的
     *
     * @param task 查询条件
     * @return Page<HistoryTaskInstance>
     */
    @GetMapping("participate")
    @SaCheckPermission("activiti:historic:select:participate")
    public Page<ActivitiHistoryTaskInstance> selectParticipate(ActivitiHistoryTaskInstance task, Page<ActivitiHistoryTaskInstance> page) {
        return service.selectParticipate(task, page);
    }

    /**
     * 所有任务
     *
     * @param task 查询条件
     * @return Page<HistoryTaskInstance>
     */
    @GetMapping("all")
    @SaCheckPermission("activiti:historic:select:all")
    public Page<ActivitiHistoryTaskInstance> selectAll(ActivitiHistoryTaskInstance task, Page<ActivitiHistoryTaskInstance> page) {
        return service.selectAll(task, page);
    }
}
