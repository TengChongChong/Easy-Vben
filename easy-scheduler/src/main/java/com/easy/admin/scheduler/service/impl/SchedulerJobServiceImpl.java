package com.easy.admin.scheduler.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.auth.common.constant.SysRoleConst;
import com.easy.admin.auth.model.SysUser;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.util.SpringContextHolder;
import com.easy.admin.scheduler.common.status.SchedulerStatus;
import com.easy.admin.scheduler.dao.SchedulerJobMapper;
import com.easy.admin.scheduler.model.SchedulerJob;
import com.easy.admin.scheduler.model.SchedulerJobLog;
import com.easy.admin.scheduler.service.QuartzService;
import com.easy.admin.scheduler.service.SchedulerJobLogService;
import com.easy.admin.scheduler.service.SchedulerJobService;
import com.easy.admin.sys.common.constant.WhetherConst;
import com.easy.admin.util.ShiroUtil;
import com.easy.admin.common.core.util.ToolUtil;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 定时任务
 *
 * @author TengChong
 * @date 2019-05-11
 */
@Service
public class SchedulerJobServiceImpl extends ServiceImpl<SchedulerJobMapper, SchedulerJob> implements SchedulerJobService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private QuartzService quartzService;

    @Autowired
    private SchedulerJobLogService schedulerJobLogService;

    /**
     * 列表
     *
     * @param schedulerJob 查询条件
     * @param page         分页
     * @return 数据集合
     */
    @Override
    public Page<SchedulerJob> select(SchedulerJob schedulerJob, Page<SchedulerJob> page) {
        QueryWrapper<SchedulerJob> queryWrapper = new QueryWrapper<>();
        if (schedulerJob != null) {
            // 查询条件
            // 名称
            if (Validator.isNotEmpty(schedulerJob.getName())) {
                queryWrapper.like("name", schedulerJob.getName());
            }
            // cron表达式
            if (Validator.isNotEmpty(schedulerJob.getCode())) {
                queryWrapper.like("code", schedulerJob.getCode());
            }
            // bean
            if (Validator.isNotEmpty(schedulerJob.getBean())) {
                queryWrapper.like("bean", schedulerJob.getBean());
            }
            // 方法
            if (Validator.isNotEmpty(schedulerJob.getMethod())) {
                queryWrapper.like("method", schedulerJob.getMethod());
            }
            // 状态
            if (Validator.isNotEmpty(schedulerJob.getStatus())) {
                if (schedulerJob.getStatus().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("status", schedulerJob.getStatus().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("status", schedulerJob.getStatus());
                }
            }
            // 系统
            if (Validator.isNotEmpty(schedulerJob.getSys())) {
                if (schedulerJob.getSys().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("sys", schedulerJob.getSys().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("sys", schedulerJob.getSys());
                }
            }
        }
        // 非系统管理员，仅显示非系统数据
        if (!ShiroUtil.havRole(SysRoleConst.SYS_ADMIN)) {
            queryWrapper.eq("sys", WhetherConst.NO);
        }
        page.setDefaultDesc("create_date");
        page.setRecords(baseMapper.select(page, queryWrapper));
        return page;
    }

    @Override
    public List<SchedulerJob> selectAll() {
        QueryWrapper<SchedulerJob> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", SchedulerStatus.ENABLE.getCode());
        return baseMapper.selectList(queryWrapper);
    }

    /**
     * 详情
     *
     * @param id id
     * @return 详细信息
     */
    @Override
    public SchedulerJob get(String id) {
        return baseMapper.getById(id);
    }

    /**
     * 新增
     *
     * @return 默认值
     */
    @Override
    public SchedulerJob add() {
        SchedulerJob schedulerJob = new SchedulerJob();
        // 默认开启
        schedulerJob.setStatus(SchedulerStatus.ENABLE.getCode());
        schedulerJob.setSys(WhetherConst.NO);
        return schedulerJob;
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return 是否成功
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        QueryWrapper<SchedulerJob> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", idList);
        List<SchedulerJob> schedulerJobs = baseMapper.selectSchedulerJobCodes(queryWrapper);
        boolean isSuccess = removeByIds(idList);
        if (isSuccess) {
            // 删除成功后删除任务
            for (SchedulerJob schedulerJob : schedulerJobs) {
                quartzService.operateJob(schedulerJob, SchedulerStatus.DELETE);
            }
        }
        return isSuccess;
    }

    /**
     * 保存
     *
     * @param schedulerJob 表单内容
     * @return 保存后信息
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SchedulerJob saveData(SchedulerJob schedulerJob) {
        SysUser currentUser = ShiroUtil.getCurrentUser();
        // 更新前的任务名称
        String jobJobCode = null;
        schedulerJob.setEditDate(new Date());
        schedulerJob.setEditUser(currentUser.getId());
        //
        QueryWrapper<SchedulerJob> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code", schedulerJob.getCode());
        if (schedulerJob.getId() != null) {
            queryWrapper.ne("id", schedulerJob.getId());
        }
        if (count(queryWrapper) > 0) {
            throw new EasyException("code[" + schedulerJob.getCode() + "]已存在");
        }

        if (StrUtil.isBlank(schedulerJob.getId())) {
            // 新增,设置默认值
            schedulerJob.setCreateDate(new Date());
            schedulerJob.setCreateUser(currentUser.getId());
        } else {
            jobJobCode = baseMapper.getJobCodeById(schedulerJob.getId());

        }
        boolean isSuccess = saveOrUpdate(schedulerJob);
        if (isSuccess) {
            // 如果是新增直接添加任务,如果是修改则删除原任务后重新添加
            if (StrUtil.isNotBlank(jobJobCode)) {
                quartzService.operateJob(new SchedulerJob(jobJobCode), SchedulerStatus.DELETE);
            }
            if (SchedulerStatus.ENABLE.getCode().equals(schedulerJob.getStatus())) {
                // 如果保存后是启用状态,添加到任务里
                quartzService.addJob(schedulerJob);
            }
        }
        return (SchedulerJob) ToolUtil.checkResult(isSuccess, schedulerJob);
    }

    @Override
    public boolean updateLastRunDate(String id) {
        if (id != null) {
            UpdateWrapper<SchedulerJob> updateWrapper = new UpdateWrapper<>();
            updateWrapper.set("last_run_date", new Date());
            updateWrapper.eq("id", id);
            return update(updateWrapper);
        }
        return false;
    }

    @Override
    public void start(String id) {
        boolean updateSuccess = updateJobStatus(SchedulerStatus.ENABLE.getCode(), id);
        if (updateSuccess) {
            quartzService.operateJob(getById(id), SchedulerStatus.ENABLE);
        } else {
            throw new EasyException("更新任务状态失败");
        }
    }

    @Override
    public void pause(String id) {
        boolean updateSuccess = updateJobStatus(SchedulerStatus.DISABLE.getCode(), id);
        if (updateSuccess) {
            quartzService.operateJob(getById(id), SchedulerStatus.DISABLE);
        } else {
            throw new EasyException("更新任务状态失败");
        }
    }

    @Override
    public void startAll() {
        try {
            boolean updateSuccess = updateJobStatus(SchedulerStatus.ENABLE.getCode(), null);
            if (updateSuccess) {
                quartzService.startAll();
            } else {
                throw new EasyException("更新任务状态失败");
            }
        } catch (SchedulerException e) {
            logger.error("startAll()", e);
            throw new EasyException("开启任务失败");
        }
    }

    @Override
    public void pauseAll() {
        try {
            boolean updateSuccess = updateJobStatus(SchedulerStatus.DISABLE.getCode(), null);
            if (updateSuccess) {
                quartzService.pauseAll();
            } else {
                throw new EasyException("更新任务状态失败");
            }
        } catch (SchedulerException e) {
            logger.error("pauseAll()", e);
            throw new EasyException("暂停任务失败");
        }
    }


    /**
     * 更改任务状态
     *
     * @param status 状态
     * @param ids    任务ids,如果null则更新全部
     * @return true/false
     */
    private boolean updateJobStatus(String status, String ids) {
        UpdateWrapper<SchedulerJob> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("status", status);
        if (StrUtil.isNotBlank(ids)) {
            updateWrapper.in("id", ids.split(CommonConst.SPLIT));
        }
        return update(updateWrapper);
    }

    @Override
    public boolean immediateExecution(String id) {
        SchedulerJob schedulerJob = getById(id);
        if (schedulerJob == null) {
            throw new EasyException("查询任务信息失败");
        }
        if (StrUtil.isBlank(schedulerJob.getBean())) {
            throw new EasyException("该任务未设置Bean信息，请设置后重试");
        }
        Object bean = SpringContextHolder.getBean(schedulerJob.getBean());
        if (bean != null) {
            try {
                // 获取方法
                Method method = bean.getClass().getMethod(schedulerJob.getMethod());
                try {
                    Date startDate = new Date();
                    // 执行
                    method.invoke(bean);
                    // 更新最后执行时间
                    updateLastRunDate(schedulerJob.getId());
                    // 保存执行日志
                    schedulerJobLogService.saveData(new SchedulerJobLog(schedulerJob.getId(),
                            startDate, System.currentTimeMillis() - startDate.getTime()));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new EasyException(schedulerJob.getName() + "失败[" + e.getCause().getMessage() + "]");
                }
            } catch (NoSuchMethodException e) {
                throw new EasyException("定时任务[" + schedulerJob.getName() + "]获取method[" + schedulerJob.getMethod() + "]失败");
            }
        } else {
            throw new EasyException("定时任务[" + schedulerJob.getName() + "]bean不存在");
        }
        return false;
    }
}