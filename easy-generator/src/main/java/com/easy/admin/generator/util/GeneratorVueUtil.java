package com.easy.admin.generator.util;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ArrayUtil;
import com.easy.admin.generator.constant.GeneratorFormTemplateConst;
import com.easy.admin.generator.constant.GeneratorListTemplateConst;
import com.easy.admin.generator.constant.GeneratorMethodConst;
import com.easy.admin.generator.model.BasicsConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成vue代码帮助类
 *
 * @author TengChongChong
 * @date 2019-02-22
 */
public class GeneratorVueUtil {
    private GeneratorVueUtil() {
    }

    /**
     * 获取列表页面引入的api方法
     *
     * @param basicsConfig 基础信息
     * @return 引入的方法
     */
    public static String getListImport(BasicsConfig basicsConfig) {
        List<String> importMethod = new ArrayList<>();
        for (String method : basicsConfig.getGenMethod()) {
            if (GeneratorMethodConst.SELECT.equals(method) ||
                    GeneratorMethodConst.REMOVE.equals(method) ||
                    GeneratorMethodConst.EXPORT_DATA.equals(method)) {
                importMethod.add(method);
            }
            if (GeneratorFormTemplateConst.MODAL.equals(basicsConfig.getFormGeneratorTemplate()) || GeneratorFormTemplateConst.DRAWER.equals(basicsConfig.getFormGeneratorTemplate())) {
                if (GeneratorMethodConst.ADD.equals(method)) {
                    importMethod.add(method);
                }
                if (GeneratorMethodConst.SELECT.equals(method)) {
                    importMethod.add("get");
                }
            }
        }
        return ArrayUtil.join(importMethod.toArray(), ", ");
    }

    /**
     * 获取表单页面引入的api方法
     *
     * @param basicsConfig 基础信息
     * @return 引入的方法
     */
    public static String getInputImport(BasicsConfig basicsConfig) {
        List<String> importMethod = new ArrayList<>();
        for (String method : basicsConfig.getGenMethod()) {
            if (GeneratorMethodConst.ADD.equals(method) || GeneratorMethodConst.SAVE.equals(method)) {
                importMethod.add(method);
            }
        }
        if (GeneratorFormTemplateConst.PAGE.equals(basicsConfig.getFormGeneratorTemplate())) {
            importMethod.add("get");
        }
        return ArrayUtil.join(importMethod.toArray(), ", ");
    }

    /**
     * 获取列表页面需要引入的按钮
     *
     * @param basicsConfig 基础信息
     * @return 引入的按钮
     */
    public static String getImportButton(BasicsConfig basicsConfig) {
        List<String> buttonArray = new ArrayList<>();

        if (basicsConfig.isGeneratorMethodsAdd()) {
            buttonArray.add("AButtonAdd");
            buttonArray.add("AButtonEdit");
            if (GeneratorListTemplateConst.TREE_TABLE.equals(basicsConfig.getListGeneratorTemplate())) {
                buttonArray.add("AButtonAddSub");
            }
        }
        if (basicsConfig.isGeneratorMethodsRemove()) {
            buttonArray.add("AButtonRemove");
            buttonArray.add("AButtonRemoveBatch");
        }
        if (basicsConfig.isGeneratorMethodsImport()) {
            buttonArray.add("AButtonImport");
        }
        if (basicsConfig.isGeneratorMethodsExport()) {
            buttonArray.add("AButtonExport");
        }
        return CollectionUtil.join(buttonArray, ", ");
    }

}
