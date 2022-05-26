package com.easy.admin.activiti.config.util;

import com.easy.admin.auth.model.SysUser;
import org.activiti.engine.identity.Group;
import org.activiti.engine.impl.persistence.entity.GroupEntity;
import org.activiti.engine.impl.persistence.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 将业务系统中用户与角色转为Activiti所需的类型
 *
 * @author TengChongChong
 * @date 2020/3/13
 */
public class ActivitiUserUtil {

    /**
     * 将SysUser转为Activiti中的UserEntity
     *
     * @param sysUser SysUser
     * @return UserEntity
     */
    public static UserEntity toActivitiUser(SysUser sysUser) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(sysUser.getId());
        userEntity.setFirstName(sysUser.getNickname());
        userEntity.setLastName(sysUser.getNickname());
        userEntity.setPassword(sysUser.getPassword());
        userEntity.setEmail(sysUser.getEmail());
        userEntity.setRevision(1);
        return userEntity;
    }

    /**
     * 获取Activiti中的GroupEntity
     *
     * @param code 标识
     * @return GroupEntity
     */
    public static GroupEntity toActivitiGroup(String code) {
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setRevision(1);
        groupEntity.setType("assignment");
        groupEntity.setId(code);
        return groupEntity;
    }

    /**
     * 将一组角色标识转为Activiti中的角色标识
     *
     * @param roleCodeList 角色标识集合
     * @return List<Group>
     */
    public static List<Group> toActivitiGroups(List<String> roleCodeList) {
        List<Group> groups = new ArrayList<>();
        for (String code : roleCodeList) {
//            GroupEntity groupEntity = toActivitiGroup(enterpriseBasicId, code);
            GroupEntity groupEntity = toActivitiGroup(code);
            groups.add(groupEntity);
        }
        return groups;
    }
}
