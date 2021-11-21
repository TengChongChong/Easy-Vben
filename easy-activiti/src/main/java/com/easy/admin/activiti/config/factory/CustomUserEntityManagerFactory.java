package com.easy.admin.activiti.config.factory;

import com.easy.admin.activiti.config.manager.CustomUserEntityManager;
import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.engine.impl.persistence.entity.UserIdentityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 自定义实现Activiti用户管理接口
 *
 * @author TengChongChong
 * @date 2020/3/13
 */
@Service
public class CustomUserEntityManagerFactory implements SessionFactory {

    @Autowired
    private CustomUserEntityManager customUserEntityManager;

    @Override
    public Class<?> getSessionType() {
        return UserIdentityManager.class;
    }

    @Override
    public Session openSession() {
        return customUserEntityManager;
    }
}
