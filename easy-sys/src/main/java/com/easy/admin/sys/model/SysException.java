package com.easy.admin.sys.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 异常日志
 *
 * @author TengChong
 * @date 2019-04-08
 */
@TableName("sys_exception")
public class SysException extends Model<SysException> implements Serializable {

    @TableId(value = "id")
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
    @TableField(exist=false)
    private Date startTriggerTime;
    /**
     * 触发时间
     */
    @TableField(exist=false)
    private Date endTriggerTime;

    /**
     * 用户昵称
     */
    @TableField(exist = false)
    private String nickname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getTriggerTime() {
        return triggerTime;
    }

    public void setTriggerTime(Date triggerTime) {
        this.triggerTime = triggerTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getStartTriggerTime() {
        return startTriggerTime;
    }

    public void setStartTriggerTime(Date startTriggerTime) {
        this.startTriggerTime = startTriggerTime;
    }

    public Date getEndTriggerTime() {
        return endTriggerTime;
    }

    public void setEndTriggerTime(Date endTriggerTime) {
        this.endTriggerTime = endTriggerTime;
    }
}
