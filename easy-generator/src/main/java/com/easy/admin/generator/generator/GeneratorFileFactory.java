package com.easy.admin.generator.generator;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.easy.admin.generator.constant.GeneratorFileConst;
import com.easy.admin.generator.generator.impl.*;
import com.easy.admin.generator.model.GeneratorConfig;

/**
 * 文件生成
 *
 * @author tengchong
 * @date 2022/6/20
 */
public class GeneratorFileFactory {
    /**
     * 获取文件生成器
     *
     * @param type            文件类型
     * @param generatorConfig 生成配置
     * @param tableInfo       表信息
     * @return 生成器
     */
    public static GeneratorFile getGeneratorFile(String type, GeneratorConfig generatorConfig, TableInfo tableInfo) {
        GeneratorFile generatorFile;
        switch (type) {
            case GeneratorFileConst.MODEL:
                generatorFile = new GeneratorModel(generatorConfig, tableInfo);
                break;
            case GeneratorFileConst.MAPPER:
                generatorFile = new GeneratorMapper(generatorConfig, tableInfo);
                break;
            case GeneratorFileConst.MAPPING:
                generatorFile = new GeneratorMapping(generatorConfig, tableInfo);
                break;
            case GeneratorFileConst.SERVICE:
                generatorFile = new GeneratorService(generatorConfig, tableInfo);
                break;
            case GeneratorFileConst.SERVICE_IMPL:
                generatorFile = new GeneratorServiceImpl(generatorConfig, tableInfo);
                break;
            case GeneratorFileConst.CONTROLLER:
                generatorFile = new GeneratorController(generatorConfig, tableInfo);
                break;
            case GeneratorFileConst.LIST_VUE:
                generatorFile = new GeneratorList(generatorConfig, tableInfo);
                break;
            case GeneratorFileConst.ORDER_VUE:
                generatorFile = new GeneratorOrder(generatorConfig, tableInfo);
                break;
            case GeneratorFileConst.INPUT_VUE:
                generatorFile = new GeneratorInput(generatorConfig, tableInfo);
                break;
            case GeneratorFileConst.API_TS:
                generatorFile = new GeneratorApiTs(generatorConfig, tableInfo);
                break;
            case GeneratorFileConst.MODEL_TS:
                generatorFile = new GeneratorModelTs(generatorConfig, tableInfo);
                break;
            case GeneratorFileConst.DATA_TS:
                generatorFile = new GeneratorDataTs(generatorConfig, tableInfo);
                break;
            default:
                generatorFile = null;
                break;
        }
        return generatorFile;
    }
}
