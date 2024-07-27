package com.easy.admin.scheduler.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 定时任务
 *
 * @author TengChong
 * @date 2019-05-11
 */
@Data
@TableName("scheduler_job")
public class SchedulerJob extends Model<SchedulerJob> {

    /**
     * id
     */
    @TableId
    private String id;

    /**
     * 名称
     */
    @NotBlank(message = "名称不能为空")
    private String name;
    /**
     * 代码
     */
    @NotBlank(message = "代码不能为空")
    private String code;
    /**
     * cron表达式
     */
    @NotBlank(message = "cron表达式不能为空")
    private String cron;

    /**
     * bean
     */
    @NotBlank(message = "bean不能为空")
    private String bean;

    /**
     * method
     */
    @NotBlank(message = "method不能为空")
    private String method;

    /**
     * 状态
     */
    @NotNull(message = "状态不能为空")
    private String status;

    /**
     * 备注
     */
    private String remarks;
    /**
     * 是否系统
     */
    private String sys;

    /**
     * 上次执行时间
     */
    private Date lastRunDate;

    /**
     * 乐观锁
     */
    @Version
    private Integer version;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createUser;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;

    /**
     * 修改人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String editUser;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date editDate;

    //

    public SchedulerJob() {
    }

    public SchedulerJob(String code) {
        this.code = code;
    }

}
