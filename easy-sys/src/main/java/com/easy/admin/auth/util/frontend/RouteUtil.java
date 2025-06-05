package com.easy.admin.auth.util.frontend;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.easy.admin.auth.common.type.MenuType;
import com.easy.admin.auth.model.SysMenu;
import com.easy.admin.auth.model.vo.route.RouteMetaVO;
import com.easy.admin.auth.model.vo.route.RouteVO;

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
     * 将菜单&权限集合转为权限标识数组
     *
     * @param sysMenuList 菜单&权限集合
     * @return 权限标识数组
     */
    public static List<String> convertPermissionCodeList(List<SysMenu> sysMenuList) {
        if (sysMenuList == null || sysMenuList.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> permissionCodeList = new ArrayList<>();
        sysMenuList.forEach(sysMenu -> {
            if (StrUtil.isNotBlank(sysMenu.getAuthCode()) && !permissionCodeList.contains(sysMenu.getAuthCode())) {
                permissionCodeList.add(sysMenu.getAuthCode());
            }
        });
        return permissionCodeList;
    }

    /**
     * 将菜单&权限集合转为路由集合
     *
     * @param sysMenuList 权菜单&权限限集合
     * @return 路由集合
     */
    public static List<RouteVO> convertRouteList(List<SysMenu> sysMenuList) {
        if (sysMenuList == null || sysMenuList.isEmpty()) {
            return Collections.emptyList();
        }
        List<RouteVO> routeList = new ArrayList<>();
        sysMenuList.forEach(sysMenu -> {
            RouteVO route = convertRoute(sysMenu);
            if (route != null) {
                routeList.add(route);
            }
        });

        return routeList;
    }

    /**
     * 将菜单&权限转为路由
     *
     * @param sysMenu 菜单&权限
     * @return 路由
     */
    public static RouteVO convertRoute(SysMenu sysMenu) {
        if (sysMenu == null || MenuType.BUTTON.getCode().equals(sysMenu.getType())) {
            return null;
        }

        RouteVO route = new RouteVO();
        BeanUtil.copyProperties(sysMenu, route);

        // 路由的名称
        route.setName(getRouteName(sysMenu));


        if (MenuType.EMBEDDED.getCode().equals(sysMenu.getType())) {
            route.setComponent("IFrameView");
        }

        // 组件路径
        if (StrUtil.isBlank(sysMenu.getPath())) {
            route.setPath("/" + route.getId());
        } else {
            route.setPath(sysMenu.getPath());
        }

        // 路由Meta配置
        route.setMeta(convertRouteMeta(sysMenu));

        return route;
    }

    /**
     * 获取路由 name
     *
     * @param sysMenu 菜单&权限
     * @return 路由 name
     */
    private static String getRouteName(SysMenu sysMenu) {
        if (MenuType.BUTTON.getCode().equals(sysMenu.getType())) {
            // 按钮无需 name
            return null;
        }
        if (StrUtil.isNotBlank(sysMenu.getName())) {
            return sysMenu.getName();
        }
        if (StrUtil.isNotBlank(sysMenu.getPath())) {
            String[] pathArray = sysMenu.getPath().split("[/\\-]");
            StringBuilder name = new StringBuilder();
            for (String path : pathArray) {
                if (path.contains(":")) {
                    name.append(StrUtil.upperFirst(path.replace(":", "")));
                } else {
                    name.append(StrUtil.upperFirst(path));
                }
            }
            return name.toString();
        }
        return sysMenu.getId();
    }

    private static RouteMetaVO convertRouteMeta(SysMenu sysMenu) {
        RouteMetaVO routeMeta = new RouteMetaVO();
        BeanUtil.copyProperties(sysMenu, routeMeta, "query");
        if (MenuType.EMBEDDED.getCode().equals(sysMenu.getType())) {
            routeMeta.setIframeSrc(sysMenu.getLinkSrc());
        } else if (MenuType.LINK.getCode().equals(sysMenu.getType())) {
            // 外链需要新窗口打开
            routeMeta.setOpenInNewWindow(true);
            routeMeta.setLink(sysMenu.getLinkSrc());
        } else if (MenuType.MENU.getCode().equals(sysMenu.getType())) {
            if (StrUtil.isNotBlank(sysMenu.getQuery())) {
                try {
                    routeMeta.setQuery(new JSONObject(sysMenu.getQuery()));
                } catch (Exception e) {
                    // ignore 不符合规范的query忽略
                }
            }
        }
        routeMeta.setOrder(sysMenu.getOrderNo());
        return routeMeta;
    }
}
