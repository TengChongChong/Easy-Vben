package com.easy.restful.generator.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.system.SystemUtil;
import cn.hutool.system.UserInfo;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.easy.restful.common.core.common.select.Select;
import com.easy.restful.common.core.exception.EasyException;
import com.easy.restful.config.properties.ProjectProperties;
import com.easy.restful.generator.constant.GeneratorConst;
import com.easy.restful.generator.engine.TemplateEngine;
import com.easy.restful.generator.model.FieldSet;
import com.easy.restful.generator.model.Generator;
import com.easy.restful.generator.service.GeneratorService;
import com.easy.restful.sys.common.status.PermissionsStatus;
import com.easy.restful.sys.common.status.ProfilesActiveStatus;
import com.easy.restful.sys.common.type.PermissionsType;
import com.easy.restful.sys.model.SysImportExcelTemplate;
import com.easy.restful.sys.model.SysImportExcelTemplateDetails;
import com.easy.restful.sys.model.SysPermissions;
import com.easy.restful.sys.service.SysImportExcelTemplateDetailsService;
import com.easy.restful.sys.service.SysImportExcelTemplateService;
import com.easy.restful.sys.service.SysPermissionsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 代码生成
 *
 * @author tengchong
 * @date 2019-01-09
 */
@Service
public class GeneratorServiceImpl implements GeneratorService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysPermissionsService sysPermissionsService;
    @Autowired
    private SysImportExcelTemplateService sysImportExcelTemplateService;
    @Autowired
    private SysImportExcelTemplateDetailsService sysImportExcelTemplateDetailsService;

    @Autowired
    private ProjectProperties projectProperties;

    @Autowired
    private DruidDataSource druidDataSource;

    @Override
    public boolean generate(Generator object) {
        if (object != null) {
            if (!ProfilesActiveStatus.DEV.getProfilesActive().equals(projectProperties.getProfilesActive())) {
                throw new EasyException("当前模式[" + projectProperties.getProfilesActive() + "]不允许生成");
            }
            // 生成文件
            new TemplateEngine(object, selectFields(object.getTableName())).start();
            SysImportExcelTemplate sysImportExcelTemplate = null;
            if (object.isGeneratorMethodsImport()) {
                // 需要创建导入模板
                sysImportExcelTemplate = new SysImportExcelTemplate();
                sysImportExcelTemplate.setName(object.getBusinessName());
                sysImportExcelTemplate.setImportTable(object.getTableName());
                sysImportExcelTemplate.setStartRow(1);
                sysImportExcelTemplate.setCallback(StrUtil.lowerFirst(object.getModelName()) + "ServiceImpl");
                sysImportExcelTemplate.setImportCode(object.getPermissionsCode());
                sysImportExcelTemplate.setPermissionCode(sysImportExcelTemplate.getImportCode() + ":import:data");
                try {
                    sysImportExcelTemplate = sysImportExcelTemplateService.saveData(sysImportExcelTemplate);
                    // 保存导入规则
                    List<SysImportExcelTemplateDetails> sysImportExcelTemplateDetails = new ArrayList<>();
                    int index = 1;
                    for (FieldSet item : object.getImportItems()) {
                        SysImportExcelTemplateDetails importExcelTemplateDetails = new SysImportExcelTemplateDetails();
                        importExcelTemplateDetails.setTemplateId(sysImportExcelTemplate.getId());
                        importExcelTemplateDetails.setTitle(item.getTitle());
                        importExcelTemplateDetails.setFieldName(item.getColumnName());
                        importExcelTemplateDetails.setFieldType(item.getColumnType());
                        importExcelTemplateDetails.setOrderNo(index);
                        if(StrUtil.isNotBlank(item.getDictType())){
                            importExcelTemplateDetails.setReplaceTable("sys_dict");
                            importExcelTemplateDetails.setReplaceTableDictType(item.getDictType());
                            importExcelTemplateDetails.setReplaceTableFieldName("name");
                            importExcelTemplateDetails.setReplaceTableFieldValue("code");
                        }
                        index++;
                        sysImportExcelTemplateDetails.add(importExcelTemplateDetails);
                    }
                    sysImportExcelTemplateDetailsService.saveData(sysImportExcelTemplate.getId(), sysImportExcelTemplateDetails);
                } catch (EasyException e) {
                    // ignore，可能用户已经自己新增
                }
            }
            // 检查是否需要添加菜单
            if (StrUtil.isNotBlank(object.getMenuName())) {
                // 菜单名称不为空
                // 检查菜单名称是否存在
                if (!sysPermissionsService.checkMenuIsHaving(object.getMenuName())) {
                    // 菜单不存在
                    SysPermissions basePermission = getNewMenu(
                            object.getMenuName(),
                            PermissionsType.MENU.getCode(),
                            "0",
                            object.getPermissionsCode() + ":select",
                            object.getControllerMapping() + "/list",
                            object.getViewPath().replace("/views", "") + "/List"
                    );
                    basePermission.setpId("0");
                    basePermission.setType(PermissionsType.MENU.getCode());
                    sysPermissionsService.saveData(basePermission);
                    if (StrUtil.isNotBlank(object.getPermissionsCode())) {
                        // 如果权限标识不为空,保存方法权限
                        if (object.isGeneratorMethodsSave()) {
                            SysPermissions savePermission = getNewMenu(
                                    "保存/修改",
                                    PermissionsType.PERMISSIONS.getCode(),
                                    "1",
                                    object.getPermissionsCode() + ":save",
                                    null,
                                    null
                            );
                            savePermission.setpId(basePermission.getId());
                            sysPermissionsService.saveData(savePermission);
                            savePermission = getNewMenu(
                                    "详情",
                                    PermissionsType.MENU.getCode(),
                                    "1",
                                    null,
                                    object.getControllerMapping() + "/input",
                                    object.getViewPath().replace("/views", "") + "/Input"
                            );
                            savePermission.setpId(basePermission.getId());
                            sysPermissionsService.saveData(savePermission);

                        }
                        if (object.isGeneratorMethodsRemove()) {
                            SysPermissions savePermission = getNewMenu(
                                    "删除",
                                    PermissionsType.PERMISSIONS.getCode(),
                                    "1",
                                    object.getPermissionsCode() + ":remove",
                                    null,
                                    null
                            );
                            savePermission.setpId(basePermission.getId());
                            sysPermissionsService.saveData(savePermission);
                        }
                        if(object.isGeneratorMethodsImport() && StrUtil.isNotBlank(sysImportExcelTemplate.getId())){
                            SysPermissions savePermission = getNewMenu(
                                    "导入数据",
                                    PermissionsType.PERMISSIONS.getCode(),
                                    "1",
                                    sysImportExcelTemplate.getPermissionCode(),
                                    null,
                                    null
                            );
                            savePermission.setpId(basePermission.getId());
                            sysPermissionsService.saveData(savePermission);
                        }
                    }
                }
            }
            return true;
        }
        throw new RuntimeException("参数获取失败");
    }

    /**
     * 获取菜单/权限对象
     *
     * @param name      名称
     * @param type      类型
     * @param hide      是否隐藏
     * @param code      权限标识
     * @param path      访问地址
     * @param component 页面地址
     * @return SysPermissions
     */
    private SysPermissions getNewMenu(String name, String type, String hide, String code, String path, String component) {
        SysPermissions sysPermissions = new SysPermissions();
        sysPermissions.setName(name);
        sysPermissions.setCode(code);
        sysPermissions.setPath(path);
        sysPermissions.setComponent(component);
        sysPermissions.setType(type);
        sysPermissions.setStatus(PermissionsStatus.ENABLE.getCode());
        sysPermissions.setHide(hide);
        // 打开方式
        sysPermissions.setTarget("1");
        return sysPermissions;
    }

    @Override
    public List<Select> selectTable() {
        List<Select> tables = new ArrayList<>();
        try {
            DruidPooledConnection connection = druidDataSource.getConnection();
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            // 获取表
            ResultSet rs = databaseMetaData.getTables(null, null, null, new String[]{"TABLE"});
            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME");
                String remarks = rs.getString("REMARKS");
                if (!inExclude(tableName)) {
                    tables.add(new Select(tableName, remarks));
                }
            }
            rs.close();
            connection.close();
        } catch (SQLException e) {
            logger.warn("查询表信息失败", e);
            throw new EasyException("查询表信息失败" + e.getMessage());
        }
        return tables;
    }

    /**
     * 是否属于被排除的表
     * 比如: 定时任务(qrtz_)
     *
     * @param tableName 表名
     * @return true/false
     */
    private boolean inExclude(String tableName) {
        for (String tablePrefix : GeneratorConst.EXCLUDE_TABLE_PREFIX) {
            if (tableName.startsWith(tablePrefix)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 全局设置
     *
     * @return GlobalConfig
     */
    private GlobalConfig getGlobalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setDateType(DateType.ONLY_DATE);
        return globalConfig;
    }

    /**
     * 生成策略
     *
     * @param tableName 表名
     * @return 策略
     */
    private StrategyConfig getStrategyConfig(String tableName) {
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude(tableName);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        return strategyConfig;
    }

    /**
     * 获取数据源配置
     *
     * @return 数据源配置
     */
    private DataSourceConfig getDataSourceConfig() {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(druidDataSource.getUrl());
        dataSourceConfig.setDriverName(druidDataSource.getDriverClassName());
        dataSourceConfig.setUsername(druidDataSource.getUsername());
        dataSourceConfig.setPassword(druidDataSource.getPassword());
        return dataSourceConfig;
    }

    @Override
    public List<Select> selectModules() {
        if (!ProfilesActiveStatus.DEV.getProfilesActive().equals(projectProperties.getProfilesActive())) {
            // 除开发模式以外都返回虚拟数据
            return Collections.singletonList(new Select("/fictitious/easy-test", "easy-test"));
        }
        List<Select> selectList = new ArrayList<>();
        UserInfo userInfo = SystemUtil.getUserInfo();
        File[] files = new File(userInfo.getCurrentDir()).listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory() && file.getName().startsWith("easy-")) {
                    selectList.add(new Select(file.getPath(), file.getName()));
                    selectList.addAll(selectModules(file));
                }
            }
        }
        return selectList;
    }

    private List<Select> selectModules(File parentFile) {
        List<Select> selectList = new ArrayList<>();
        File[] files = parentFile.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory() && file.getName().startsWith("easy-")) {
                    selectList.add(new Select(file.getPath(), parentFile.getName() + "/" + file.getName()));
                }
            }
        }
        return selectList;
    }

    @Override
    public TableInfo selectFields(String tableName) {
        ConfigBuilder configBuilder = new ConfigBuilder(null, getDataSourceConfig(), getStrategyConfig(tableName), null, getGlobalConfig());
        List<TableInfo> tableInfoList = configBuilder.getTableInfoList();
        return tableInfoList.get(0);
    }
}