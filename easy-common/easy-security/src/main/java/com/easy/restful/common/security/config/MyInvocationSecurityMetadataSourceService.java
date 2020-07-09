package com.easy.restful.common.security.config;


import com.easy.restful.sys.model.SysRolePermissions;
import com.easy.restful.sys.service.SysRolePermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * 初始化访问url所需要的角色权限信息
 *
 * @author tengchong
 * @date 2020/6/12
 */
@Component
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

    /**
     * 分隔符
     */
    private static final String SEPARATOR = ":";

    @Autowired
    private SysRolePermissionsService sysRolePermissionsService;

    /**
     * 每一个资源所需要的角色 Collection<ConfigAttribute>决策器会用到
     */
    private static HashMap<String, Collection<ConfigAttribute>> map = null;

    /**
     * 获取请求所需的角色标识
     *
     * @param filterInvocation FilterInvocation
     * @return Collection<ConfigAttribute> || null
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object filterInvocation) throws IllegalArgumentException {
        //object 中包含用户请求的request 信息
        HttpServletRequest request = ((FilterInvocation) filterInvocation).getHttpRequest();
        for (String key : map.keySet()) {
            String httpMethods = key.split(SEPARATOR)[0];
            String url = key.split(SEPARATOR)[1];
            if (new AntPathRequestMatcher(url, httpMethods).matches(request)) {
                return map.get(key);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        // 初始化url<=>角色对应关系
        loadResourceDefine();
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    /**
     * 初始化url<=>角色对应关系
     */
    public void loadResourceDefine() {
        map = new HashMap<>(16);
        // 角色资源，角色和权限中间表所有数据
        List<SysRolePermissions> rolePermissionsList = sysRolePermissionsService.selectAll();

        // 放到map中
        for (SysRolePermissions sysRolePermissions : rolePermissionsList) {
            String url = sysRolePermissions.getUrl();
            String httpMethods = sysRolePermissions.getHttpMethods();
            String key = httpMethods + SEPARATOR + url;
            String roleCode = sysRolePermissions.getRoleCode();
            ConfigAttribute role = new SecurityConfig(roleCode);

            if (map.containsKey(key)) {
                map.get(key).add(role);
            } else {
                List<ConfigAttribute> list = new ArrayList<>();
                list.add(role);
                map.put(key, list);
            }
        }
    }
}
