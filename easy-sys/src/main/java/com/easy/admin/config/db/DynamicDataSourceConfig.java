package com.easy.admin.config.db;

import cn.hutool.core.collection.CollUtil;
import com.easy.admin.sys.model.SysDataSource;
import com.easy.admin.sys.service.SysDataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.List;

/**
 * 动态数据源
 *
 * @author tengchong
 * @date 2021/12/20
 */
@Configuration
public class DynamicDataSourceConfig implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private SysDataSourceService sysDataSourceService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        List<SysDataSource> dataSourceList = sysDataSourceService.selectAll();
        if (CollUtil.isEmpty(dataSourceList)) {
            return;
        }

        dataSourceList.forEach(dataSource -> sysDataSourceService.addDataSource(dataSource));
    }
}
