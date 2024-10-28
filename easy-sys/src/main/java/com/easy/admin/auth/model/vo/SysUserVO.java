package com.easy.admin.auth.model.vo;

import com.easy.admin.auth.model.SysDept;
import com.easy.admin.auth.model.SysUser;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.dromara.x.file.storage.core.FileInfo;

import java.util.List;

/**
 * 用户
 *
 * @author TengChongChong
 * @date 2024-10-25
 **/
@Data
public class SysUserVO extends SysUser {

    /**
     * 所属部门
     */
    private SysDept dept;

    /**
     * 角色ids
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> roleIdList;

    /**
     * 头像
     */
    private FileInfo avatar;

    /**
     * 头像
     */
    private String avatarUrl;

    /**
     * 邮箱是否验证
     */
    private boolean mailIsVerifies = true;

    /**
     * 部门名称
     */
    private String deptName;
}
