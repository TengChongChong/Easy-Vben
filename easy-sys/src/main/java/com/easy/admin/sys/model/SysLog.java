package com.easy.admin.sys.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 日志
 *
 * @author TengChong
 * @date 2019-06-27
 */
@Data
@TableName("sys_log")
public class SysLog extends Model<SysLog> implements Serializable {

    /**
     * id
     */
    @TableId
    private String id;

    /**
     * 模块
     */
    private String modular;

    /**
     * 方法
     */
    private String method;

    /**
     * ip
     */
    private String ip;

    /**
     * url
     */
    private String url;

    /**
     * uri
     */
    private String uri;

    /**
     * class
     */
    private String clazz;

    /**
     * 方法名
     */
    private String methodName;

    /**
     * 参数
     */
    private String params;

    /**
     * Http Method
     */
    private String httpMethod;

    /**
     * 耗时
     * 由于需要在方法return去拦截,所以暂时作为保留字段
     */
    private Long timeConsuming;
    /**
     * 租户id
     */
    private String tenantId;
    /**
     * 操作人
     */
    private String operationUser;

    /**
     * 操作时间
     */
    private Date operationDate;

    //

    /**
     * 操作时间
     */
    @TableField(exist = false)
    private Date startOperationDate;
    /**
     * 操作时间
     */
    @TableField(exist = false)
    private Date endOperationDate;
}
