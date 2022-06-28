package com.easy.admin.generator.generator.impl;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.easy.admin.generator.constant.GeneratorTemplateConst;
import com.easy.admin.generator.generator.GeneratorFile;
import com.easy.admin.generator.model.GeneratorConfig;
import com.easy.admin.generator.util.GeneratorUtil;

import java.io.File;

/**
 * 生成 data.ts
 *
 * @author tengchong
 * @date 2022/6/20
 */
public class GeneratorDataTs extends GeneratorFile {

    /**
     * 构造
     *
     * @param generatorConfig 生成配置
     */
    public GeneratorDataTs(GeneratorConfig generatorConfig, TableInfo tableInfo) {
        super(generatorConfig, tableInfo);
    }

    @Override
    public void init() {
        // 设置模板
        this.setTemplate(GeneratorTemplateConst.DATA_TS);
        // 设置文件路径
        initFilePath();
    }

    private void initFilePath() {
        setFilePath(generatorConfig.getBasicsConfig().getFrontEndPath() + generatorConfig.getBasicsConfig().getViewPath() + File.separator + GeneratorUtil.getDataTsName(generatorConfig.getBasicsConfig()));
    }
}
