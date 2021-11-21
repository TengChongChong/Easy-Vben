package com.easy.admin.sys.common.constant;

/**
 * 数据导入常量
 *
 * @author TengChongChong
 * @date 2019-04-24
 */
public class ImportConst {

    private ImportConst() {}

    /**
     * 临时表class
     */
    public static final String TEMPORARY_CLASS = "com.easy.admin.sys.model.SysImportExcelTemporary";
    /**
     * 必填
     */
    public static final int REQUIRED = 1;
    /**
     * 唯一
     */
    public static final int IS_ONLY = 1;
    /**
     * 字典表表名
     */
    public static final String SYS_DICT = "sys_dict";
    /**
     * 验证通过
     */
    public static final String VERIFICATION_STATUS_SUCCESS = "1";
    /**
     * 验证失败
     */
    public static final String VERIFICATION_STATUS_FAIL = "0";
    /**
     * 数据库日期类型
     */
    public static final String FIELD_TYPE_DATE = "date";
    /**
     * 数据库日期类型
     */
    public static final String FIELD_TYPE_DATE_TIME = "datetime";
    /**
     * 数据库日期类型
     */
    public static final String FIELD_TYPE_TIMESTAMP = "timestamp";
    /**
     * mysql int
     */
    public static final String FIELD_TYPE_INT = "int";
    /**
     * mysql bigint
     */
    public static final String FIELD_TYPE_BIGINT = "bigint";
    /**
     * mysql long
     */
    public static final String FIELD_TYPE_LONG = "long";
    /**
     * oracle number
     */
    public static final String FIELD_TYPE_NUMBER = "number";
    /**
     * mysql double
     */
    public static final String FIELD_TYPE_DOUBLE = "double";
    /**
     * mysql decimal
     */
    public static final String FIELD_TYPE_DECIMAL = "decimal";

    /**
     * 任意长度
     */
    public static final String FIELD_LENGRH_ARBITRARILY = "*";








}
