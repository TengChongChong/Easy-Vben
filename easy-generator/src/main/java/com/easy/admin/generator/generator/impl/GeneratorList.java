package com.easy.admin.generator.generator.impl;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.easy.admin.generator.constant.GeneratorVersion;
import com.easy.admin.generator.generator.GeneratorFile;
import com.easy.admin.generator.model.GeneratorConfig;
import com.easy.admin.generator.util.FrontEndImportPathUtil;
import com.easy.admin.sys.common.constant.SysConfigConst;
import com.easy.admin.util.SysConfigUtil;

import java.io.File;

/**
 * 生成 List.vue
 *
 * @author tengchong
 * @date 2022/6/20
 */
public class GeneratorList extends GeneratorFile {
    /**
     * 构造
     *
     * @param generatorConfig 生成配置
     */
    public GeneratorList(GeneratorConfig generatorConfig, TableInfo tableInfo) {
        super(generatorConfig, tableInfo);
    }

    @Override
    public void init() {

        if (GeneratorVersion.VBEN2.equals(SysConfigUtil.get(SysConfigConst.CODE_GENERATOR_VERSION))) {
            // 设置模板
            this.setTemplate("/template/vben2/view/list/" + generatorConfig.getBasicsConfig().getListGeneratorTemplate() + "/List.vue.btl");
            // 设置文件路径
            this.setFilePath(generatorConfig.getBasicsConfig().getFrontEndPath() + generatorConfig.getBasicsConfig().getViewPath() + File.separator + "List.vue");
        } else {
            // 设置模板
            this.setTemplate("/template/vben5/view/list/" + generatorConfig.getBasicsConfig().getListGeneratorTemplate() + "/list.vue.btl");
            // 设置文件路径
            this.setFilePath(generatorConfig.getBasicsConfig().getFrontEndPath() + generatorConfig.getBasicsConfig().getViewPath() + File.separator + "list.vue");
        }
    }

    @Override
    public void binding() {
        this.getPageTemplate().binding("modelTsPath", FrontEndImportPathUtil.getModelTsImportPath(generatorConfig));
        this.getPageTemplate().binding("apiTsPath", FrontEndImportPathUtil.getApiTsImportPath(generatorConfig));

        this.getPageTemplate().binding("dataTsPath", FrontEndImportPathUtil.getDataTsImportPath());
        this.getPageTemplate().binding("viewPath", FrontEndImportPathUtil.getViewImportPath(generatorConfig));

        this.getPageTemplate().binding("tableId", generatorConfig.getBasicsConfig().getTable().replaceAll("_", "-"));
    }
}
