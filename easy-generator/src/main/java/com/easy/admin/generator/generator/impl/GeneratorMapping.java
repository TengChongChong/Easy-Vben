package com.easy.admin.generator.generator.impl;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.easy.admin.generator.constant.GeneratorPackageConst;
import com.easy.admin.generator.constant.GeneratorTemplateConst;
import com.easy.admin.generator.generator.GeneratorFile;
import com.easy.admin.generator.model.GeneratorConfig;

/**
 * 生成 Mapping.xml
 *
 * @author tengchong
 * @date 2022/6/20
 */
public class GeneratorMapping extends GeneratorFile {
    /**
     * 构造
     *
     * @param generatorConfig 生成配置
     */
    public GeneratorMapping(GeneratorConfig generatorConfig, TableInfo tableInfo) {
        super(generatorConfig, tableInfo);
    }

    @Override
    public void init() {
        // 设置模板
        this.setTemplate(GeneratorTemplateConst.MAPPING);
        // 设置文件路径
        this.setFilePath(this.backEndPathBasePath + GeneratorPackageConst.MAPPING + generatorConfig.getBasicsConfig().getModelName() + "Mapper.xml");
    }

}
