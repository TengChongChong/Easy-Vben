package com.easy.restful.generator.engine.config;

import com.easy.restful.generator.constant.GeneratorConst;
import com.easy.restful.generator.model.Generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Config Abstract
 *
 * @author tengchong
 * @date 2021/1/23
 */
public class AbstractConfig {
    /**
     * 生成信息
     */
    protected final Generator generator;
    /**
     * controller 路径
     */
    protected String path;
    /**
     * 需要导入的包
     */
    protected final List<Class<?>> imports;

    protected String backEndFilePath;

    protected String frontEndFilePath;

    public AbstractConfig(Generator generator) {
        this.generator = generator;
        this.imports = new ArrayList<>();
        this.backEndFilePath = generator.getBackEndPath() + GeneratorConst.JAVA_PATH + generator.getPackagePath().replace(".", File.separator) + File.separator;
        this.frontEndFilePath = generator.getFrontEndPath() + File.separator + "src" + File.separator;
    }

    public Generator getGenerator() {
        return generator;
    }

    public String getPath() {
        return path;
    }

    public List<Class<?>> getImports() {
        return imports;
    }
}
