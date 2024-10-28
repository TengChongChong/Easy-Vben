package com.easy.admin.auth.util.frontend;

import cn.hutool.core.util.StrUtil;
import com.easy.admin.auth.common.type.PermissionType;
import com.easy.admin.auth.model.SysPermission;
import com.easy.admin.auth.model.vo.route.RouteMetaVO;
import com.easy.admin.auth.model.vo.route.RouteVO;
import com.easy.admin.sys.common.constant.WhetherConst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 前端路由工具类
 *
 * @author TengChongChong
 * @date 2024-08-06
 **/
public class RouteUtil {

    private RouteUtil() {
    }

    /**
     * 将权限集合转为权限标识数组
     *
     * @param sysPermissionList 权限集合
     * @return 权限标识数组
     */
    public static List<String> convertPermissionCodeList(List<SysPermission> sysPermissionList) {
        if (sysPermissionList == null || sysPermissionList.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> permissionCodeList = new ArrayList<>();
        sysPermissionList.forEach(sysPermission -> {
            if (StrUtil.isNotBlank(sysPermission.getCode()) && !permissionCodeList.contains(sysPermission.getCode())) {
                permissionCodeList.add(sysPermission.getCode());
            }
        });
        return permissionCodeList;
    }

    /**
     * 将权限集合转为路由集合
     *
     * @param sysPermissionList 权限集合
     * @return 路由集合
     */
    public static List<RouteVO> convertRouteList(List<SysPermission> sysPermissionList) {
        if (sysPermissionList == null || sysPermissionList.isEmpty()) {
            return Collections.emptyList();
        }
        List<RouteVO> routeList = new ArrayList<>();
        sysPermissionList.forEach(sysPermission -> {
            RouteVO route = convertRoute(sysPermission);
            if (route != null) {
                routeList.add(route);
            }
        });

        return routeList;
    }

    /**
     * 将权限转为路由
     *
     * @param sysPermission 权限
     * @return 路由
     */
    public static RouteVO convertRoute(SysPermission sysPermission) {
        if (sysPermission == null) {
            return null;
        }
        boolean isCatalogue = PermissionType.CATALOGUE.getCode().equals(sysPermission.getType());
        boolean isMenu = PermissionType.MENU.getCode().equals(sysPermission.getType());
        boolean canConvert = isCatalogue || isMenu;
        if (!canConvert) {
            return null;
        }

        RouteVO route = new RouteVO();
        route.setId(sysPermission.getId());
        route.setParentId(sysPermission.getParentId());
        // 是否为外链
        boolean isExternalLink = WhetherConst.YES.equals(sysPermission.getExternalLink());
        // 组件
        if (isMenu) {
            route.setComponent(isExternalLink ? "IFrameView" : StrUtil.isNotBlank(sysPermission.getComponent()) ? sysPermission.getComponent() : "BasicLayout");
        }
        // 路由的名称
        route.setName(getRouteName(sysPermission));
        // 路由Meta配置
        route.setMeta(convertRouteMeta(sysPermission));
        if (isExternalLink || StrUtil.isBlank(sysPermission.getPath())) {
            route.setPath("/" + route.getId());
        } else {
            route.setPath(sysPermission.getPath());
        }
        return route;
    }

    /**
     * 获取路由 name
     *
     * @param sysPermission 权限
     * @return 路由 name
     */
    private static String getRouteName(SysPermission sysPermission) {
        if (StrUtil.isNotBlank(sysPermission.getName())) {
            return sysPermission.getName();
        }
        if (StrUtil.isNotBlank(sysPermission.getComponent())) {
            String[] pathArray = sysPermission.getComponent().split("[/\\-]");
            StringBuilder name = new StringBuilder();
            for (String path : pathArray) {
                name.append(StrUtil.upperFirst(path));
            }
            return name.toString();
        }
        return sysPermission.getId();
    }


    private static RouteMetaVO convertRouteMeta(SysPermission sysPermission) {
        RouteMetaVO routeMeta = new RouteMetaVO();
        // 配置页面的标题，会在菜单和标签页中显示。一般会配合国际化使用。
        routeMeta.setTitle(sysPermission.getTitle());
        // 配置页面的图标，会在菜单和标签页中显示。一般会配合图标库使用，如果是http链接，会自动加载图片。
        if (StrUtil.isNotBlank(sysPermission.getIcon())) {
            routeMeta.setIcon(sysPermission.getIcon());
        }
        if (WhetherConst.NO.equals(sysPermission.getShowInMenu())) {
            // 配置页面是否在菜单中隐藏，隐藏后页面不会在菜单中显示。
            routeMeta.setHideInMenu(true);
        }
        routeMeta.setOpenInNewWindow(!WhetherConst.YES.equals(sysPermission.getOpenMode()));

        // 外部链接
        if (WhetherConst.YES.equals(sysPermission.getExternalLink())) {
            if (routeMeta.getOpenInNewWindow()) {
                // 配置内嵌页面的 iframe 地址，设置后会在当前页面内嵌对应的页面。
                routeMeta.setIframeSrc(sysPermission.getPath());
            } else {
                // 用于配置外链跳转路径，会在新窗口打开。
                routeMeta.setLink(sysPermission.getPath());
            }
        }
        // 配置页面的排序
        routeMeta.setOrder(sysPermission.getOrderNo());

        // 兼容vben 2.x
        routeMeta.setHideMenu(routeMeta.getHideInMenu());
        routeMeta.setFrameSrc(routeMeta.getIframeSrc());
        return routeMeta;
    }
}
