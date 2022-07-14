package com.easy.admin.activiti.config.manager;

import cn.hutool.core.util.StrUtil;
import com.easy.admin.activiti.config.util.ActivitiUserUtil;
import com.easy.admin.activiti.constant.ActivitiWorkflowConst;
import com.easy.admin.auth.model.SysUser;
import com.easy.admin.auth.service.SysRoleService;
import com.easy.admin.auth.service.SysUserService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.UserQueryImpl;
import org.activiti.engine.impl.persistence.entity.IdentityInfoEntity;
import org.activiti.engine.impl.persistence.entity.UserEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 自定义用户EntityManager
 *
 * @author TengChongChong
 * @date 2020/3/13
 */
@Component
public class CustomUserEntityManager extends UserEntityManager {

    @Autowired
    private SysUserService userService;

    @Autowired
    private SysRoleService roleService;

    /**
     * 根据userId获取用户（Activiti）信息
     *
     * @param userId 用户id
     * @return 用户信息（Activiti）
     */
    @Override
    public User findUserById(String userId) {
        SysUser user = userService.getUser(userId);
        return ActivitiUserUtil.toActivitiUser(user);
    }

    /**
     * 根据userId获取用户所属用户组集合
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
        return ActivitiUserUtil.toActivitiGroups(list);
    }

    /**
     * 查找用户
     *
     * @param query 查询条件
     * @param page  分页
     * @return 用户集合
     */
    @Override
    public List<User> findUserByQueryCriteria(UserQueryImpl query, Page page) {
        SysUser user = getUser(query.getId());
        List<User> list = new ArrayList<>();
        list.add(ActivitiUserUtil.toActivitiUser(user));
        return list;
    }

    /**
     * 根据userId获取用户信息
     *
     * @param userId 用户id
     * @return SysUser
     */
    private SysUser getUser(String userId) {
        SysUser user = new SysUser();
        // 判断是否是系统管理员
        if (ActivitiWorkflowConst.INTERFACE_SYSTEM_ID.equals(userId)) {
            user.setId(ActivitiWorkflowConst.INTERFACE_SYSTEM_ID);
            user.setNickname(ActivitiWorkflowConst.INTERFACE_SYSTEM_NAME);
            user.setPassword("");
            user.setEmail("");
        } else {
            user = userService.getUser(userId);
        }
        return user;
    }

    @Override
    public long findUserCountByQueryCriteria(UserQueryImpl query) {
        throw new RuntimeException("not implement method.");
    }

    @Override
    public IdentityInfoEntity findUserInfoByUserIdAndKey(String userId, String key) {
        throw new RuntimeException("not implement method.");
    }

    @Override
    public List<String> findUserInfoKeysByUserIdAndType(String userId, String type) {
        throw new RuntimeException("not implement method.");
    }

    @Override
    public List<User> findPotentialStarterUsers(String proceDefId) {
        throw new RuntimeException("not implement method.");
    }

    @Override
    public List<User> findUsersByNativeQuery(Map<String, Object> parameterMap,
                                             int firstResult, int maxResults) {
        throw new RuntimeException("not implement method.");
    }

    @Override
    public long findUserCountByNativeQuery(Map<String, Object> parameterMap) {
        throw new RuntimeException("not implement method.");
    }
}
