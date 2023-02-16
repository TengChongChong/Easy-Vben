package com.easy.admin.generator.generator.impl;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.generator.constant.GeneratorListTemplateConst;
import com.easy.admin.generator.constant.GeneratorPackageConst;
import com.easy.admin.generator.constant.GeneratorTemplateConst;
import com.easy.admin.generator.generator.GeneratorFile;
import com.easy.admin.generator.model.GeneratorConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成 Service
 *
 * @author tengchong
 * @date 2022/6/20
 */
public class GeneratorService extends GeneratorFile {
    /**
     * 构造
     *
     * @param generatorConfig 生成配置
     */
    public GeneratorService(GeneratorConfig generatorConfig, TableInfo tableInfo) {
        super(generatorConfig, tableInfo);
    }

    @Override
    public void init() {
        // 设置模板
        this.setTemplate(GeneratorTemplateConst.SERVICE);
        // 设置导入包
        this.setImports(initImports());
        // 设置文件路径
        this.setFilePath(this.backEndPathBasePath + GeneratorPackageConst.SERVICE + generatorConfig.getBasicsConfig().getModelName() + "Service.java");
    }

    /**
     * 初始化导入类
     *
     * @return 导入类
     */
    private List<Class<?>> initImports() {
        List<Class<?>> imports = new ArrayList<>();
        imports.add(Page.class);
        if (GeneratorListTemplateConst.TREE_TABLE.equals(generatorConfig.getBasicsConfig().getListGeneratorTemplate()) ||
                GeneratorListTemplateConst.TREE.equals(generatorConfig.getBasicsConfig().getListGeneratorTemplate())) {
            imports.add(List.class);
            imports.add(Tree.class);
        }
        return imports;
    }
}
