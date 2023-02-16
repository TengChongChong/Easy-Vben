package com.easy.admin.generator.generator.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.generator.constant.GeneratorListTemplateConst;
import com.easy.admin.generator.constant.GeneratorMethodConst;
import com.easy.admin.generator.constant.GeneratorPackageConst;
import com.easy.admin.generator.constant.GeneratorTemplateConst;
import com.easy.admin.generator.generator.GeneratorFile;
import com.easy.admin.generator.model.FieldConfig;
import com.easy.admin.generator.model.GeneratorConfig;
import com.easy.admin.sys.service.ImportService;
import com.easy.admin.util.ToolUtil;
import com.easy.admin.util.office.ExcelUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 生成 ServiceImpl
 *
 * @author tengchong
 * @date 2022/6/20
 */
public class GeneratorServiceImpl extends GeneratorFile {
    /**
     * 构造
     *
     * @param generatorConfig 生成配置
     */
    public GeneratorServiceImpl(GeneratorConfig generatorConfig, TableInfo tableInfo) {
        super(generatorConfig, tableInfo);
    }

    @Override
    public void init() {
        // 设置模板
        this.setTemplate(GeneratorTemplateConst.SERVICE_IMPL);
        // 设置导入包
        this.setImports(initImports());
        // 设置文件路径
        this.setFilePath(this.backEndPathBasePath + GeneratorPackageConst.SERVICE_IMPL + generatorConfig.getBasicsConfig().getModelName() + "ServiceImpl.java");
    }

    /**
     * 初始化导入类
     *
     * @return 导入类
     */
    private List<Class<?>> initImports() {
        List<Class<?>> imports = new ArrayList<>();
        imports.add(Validator.class);
        imports.add(QueryWrapper.class);
        imports.add(ServiceImpl.class);
        imports.add(Page.class);
        if (hasDict()) {
            imports.add(CommonConst.class);
        }
        // 导入
        if (generatorConfig.getBasicsConfig().getGenMethod().contains(GeneratorMethodConst.IMPORT_DATA)) {
            imports.add(ImportService.class);
        }
        imports.add(ToolUtil.class);
        // 导出
        if (generatorConfig.getBasicsConfig().getGenMethod().contains(GeneratorMethodConst.EXPORT_DATA)) {
            imports.add(ExcelUtil.class);
        }
        imports.add(Service.class);
        imports.add(Transactional.class);
        imports.add(Arrays.class);
        imports.add(List.class);
        if (GeneratorListTemplateConst.TREE_TABLE.equals(generatorConfig.getBasicsConfig().getListGeneratorTemplate()) ||
                GeneratorListTemplateConst.TREE.equals(generatorConfig.getBasicsConfig().getListGeneratorTemplate())) {
            imports.add(Tree.class);
        }
        return imports;
    }

    /**
     * 查询条件是否使用了字典
     *
     * @return true/false
     */
    private boolean hasDict() {
        for (FieldConfig fieldConfig : generatorConfig.getQueryConfig()) {
            if (StrUtil.isNotBlank(fieldConfig.getDictType())) {
                return true;
            }
        }
        return false;
    }
}
