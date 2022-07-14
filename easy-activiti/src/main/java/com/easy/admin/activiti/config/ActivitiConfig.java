package com.easy.admin.activiti.config;

import cn.hutool.core.date.DatePattern;
import com.easy.admin.activiti.config.factory.CustomGroupEntityManagerFactory;
import com.easy.admin.activiti.config.factory.CustomUserEntityManagerFactory;
import com.easy.admin.activiti.config.manager.CustomProcessDiagramGenerator;
import com.easy.admin.activiti.constant.ActivitiWorkflowConst;
import org.activiti.engine.*;
import org.activiti.engine.form.AbstractFormType;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.form.DateFormType;
import org.activiti.engine.impl.interceptor.SessionFactory;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Activiti Config
 *
 * @author TengChongChong
 * @date 2019-07-01
 */
@Configuration
public class ActivitiConfig {

    @Autowired
    private CustomUserEntityManagerFactory customUserEntityManagerFactory;

    @Autowired
    private CustomGroupEntityManagerFactory customGroupEntityManagerFactory;

    @Autowired
    private CustomProcessDiagramGenerator customProcessDiagramGenerator;

    /**
     * 流程引擎设置
     *
     * @param dataSource 数据源
     * @param transactionManager transactionManager
     * @return ProcessEngineConfiguration
     */
    @Bean
    public ProcessEngineConfiguration processEngineConfiguration(DataSource dataSource,
                                                                 PlatformTransactionManager transactionManager) {
        SpringProcessEngineConfiguration processEngineConfiguration = new SpringProcessEngineConfiguration();
        processEngineConfiguration.setDataSource(dataSource);
        // 如果表不存在，就抛出异常
        processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_FALSE);

        //指定数据库
        processEngineConfiguration.setDatabaseType("mysql");

        processEngineConfiguration.setTransactionManager(transactionManager);

        // 流程图字体
        processEngineConfiguration.setActivityFontName(ActivitiWorkflowConst.TYPEFACE);
        processEngineConfiguration.setAnnotationFontName(ActivitiWorkflowConst.TYPEFACE);
        processEngineConfiguration.setLabelFontName(ActivitiWorkflowConst.TYPEFACE);

        // 用户验证表改成使用视图
        processEngineConfiguration.setDbIdentityUsed(false);

        //自定义用户和组
        List<SessionFactory> customSessionFactories = new ArrayList<>();
        customSessionFactories.add(customUserEntityManagerFactory);
        customSessionFactories.add(customGroupEntityManagerFactory);
        processEngineConfiguration.setCustomSessionFactories(customSessionFactories);

        // 自定义日期格式化
        List<AbstractFormType> customFormTypes = new ArrayList<>();
        customFormTypes.add(new DateFormType(DatePattern.NORM_DATE_PATTERN));
        processEngineConfiguration.setCustomFormTypes(customFormTypes);

        //自定义流程图样式
        processEngineConfiguration.setProcessDiagramGenerator(customProcessDiagramGenerator);

        return processEngineConfiguration;
    }

    /**
     * 流程引擎，与spring整合使用factoryBean
     *
     * @param processEngineConfiguration processEngineConfiguration
     * @return ProcessEngineFactoryBean
     */
    @Bean
    public ProcessEngineFactoryBean processEngine(ProcessEngineConfiguration processEngineConfiguration) {
        ProcessEngineFactoryBean processEngineFactoryBean = new ProcessEngineFactoryBean();
        processEngineFactoryBean.setProcessEngineConfiguration((ProcessEngineConfigurationImpl) processEngineConfiguration);
        return processEngineFactoryBean;
    }

    @Bean
    public RepositoryService repositoryService(ProcessEngine processEngine) {
        return processEngine.getRepositoryService();
    }

    @Bean
    public RuntimeService runtimeService(ProcessEngine processEngine) {
        return processEngine.getRuntimeService();
    }

    @Bean
    public TaskService taskService(ProcessEngine processEngine) {
        return processEngine.getTaskService();
    }

    @Bean
    public HistoryService historyService(ProcessEngine processEngine) {
        return processEngine.getHistoryService();
    }

    @Bean
    public FormService formService(ProcessEngine processEngine) {
        return processEngine.getFormService();
    }

    @Bean
    public IdentityService identityService(ProcessEngine processEngine) {
        return processEngine.getIdentityService();
    }

    @Bean
    public ManagementService managementService(ProcessEngine processEngine) {
        return processEngine.getManagementService();
    }

    @Bean
    public DynamicBpmnService dynamicBpmnService(ProcessEngine processEngine) {
        return processEngine.getDynamicBpmnService();
    }
}
