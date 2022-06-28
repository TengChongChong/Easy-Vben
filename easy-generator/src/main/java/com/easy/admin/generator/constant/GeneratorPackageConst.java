package com.easy.admin.generator.constant;

import java.io.File;

/**
 * 包路径
 *
 * @author TengChongChong
 * @date 2021/1/23
 */
public class GeneratorPackageConst {
    /**
     * 实体类
     */
    public static final String MODEL = "model" + File.separator;
    /**
     * dao
     */
    public static final String MAPPER = "dao" + File.separator;
    /**
     * mapping
     */
    public static final String MAPPING = "dao" + File.separator + "mapping" + File.separator;
    /**
     * service
     */
    public static final String SERVICE = "service" + File.separator;
    /**
     * service 实现类
     */
    public static final String SERVICE_IMPL = "service" + File.separator + "impl" + File.separator;
    /**
     * controller
     */
    public static final String CONTROLLER = "controller" + File.separator;
}
