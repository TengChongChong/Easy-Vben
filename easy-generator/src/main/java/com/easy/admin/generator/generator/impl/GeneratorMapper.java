package com.easy.admin.generator.generator.impl;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.generator.constant.GeneratorListTemplateConst;
import com.easy.admin.generator.constant.GeneratorPackageConst;
import com.easy.admin.generator.constant.GeneratorTemplateConst;
import com.easy.admin.generator.generator.GeneratorFile;
import com.easy.admin.generator.model.GeneratorConfig;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成 Mapper
 *
 * @author tengchong
 * @date 2022/6/20
 */
public class GeneratorMapper extends GeneratorFile {
    /**
     * 构造
     *
     * @param generatorConfig 生成配置
     */
    public GeneratorMapper(GeneratorConfig generatorConfig, TableInfo tableInfo) {
        super(generatorConfig, tableInfo);
    }

    @Override
    public void init() {
        // 设置模板
        this.setTemplate(GeneratorTemplateConst.MAPPER);
        // 设置导入包
        this.setImports(initImports());
        // 设置文件路径
        this.setFilePath(this.backEndPathBasePath + GeneratorPackageConst.MAPPER + generatorConfig.getBasicsConfig().getModelName() + "Mapper.java");
    }

    /**
     * 初始化导入类
     *
     * @return 导入类
     */
    private List<Class<?>> initImports(){
        List<Class<?>> imports = new ArrayList<>();
        imports.add(QueryWrapper.class);
        imports.add(BaseMapper.class);
        imports.add(Page.class);
        imports.add(Param.class);
        imports.add(List.class);
        if (GeneratorListTemplateConst.TREE_TABLE.equals(generatorConfig.getBasicsConfig().getListGeneratorTemplate()) ||
                GeneratorListTemplateConst.TREE.equals(generatorConfig.getBasicsConfig().getListGeneratorTemplate())) {
            imports.add(Tree.class);
        }
        return imports;
    }
}
