package com.easy.restful.generator.util;

import cn.hutool.core.util.StrUtil;
import com.easy.restful.generator.model.FieldSet;

import java.util.List;

/**
 * 生成html代码帮助类
 *
 * @author tengchong
 * @date 2019-02-22
 */
public class GeneratorHtmlUtil {
    private GeneratorHtmlUtil() {}

    /**
     * 栅格class
     */
    private static final String GRID_1_1 = "12/2/10";
    private static final String GRID_1_2 = "12/2/5";
    private static final String GRID_1_3 = "12/2/8";
    private static final String GRID_2 = "6/4/8";
    private static final String GRID_3 = "4/4/8";
    private static final String GRID_4 = "3/4/8";
    /**
     * 页面类型
     */
    private static final String PAGE_TYPE_INPUT = "input";
    private static final String PAGE_TYPE_LIST = "list";

    /**
     * 根据属性名称查找配置获取html
     *
     * @param propertyName 属性名称
     * @param list         配置列表
     * @param tab          tab数量
     * @param value        是否生成value属性
     * @param pageType     list/input 页面类型
     * @return html
     */
    public static String generator(String propertyName, List<FieldSet> list, int tab, boolean value, String pageType) {
        for (FieldSet fieldSet : list) {
            if (propertyName.equals(fieldSet.getPropertyName())) {
                return generator(fieldSet, tab, value, pageType);
            }
        }
        return null;
    }

    /**
     * 根据配置获取html
     *
     * @param fieldSet 配置
     * @param tab      tab数量
     * @param value    是否生成value属性
     * @param pageType list/input 页面类型
     * @return html
     */
    private static String generator(FieldSet fieldSet, int tab, boolean value, String pageType) {
        String element;
        switch (fieldSet.getElementType()) {
            case "textarea":
                element = textarea(fieldSet, value, pageType);
                break;
            case "hidden":
                element = hidden(fieldSet, value);
                break;
            case "select":
                element = select(fieldSet, value, pageType);
                break;
            case "select_multiple":
                element = selectMultiple(fieldSet, value, pageType);
                break;
            case "radio":
                tab++;
                element = radio(fieldSet, tab, value, pageType);
                break;
            case "checkbox":
                tab++;
                element = checkbox(fieldSet, tab, value, pageType);
                break;
            case "date":
                element = date(fieldSet, value, pageType);
                break;
            case "datetime":
                element = datetime(fieldSet, value, pageType);
                break;
            case "password":
                element = password(fieldSet, value, pageType);
                break;
            case "number":
                element = number(fieldSet, value, pageType);
                break;
            default:
                element = text(fieldSet, value, pageType);
                break;
        }
        if (!"hidden".equals(fieldSet.getElementType())) {
            String gridClass = "";
//            if (PAGE_TYPE_INPUT.equals(pageType)) {
//                gridClass = getGridClass(fieldSet.getInputGrid());
//            } else {
//                gridClass = getGridClass(fieldSet.getListGrid());
//            }
            String html;
            if("checkbox".equals(fieldSet.getElementType()) || "radio".equals(fieldSet.getElementType())){
                html = "<div class=\"" + gridClass + "\">\n" + GeneratorUtil.getTab(tab) + "<div class=\"form-group row\">\n" + GeneratorUtil.getTab(tab + 1) + element + "\n" + GeneratorUtil.getTab(tab) + "</div>" + "\n" + GeneratorUtil.getTab(tab - 1) +  "</div>";
            }else{
                html = "<div class=\"" + gridClass + "\">\n" + GeneratorUtil.getTab(tab + 1) + element + "\n" + GeneratorUtil.getTab(tab) + "</div>";
            }
            return html;
        } else {
            return element;
        }
    }

    /**
     * 获取label的栅格
     *
     * @param fieldSet 配置
     * @param pageType list/input 页面类型
     * @return html
     */
    private static String getLabel(FieldSet fieldSet, String pageType) {
        String dictValue = "";
//        if (PAGE_TYPE_INPUT.equals(pageType)) {
//            dictValue = fieldSet.getInputGrid();
//        } else {
//            dictValue = fieldSet.getListGrid();
//        }
        String labelClass;
        if (GRID_1_1.equals(dictValue) || GRID_1_2.equals(dictValue) || GRID_1_3.equals(dictValue)) {
            labelClass = "col-md-2 col-4";
        } else {
            labelClass = "col-4";
        }
        return "<label class=\"" + labelClass + " col-form-label\"" +
                ((!"radio".equals(fieldSet.getElementType()) && !"checkbox".equals(fieldSet.getElementType())) ? " for=\"" + fieldSet.getPropertyName() + "\"" : "") + ">" + fieldSet.getLabel() + "：</label>";
    }

    /**
     * 获取input的栅格
     *
     * @param fieldSet 配置
     * @param pageType list/input 页面类型
     * @return class
     */
    private static String getInputGridClass(FieldSet fieldSet, String pageType) {
        String dictValue = "";
//        if (PAGE_TYPE_INPUT.equals(pageType)) {
//            dictValue = fieldSet.getInputGrid();
//        } else {
//            dictValue = fieldSet.getListGrid();
//        }
        String inputClass;
        if (GRID_1_1.equals(dictValue)) {
            inputClass = "col-md-10 col-8";
        } else if (GRID_1_2.equals(dictValue)) {
            inputClass = "col-md-5 col-8";
        } else {
            inputClass = "col-8";
        }
        return inputClass;
    }

    /**
     * 获取栅格class
     *
     * @param grid 栅格
     * @return 栅格class
     */
    private static String getGridClass(String grid) {
        String gridClass = null;
        if (GRID_1_1.equals(grid) || GRID_1_2.equals(grid) || GRID_1_3.equals(grid)) {
            gridClass = "col-12";
        } else if (GRID_2.equals(grid)) {
//            gridClass = "col-xl-4 col-lg-6 col-12";
            gridClass = "col-lg-6 col-12";
        } else if (GRID_3.equals(grid)) {
            gridClass = "col-xl-3 col-lg-4 col-md-6 col-12";
        } else if (GRID_4.equals(grid)) {
            gridClass = "col-lg-3 col-md-4 col-sm-6 col-12";
        }
        return gridClass;
    }

    /**
     * 获取通用的属性
     *
     * @param fieldSet 配置
     * @param value    是否生成value属性
     * @param pageType list/input 页面类型
     * @return 通用属性
     */
    private static String getCommonProperty(FieldSet fieldSet, boolean value, String pageType) {
        StringBuilder property = new StringBuilder();
        if (StrUtil.isNotBlank(fieldSet.getPropertyName())) {
            property.append(" id=\"").append(fieldSet.getPropertyName()).append("\"");
        }
        if (StrUtil.isNotBlank(fieldSet.getLabel())) {
            property.append(" name=\"").append(fieldSet.getLabel()).append("\"");
        }
        // 提示文字
        if (StrUtil.isNotBlank(fieldSet.getTips())) {
            property.append(" tips=\"").append(fieldSet.getTips()).append("\"");
        }
        if (!PAGE_TYPE_LIST.equals(pageType)) {
            // 必填
            if (fieldSet.getRequired()) {
                property.append(" required=\"").append(fieldSet.getRequired()).append("\"");
            }
            // 表单验证
            if (StrUtil.isNotBlank(fieldSet.getValidate())) {
                property.append(" validate=\"").append(fieldSet.getValidate()).append("\"");
            }
        }
        if (value) {
            if ("text".equals(fieldSet.getElementType()) ||
                    "number".equals(fieldSet.getElementType()) ||
                    "date".equals(fieldSet.getElementType()) ||
                    "datetime".equals(fieldSet.getElementType()) ||
                    "password".equals(fieldSet.getElementType()) ||
                    "textarea".equals(fieldSet.getElementType()) ||
                    "select".equals(fieldSet.getElementType())
            ) {
                property.append(" value=\"${object.").append(fieldSet.getPropertyName()).append("}\"");
            } else {
                property.append(" data-value=\"${object.").append(fieldSet.getPropertyName()).append("}\"");
            }
        }
        return property.toString();
    }

    /**
     * 获取text所需要的html
     *
     * @param fieldSet 配置
     * @param value 是否生成value属性
     * @param pageType list/input 页面类型
     * @return html
     */
    private static String text(FieldSet fieldSet, boolean value, String pageType) {
        return "<#form:input" + getCommonProperty(fieldSet, value, pageType) + " />";
    }

    /**
     * 获取hidden所需要的html
     *
     * @param fieldSet 配置
     * @return html
     */
    private static String hidden(FieldSet fieldSet, boolean value) {
        return "<input type=\"hidden\" id=\"" + fieldSet.getPropertyName() + "\" name=\"" + fieldSet.getPropertyName() + "\" " +
                (value ? "value=\"${object." + fieldSet.getPropertyName() + "}\"" : "") + " />";
    }

    /**
     * 获取select所需要的html
     *
     * @param fieldSet 配置
     * @param value 是否生成value属性
     * @param pageType list/input 页面类型
     * @return html
     */
    private static String select(FieldSet fieldSet, boolean value, String pageType) {
        return "<#form:select class=\"select-picker\"" +
                (StrUtil.isNotBlank(fieldSet.getDictType()) ? " dataDictType=\"" + fieldSet.getDictType() + "\"" : "") +
                getCommonProperty(fieldSet, value, pageType) + " />";
    }

    /**
     * 获取多选select所需要的html
     *
     * @param fieldSet 配置
     * @param value 是否生成value属性
     * @param pageType list/input 页面类型
     * @return html
     */
    private static String selectMultiple(FieldSet fieldSet, boolean value, String pageType) {
        return "<#form:select class=\"select-picker\"" +
                getCommonProperty(fieldSet, value, pageType) +
                (StrUtil.isNotBlank(fieldSet.getDictType()) ? " dataDictType=\"" + fieldSet.getDictType() + "\"" : "") +
                " other=\"multiple\"/>";
    }

    /**
     * 获取textarea所需要的html
     *
     * @param fieldSet 配置
     * @param value 是否生成value属性
     * @param pageType list/input 页面类型
     * @return html
     */
    private static String textarea(FieldSet fieldSet, boolean value, String pageType) {
        return "<#form:textarea" + getCommonProperty(fieldSet, value, pageType) + " />";
    }

    /**
     * 获取radio所需要的html
     *
     * @param fieldSet 配置
     * @param pageType list/input 页面类型
     * @return html
     */
    private static String radio(FieldSet fieldSet, int tab, boolean value, String pageType) {
        StringBuilder html = new StringBuilder();
        if (StrUtil.isNotBlank(fieldSet.getDictType())) {
            html.append("<div class=\"radio-dict\"")
                    .append(" data-name=\"").append(fieldSet.getPropertyName()).append("\"")
                    .append(" data-dict-type=\"").append(fieldSet.getDictType()).append("\"");
            if(value){
                html.append(" data-value=\"${object.").append(fieldSet.getPropertyName()).append("}\"");
            }
            if(fieldSet.getRequired()){
                html.append(" data-required=\"").append(fieldSet.getRequired()).append("\"");
            }
            html.append("></div>");
        } else {
            html.append("<div class=\"e-radio-inline\"></div>");
        }
        return wrap(fieldSet, html, tab, pageType);
    }

    /**
     * 获取checkbox所需要的html
     *
     * @param fieldSet 配置
     * @param pageType list/input 页面类型
     * @return html
     */
    private static String checkbox(FieldSet fieldSet, int tab, boolean value, String pageType) {
        StringBuilder html = new StringBuilder();
        if (StrUtil.isNotBlank(fieldSet.getDictType())) {
            html.append("<div class=\"checkbox-dict\"")
                    .append(" data-name=\"").append(fieldSet.getPropertyName()).append("\"")
                    .append(" data-dict-type=\"").append(fieldSet.getDictType()).append("\"");
            if(value){
                html.append(" data-value=\"${object.").append(fieldSet.getPropertyName()).append("}\"");
            }
            if(fieldSet.getRequired()){
                html.append(" data-required=\"").append(fieldSet.getRequired()).append("\"");
            }
            html.append("></div>");
        } else {
            html.append("<div class=\"e-checkbox-inline\"></div>");
        }
        return wrap(fieldSet, html, tab, pageType);
    }

    /**
     * 将内容用栅格div包起来
     *
     * @param fieldSet 配置
     * @param content  内容
     * @param pageType list/input 页面类型
     * @return html
     */
    private static String wrap(FieldSet fieldSet, StringBuilder content, int tab, String pageType) {
        return getLabel(fieldSet, pageType) + "\n" +
                GeneratorUtil.getTab(tab + 1) + "<div class=\"" + getInputGridClass(fieldSet, pageType) + "\">\n" +
                GeneratorUtil.getTab(tab + 2) + content + "\n" +
                GeneratorUtil.getTab(tab + 1) + "</div>";
    }

    /**
     * 获取日期插件所需要的html
     *
     * @param fieldSet 配置
     * @param value 是否生成value属性
     * @param pageType list/input 页面类型
     * @return html
     */
    private static String date(FieldSet fieldSet, boolean value, String pageType) {
        return "<#form:input class=\"date-picker\" dataFormat=\"yyyy-mm-dd\" " + getCommonProperty(fieldSet, value, pageType) + " />";
    }

    /**
     * 获取日期插件所需要的html
     *
     * @param fieldSet 配置
     * @param value 是否生成value属性
     * @param pageType list/input 页面类型
     * @return html
     */
    private static String datetime(FieldSet fieldSet, boolean value, String pageType) {
        return "<#form:input class=\"date-picker\" dataFormat=\"yyyy-mm-dd hh:ii:ss\"" + getCommonProperty(fieldSet, value, pageType) + " />";
    }

    /**
     * 获取password所需要的html
     *
     * @param fieldSet 配置
     * @param value 是否生成value属性
     * @param pageType list/input 页面类型
     * @return html
     */
    private static String password(FieldSet fieldSet, boolean value, String pageType) {
        return "<#form:input type=\"password\" " + getCommonProperty(fieldSet, value, pageType) + " />";
    }

    /**
     * 获取number所需要的html
     *
     * @param fieldSet 配置
     * @param value 是否生成value属性
     * @param pageType list/input 页面类型
     * @return html
     */
    private static String number(FieldSet fieldSet, boolean value, String pageType) {
        return "<#form:input type=\"number\" " + getCommonProperty(fieldSet, value, pageType) + " />";

    }
}
