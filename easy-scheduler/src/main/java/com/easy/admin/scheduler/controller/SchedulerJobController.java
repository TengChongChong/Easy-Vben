package com.easy.admin.scheduler.controller;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.annotation.ResponseResult;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.scheduler.model.SchedulerJob;
import com.easy.admin.scheduler.model.SchedulerJobMethodOption;
import com.easy.admin.scheduler.service.SchedulerJobService;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
 * 定时任务
 *
 * @author TengChong
 * @date 2019-05-11
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/scheduler/job")
public class SchedulerJobController {

    /**
     * 定时任务  service
     */
    @Autowired
    private SchedulerJobService service;

    /**
     * 列表
     *
     * @param schedulerJob 查询条件
     * @return Page<SchedulerJob>
     */
    @GetMapping()
    @SaCheckPermission("scheduler:job:select")
    public Page<SchedulerJob> select(SchedulerJob schedulerJob, Page<SchedulerJob> page) {
        return service.select(schedulerJob, page);
    }

    /**
     * 查询候选 Bean
     *
     * @param keyword 关键字
     * @return Bean 选项
     */
    @GetMapping("select/beans")
    @SaCheckPermission("scheduler:job:select")
    public List<Select> selectBeans(@RequestParam(value = "keyword", required = false) String keyword) {
        return service.selectBeans(keyword);
    }

    /**
     * 查询 Bean 可调用的方法
     *
     * @param bean Bean 名称
     * @return 方法选项
     */
    @GetMapping("select/methods")
    @SaCheckPermission("scheduler:job:select")
    public List<SchedulerJobMethodOption> selectMethods(@RequestParam("bean") String bean) {
        return service.selectMethods(bean);
    }

    /**
     * 详情
     *
     * @param id id
     * @return SchedulerJob
     */
    @GetMapping("{id}")
    @SaCheckPermission("scheduler:job:select")
    public SchedulerJob get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 新增
     *
     * @return SchedulerJob
     */
    @GetMapping("/add")
    public SchedulerJob add() {
        return service.add();
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    @DeleteMapping("{ids}")
    @SaCheckPermission("scheduler:job:remove")
    public boolean remove(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存
     *
     * @param schedulerJob 表单内容
     * @return SchedulerJob
     */
    @PostMapping()
    @SaCheckPermission("scheduler:job:save")
    public SchedulerJob saveData(@Valid @RequestBody SchedulerJob schedulerJob) {
        return service.saveData(schedulerJob);
    }

    /**
     * 开启
     *
     * @param id 数据id
     * @return true/false
     */
    @PostMapping("start/{id}")
    @SaCheckPermission("scheduler:job:save")
    public boolean start(@PathVariable("id") String id) {
        service.start(id);
        return true;
    }

    /**
     * 暂停
     *
     * @param id 数据id
     * @return true/false
     */
    @PostMapping("pause/{id}")
    @SaCheckPermission("scheduler:job:save")
    public boolean pause(@PathVariable("id") String id) {
        service.pause(id);
        return true;
    }

    /**
     * 全部开启
     *
     * @return true/false
     */
    @PostMapping("start/all")
    @SaCheckPermission("scheduler:job:save")
    public boolean startAll() {
        service.startAll();
        return true;
    }

    /**
     * 全部暂停
     *
     * @return true/false
     */
    @PostMapping("pause/all")
    @SaCheckPermission("scheduler:job:save")
    public boolean pauseAll() {
        service.pauseAll();
        return true;
    }

    /**
     * 立即执行指定任务
     *
     * @param id 数据id
     * @return true/false
     */
    @PostMapping("immediate/execution/{id}")
    @SaCheckPermission("scheduler:job:save")
    public boolean immediateExecution(@PathVariable("id") String id) {
        return service.immediateExecution(id);
    }
}
