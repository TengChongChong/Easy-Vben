package com.easy.admin.workflow.config.manager;

import org.activiti.api.runtime.shared.identity.UserGroupManager;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserGroupManager
 *
 * @author TengChongChong
 * @date 2025-07-24
 **/
@Service
public class EasyUserGroupManager implements UserGroupManager {
    @Override
    public List<String> getUserGroups(String username) {
        return List.of();
    }

    @Override
    public List<String> getUserRoles(String username) {
        return List.of();
    }

    @Override
    public List<String> getGroups() {
        return List.of();
    }

    @Override
    public List<String> getUsers() {
        return List.of();
    }
}
