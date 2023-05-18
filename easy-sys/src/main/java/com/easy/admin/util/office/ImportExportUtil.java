package com.easy.admin.util.office;

import cn.hutool.core.date.DateException;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.sys.common.constant.ImportConst;
import com.easy.admin.sys.model.SysImportExcelTemplateDetail;
import com.easy.admin.sys.model.SysImportExcelTemporary;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 导入&导出工具类
 *
 * @author TengChongChong
 * @date 2019-04-30
 */
public class ImportExportUtil {
    private ImportExportUtil() {
    }

    /**
     * 将临时表数据转为生成excel所需的数据
     *
     * @param temporaries                临时表数据集合
     * @param configs                    导入规则 注: 导入规则用户设置单元格格式以及列数量
     * @param containVerificationResults 包含验证结果
     * @return 数组
     */
    public static List<List<Object>> toExportData(List<SysImportExcelTemporary> temporaries,
                                                  List<SysImportExcelTemplateDetail> configs,
                                                  boolean containVerificationResults) {
        List<List<Object>> rows = new ArrayList<>();
        if (temporaries != null && !temporaries.isEmpty() &&
                configs != null && !configs.isEmpty()) {
            Class temporaryClass = getTemporaryClass();
            for (SysImportExcelTemporary temporary : temporaries) {
                rows.add(callingGetMethodToArray(temporary, configs, temporaryClass, containVerificationResults));
            }
        }
        return rows;
    }

    /**
     * 将临时表数据转为生成excel所需的数据
     * 注: 此方法不需要传入导入规则,但是导出的excel所有单元格都会被设置为文本
     *
     * @param temporaries  临时表数据集合,用于设置单元格格式
     * @param columnNumber 列数量
     * @return 数组
     */
    public static List<List<Object>> toExportData(List<SysImportExcelTemporary> temporaries,
                                                  int columnNumber,
                                                  boolean containVerificationResults) {
        List<List<Object>> rows = new ArrayList<>();
        if (temporaries != null && !temporaries.isEmpty() &&
                columnNumber > 0) {
            Class temporaryClass = getTemporaryClass();
            for (SysImportExcelTemporary temporary : temporaries) {
                rows.add(callingGetMethodToArray(temporary, columnNumber, temporaryClass, containVerificationResults));
            }
        }
        return rows;
    }

    /**
     * 获取临时表实体类
     *
     * @return class
     */
    public static Class getTemporaryClass() {
        Class temporaryClass;
        try {
            temporaryClass = Class.forName(ImportConst.TEMPORARY_CLASS);
        } catch (ClassNotFoundException e) {
            throw new EasyException(ImportConst.TEMPORARY_CLASS + "未找到");
        }
        return temporaryClass;
    }

    /**
     * 根据导入规则获取表头
     *
     * @param configs                    导入规则
     * @param containVerificationResults 是否包含验证结果列
     * @return 标题集合
     */
    public static List<String> getTitles(List<SysImportExcelTemplateDetail> configs, boolean containVerificationResults) {
        List<String> titles = new ArrayList<>();
        for (SysImportExcelTemplateDetail detail : configs) {
            titles.add(detail.getTitle());
        }
        if (containVerificationResults) {
            titles.add("验证结果");
        }
        return titles;
    }

    /**
     * 根据导入规则获取表头
     *
     * @param configs 导入规则
     * @return 标题数组
     */
    public static String[] getTitles(List<SysImportExcelTemplateDetail> configs) {
        return getTitles(configs, false).toArray(new String[]{});
    }

    /**
     * 调用get方法获取数据
     *
     * @param temporary                  临时表数据
     * @param configs                    导入规则
     * @param temporaryClass             临时表映射class
     * @param containVerificationResults 包含验证结果
     */
    private static List<Object> callingGetMethodToArray(SysImportExcelTemporary temporary,
                                                        List<SysImportExcelTemplateDetail> configs,
                                                        Class temporaryClass, boolean containVerificationResults) {
        List<Object> row = new ArrayList<>();
        Method method = null;
        String methodName = null;
        try {
            for (int i = 0; i < configs.size(); i++) {
                methodName = "getField" + (i + 1);
                method = temporaryClass.getMethod(methodName);
                // 获取数据并转换格式
                row.add(transformationData((String) method.invoke(temporary), configs.get(i)));
            }
            if (containVerificationResults) {
                method = temporaryClass.getMethod("getVerificationResults");
                // 获取数据并转换格式
                row.add(method.invoke(temporary));
            }
        } catch (NoSuchMethodException e) {
            throw new EasyException(ImportConst.TEMPORARY_CLASS + "." + methodName + "未定义的方法");
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new EasyException(ImportConst.TEMPORARY_CLASS + "." + methodName + "调用失败");
        }
        return row;
    }

    /**
     * 调用get方法获取数据
     *
     * @param temporary                  临时表数据
     * @param columnNumber               列数量
     * @param temporaryClass             临时表映射class
     * @param containVerificationResults 包含验证结果
     */
    private static List<Object> callingGetMethodToArray(SysImportExcelTemporary temporary,
                                                        int columnNumber,
                                                        Class temporaryClass,
                                                        boolean containVerificationResults) {
        List<Object> row = new ArrayList<>();
        Method method = null;
        String methodName = null;
        try {
            for (int i = 0; i < columnNumber; i++) {
                methodName = "getField" + (i + 1);
                method = temporaryClass.getMethod(methodName);
                // 获取数据并转换格式
                row.add(method.invoke(temporary));
            }
            if (containVerificationResults) {
                method = temporaryClass.getMethod("getVerificationResults");
                // 获取数据并转换格式
                row.add(method.invoke(temporary));
            }
        } catch (NoSuchMethodException e) {
            throw new EasyException(ImportConst.TEMPORARY_CLASS + "." + methodName + "未定义的方法");
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new EasyException(ImportConst.TEMPORARY_CLASS + "." + methodName + "调用失败");
        }
        return row;
    }

    /**
     * 根据导入规则将数据转为指定类型
     *
     * @param data   数据
     * @param config 导入规则
     * @return 转换后的类型, 如果转换失败则用string类型
     */
    public static Object transformationData(String data, SysImportExcelTemplateDetail config) {
        if (StrUtil.isBlank(data)) {
            return null;
        }
        Object obj = null;
        try {
            if (ImportExportUtil.isDate(config.getFieldType())) {
                obj = DateUtil.parse(data);
            }
        } catch (DateException ignored) {
        }
        try {
            if (ImportExportUtil.isInteger(config.getFieldType())) {
                obj = Integer.parseInt(data);
            } else if (ImportExportUtil.isLong(config.getFieldType())) {
                obj = Long.parseLong(data);
            } else if (ImportExportUtil.isDouble(config.getFieldType())) {
                obj = Double.parseDouble(data);
            }
        } catch (NumberFormatException ignored) {
        }
        if (obj == null) {
            obj = data;
        }
        return obj;
    }

    //====================================== str: 查询语句 ======================================/

    /**
     * 获取查询语句中的查询字段
     *
     * @param configs    导入规则
     * @param ignoreDict 是否忽略字典翻译
     * @return sql
     */
    public static String getSelectFields(List<SysImportExcelTemplateDetail> configs, boolean ignoreDict) {
        StringBuilder selectFields = new StringBuilder();
        for (int i = 0; i < configs.size(); i++) {
            // 如果指定了忽略字典并且替换表是sys_dict,则当做常规处理
            boolean ignore = ignoreDict && ImportConst.SYS_DICT.equals(configs.get(i).getReplaceTable());
            if (ignore || StrUtil.isBlank(configs.get(i).getReplaceTable())) {
                // 没有设置转换表,直接查询
                selectFields.append("temp.field").append(i + 1);
            } else {
                // 表别名
                String tableSlug = configs.get(i).getReplaceTable() + configs.get(i).getOrderNo();
                // 拼接查询字段
                selectFields.append("(case when ").append(tableSlug).append(".").append(configs.get(i).getReplaceTableFieldName())
                        .append(" is null then temp.field").append(i + 1).append(" else ")
                        .append(tableSlug).append(".").append(configs.get(i).getReplaceTableFieldName())
                        .append(" end) as field").append(i + 1);
            }
            // 始终在最后添加 , 因为后面还有个verification_results字段
            selectFields.append(CommonConst.SPLIT);
        }
        return selectFields.toString();
    }

    /**
     * 获取查询语句中的left关联
     *
     * @param configs    导入规则
     * @param ignoreDict 是否忽略字典翻译
     * @return sql
     */
    public static String getLeftJoinTables(List<SysImportExcelTemplateDetail> configs, boolean ignoreDict) {
        StringBuilder leftJoinTables = new StringBuilder();
        for (int i = 0; i < configs.size(); i++) {
            boolean ignore = ignoreDict && ImportConst.SYS_DICT.equals(configs.get(i).getReplaceTable());
            if (!ignore && StrUtil.isNotBlank(configs.get(i).getReplaceTable())) {
                // 替换表
                String tableName = configs.get(i).getReplaceTable();
                // 表别名
                String tableSlug = configs.get(i).getReplaceTable() + configs.get(i).getOrderNo();
                // 拼接left join
                leftJoinTables.append("left join ").append(tableName).append(" ").append(tableSlug)
                        .append(" on ")
                        .append(tableSlug).append(".").append(configs.get(i).getReplaceTableFieldValue())
                        .append(" = temp.field").append(i + 1).append(" ");
                if (ImportConst.SYS_DICT.equals(configs.get(i).getReplaceTable())) {
                    leftJoinTables.append(" and ").append(tableSlug).append(".dict_type = '").append(configs.get(i).getReplaceTableDictType()).append("' ");
                }
            }
        }
        return leftJoinTables.toString();
    }
    //====================================== end: 查询语句 ======================================/


    //====================================== str: 数据类型&长度验证 ======================================/

    /**
     * 验证数据类型是否正确
     * 只验证date、int、long、double类型
     *
     * @param data   单元格中内容
     * @param config 单元格导入规则
     */
    public static void verificationData(String data, SysImportExcelTemplateDetail config) {
        if (StrUtil.isNotBlank(data)) {
            if (ImportExportUtil.isDate(config.getFieldType())) {
                try {
                    DateUtil.parse(data);
                } catch (DateException e) {
                    throw new EasyException(config.getTitle() + "必须为常见日期格式;");
                }
            } else if (ImportExportUtil.isInteger(config.getFieldType())) {
                try {
                    Integer.parseInt(data);
                } catch (NumberFormatException e) {
                    throw new EasyException(config.getTitle() + "必须为整数;");
                }
            } else if (ImportExportUtil.isLong(config.getFieldType())) {
                try {
                    Long.parseLong(data);
                } catch (NumberFormatException e) {
                    throw new EasyException(config.getTitle() + "必须为整数;");
                }
            } else if (ImportExportUtil.isDouble(config.getFieldType())) {
                try {
                    Double.parseDouble(data);
                } catch (NumberFormatException e) {
                    throw new EasyException(config.getTitle() + "必须为小数或整数;");
                }
            }
            // 验证数据长度是否符合字段设置
            verificationLength(data, config);
        }
    }

    /**
     * 验证数据长度是否符合字段长度要求
     *
     * @param data   单元格数据
     * @param config 单元格导入规则
     */
    private static void verificationLength(String data, SysImportExcelTemplateDetail config) {
        if (config.getFieldLength() != null) {
            if (data.length() > config.getFieldLength()) {
                throw new EasyException(config.getTitle() + "长度超出限制[" + config.getFieldLength() + "];");
            }
        }
    }

    /**
     * 是否date类型
     *
     * @param filedType 数据类型
     * @return true/false
     */
    public static boolean isDate(String filedType) {
        return filedType.contains(ImportConst.FIELD_TYPE_DATE) || filedType.contains(ImportConst.FIELD_TYPE_TIMESTAMP);
    }

    /**
     * 是否int类型
     *
     * @param filedType 数据类型
     * @return true/false
     */
    public static boolean isInteger(String filedType) {
        if (filedType.contains(ImportConst.FIELD_TYPE_NUMBER)) {
            return filedType.matches("number\\(+\\d\\)");
        } else {
            return filedType.contains(ImportConst.FIELD_TYPE_INT);
        }
    }

    /**
     * 是否long类型
     *
     * @param filedType 数据类型
     * @return true/false
     */
    public static boolean isLong(String filedType) {
        if (filedType.contains(ImportConst.FIELD_TYPE_NUMBER)) {
            return filedType.matches("number\\(+\\d{2}+\\)");
        } else {
            return filedType.contains(ImportConst.FIELD_TYPE_BIGINT);
        }
    }

    /**
     * 是否double类型
     *
     * @param filedType 数据类型
     * @return true/false
     */
    public static boolean isDouble(String filedType) {
        if (filedType.contains(ImportConst.FIELD_TYPE_NUMBER)) {
            return !filedType.matches("number\\(+\\d{2}+\\)") && !filedType.matches("number\\(+\\d\\)");
        } else {
            return filedType.contains(ImportConst.FIELD_TYPE_DOUBLE) || filedType.contains(ImportConst.FIELD_TYPE_DECIMAL);
        }
    }
    //====================================== end: 数据类型验证 ======================================/

}
