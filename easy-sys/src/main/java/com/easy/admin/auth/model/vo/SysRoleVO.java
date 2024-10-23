package com.easy.admin.auth.model.vo;

import com.easy.admin.auth.model.SysRole;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * 角色
 *
 * @author TengChongChong
 * @date 2024-10-23
 **/
@Data
public class SysRoleVO extends SysRole {

    /**
     * 权限ids
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> permissionIds;

    /**
     * 数据权限 自定义部门ids
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> dataPermissionDeptIds;

}
