package com.easy.admin.generator.generator.impl;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.easy.admin.generator.constant.GeneratorVersion;
import com.easy.admin.generator.generator.GeneratorFile;
import com.easy.admin.generator.model.GeneratorConfig;
import com.easy.admin.generator.util.GeneratorUtil;
import com.easy.admin.sys.common.constant.SysConfigConst;
import com.easy.admin.util.SysConfigUtil;

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
        if (GeneratorVersion.VBEN2.equals(SysConfigUtil.get(SysConfigConst.CODE_GENERATOR_VERSION))) {
            // 设置模板
            this.setTemplate("/template/vben2/ts/model.ts.btl");
        } else {
            // 设置模板
            this.setTemplate("/template/vben5/ts/model.ts.btl");
        }

        // 设置文件路径
        initFilePath();
    }

    private void initFilePath() {
        String path = generatorConfig.getBasicsConfig().getFrontEndPath() + File.separator + "src" + GeneratorUtil.getModelTsPath(generatorConfig.getBasicsConfig());
        setFilePath(path);
    }
}
