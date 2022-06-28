package com.easy.admin.sys.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 日志 
 *
 * @author TengChong
 * @date 2019-06-27
 */
@TableName("sys_log")
public class SysLog extends Model<SysLog> implements Serializable{

    /**
     * id
     */
    @TableId(value = "id")
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
    @TableField(exist=false)
    private Date startOperationDate;
    /**
     * 操作时间
     */
    @TableField(exist=false)
    private Date endOperationDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getModular() {
        return modular;
    }

    public void setModular(String modular) {
        this.modular = modular;
    }
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }
    public Long getTimeConsuming() {
        return timeConsuming;
    }

    public void setTimeConsuming(Long timeConsuming) {
        this.timeConsuming = timeConsuming;
    }
    public String getOperationUser() {
        return operationUser;
    }

    public void setOperationUser(String operationUser) {
        this.operationUser = operationUser;
    }
    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public Date getStartOperationDate() {
        return startOperationDate;
    }

    public void setStartOperationDate(Date startOperationDate) {
        this.startOperationDate = startOperationDate;
    }

    public Date getEndOperationDate() {
        return endOperationDate;
    }

    public void setEndOperationDate(Date endOperationDate) {
        this.endOperationDate = endOperationDate;
    }
}
