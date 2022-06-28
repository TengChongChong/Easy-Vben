package com.easy.admin.generator.generator.impl;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.easy.admin.generator.constant.GeneratorTemplateConst;
import com.easy.admin.generator.generator.GeneratorFile;
import com.easy.admin.generator.model.GeneratorConfig;
import com.easy.admin.generator.util.GeneratorUtil;

import java.io.File;

/**
 * 生成 Model.ts
 *
 * @author tengchong
 * @date 2022/6/20
 */
public class GeneratorModelTs extends GeneratorFile {

    /**
     * 构造
     *
     * @param generatorConfig 生成配置
     */
    public GeneratorModelTs(GeneratorConfig generatorConfig, TableInfo tableInfo) {
        super(generatorConfig, tableInfo);
    }

    @Override
    public void init() {
        // 设置模板
        this.setTemplate(GeneratorTemplateConst.MODEL_TS);
        // 设置文件路径
        initFilePath();
    }

    private void initFilePath() {
        String path = generatorConfig.getBasicsConfig().getFrontEndPath() + File.separator + "src" + GeneratorUtil.getModelTsPath(generatorConfig.getBasicsConfig());
        setFilePath(path);
    }
}
