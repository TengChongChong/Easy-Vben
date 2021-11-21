package com.easy.admin.generator.engine.config;

import com.easy.admin.generator.constant.GeneratorPackageConst;
import com.easy.admin.generator.model.Generator;

import java.io.File;

/**
 * mapping 模板生成的配置
 *
 * @author TengChongChong
 * @date 2019-01-08
 */
public class MappingConfig extends AbstractConfig{
    public MappingConfig(Generator generator) {
        super(generator);

        this.path = backEndFilePath + GeneratorPackageConst.MAPPING + File.separator + generator.getModelName() + "Mapper.xml";
    }
}
