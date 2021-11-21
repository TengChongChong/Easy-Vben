package com.easy.admin.activiti.config.factory;

import com.easy.admin.activiti.config.manager.CustomGroupEntityManager;
import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.GroupIdentityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 自定义实现Activiti角色管理接口
 *
 * @author TengChongChong
 * @date 2020/3/13
 */
@Service
public class CustomGroupEntityManagerFactory implements SessionFactory {

    @Autowired
    private CustomGroupEntityManager customGroupEntityManager;


    @Override
    public Class<?> getSessionType() {
        return GroupIdentityManager.class;
    }

    @Override
    public Session openSession() {
        return customGroupEntityManager;
    }
}
