package com.easy.admin.sys.model;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonProperty;

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
@TableName("sys_user")
public class SysUser extends Model<SysUser> implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id")
    private String id;
    /**
     * 部门id
     */
    private String deptId;
    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;
    /**
     * 密码
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    /**
     * 密码强度
     */
    private String passwordStrength;
    /**
     * md5密码盐
     */
    private String salt;
    /**change/password/
     * 昵称
     */
    private String nickname;
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
    private String phone;
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
     * 最后登录时间
     */
    private Date lastLogin;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 乐观锁保留字段
     */
    private Integer version;
    /**
     * 账号来源
     */
    private String source;
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
    /**
     * 所属部门
     */
    @TableField(exist = false)
    private SysDept dept;
    /**
     * 角色集合(标识)
     */
    @TableField(exist = false)
    private List<String> roles;
    /**
     * 角色集合
     */
    @TableField(exist = false)
    private List<String> roleIds;
    /**
     * 角色名称集合
     */
    @TableField(exist = false)
    private List<String> roleNames;
    /**
     * 权限集合
     */
    @TableField(exist = false)
    private List<String> permissionList;
    /**
     * 菜单集合
     */
    @TableField(exist = false)
    private List<SysPermissions> menus;
    /**
     * 头像缩略图
     */
    @TableField(exist = false)
    private String avatarLg;
    @TableField(exist = false)
    private String avatarMd;
    @TableField(exist = false)
    private String avatarSm;
    @TableField(exist = false)
    private String avatarXs;
    /**
     * 邮箱是否验证
     */
    @TableField(exist = false)
    private boolean mailIsVerifies = true;
    /**
     * 年龄
     */
    @TableField(exist = false)
    private int age;
    /**
     * 部门名称
     */
    @TableField(exist = false)
    private String deptName;

    public SysUser(String username) {
        this.username = username;
    }

    public SysUser() {
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordStrength() {
        return passwordStrength;
    }

    public void setPasswordStrength(String passwordStrength) {
        this.passwordStrength = passwordStrength;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getEditUser() {
        return editUser;
    }

    public void setEditUser(String editUser) {
        this.editUser = editUser;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<String> permissionList) {
        this.permissionList = permissionList;
    }

    public List<SysPermissions> getMenus() {
        return menus;
    }

    public void setMenus(List<SysPermissions> menus) {
        this.menus = menus;
    }

    public String getAvatarLg() {
        return avatarLg;
    }

    public void setAvatarLg(String avatarLg) {
        this.avatarLg = avatarLg;
    }

    public String getAvatarMd() {
        return avatarMd;
    }

    public void setAvatarMd(String avatarMd) {
        this.avatarMd = avatarMd;
    }

    public String getAvatarSm() {
        return avatarSm;
    }

    public void setAvatarSm(String avatarSm) {
        this.avatarSm = avatarSm;
    }

    public String getAvatarXs() {
        return avatarXs;
    }

    public void setAvatarXs(String avatarXs) {
        this.avatarXs = avatarXs;
    }

    public SysDept getDept() {
        return dept;
    }

    public void setDept(SysDept dept) {
        this.dept = dept;
    }

    public boolean isMailIsVerifies() {
        return mailIsVerifies;
    }

    public void setMailIsVerifies(boolean mailIsVerifies) {
        this.mailIsVerifies = mailIsVerifies;
    }

    public int getAge() {
        if (this.birthday != null) {
            return DateUtil.age(this.birthday, new Date());
        }
        return 0;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<String> getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(List<String> roleNames) {
        this.roleNames = roleNames;
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }
}