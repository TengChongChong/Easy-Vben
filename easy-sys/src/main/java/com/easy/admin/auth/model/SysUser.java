package com.easy.admin.auth.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.easy.admin.config.mybatis.plugins.model.DataPermission;
import com.easy.admin.file.model.FileInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户
 *
 * @author TengChongChong
 * @date 2018/9/4
 */
@Data
@TableName("sys_user")
public class SysUser extends Model<SysUser> implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String id;
    /**
     * 部门id
     */
    private String deptId;
    /**
     * 岗位id
     */
    private String postId;
    /**
     * 账号
     */
    @NotBlank(message = "账号不能为空")
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 密码
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    /**
     * 密码盐
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String salt;
    /**
     * 性别
     */
    private String sex;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String phoneNumber;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 状态(1.正常 2.冻结 0.已删除)
     */
    @NotNull(message = "状态不能为空")
    private String status;
    /**
     * 账号来源
     */
    private String source;
    /**
     * 最后登录时间
     */
    private Date lastLoginDate;
    /**
     * 租户Id
     */
    private String tenantId;
    /**
     * 乐观锁
     */
    @Version
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer version;
    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String createUser;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date createDate;
    /**
     * 修改人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String editUser;
    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date editDate;

    //
    /**
     * 所属部门
     */
    @TableField(exist = false)
    private SysDept dept;

    /**
     * 所属部门名称
     */
    @TableField(exist = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String deptName;

    /**
     * 角色集合
     */
    @TableField(exist = false)
    private List<SysRole> roleList;

    /**
     * 角色数据权限
     */
    @TableField(exist = false)
    private List<DataPermission> dataPermissionList;

    /**
     * 角色ids，修改时使用
     */
    @TableField(exist = false)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> roleIdList;

    /**
     * 菜单集合
     */
    @TableField(exist = false)
    private List<SysPermission> permissionList;

    /**
     * 头像缩略图
     */
    @TableField(exist = false)
    private FileInfo avatar;

    /**
     * 邮箱是否验证
     */
    @TableField(exist = false)
    private boolean mailIsVerifies = true;
}