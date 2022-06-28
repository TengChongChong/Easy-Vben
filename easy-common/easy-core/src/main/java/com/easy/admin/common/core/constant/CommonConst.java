package com.easy.admin.common.core.constant;

import org.springframework.stereotype.Component;

import java.io.File;

/**
 * 公用常量
 *
 * @author TengChongChong
 * @date 2018/9/4
 */
@Component
public class CommonConst {
    /**
     * 数据分隔符
     */
    public static final String SPLIT = ",";

    /**
     * 数据分隔符
     */
    public static final String SPLIT2 = ";";

    /**
     * 表分隔符
     */
    public static final String TABLE_SEPARATE = "_";

    /**
     * 小数点
     */
    public static final String DECIMAL_POINT = ".";

    /**
     * false
     */
    public static final String FALSE = "false";

    /**
     * true
     */
    public static final String TRUE = "true";

    /**
     * 缓存方式
     */
    public static final String CACHE_TYPE_REDIS = "redis";

    /**
     * 静态数据存放路径
     * 例如: 字典数据
     */
    public static final String STATIC_DATA_PATH = File.separator + "data";

    /**
     * 默认文件夹图标
     */
    public static final String DEFAULT_FOLDER_ICON = "appstore";

    /**
     * 静态资源后缀,用于优化性能
     * 请求静态资源不会 read/update redis 中的 session 信息
     */
    public final static String[] STATIC_FILE_SUFFIX = new String[]{".css", ".js", ".png", ".jpg", ".gif", ".jpeg", ".bmp",
            ".ico", ".swf", ".map", ".ico", ".woff", ".woff2"};
    /**
     * 字节长度
     */
    public static final int BYTE1024 = 1024;

    public static final String RESPONSE_RESULT_ANN = "RESPONSE_RESULT_ANN";
}
