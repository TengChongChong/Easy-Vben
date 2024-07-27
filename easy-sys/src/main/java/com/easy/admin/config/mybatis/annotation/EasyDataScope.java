package com.easy.admin.config.mybatis.annotation;

import java.lang.annotation.*;

/**
 * 数据权限
 * 用于自定义拼接数据权限Sql时业务表别名
 *
 * @author TengChongChong
 * @date 2024-07-23
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EasyDataScope {

    /**
     * 业务表的别名
     */
    String businessTableAlias() default "";

    /**
     * 业务表所属部门Id字段名称，默认为 `dept_id`
     */
    String businessDeptField() default "dept_id";

    /**
     * 业务表创建用户Id字段名称，默认为 `create_user`
     */
    String businessUserField() default "create_user";
}
