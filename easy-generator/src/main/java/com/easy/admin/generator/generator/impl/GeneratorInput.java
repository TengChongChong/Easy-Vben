package com.easy.admin.generator.generator.impl;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.easy.admin.generator.generator.GeneratorFile;
import com.easy.admin.generator.model.GeneratorConfig;
import com.easy.admin.generator.util.GeneratorTsUtil;
import com.easy.admin.generator.util.GeneratorUtil;

import java.io.File;

/**
 * 生成 Input.vue
 *
 * @author tengchong
 * @date 2022/6/20
 */
public class GeneratorInput extends GeneratorFile {
    /**
     * 构造
     *
     * @param generatorConfig 生成配置
     */
    public GeneratorInput(GeneratorConfig generatorConfig, TableInfo tableInfo) {
        super(generatorConfig, tableInfo);
    }

    @Override
    public void init() {
        // 设置模板
        this.setTemplate("/template/common/view/form/" + generatorConfig.getBasicsConfig().getFormGeneratorTemplate() + "/Input.vue.btl");
        // 设置文件路径
        this.setFilePath(generatorConfig.getBasicsConfig().getFrontEndPath() + generatorConfig.getBasicsConfig().getViewPath() + File.separator + "Input.vue");
    }

    @Override
    public void binding() {
        if (this.generatorConfig.getBasicsConfig().isGeneratorFileApi()) {
            this.getPageTemplate().binding("apiTsPath", GeneratorTsUtil.convertImportPath(this.generatorConfig.getBasicsConfig().getApiPath()));
            this.getPageTemplate().binding("modelTsPath", "@" + GeneratorTsUtil.convertImportPath(GeneratorUtil.getModelTsPath(generatorConfig.getBasicsConfig())));
        }

        this.getPageTemplate().binding("dataTsPath", GeneratorTsUtil.convertImportPath(this.generatorConfig.getBasicsConfig().getViewPath() + "/" + GeneratorUtil.getDataTsName(generatorConfig.getBasicsConfig())));
        this.getPageTemplate().binding("viewPath", GeneratorTsUtil.convertImportPath(this.generatorConfig.getBasicsConfig().getViewPath()));
    }
}
