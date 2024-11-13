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
    public static final String MODEL = "/template/common/classes/Model.java.btl";
    /**
     * 实体类VO
     */
    public static final String MODEL_VO = "/template/common/classes/ModelVO.java.btl";
    /**
     * dao
     */
    public static final String MAPPER = "/template/common/classes/Mapper.java.btl";
    /**
     * mapping
     */
    public static final String MAPPING = "/template/common/xml/Mapper.xml.btl";
    /**
     * service
     */
    public static final String SERVICE = "/template/common/classes/Service.java.btl";
    /**
     * service 实现类
     */
    public static final String SERVICE_IMPL = "/template/common/classes/ServiceImpl.java.btl";
    /**
     * controller
     */
    public static final String CONTROLLER = "/template/common/classes/Controller.java.btl";
    /**
     * 接口文件，需根据版本拼接地址
     */
    public static final String API_TS = "/ts/api.ts.btl";
    /**
     * Model.ts
     */
    public static final String MODEL_TS = "/template/common/ts/model.ts.btl";
    /**
     * data.ts，需根据版本拼接地址
     */
    public static final String DATA_TS = "/ts/data.ts.btl";
}
