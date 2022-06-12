package com.easy.admin.scheduler.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.util.Date;

/**
 * 定时任务执行日志
 *
 * @author TengChong
 * @date 2019-05-11
 */
 @TableName("scheduler_job_log")
public class SchedulerJobLog extends Model<SchedulerJobLog> {

    /**
     * id
     */
    @TableId(value = "id")
    private String id;

    /**
     * 任务id
     */
    private String schedulerJobId;

    /**
     * 执行时间
     */
    private Date runDate;

    /**
     * 耗时
     */
    private Long timeConsuming;

    //

    public SchedulerJobLog() {
    }

    public SchedulerJobLog(String schedulerJobId, Date runDate, Long timeConsuming) {
        this.schedulerJobId = schedulerJobId;
        this.runDate = runDate;
        this.timeConsuming = timeConsuming;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchedulerJobId() {
        return schedulerJobId;
    }

    public void setSchedulerJobId(String schedulerJobId) {
        this.schedulerJobId = schedulerJobId;
    }

    public Date getRunDate() {
        return runDate;
    }

    public void setRunDate(Date runDate) {
        this.runDate = runDate;
    }
    public Long getTimeConsuming() {
        return timeConsuming;
    }

    public void setTimeConsuming(Long timeConsuming) {
        this.timeConsuming = timeConsuming;
    }
}
