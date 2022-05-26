package com.easy.admin.activiti.config.manager;

import cn.hutool.core.util.StrUtil;
import com.easy.admin.activiti.config.util.ActivitiUserUtil;
import com.easy.admin.auth.service.SysRoleService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.impl.GroupQueryImpl;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.persistence.entity.GroupEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 自定义角色EntityManager
 *
 * @author TengChongChong
 * @date 2020/3/13
 */
@Component
public class CustomGroupEntityManager extends GroupEntityManager {

    @Autowired
    private SysRoleService roleService;

    public CustomGroupEntityManager() {
    }

    /**
     * 根据用户Id获取所属用户组集合
     *
     * @param userId 用户id
     * @return 用户组集合
     */
    @Override
    public List<Group> findGroupsByUser(String userId) {
        if (StrUtil.isBlank(userId)) {
            return null;
        }
        List<String> list = roleService.selectRoleCodeByUserId(userId);
        List<Group> groups = ActivitiUserUtil.toActivitiGroups(list);
        return groups;
    }

    @Override
    public List<Group> findGroupByQueryCriteria(GroupQueryImpl query, Page page) {
        throw new RuntimeException("not implement method.");
    }

    @Override
    public long findGroupCountByQueryCriteria(GroupQueryImpl query) {
        throw new RuntimeException("not implement method.");
    }

    @Override
    public List<Group> findGroupsByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults) {
        throw new RuntimeException("not implement method.");
    }

    @Override
    public long findGroupCountByNativeQuery(Map<String, Object> parameterMap) {
        throw new RuntimeException("not implement method.");
    }
}
