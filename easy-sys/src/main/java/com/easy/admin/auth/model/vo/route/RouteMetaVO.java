package com.easy.admin.auth.model.vo.route;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * 路由Meta配置
 *
 * @author TengChongChong
 * @date 2024-08-05
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RouteMetaVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用于配置页面的标题，会在菜单和标签页中显示。一般会配合国际化使用。
     */
    private String title;

    /**
     * 用于配置页面的图标，会在菜单和标签页中显示。一般会配合图标库使用，如果是http链接，会自动加载图片。
     */
    private String icon;

    /**
     * 用于配置页面的激活图标，会在菜单中显示。一般会配合图标库使用，如果是http链接，会自动加载图片。
     */
    private String activeIcon;

    /**
     * 用于配置页面是否开启缓存，开启后页面会缓存，不会重新加载，仅在标签页启用时有效。默认值：false
     */
    private Boolean keepAlive;

    /**
     * 用于配置页面是否在菜单中隐藏，隐藏后页面不会在菜单中显示。默认值：false
     */
    private Boolean hideInMenu;
    /**
     * 用于配置页面是否在菜单中隐藏，隐藏后页面不会在菜单中显示。默认值：false
     */
    @Deprecated
    private Boolean hideMenu;

    /**
     * 用于配置页面是否在标签页中隐藏，隐藏后页面不会在标签页中显示。默认值：false
     */
    private Boolean hideInTab;

    /**
     * 用于配置页面是否在面包屑中隐藏，隐藏后页面不会在面包屑中显示。默认值：false
     */
    private Boolean hideInBreadcrumb;

    /**
     * 用于配置页面的子页面是否在菜单中隐藏，隐藏后子页面不会在菜单中显示。默认值：false
     */
    private Boolean hideChildrenInMenu;

    /**
     * 用于配置页面的徽标，会在菜单显示。
     */
    private String badge;

    /**
     * 用于配置页面的徽标类型，dot 为小红点，normal 为文本，默认值：normal
     */
    private String badgeType;

    /**
     * 用于配置页面的徽标颜色，'default' | 'destructive' | 'primary' | 'success' | 'warning'，默认值：success
     */
    private String badgeVariants;

    /**
     * 用于配置当前激活的菜单，有时候页面没有显示在菜单内，需要激活父级菜单时使用。
     */
    private String activePath;

    /**
     * 用于配置页面是否固定标签页，固定后页面不可关闭，默认值：false
     */
    private Boolean affixTab;

    /**
     * 用于配置页面固定标签页的排序, 采用升序排序，默认值：0
     */
    private Integer affixTabOrder;

    /**
     * 用于配置内嵌页面的 iframe 地址，设置后会在当前页面内嵌对应的页面。
     */
    private String iframeSrc;
    // 兼容 vben 2.x
    @Deprecated
    private String frameSrc;

    /**
     * 用于配置页面是否忽略权限，直接可以访问，默认值：false
     */
    private Boolean ignoreAccess;

    /**
     * 用于配置外链跳转路径，会在新窗口打开。
     */
    private String link;

    /**
     * 用于配置标签页最大打开数量，设置后会在打开新标签页时自动关闭最早打开的标签页(仅在打开同名标签页时生效)，默认值：-1
     */
    private Integer maxNumOfOpenTab;

    /**
     * 用于配置页面在菜单可以看到，但是访问会被重定向到403。默认值：false
     */
    private Boolean menuVisibleWithForbidden;

    /**
     * 用于配置页面的排序，用于路由到菜单排序。默认值：0
     */
    private Integer order;
}
