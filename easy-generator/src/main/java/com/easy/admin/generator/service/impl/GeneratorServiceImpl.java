package com.easy.admin.generator.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.system.SystemUtil;
import cn.hutool.system.UserInfo;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.ds.ItemDataSource;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.easy.admin.auth.common.type.MenuType;
import com.easy.admin.auth.model.vo.SysMenuVO;
import com.easy.admin.auth.service.SysMenuService;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.config.properties.ProjectProperties;
import com.easy.admin.config.sa.token.util.SessionUtil;
import com.easy.admin.generator.constant.*;
import com.easy.admin.generator.generator.GeneratorFile;
import com.easy.admin.generator.generator.GeneratorFileFactory;
import com.easy.admin.generator.model.GenerateDictEnumResponse;
import com.easy.admin.generator.model.GeneratorConfig;
import com.easy.admin.generator.model.ImportCellConfig;
import com.easy.admin.generator.service.GeneratorService;
import com.easy.admin.generator.type.EasyTypeConvertHandler;
import com.easy.admin.generator.util.GeneratorJavaUtil;
import com.easy.admin.sys.common.constant.WhetherConst;
import com.easy.admin.sys.common.status.ProfilesActiveStatus;
import com.easy.admin.sys.model.SysDictType;
import com.easy.admin.sys.model.SysImportExcelTemplate;
import com.easy.admin.sys.model.SysImportExcelTemplateDetail;
import com.easy.admin.sys.service.SysDictService;
import com.easy.admin.sys.service.SysDictTypeService;
import com.easy.admin.sys.service.SysImportExcelTemplateDetailService;
import com.easy.admin.sys.service.SysImportExcelTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * 代码生成
 *
 * @author TengChongChong
 * @date 2019-01-09
 */
@Slf4j
@Service
public class GeneratorServiceImpl implements GeneratorService {

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysDictTypeService sysDictTypeService;

    @Autowired
    private SysDictService sysDictService;

    @Autowired
    private SysImportExcelTemplateService sysImportExcelTemplateService;

    @Autowired
    private SysImportExcelTemplateDetailService sysImportExcelTemplateDetailsService;

    @Autowired
    private DynamicRoutingDataSource dynamicRoutingDataSource;

    @Autowired
    private ProjectProperties projectProperties;

    @Autowired
    private EasyTypeConvertHandler easyTypeConvertHandler;


    @Override
    public boolean generate(GeneratorConfig generatorConfig) {
        if (generatorConfig == null) {
            throw new RuntimeException("参数获取失败");
        }
        if (!ProfilesActiveStatus.DEV.getProfilesActive().equals(projectProperties.getProfilesActive())) {
            throw new EasyException("当前模式[" + projectProperties.getProfilesActive() + "]不允许生成");
        }
        // 生成文件
        if (generatorConfig.getBasicsConfig().getGenFile() != null) {
            TableInfo tableInfo = getTableInfo(generatorConfig.getBasicsConfig().getDataSource(), generatorConfig.getBasicsConfig().getTable());
            for (String fileSlug : generatorConfig.getBasicsConfig().getGenFile()) {
                GeneratorFile generatorFile = GeneratorFileFactory.getGeneratorFile(fileSlug, generatorConfig, tableInfo);
                generatorFile.generator();

                // 部分选项需要生成额外的文件，用于减少用户在前端选择的选项数量
                if (GeneratorFileConst.MODEL.equals(fileSlug)) {
                    generatorFile = GeneratorFileFactory.getGeneratorFile(GeneratorFileConst.MODEL_VO, generatorConfig, tableInfo);
                    generatorFile.generator();
                }
                if (GeneratorFileConst.MAPPER.equals(fileSlug)) {
                    generatorFile = GeneratorFileFactory.getGeneratorFile(GeneratorFileConst.MAPPING, generatorConfig, tableInfo);
                    generatorFile.generator();
                }
                if (GeneratorFileConst.SERVICE.equals(fileSlug)) {
                    generatorFile = GeneratorFileFactory.getGeneratorFile(GeneratorFileConst.SERVICE_IMPL, generatorConfig, tableInfo);
                    generatorFile.generator();
                }
                if (GeneratorFileConst.LIST_VUE.equals(fileSlug)) {
                    if (GeneratorListTemplateConst.TREE_TABLE.equals(generatorConfig.getBasicsConfig().getListGeneratorTemplate())) {
                        // 树表格 - 排序
                        generatorFile = GeneratorFileFactory.getGeneratorFile(GeneratorFileConst.ORDER_VUE, generatorConfig, tableInfo);
                        generatorFile.generator();
                    }

                    generatorFile = GeneratorFileFactory.getGeneratorFile(GeneratorFileConst.DATA_TS, generatorConfig, tableInfo);
                    generatorFile.generator();
                }
                if (GeneratorFileConst.API_TS.equals(fileSlug)) {
                    generatorFile = GeneratorFileFactory.getGeneratorFile(GeneratorFileConst.MODEL_TS, generatorConfig, tableInfo);
                    generatorFile.generator();
                }
            }
        }
        // 导入
        SysImportExcelTemplate sysImportExcelTemplate = null;
        if (generatorConfig.getBasicsConfig().getGenMethod().contains(GeneratorMethodConst.IMPORT_DATA)) {
            sysImportExcelTemplate = saveImportExcelTemplate(generatorConfig);
        }

        // 添加菜单
        saveMenu(generatorConfig, sysImportExcelTemplate);
        return true;
    }

    @Override
    public GenerateDictEnumResponse generateDictEnum(String dictType) {
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader();
        Configuration configuration;
        try {
            configuration = Configuration.defaultConfiguration();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        GroupTemplate groupTemplate = new GroupTemplate(resourceLoader, configuration);
        groupTemplate.registerFunctionPackage("GeneratorJavaUtil", GeneratorJavaUtil.class);
        Template javaTemplate = groupTemplate.getTemplate("/template/classes/Enum.java.btl");
        Template jsTemplate = groupTemplate.getTemplate("/template/ts/enum.ts.btl");

        Map<String, Object> vars = getSharedVars(dictType);
        groupTemplate.setSharedVars(vars);

        GenerateDictEnumResponse generateDictEnumResponse = new GenerateDictEnumResponse();
        generateDictEnumResponse.setJavaCode(javaTemplate.render());
        generateDictEnumResponse.setJsCode(jsTemplate.render());
        generateDictEnumResponse.setJavaFileName((String) vars.get("enumClassName"));
        generateDictEnumResponse.setJsFileName(StrUtil.lowerFirst(generateDictEnumResponse.getJavaFileName()));

        return generateDictEnumResponse;
    }

    /**
     * 设置字典枚举变量
     */
    private Map<String, Object> getSharedVars(String dictType) {
        Map<String, Object> vars = new HashMap<>();

        vars.put("date", DateUtil.today());
        vars.put("author", SessionUtil.getCurrentUser().getNickname());

        SysDictType sysDictType = sysDictTypeService.getByType(dictType);
        if (sysDictType == null) {
            throw new EasyException("字典类型[" + dictType + "]不存在");
        }
        vars.put("enumClassDescribe", sysDictType.getName());
        vars.put("enumClassName", StrUtil.upperFirst(sysDictType.getType()) + "Enum");
        List<Select> dictList = sysDictService.selectByDictType(dictType);
        vars.put("dictList", dictList);
        return vars;
    }

    /**
     * 保存菜单
     *
     * @param generatorConfig        生成配置
     * @param sysImportExcelTemplate 导入
     */
    private void saveMenu(GeneratorConfig generatorConfig, SysImportExcelTemplate sysImportExcelTemplate) {
        // 检查是否需要添加菜单
        if (StrUtil.isBlank(generatorConfig.getBasicsConfig().getMenuName()) || !generatorConfig.getBasicsConfig().isGeneratorFileListView()) {
            return;
        }
        // 菜单是否存在
        if (sysMenuService.hasMenu(generatorConfig.getBasicsConfig().getMenuName())) {
            return;
        }
        String listComponent;
        listComponent = generatorConfig.getBasicsConfig().getViewPath().replace("/src/views", "") + "/list";
        SysMenuVO baseMenu = getNewMenu(
                generatorConfig.getBasicsConfig().getMenuName(),
                MenuType.MENU.getCode(),
                generatorConfig.getBasicsConfig().getPermissionCode() + ":select",
                generatorConfig.getBasicsConfig().getControllerMapping().replace("/auth/", "/") + "/list",
                listComponent
        );
        baseMenu.setKeepAlive(WhetherConst.YES);
        baseMenu.setType(MenuType.MENU.getCode());
        baseMenu.setParentId(generatorConfig.getBasicsConfig().getMenuParentId());
        sysMenuService.saveData(baseMenu);
        if (StrUtil.isNotBlank(generatorConfig.getBasicsConfig().getPermissionCode())) {
            // 如果权限标识不为空,保存方法权限
            if (generatorConfig.getBasicsConfig().getGenMethod().contains(GeneratorMethodConst.SAVE)) {
                SysMenuVO savePermission = getNewMenu(
                        "保存/修改",
                        MenuType.BUTTON.getCode(),
                        generatorConfig.getBasicsConfig().getPermissionCode() + ":save",
                        null,
                        null
                );
                savePermission.setParentId(baseMenu.getId());
                sysMenuService.saveData(savePermission);
            }
            if (generatorConfig.getBasicsConfig().getGenMethod().contains(GeneratorMethodConst.REMOVE)) {
                SysMenuVO savePermission = getNewMenu(
                        "删除",
                        MenuType.BUTTON.getCode(),
                        generatorConfig.getBasicsConfig().getPermissionCode() + ":remove",
                        null,
                        null
                );
                savePermission.setParentId(baseMenu.getId());
                sysMenuService.saveData(savePermission);
            }
            if (GeneratorFormTemplateConst.PAGE.equals(generatorConfig.getBasicsConfig().getFormGeneratorTemplate())) {
                String inputComponent;
                inputComponent = generatorConfig.getBasicsConfig().getViewPath().replace("/src/views", "") + "/input";
                SysMenuVO savePermission = getNewMenu(
                        "详情",
                        MenuType.MENU.getCode(),
                        null,
                        generatorConfig.getBasicsConfig().getControllerMapping().replace("/auth/", "/") + "/input",
                        inputComponent
                );
                savePermission.setParentId(baseMenu.getId());
                sysMenuService.saveData(savePermission);
            }
            if (generatorConfig.getBasicsConfig().getGenMethod().contains(GeneratorMethodConst.IMPORT_DATA) && sysImportExcelTemplate != null && StrUtil.isNotBlank(sysImportExcelTemplate.getId())) {
                SysMenuVO savePermission = getNewMenu(
                        "导入数据",
                        MenuType.BUTTON.getCode(),
                        sysImportExcelTemplate.getPermissionCode(),
                        null,
                        null
                );
                savePermission.setParentId(baseMenu.getId());
                sysMenuService.saveData(savePermission);
            }
        }
    }

    /**
     * 保存导入模板
     *
     * @param generatorConfig 生成信息
     * @return SysImportExcelTemplate
     */
    private SysImportExcelTemplate saveImportExcelTemplate(GeneratorConfig generatorConfig) {
        if (sysImportExcelTemplateService.checkHav(generatorConfig.getBasicsConfig().getPermissionCode(), null)) {
            return null;
        }
        // 需要创建导入模板
        SysImportExcelTemplate sysImportExcelTemplate = new SysImportExcelTemplate();
        sysImportExcelTemplate.setName(generatorConfig.getBasicsConfig().getBusinessName());
        sysImportExcelTemplate.setImportTable(generatorConfig.getBasicsConfig().getTable());
        sysImportExcelTemplate.setStartRow(2);
        sysImportExcelTemplate.setCallback(StrUtil.lowerFirst(generatorConfig.getBasicsConfig().getModelName()) + "ServiceImpl");
        sysImportExcelTemplate.setImportCode(generatorConfig.getBasicsConfig().getPermissionCode());
        sysImportExcelTemplate.setPermissionCode(sysImportExcelTemplate.getImportCode() + ":import:data");
        try {
            sysImportExcelTemplate = sysImportExcelTemplateService.saveData(sysImportExcelTemplate);
            // 保存导入规则
            List<SysImportExcelTemplateDetail> sysImportExcelTemplateDetails = new ArrayList<>();
            int index = 1;
            for (ImportCellConfig item : generatorConfig.getImportConfig()) {
                SysImportExcelTemplateDetail importExcelTemplateDetails = new SysImportExcelTemplateDetail();
                importExcelTemplateDetails.setTemplateId(sysImportExcelTemplate.getId());
                importExcelTemplateDetails.setTitle(item.getTitle());
                importExcelTemplateDetails.setFieldName(item.getName());
                importExcelTemplateDetails.setFieldType(item.getMetaInfo().getJdbcType().name().toLowerCase());
                importExcelTemplateDetails.setFieldLength(item.getMetaInfo().getLength());
                importExcelTemplateDetails.setOrderNo(index);
                if (StrUtil.isNotBlank(item.getDictType())) {
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
        return sysImportExcelTemplate;
    }

    /**
     * 获取菜单/权限对象
     *
     * @param title     名称
     * @param type      类型
     * @param code      权限标识
     * @param path      访问地址
     * @param component 页面地址
     * @return SysMenus
     */
    private SysMenuVO getNewMenu(String title, String type, String code, String path, String component) {
        SysMenuVO sysPermissions = new SysMenuVO();
        sysPermissions.setTitle(title);
        sysPermissions.setAuthCode(code);
        sysPermissions.setPath(path);
        sysPermissions.setComponent(component);
        sysPermissions.setType(type);
        sysPermissions.setStatus(CommonStatus.ENABLE.getCode());
        return sysPermissions;
    }

    @Override
    public List<Select> selectTable(String dataSource) {
        List<Select> tables = new ArrayList<>();
        DruidPooledConnection connection = null;
        ResultSet rs = null;
        try {
            connection = (DruidPooledConnection) dynamicRoutingDataSource.getDataSource(dataSource).getConnection();
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            // 获取表
            rs = databaseMetaData.getTables(connection.getCatalog(), null, null, new String[]{"TABLE"});
            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME");
                String remarks = rs.getString("REMARKS");
                if (!inExclude(tableName)) {
                    tables.add(new Select(tableName, remarks));
                }
            }
        } catch (SQLException e) {
            log.warn("查询表信息失败", e);
            throw new EasyException("查询表信息失败" + e.getMessage());
        } finally {
            try {
                rs.close();
                connection.close();
            } catch (SQLException e) {
                log.warn("关闭连接失败", e);
            }
        }
        return tables;
    }

    /**
     * 是否属于被排除的表
     * 比如: 定时任务(qrtz_)、工作流（act_）
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
        return new GlobalConfig.Builder().dateType(DateType.ONLY_DATE).build();
    }

    /**
     * 生成策略
     *
     * @param tableName 表名
     * @return 策略
     */
    private StrategyConfig getStrategyConfig(String tableName) {
        return new StrategyConfig.Builder().addInclude(tableName).build();
    }

    /**
     * 获取数据源配置
     *
     * @return 数据源配置
     */
    private DataSourceConfig getDataSourceConfig(String dataSource) {
        ItemDataSource itemDataSource = (ItemDataSource) dynamicRoutingDataSource.getDataSource(dataSource);
        DruidDataSource ds = (DruidDataSource) itemDataSource.getRealDataSource();
        return new DataSourceConfig.Builder(ds.getUrl(), ds.getUsername(), ds.getPassword()).typeConvertHandler(easyTypeConvertHandler).build();
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
        if (files != null) {
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
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory() && file.getName().startsWith("easy-")) {
                    selectList.add(new Select(file.getPath(), parentFile.getName() + "/" + file.getName()));
                }
            }
        }
        return selectList;
    }

    @Override
    public TableInfo getTableInfo(String dataSource, String tableName) {
        ConfigBuilder configBuilder = new ConfigBuilder(null, getDataSourceConfig(dataSource), getStrategyConfig(tableName), null, getGlobalConfig(), null);
        List<TableInfo> tableInfoList = configBuilder.getTableInfoList();
        if (tableInfoList.isEmpty()) {
            throw new EasyException("表不存在");
        }
        return tableInfoList.get(0);
    }
}