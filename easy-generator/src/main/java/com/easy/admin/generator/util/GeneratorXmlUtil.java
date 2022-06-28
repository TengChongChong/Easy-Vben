package com.easy.admin.generator.util;

import cn.hutool.core.util.StrUtil;
import com.easy.admin.generator.model.TableCellConfig;

/**
 * 生成xml代码帮助类
 *
 * @author TengChongChong
 * @date 2019-02-22
 */
public class GeneratorXmlUtil {
    private GeneratorXmlUtil() {
    }

    /**
     * 获取查询语句中查询的字段
     *
     * @param config 配置
     * @return 字段
     */
    public static String getSelectField(TableCellConfig config) {
        if ("createUser".equals(config.getPropertyName()) || "editUser".equals(config.getPropertyName())) {
            return "su_" + config.getName() + ".nickname as " + config.getName();
        } else {
            return "t." + config.getName();
        }
    }

    /**
     * 获取导出语句中查询的字段
     *
     * @param config 配置
     * @return 字段
     */
    public static String getExportField(TableCellConfig config) {
        if (StrUtil.isNotBlank(config.getDictType())) {
            return "sd_" + config.getName() + ".name as " + config.getName();
        } else if ("createUser".equals(config.getPropertyName()) || "editUser".equals(config.getPropertyName())) {
            return "su_" + config.getName() + ".nickname as " + config.getName();
        } else {
            return "t." + config.getName();
        }
    }
}
