package com.easy.admin.generator.util;

import com.easy.admin.generator.model.GeneratorConfig;

/**
 * 前端文件 import 路径
 *
 * @author TengChongChong
 * @date 2024-11-12
 **/
public class FrontEndImportPathUtil {

    private static final String PREFIX_VBEN5 = "#";


    /**
     * 获取前端Model.ts引入路径
     *
     * @param generatorConfig 生成配置
     * @return 引入路径
     */
    public static String getModelTsImportPath(GeneratorConfig generatorConfig) {
        return convertTsImportPath(GeneratorUtil.getModelTsPath(generatorConfig.getBasicsConfig()));
    }

    /**
     * 获取前端api.ts引入路径
     *
     * @param generatorConfig 生成配置
     * @return 引入路径
     */
    public static String getApiTsImportPath(GeneratorConfig generatorConfig) {
        return convertTsImportPath(generatorConfig.getBasicsConfig().getApiPath());
    }

    /**
     * 获取前端data.ts引入路径
     *
     * @return 引入路径
     */
    public static String getDataTsImportPath() {
        return "./data";
    }

    /**
     * 获取前端xxx.vue引入路径
     *
     * @param generatorConfig 生成配置
     * @return 引入路径
     */
    public static String getViewImportPath(GeneratorConfig generatorConfig) {
        return convertTsImportPath(generatorConfig.getBasicsConfig().getViewPath());
    }

    /**
     * 将ts文件路径转为引入路径
     *
     * @param tsFilePath 文件路径
     * @return 引入路径
     */
    private static String convertTsImportPath(String tsFilePath) {
        if (tsFilePath.startsWith("/src")) {
            tsFilePath = tsFilePath.replace("/src", PREFIX_VBEN5);
        } else {
            tsFilePath = PREFIX_VBEN5 + tsFilePath;
        }
        return tsFilePath.replace(".ts", "");
    }
}
