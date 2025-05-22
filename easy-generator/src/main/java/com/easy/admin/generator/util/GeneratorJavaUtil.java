package com.easy.admin.generator.util;

import com.easy.admin.generator.model.FieldConfig;
import com.easy.admin.generator.model.TableCellConfig;

import java.util.List;

/**
 * 生成java代码帮助类
 *
 * @author TengChongChong
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
     * 获取查询条件中查询的字段
     *
     * @param config 配置
     * @return 字段
     */
    public static String getSelectField(FieldConfig config) {
        if ("createUser".equals(config.getPropertyName()) || "editUser".equals(config.getPropertyName())) {
            return "su_" + config.getName().toLowerCase() + ".nickname";
        } else {
            return "t." + config.getName().toLowerCase();
        }
    }

    /**
     * 生成验证注解
     *
     * @param propertyName 属性名
     * @param list         配置列表
     * @return 验证注解
     */
    public static String generatorVerification(String propertyName, List<FieldConfig> list) {
        if (list != null) {
            for (FieldConfig fieldSet : list) {
                if (propertyName.equals(fieldSet.getPropertyName())) {
                    return generatorVerification(fieldSet);
                }
            }
        }
        return null;
    }

    private static String generatorVerification(FieldConfig fieldSet) {
        if (fieldSet.getRequired() != null && fieldSet.getRequired()) {
            if (STRING.equals(fieldSet.getPropertyType())) {
                return addBr("@NotBlank(message = \"" + fieldSet.getLabel() + "不能为空\")");
            }
            return addBr("@NotNull(message = \"" + fieldSet.getLabel() + "不能为空\")");
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
    public static String generatorExport(String propertyName, List<TableCellConfig> list) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (propertyName.equals(list.get(i).getPropertyName())) {
                    return generatorExport(list.get(i), i);
                }
            }
        }
        return null;
    }

    public static String getEnumProperty(String dictCode) {
        return toUpperCaseSnake(dictCode);
    }

    private static String toUpperCaseSnake(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];

            // 处理分隔符（连字符或下划线）
            if (currentChar == '-' || currentChar == '_') {
                if (i > 0 && result.charAt(result.length() - 1) != '_') {
                    // 统一分隔符为下划线
                    result.append('_');
                }
                continue;
            }

            // 处理驼峰：当前字符为大写且前一个字符为小写时添加下划线
            if (Character.isUpperCase(currentChar) && i > 0) {
                char prevChar = chars[i - 1];
                if (prevChar != '-' && prevChar != '_' && Character.isLowerCase(prevChar)) {
                    result.append('_');
                }
            }

            result.append(Character.toUpperCase(currentChar));
        }

        // 移除连续的下划线（处理输入中连续分隔符的情况）
        return result.toString().replaceAll("_+", "_");
    }

    private static String generatorExport(TableCellConfig fieldSet, int index) {
        if ("Date".equals(fieldSet.getPropertyType())) {
            return addBr("@Excel(name = \"" + fieldSet.getTitle() + "\", width = 20, orderNum = \"" + index + "\", exportFormat = \"yyyy-MM-dd HH:mm:ss\")");
        }
        Integer width = getWidth(fieldSet);
        if (width != null) {
            // 限制4-255
            width = Math.min(width, 255);
            width = Math.max(width, 4);
            return addBr("@Excel(name = \"" + fieldSet.getTitle() + "\", width = " + width + ", orderNum = \"" + index + "\")");
        } else {
            return addBr("@Excel(name = \"" + fieldSet.getTitle() + "\", orderNum = \"" + index + "\")");
        }
    }

    private static Integer getWidth(TableCellConfig fieldSet) {
        // 导出时在excel中每个列的宽 单位为字符，一个汉字=2个字符 如 以列名列内容中较合适的长度 例如姓名列6 【姓名一般三个字】 性别列4【男女占1，但是列标题两个汉字】 限制1-255
        return fieldSet.getWidth() != null ? fieldSet.getWidth() / 16 : null;
    }

    /**
     * 添加换行以及缩进
     *
     * @param code 代码
     * @return 代码
     */
    private static String addBr(String code) {
        return code + "\r\n    ";
    }

}
