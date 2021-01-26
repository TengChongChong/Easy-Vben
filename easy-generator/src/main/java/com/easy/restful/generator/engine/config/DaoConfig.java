package com.easy.restful.generator.engine.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.generator.constant.GeneratorPackageConst;
import com.easy.restful.generator.model.Generator;
import org.apache.ibatis.annotations.Param;

import java.io.File;
import java.util.List;

/**
 * dao 模板生成的配置
 *
 * @author tengchong
 * @date 2019-01-09
 */
public class DaoConfig extends AbstractConfig{

    public DaoConfig(Generator generator) {
        super(generator);

        imports.add(QueryWrapper.class);
        imports.add(BaseMapper.class);
        imports.add(Page.class);
        imports.add(Param.class);
        imports.add(List.class);

        this.path = backEndFilePath + GeneratorPackageConst.DAO + File.separator + generator.getModelName() + "Mapper.java";
    }
}
