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
    public static final String MODEL = "model";
    /**
     * dao
     */
    public static final String DAO = "dao";
    /**
     * mapping
     */
    public static final String MAPPING = "dao" + File.separator + "mapping";
    /**
     * service
     */
    public static final String SERVICE = "service";
    /**
     * service 实现类
     */
    public static final String SERVICE_IMPL = "service" + File.separator + "impl";
    /**
     * controller
     */
    public static final String CONTROLLER = "controller";
}
