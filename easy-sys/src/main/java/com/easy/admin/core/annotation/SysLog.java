package com.easy.admin.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 日志注解
 *
 * @author TengChong
 * @date 2019-06-27
 */
@Target({ElementType.METHOD}) // 注解放置的目标位置,方法
@Retention(RetentionPolicy.RUNTIME) // 注解在哪个阶段执行
public @interface SysLog {
    // 模块名称
    String modular() default "";

    // 方法名称
    String method() default "";
}
