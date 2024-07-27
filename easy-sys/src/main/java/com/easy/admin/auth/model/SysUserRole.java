package com.easy.admin.auth.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * 用户角色
 *
 * @author TengChongChong
 * @date 2018/9/4
 */
@Data
@TableName("sys_user_role")
public class SysUserRole extends Model<SysUserRole> {

    @TableId
    private String id;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 角色id
     */
    private String roleId;
}