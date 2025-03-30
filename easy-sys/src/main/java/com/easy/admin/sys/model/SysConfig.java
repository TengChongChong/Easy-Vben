package com.easy.admin.sys.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 系统参数
 *
 * @author TengChongChong
 * @date 2019-03-03 23:13:03
 */
@Data
@TableName("sys_config")
public class SysConfig extends Model<SysConfig> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId
    private String id;

    /**
     * category
     */
    @NotBlank(message = "参数分类不能为空")
    private String category;
    /**
     * key
     */
    @NotBlank(message = "key不能为空")
    private String sysKey;

    /**
     * value
     */
    @NotBlank(message = "value不能为空")
    private String value;

    /**
     * 类型
     */
    @NotBlank(message = "类型不能为空")
    private String type;

    /**
     * 是否系统
     */
    private String sys;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 乐观锁
     */
    @Version
    private Integer version;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createDate;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createUser;

    /**
     * 编辑时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date editDate;

    /**
     * 编辑人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String editUser;

    //
}
