package com.easy.admin.sys.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 数据源管理
 *
 * @author TengChongChong
 * @date 2021-12-18
 */
@Data
@TableName("sys_data_source")
public class SysDataSource extends Model<SysDataSource> {

    /**
     * 主键
     */
    @TableId
    private String id;
    /**
     * 名称
     */
    @NotBlank(message = "名称不能为空")
    private String name;
    /**
     * 类型
     */
    private String type;
    /**
     * url
     */
    @NotBlank(message = "url不能为空")
    private String url;
    /**
     * 账号
     */
    @NotBlank(message = "账号不能为空")
    private String username;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;
    /**
     * 备注
     */
    private String remarks;
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
     * 更新人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String editUser;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date editDate;
    /**
     * 乐观锁
     */
    @Version
    private Integer version;
    /**
     * 状态
     */
    private String status;
    //
}
