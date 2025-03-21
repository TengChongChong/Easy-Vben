package com.easy.admin.generator.generator.impl;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.easy.admin.generator.constant.GeneratorMethodConst;
import com.easy.admin.generator.constant.GeneratorPackageConst;
import com.easy.admin.generator.constant.GeneratorTemplatePathConst;
import com.easy.admin.generator.generator.GeneratorFile;
import com.easy.admin.generator.model.GeneratorConfig;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成实体类
 *
 * @author tengchong
 * @date 2022/6/20
 */
public class GeneratorModel extends GeneratorFile {

    /**
     * 构造
     *
     * @param generatorConfig 生成配置
     */
    public GeneratorModel(GeneratorConfig generatorConfig, TableInfo tableInfo) {
        super(generatorConfig, tableInfo);
    }

    @Override
    public void init() {
        // 设置模板
        this.setTemplate(GeneratorTemplatePathConst.MODEL);
        // 设置导入包
        this.setImports(initImports());
        // 设置文件路径
        this.setFilePath(this.backEndPathBasePath + GeneratorPackageConst.MODEL + generatorConfig.getBasicsConfig().getModelName() + ".java");
    }

    /**
     * 初始化导入类
     *
     * @return 导入类
     */
    private List<Class<?>> initImports() {
        List<Class<?>> imports = new ArrayList<>();
        imports.add(Model.class);
        imports.add(TableId.class);
        imports.add(TableField.class);
        imports.add(FieldFill.class);
        // lombok
        imports.add(Data.class);
        // mybatis 相关
        if (generatorConfig.getBasicsConfig().getGenMethod().contains(GeneratorMethodConst.SAVE)) {
            imports.add(NotBlank.class);
            imports.add(NotNull.class);
            imports.add(Version.class);
        }
        // 导出
        if (generatorConfig.getBasicsConfig().getGenMethod().contains(GeneratorMethodConst.EXPORT_DATA)) {
            imports.add(Excel.class);
        }
        return imports;
    }

}
