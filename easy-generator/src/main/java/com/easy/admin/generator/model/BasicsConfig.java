package com.easy.admin.generator.model;

import com.easy.admin.generator.constant.GeneratorFileConst;
import com.easy.admin.generator.constant.GeneratorMethodConst;
import lombok.Data;

import java.util.List;

/**
 * 基础信息
 *
 * @author tengchong
 * @date 2022/6/20
 */
@Data
public class BasicsConfig {
    /**
     * 数据源
     */
    private String dataSource;
    /**
     * 表
     */
    private String table;
    /**
     * 与主表关联字段
     */
    private String mainTableField;
    /**
     * 与主表关联属性
     */
    private String mainTableProperty;
    /**
     * 生成模版
     */
    private String generatorTemplate;
    /**
     * 生成模版 - 列表
     */
    private String listGeneratorTemplate;
    /**
     * 生成模版 - 表单
     */
    private String formGeneratorTemplate;
    /**
     * 生成方法
     */
    private List<String> genMethod;
    /**
     * 生成文件
     */
    private List<String> genFile;
    /**
     * 后端项目路径
     */
    private String backEndPath;
    /**
     * 业务名称
     */
    private String businessName;
    /**
     * 作者
     */
    private String author;
    /**
     * 实体类名称
     */
    private String modelName;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 上级菜单
     */
    private String menuParentId;
    /**
     * 权限标识
     */
    private String permissionCode;
    /**
     * 包路径
     */
    private String packagePath;
    /**
     * Controller Mapping
     */
    private String controllerMapping;
    /**
     * 前端项目路径
     */
    private String frontEndPath;
    /**
     * 页面路径
     */
    private String viewPath;
    /**
     * api路径
     */
    private String apiPath;

    /**
     * 覆盖已存在文件
     */
    private Boolean overwrite;


    /**
     * 是否生成新增方法
     *
     * @return true/false
     */
    public boolean isGeneratorMethodsAdd() {
        return this.genMethod != null && this.genMethod.contains(GeneratorMethodConst.ADD);
    }

    /**
     * 是否生成删除方法
     *
     * @return true/false
     */
    public boolean isGeneratorMethodsRemove() {
        return this.genMethod != null && this.genMethod.contains(GeneratorMethodConst.REMOVE);
    }

    /**
     * 是否生成保存方法
     *
     * @return true/false
     */
    public boolean isGeneratorMethodsSave() {
        return this.genMethod != null && this.genMethod.contains(GeneratorMethodConst.SAVE);
    }

    /**
     * 是否生成查询方法
     *
     * @return true/false
     */
    public boolean isGeneratorMethodsSelect() {
        return this.genMethod != null && this.genMethod.contains(GeneratorMethodConst.SELECT);
    }

    /**
     * 是否生成导入数据方法
     *
     * @return true/false
     */
    public boolean isGeneratorMethodsImport() {
        return this.genMethod != null && this.genMethod.contains(GeneratorMethodConst.IMPORT_DATA);
    }

    /**
     * 是否生成导出数据方法
     *
     * @return true/false
     */
    public boolean isGeneratorMethodsExport() {
        return this.genMethod != null && this.genMethod.contains(GeneratorMethodConst.EXPORT_DATA);
    }

    /**
     * 是否生成实体类
     *
     * @return true/false
     */
    public boolean isGeneratorFileModel() {
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.MODEL);
    }

    /**
     * 是否生成Dao
     *
     * @return true/false
     */
    public boolean isGeneratorFileMapper() {
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.MAPPER);
    }

    /**
     * 是否生成Mapping
     *
     * @return true/false
     */
    public boolean isGeneratorFileMapping() {
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.MAPPER);
    }

    /**
     * 是否生成Service
     *
     * @return true/false
     */
    public boolean isGeneratorFileService() {
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.SERVICE);
    }

    /**
     * 是否生成Service实现类
     *
     * @return true/false
     */
    public boolean isGeneratorFileServiceImpl() {
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.SERVICE);
    }

    /**
     * 是否生成Controller
     *
     * @return true/false
     */
    public boolean isGeneratorFileController() {
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.CONTROLLER);
    }

    /**
     * 是否生成列表页
     *
     * @return true/false
     */
    public boolean isGeneratorFileListView() {
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.LIST_VUE);
    }

    /**
     * 是否生成表单页
     *
     * @return true/false
     */
    public boolean isGeneratorFileInputView() {
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.INPUT_VUE);
    }

    /**
     * 是否生成接口js
     *
     * @return true/false
     */
    public boolean isGeneratorFileApi() {
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.API_TS);
    }

    /**
     * 是否生成model.ts
     *
     * @return true/false
     */
    public boolean isGeneratorFileModelTs() {
        return this.genFile != null && this.genFile.contains(GeneratorFileConst.MODEL_TS);
    }

}
