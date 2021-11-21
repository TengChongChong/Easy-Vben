package com.easy.admin.generator.engine.config;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.generator.constant.GeneratorPackageConst;
import com.easy.admin.generator.model.Generator;

import java.io.File;

/**
 * service 模板生成的配置
 *
 * @author TengChongChong
 * @date 2019-01-09
 */
public class ServiceConfig extends AbstractConfig {

    public ServiceConfig(Generator generator) {
        super(generator);

        imports.add(Page.class);

        this.path = backEndFilePath + GeneratorPackageConst.SERVICE + File.separator + generator.getModelName() + "Service.java";
    }
}
