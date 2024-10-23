package com.easy.admin.auth.model.vo;

import com.easy.admin.auth.model.SysPermission;
import com.easy.admin.auth.model.vo.route.RouteVO;
import com.easy.admin.auth.util.frontend.RouteUtil;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 角色权限，存放在缓存中用于用户授权
 *
 * @author TengChongChong
 * @date 2024-08-06
 **/
@Data
public class SysRoleCacheVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色标识
     */
    private String code;

    /**
     * 状态
     */
    private String status;

    /**
     * 数据权限
     */
    private String dataPermission;

    /**
     * 数据权限 自定义部门ids
     */
    private List<String> dataPermissionDeptIdList;

    /**
     * 角色拥有的权限标识
     */
    private List<String> permissionCodeList;

    /**
     * 角色拥有的权限
     */
    private List<RouteVO> routeList;

    public SysRoleCacheVO(SysRoleVO sysRole, List<SysPermission> sysPermissionList) {
        // 角色基础信息
        this.id = sysRole.getId();
        this.name = sysRole.getName();
        this.code = sysRole.getCode();
        this.status = sysRole.getStatus();
        this.dataPermission = sysRole.getDataPermission();
        this.dataPermissionDeptIdList = sysRole.getDataPermissionDeptIds();

        // 角色拥有的权限标识
        this.permissionCodeList = RouteUtil.convertPermissionCodeList(sysPermissionList);

        // 角色拥有的权限
        this.routeList = RouteUtil.convertRouteList(sysPermissionList);
    }
}
