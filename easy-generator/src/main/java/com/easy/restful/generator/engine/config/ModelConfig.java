package com.easy.restful.generator.engine.config;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.easy.restful.generator.constant.GeneratorPackageConst;
import com.easy.restful.generator.model.Generator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.Serializable;

/**
 * model 模板生成的配置
 *
 * @author tengchong
 * @date 2019-01-08
 */
public class ModelConfig extends AbstractConfig {

    public ModelConfig(Generator generator) {
        super(generator);

        imports.add(Model.class);
        imports.add(TableName.class);
        imports.add(IdType.class);
        imports.add(TableId.class);
        imports.add(TableField.class);
        imports.add(FieldFill.class);
        imports.add(Serializable.class);
        // mybatis 相关
        if (generator.isGeneratorMethodsSave()) {
            imports.add(NotBlank.class);
            imports.add(NotNull.class);
        }
        // 导出
        if (generator.isGeneratorMethodsExport()) {
            imports.add(Excel.class);
        }

        this.path = backEndFilePath + GeneratorPackageConst.MODEL + File.separator + generator.getModelName() + ".java";
    }
}
