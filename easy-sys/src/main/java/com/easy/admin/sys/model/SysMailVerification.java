package com.easy.admin.sys.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 邮箱验证
 *
 * @author TengChong
 * @date 2019-03-24
 */
@Data
@TableName("sys_mail_verification")
public class SysMailVerification extends Model<SysMailVerification> implements Serializable {

    @TableId
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

}
