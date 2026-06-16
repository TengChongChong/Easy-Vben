package com.easy.admin.scheduler.service;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.scheduler.model.SchedulerJob;
import com.easy.admin.scheduler.model.SchedulerJobMethodOption;

import java.util.List;

/**
 * 定时任务
 *
 * @author TengChong
 * @date 2019-05-11
 */
public interface SchedulerJobService {
    /**
     * 列表
     *
     * @param schedulerJob 查询条件
     * @param page         分页
     * @return 数据集合
     */
    Page<SchedulerJob> select(SchedulerJob schedulerJob, Page<SchedulerJob> page);

    /**
     * 查询所有定时任务
     *
     * @return 数据集合
     */
    List<SchedulerJob> selectAll();

    /**
     * 详情
     *
     * @param id id
     * @return 详细信息
     */
    SchedulerJob get(String id);

    /**
     * 新增
     *
     * @return 默认值
     */
    SchedulerJob add();

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return 是否成功
     */
    boolean remove(String ids);

    /**
     * 保存
     *
     * @param schedulerJob 表单内容
     * @return 保存后信息
     */
    SchedulerJob saveData(SchedulerJob schedulerJob);

    /**
     * 更新最后执行时间
     *
     * @param id 数据id
     * @return true/false
     */
    boolean updateLastRunDate(String id);

    /**
     * 开始指定任务
     *
     * @param id 任务id
     */
    void start(String id);

    /**
     * 暂停指定任务
     *
     * @param id 任务id
     */
    void pause(String id);

    /**
     * 开始全部任务
     */
    void startAll();

    /**
     * 暂停全部任务
     */
    void pauseAll();

    /**
     * 立即执行指定任务
     *
     * @param id 数据id
     * @return true/false
     */
    boolean immediateExecution(String id);

    /**
     * 查询候选 Bean
     *
     * @param keyword 关键字
     * @return Bean 选项
     */
    List<Select> selectBeans(String keyword);

    /**
     * 查询 Bean 可调用的方法
     *
     * @param bean Bean 名称
     * @return 方法选项
     */
    List<SchedulerJobMethodOption> selectMethods(String bean);
}
