package com.easy.admin.sys.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * 邮箱验证
 *
 * @author TengChong
 * @date 2019-03-24
 */
 @TableName("sys_mail_verification")
public class SysMailVerification extends Model<SysMailVerification> implements Serializable{

    @TableId(value = "id")
    private String id;

    /**
     * 用户标识/user_id/username
     */
    private String userId;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 效验码
     */
    private String code;

    /**
     * 过期时间
     */
    private Date expired;

    /**
     * 类型
     */
    private String type;

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
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
