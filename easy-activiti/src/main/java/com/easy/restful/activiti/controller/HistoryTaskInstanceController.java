package com.easy.restful.activiti.controller;

import com.easy.restful.activiti.model.HistoryTaskInstance;
import com.easy.restful.activiti.service.HistoryTaskInstanceService;
import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.core.annotation.ResponseResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 历史任务实例
 *
 * @author tengchong
 * @date 2020/5/14
 */
@RestController
@ResponseResult
@RequestMapping("/auth/activiti/history/task-instance")
public class HistoryTaskInstanceController {

    @Autowired
    private HistoryTaskInstanceService service;

    /**
     * 我发起的
     *
     * @param task 查询条件
     * @return Page<HistoryTaskInstance>
     */
    @GetMapping("my")
    @RequiresPermissions("activiti:historic:select:my")
    public Page<HistoryTaskInstance> selectMy(HistoryTaskInstance task, Page<HistoryTaskInstance> page) {
        return service.selectMy(task, page);
    }

    /**
     * 我办理的
     *
     * @param task 查询条件
     * @return Page<HistoryTaskInstance>
     */
    @GetMapping("participate")
    @RequiresPermissions("activiti:historic:select:participate")
    public Page<HistoryTaskInstance> selectParticipate(HistoryTaskInstance task, Page<HistoryTaskInstance> page) {
        return service.selectParticipate(task, page);
    }

    /**
     * 所有任务
     *
     * @param task 查询条件
     * @return Page<HistoryTaskInstance>
     */
    @GetMapping("all")
    @RequiresPermissions("activiti:historic:select:all")
    public Page<HistoryTaskInstance> selectAll(HistoryTaskInstance task, Page<HistoryTaskInstance> page) {
        return service.selectAll(task, page);
    }
}
