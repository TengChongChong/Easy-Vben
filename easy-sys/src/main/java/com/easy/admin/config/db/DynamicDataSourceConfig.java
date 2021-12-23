package com.easy.admin.config.db;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.DruidDataSourceCreator;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.easy.admin.sys.model.SysDataSource;
import com.easy.admin.sys.service.SysDataSourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import javax.sql.DataSource;
import java.util.List;

/**
 * 动态数据源
 *
 * @author tengchong
 * @date 2021/12/20
 */
@Configuration
public class DynamicDataSourceConfig implements ApplicationListener<ContextRefreshedEvent> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.datasource.dynamic.primary}")
    private String dynamicPrimary;

    @Autowired
    private SysDataSourceService sysDataSourceService;

    @Autowired
    private DynamicRoutingDataSource dynamicRoutingDataSource;

    @Autowired
    private DruidDataSourceCreator druidDataSourceCreator;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        List<SysDataSource> dataSourceList = sysDataSourceService.selectAll();
        if (CollUtil.isEmpty(dataSourceList)) {
            return;
        }

        dataSourceList.forEach(dataSource -> {
            DataSource masterDs = dynamicRoutingDataSource.getDataSource(dynamicPrimary);
            DataSourceProperty dataSourceProperty = new DataSourceProperty();
            BeanUtil.copyProperties(masterDs, dataSourceProperty);
            dataSourceProperty.setUrl(dataSource.getUrl());
            dataSourceProperty.setUsername(dataSource.getUsername());
            dataSourceProperty.setPassword(dataSource.getPassword());

            DataSource ds = druidDataSourceCreator.createDataSource(dataSourceProperty);
            dynamicRoutingDataSource.addDataSource(dataSource.getName(), ds);
            logger.debug("添加 {} 数据源", dataSource.getName());
        });
    }
}
