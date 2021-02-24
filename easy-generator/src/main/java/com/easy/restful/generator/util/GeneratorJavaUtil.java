package com.easy.restful.generator.util;

import com.easy.restful.generator.model.FieldSet;

import java.util.List;

/**
 * 生成java代码帮助类
 *
 * @author tengchong
 * @date 2019-02-22
 */
public class GeneratorJavaUtil {
    private GeneratorJavaUtil() {
    }

    /**
     * 字符串
     */
    private static final String STRING = "String";

    /**
     * 生成验证注解
     *
     * @param propertyName 属性名
     * @param list         配置列表
     * @return 验证注解
     */
    public static String generatorVerification(String propertyName, List<FieldSet> list) {
        if (list != null) {
            for (FieldSet fieldSet : list) {
                if (propertyName.equals(fieldSet.getPropertyName())) {
                    return generatorVerification(fieldSet);
                }
            }
        }
        return null;
    }

    private static String generatorVerification(FieldSet fieldSet) {
        if (fieldSet.getRequired()) {
            if (STRING.equals(fieldSet.getPropertyType())) {
                return addTab("@NotBlank(message = \"" + fieldSet.getLabel() + "不能为空\")\r\n");
            }
            return addTab("@NotNull(message = \"" + fieldSet.getLabel() + "不能为空\")\r\n");
        }
        return null;
    }


    /**
     * 生成导出注解
     *
     * @param propertyName 属性名
     * @param list         配置列表
     * @return 验证注解
     */
    public static String generatorExport(String propertyName, List<FieldSet> list) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (propertyName.equals(list.get(i).getPropertyName())) {
                    return generatorExport(list.get(i), i);
                }
            }
        }
        return null;
    }

    private static String generatorExport(FieldSet fieldSet, int index) {
        return addTab("@Excel(name = \"" + fieldSet.getTitle() + "\", orderNum = \"" + index + "\")");
    }

    /**
     * 添加换行以及缩进
     *
     * @param code 代码
     * @return 代码
     */
    private static String addTab(String code) {
        return code + "    ";
    }
}
