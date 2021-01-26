package com.easy.restful.generator.engine.config;

import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.generator.constant.GeneratorPackageConst;
import com.easy.restful.generator.model.Generator;

import java.io.File;

/**
 * service 模板生成的配置
 *
 * @author tengchong
 * @date 2019-01-09
 */
public class ServiceConfig extends AbstractConfig {

    public ServiceConfig(Generator generator) {
        super(generator);

        imports.add(Page.class);

        this.path = backEndFilePath + GeneratorPackageConst.SERVICE + File.separator + generator.getModelName() + "Service.java";
    }
}
