package com.easy.admin.sys.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 异常日志
 *
 * @author TengChong
 * @date 2019-04-08
 */
@Data
@TableName("sys_exception")
public class SysException extends Model<SysException> implements Serializable {

    @TableId
    private String id;

    /**
     * 触发用户
     */
    private String userId;

    /**
     * 触发时间
     */
    private Date triggerTime;

    /**
     * 异常类型
     */
    private String type;

    /**
     * 错误堆栈
     */
    private String trace;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 请求地址
     */
    private String url;

    /**
     * 错误代码
     */
    private Integer code;

    //
    /**
     * 触发时间
     */
    @TableField(exist = false)
    private Date startTriggerTime;
    /**
     * 触发时间
     */
    @TableField(exist = false)
    private Date endTriggerTime;

    /**
     * 用户昵称
     */
    @TableField(exist = false)
    private String nickname;
}
