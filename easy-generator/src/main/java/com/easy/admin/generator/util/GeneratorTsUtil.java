package com.easy.admin.generator.util;

import cn.hutool.core.util.ArrayUtil;
import com.easy.admin.generator.model.FieldConfig;

import java.util.List;

/**
 * 生成ts代码帮助类
 *
 * @author TengChongChong
 * @date 2019-02-22
 */
public class GeneratorTsUtil {
    private GeneratorTsUtil() {
    }

    private static final String[] BASIC_MODEL_PROPERTY_NAME = new String[]{"id", "parentId", "status", "orderNo", "remarks", "deptId", "tenantId", "version", "createUser", "createDate", "editUser", "editDate"};

    /**
     * 检查属性是否在BasicModel中
     *
     * @param propertyName 属性
     * @return true/false
     */
    public static boolean inBasicModel(String propertyName) {
        return ArrayUtil.contains(BASIC_MODEL_PROPERTY_NAME, propertyName);
    }

    /**
     * 属性是否必填
     * 
     * @param propertyName 属性 
     * @param inputConfig 表单配置
     * @return true/false
     */
    public static boolean isRequired(String propertyName, List<FieldConfig> inputConfig) {
        for (FieldConfig fieldConfig : inputConfig) {
            if(fieldConfig.getPropertyName().equals(propertyName)){
                return fieldConfig.getRequired();
            }
        }
        return false;
    }
    
    /**
     * 将java数据类型转ts数据类型
     *
     * @param propertyType 类型
     * @return 类型
     */
    public static String convertPropertyType(String propertyType) {
        switch (propertyType){
            case "Short":
            case "Integer":
            case "Long":
            case "Float":
            case "Double":
                return "number";
            case "Boolean":
                return "boolean";
            case "Date":
                return "Date";
            default:
                return "string";
        }
    }

    /**
     * 是否需要引入dayjs
     *
     * @param queryConfig 查询条件
     * @return true/false
     */
    public static boolean needDayJs(List<FieldConfig> queryConfig){
        for (FieldConfig fieldConfig : queryConfig) {
            if("RangePicker".equals(fieldConfig.getComponentType())){
                return true;
            }
        }
        return false;
    }

    public static String convertImportPath(String path){
        return path.replace("/src", "/@").replace(".ts", "");
    }
}
