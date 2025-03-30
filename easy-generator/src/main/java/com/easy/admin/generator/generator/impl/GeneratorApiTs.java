package com.easy.admin.generator.generator.impl;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.easy.admin.generator.constant.GeneratorTemplatePathConst;
import com.easy.admin.generator.generator.GeneratorFile;
import com.easy.admin.generator.model.GeneratorConfig;
import com.easy.admin.generator.util.FrontEndImportPathUtil;

/**
 * 生成 Api.ts
 *
 * @author tengchong
 * @date 2022/6/20
 */
public class GeneratorApiTs extends GeneratorFile {

    /**
     * 构造
     *
     * @param generatorConfig 生成配置
     */
    public GeneratorApiTs(GeneratorConfig generatorConfig, TableInfo tableInfo) {
        super(generatorConfig, tableInfo);
    }

    @Override
    public void init() {
        // 设置模板
        this.setTemplate(GeneratorTemplatePathConst.API_TS);
        // 设置文件路径
        this.setFilePath(generatorConfig.getBasicsConfig().getFrontEndPath() + generatorConfig.getBasicsConfig().getApiPath());
    }

    @Override
    public void binding() {
        this.getPageTemplate().binding("modelTsPath", FrontEndImportPathUtil.getModelTsImportPath(generatorConfig));
    }
}
