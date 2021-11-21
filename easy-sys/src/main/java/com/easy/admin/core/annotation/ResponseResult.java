package com.easy.admin.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 包装响应内容
 *
 * @author TengChong
 * @date 2020-12-28
 */
@Target({ElementType.TYPE, ElementType.METHOD}) // 注解放置的目标位置,方法
@Retention(RetentionPolicy.RUNTIME) // 注解在哪个阶段执行
public @interface ResponseResult {

}
