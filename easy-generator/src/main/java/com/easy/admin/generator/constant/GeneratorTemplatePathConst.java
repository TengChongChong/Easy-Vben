package com.easy.admin.generator.constant;

/**
 * 模板
 *
 * @author TengChongChong
 * @date 2021/1/23
 */
public class GeneratorTemplatePathConst {
    /**
     * 实体类
     */
    public static final String MODEL = "/template/classes/Model.java.btl";
    /**
     * 实体类VO
     */
    public static final String MODEL_VO = "/template/classes/ModelVO.java.btl";
    /**
     * dao
     */
    public static final String MAPPER = "/template/classes/Mapper.java.btl";
    /**
     * mapping
     */
    public static final String MAPPING = "/template/xml/Mapper.xml.btl";
    /**
     * service
     */
    public static final String SERVICE = "/template/classes/Service.java.btl";
    /**
     * service 实现类
     */
    public static final String SERVICE_IMPL = "/template/classes/ServiceImpl.java.btl";
    /**
     * controller
     */
    public static final String CONTROLLER = "/template/classes/Controller.java.btl";
    /**
     * 接口文件
     */
    public static final String API_TS = "/template/ts/api.ts.btl";
    /**
     * Model.ts
     */
    public static final String MODEL_TS = "/template/ts/model.ts.btl";
    /**
     * data.ts，需根据版本拼接地址
     */
    public static final String DATA_TS = "/template/ts/data.ts.btl";
}
