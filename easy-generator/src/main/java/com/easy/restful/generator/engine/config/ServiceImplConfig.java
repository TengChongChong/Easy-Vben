package com.easy.restful.generator.engine.config;


import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.generator.constant.GeneratorPackageConst;
import com.easy.restful.generator.model.Generator;
import com.easy.restful.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Arrays;
import java.util.List;


/**
 * service impl 模板生成的配置
 *
 * @author tengchong
 * @date 2019-01-09
 */
public class ServiceImplConfig extends AbstractConfig {

    public ServiceImplConfig(Generator generator) {
        super(generator);

        imports.add(QueryWrapper.class);
        imports.add(ServiceImpl.class);
        imports.add(ToolUtil.class);
        imports.add(Autowired.class);
        imports.add(Service.class);
        imports.add(Transactional.class);
        imports.add(Arrays.class);
        imports.add(List.class);
        imports.add(Page.class);
        imports.add(Validator.class);
        imports.add(StrUtil.class);

        this.path = backEndFilePath + GeneratorPackageConst.SERVICE_IMPL + File.separator + generator.getModelName() + "ServiceImpl.java";
    }
}
