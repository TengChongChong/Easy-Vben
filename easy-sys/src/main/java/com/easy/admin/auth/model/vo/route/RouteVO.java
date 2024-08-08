package com.easy.admin.auth.model.vo.route;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 路由 RouteRecordNormalized
 *
 * @author TengChongChong
 * @date 2024-08-05
 **/
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RouteVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 路由id
     */
    private String id;

    /**
     * 父路由id
     */
    private String parentId;

    /**
     * 当 URL 匹配到该路由时显示的组件
     */
    private String component;

    /**
     * 路由的名称。必须唯一
     */
    private String name;

    /**
     * 路由的路径。应该以 / 开头
     */
    private String path;

    /**
     * 路由直接匹配时重定向的位置
     */
    private String redirect;

    /**
     * 路由Meta配置
     */
    private RouteMetaVO meta;

    /**
     * 嵌套的路由
     */
    private List<RouteVO> children;
}
