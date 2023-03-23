package com.easy.admin.generator.util;

import cn.hutool.core.util.StrUtil;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.generator.model.BasicsConfig;
import com.easy.admin.generator.model.FieldConfig;
import org.apache.ibatis.type.JdbcType;

import java.io.File;
import java.util.regex.Pattern;

/**
 * 生成java代码帮助类
 *
 * @author TengChongChong
 * @date 2019-02-22
 */
public class GeneratorUtil {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\D");


    private GeneratorUtil() {
    }

    /**
     * 获取前端Model.ts路径
     *
     * @param basicsConfig 基础信息
     * @return 路径
     */
    public static String getModelTsPath(BasicsConfig basicsConfig) {
        String fileName = StrUtil.lowerFirst(basicsConfig.getModelName()) + "Model.ts";
        String path = File.separator + "api" + File.separator;
        if (basicsConfig.getTable().contains(CommonConst.TABLE_SEPARATE)) {
            path += basicsConfig.getTable().substring(0, basicsConfig.getTable().indexOf("_"));
        } else {
            path += basicsConfig.getTable();
        }
        path += File.separator + "model" + File.separator + fileName;
        return path;
    }

    /**
     * 获取data.ts文件名
     *
     * @param basicsConfig 基础信息
     * @return 文件名
     */
    public static String getDataTsName(BasicsConfig basicsConfig) {
        String fileName;
        if (basicsConfig.getTable().contains(CommonConst.TABLE_SEPARATE)) {
            fileName = basicsConfig.getTable().substring(basicsConfig.getTable().lastIndexOf(CommonConst.TABLE_SEPARATE) + 1);
        } else {
            fileName = basicsConfig.getTable();
        }
        fileName += ".data.ts";
        return fileName;
    }

    /**
     * 获取字段类型长度
     *
     * @param fieldConfig 字段
     * @return 长度
     */
    public static Integer getColumnLength(FieldConfig fieldConfig) {
        if (fieldConfig.getMetaInfo().getJdbcType() == JdbcType.VARCHAR) {
            return fieldConfig.getMetaInfo().getLength();
        }
        return null;
    }
}
