package com.easy.admin.generator.util;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ArrayUtil;
import com.easy.admin.generator.constant.GeneratorFormTemplateConst;
import com.easy.admin.generator.constant.GeneratorListTemplateConst;
import com.easy.admin.generator.constant.GeneratorMethodConst;
import com.easy.admin.generator.constant.GeneratorVersion;
import com.easy.admin.generator.model.BasicsConfig;
import com.easy.admin.generator.model.FieldConfig;
import com.easy.admin.sys.common.constant.SysConfigConst;
import com.easy.admin.util.SysConfigUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 生成vue代码帮助类
 *
 * @author TengChongChong
 * @date 2019-02-22
 */
public class GeneratorVueUtil {
    // 使用 selectRequired 验证规则的组件
    private static final List<String> USE_SELECT_REQUIRED_RULE_COMPONENT = Arrays.asList(
            "ApiSelect", "ApiTreeSelect", "Checkbox", "CheckboxGroup", "Cropper", "DatePicker", "DeptSelect",
            "DictCascader", "DictCheckbox", "DictRadio", "DictSelect", "DictTreeSelect", "Radio", "RadioGroup",
            "RangePicker", "Rate", "RoleSelect", "RuleUpload", "Select", "Switch",
            "TimePicker", "TreeSelect", "Upload", "UserSelect"
    );

    private GeneratorVueUtil() {
    }

    /**
     * 获取列表页面引入的api方法
     *
     * @param basicsConfig 基础信息
     * @return 引入的方法
     */
    public static String getListImport(BasicsConfig basicsConfig) {
        String methodSuffix = "Api";

        List<String> importMethod = new ArrayList<>();
        for (String method : basicsConfig.getGenMethod()) {
            if (GeneratorMethodConst.SELECT.equals(method) ||
                    GeneratorMethodConst.REMOVE.equals(method) ||
                    GeneratorMethodConst.EXPORT_DATA.equals(method)) {
                importMethod.add(method + methodSuffix);
            }
            if (GeneratorFormTemplateConst.MODAL.equals(basicsConfig.getFormGeneratorTemplate()) || GeneratorFormTemplateConst.DRAWER.equals(basicsConfig.getFormGeneratorTemplate())) {
                if (GeneratorMethodConst.ADD.equals(method)) {
                    importMethod.add(method + methodSuffix);
                }
                if (GeneratorMethodConst.SELECT.equals(method)) {
                    importMethod.add("get" + methodSuffix);
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
        String methodSuffix = "Api";

        List<String> importMethod = new ArrayList<>();
        for (String method : basicsConfig.getGenMethod()) {
            if (GeneratorMethodConst.ADD.equals(method) || GeneratorMethodConst.SAVE.equals(method)) {
                importMethod.add(method + methodSuffix);
            }
        }
        if (GeneratorFormTemplateConst.PAGE.equals(basicsConfig.getFormGeneratorTemplate())) {
            importMethod.add("get" + methodSuffix);
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
        String buttonPrefix = GeneratorVersion.VBEN2.equals(SysConfigUtil.get(SysConfigConst.CODE_GENERATOR_VERSION)) ? "A" : "";

        List<String> buttonArray = new ArrayList<>();

        if (basicsConfig.isGeneratorMethodsAdd()) {
            buttonArray.add(buttonPrefix + "ButtonAdd");
            buttonArray.add(buttonPrefix + "ButtonEdit");
            if (GeneratorVersion.VBEN2.equals(SysConfigUtil.get(SysConfigConst.CODE_GENERATOR_VERSION)) &&
                    GeneratorListTemplateConst.TREE_TABLE.equals(basicsConfig.getListGeneratorTemplate())) {
                buttonArray.add(buttonPrefix + "ButtonAddSub");
            }
        }
        if (basicsConfig.isGeneratorMethodsRemove()) {
            buttonArray.add(buttonPrefix + "ButtonRemove");
            if (GeneratorVersion.VBEN2.equals(SysConfigUtil.get(SysConfigConst.CODE_GENERATOR_VERSION))) {
                buttonArray.add(buttonPrefix + "ButtonRemoveBatch");
            }
        }
        if (basicsConfig.isGeneratorMethodsImport()) {
            buttonArray.add(buttonPrefix + "ButtonImport");
        }
        if (basicsConfig.isGeneratorMethodsExport()) {
            buttonArray.add(buttonPrefix + "ButtonExport");
        }
        return CollectionUtil.join(buttonArray, ", ");
    }

    public static boolean needRule(FieldConfig fieldConfig) {
        boolean useSelectRequiredRule = USE_SELECT_REQUIRED_RULE_COMPONENT.contains(fieldConfig.getComponentType());
        // 使用 selectRequired 验证规则，且非必填，不需要 rules
        return (fieldConfig.getRequired() != null && fieldConfig.getRequired()) || !useSelectRequiredRule;
    }

    public static String getFormRules(FieldConfig fieldConfig) {
        boolean useSelectRequiredRule = USE_SELECT_REQUIRED_RULE_COMPONENT.contains(fieldConfig.getComponentType());

        boolean isRequired = fieldConfig.getRequired() != null && fieldConfig.getRequired();

        if (isRequired && useSelectRequiredRule) {
            return "rules: 'selectRequired',";
        }

        // 使用 Zod rules
        StringBuilder rules = new StringBuilder();
        rules.append("rules: z");

        // 字符串
        if ("String".equals(fieldConfig.getPropertyType())) {
            rules.append(".string()");
            rules.append(".min(1, { message: '请输入").append(fieldConfig.getLabel()).append("' })");
            rules.append(".max(32, { message: '").append(fieldConfig.getLabel()).append("最多输入").append(GeneratorUtil.getColumnLength(fieldConfig)).append("个字符' })");
        }
        // Integer、Double、Long
        if ("Integer".equals(fieldConfig.getPropertyType()) || "Double".equals(fieldConfig.getPropertyType()) || "Long".equals(fieldConfig.getPropertyType())) {
            rules.append(".number()");
            rules.append(".min(0, { message: '").append(fieldConfig.getLabel()).append("不能小于0' })");
            rules.append(".max(999, { message: '").append(fieldConfig.getLabel()).append("不能大于999' })");
        }

        if (!isRequired) {
            // 非必填
            rules.append(".optional()");
        }

        return rules.append(",").toString();
    }

}
