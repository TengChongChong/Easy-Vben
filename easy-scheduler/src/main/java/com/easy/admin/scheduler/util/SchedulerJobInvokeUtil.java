package com.easy.admin.scheduler.util;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.util.SpringContextHolder;
import com.easy.admin.scheduler.model.SchedulerJob;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 定时任务反射调用工具
 *
 * @author TengChong
 */
@Slf4j
public class SchedulerJobInvokeUtil {

    private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private SchedulerJobInvokeUtil() {
    }

    /**
     * 执行定时任务
     *
     * @param schedulerJob 任务信息
     */
    public static void invoke(SchedulerJob schedulerJob) {
        if (StrUtil.isBlank(schedulerJob.getBean())) {
            throw new EasyException("定时任务[" + schedulerJob.getName() + "]缺少bean");
        }
        Object bean = SpringContextHolder.getBean(schedulerJob.getBean());
        if (bean == null) {
            throw new EasyException("定时任务[" + schedulerJob.getName() + "]bean不存在");
        }
        String params = schedulerJob.getParams();
        if (StrUtil.isBlank(params) || "[]".equals(params.trim())) {
            invokeNoArg(bean, schedulerJob);
            return;
        }
        if (!JSONUtil.isTypeJSONArray(params)) {
            throw new EasyException("定时任务[" + schedulerJob.getName() + "]参数格式错误，应为JSON数组");
        }
        JSONArray paramArray = JSONUtil.parseArray(params);
        Class<?>[] paramTypes = new Class<?>[paramArray.size()];
        Object[] args = new Object[paramArray.size()];
        for (int i = 0; i < paramArray.size(); i++) {
            JSONObject param = paramArray.getJSONObject(i);
            String type = param.getStr("type");
            String value = param.getStr("value");
            if (StrUtil.isBlank(type)) {
                throw new EasyException("定时任务[" + schedulerJob.getName() + "]第" + (i + 1) + "个参数缺少类型");
            }
            ParamValue paramValue = resolveParam(type, value);
            paramTypes[i] = paramValue.type;
            args[i] = paramValue.value;
        }
        Method method = findMethod(bean.getClass(), schedulerJob.getMethod(), paramTypes, args);
        try {
            method.invoke(bean, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            Throwable cause = e.getCause() != null ? e.getCause() : e;
            throw new EasyException("定时任务[" + schedulerJob.getName() + "]执行失败[" + cause.getMessage() + "]");
        }
    }

    private static void invokeNoArg(Object bean, SchedulerJob schedulerJob) {
        try {
            Method method = bean.getClass().getMethod(schedulerJob.getMethod());
            method.invoke(bean);
        } catch (NoSuchMethodException e) {
            throw new EasyException("定时任务[" + schedulerJob.getName() + "]获取method[" + schedulerJob.getMethod() + "]失败");
        } catch (IllegalAccessException | InvocationTargetException e) {
            Throwable cause = e.getCause() != null ? e.getCause() : e;
            throw new EasyException("定时任务[" + schedulerJob.getName() + "]执行失败[" + cause.getMessage() + "]");
        }
    }

    private static ParamValue resolveParam(String type, String value) {
        String normalizedType = type.trim();
        switch (normalizedType) {
            case "String":
                return new ParamValue(String.class, value);
            case "Integer":
            case "int":
                return new ParamValue(int.class, Convert.convert(Integer.class, value));
            case "Long":
            case "long":
                return new ParamValue(long.class, Convert.convert(Long.class, value));
            case "Double":
            case "double":
                return new ParamValue(double.class, Convert.convert(Double.class, value));
            case "Boolean":
            case "boolean":
                return new ParamValue(boolean.class, Convert.convert(Boolean.class, value));
            case "Date":
                return new ParamValue(Date.class, DateUtil.parse(value, DATE_PATTERN));
            case "JSON":
                return resolveJsonParam(value);
            default:
                throw new EasyException("不支持的参数类型[" + type + "]");
        }
    }

    private static ParamValue resolveJsonParam(String value) {
        if (StrUtil.isBlank(value)) {
            throw new EasyException("JSON类型参数值不能为空");
        }
        String trimmedValue = value.trim();
        if (!JSONUtil.isTypeJSON(trimmedValue)) {
            throw new EasyException("JSON类型参数值格式错误");
        }
        if (trimmedValue.startsWith("[")) {
            JSONArray jsonArray = JSONUtil.parseArray(trimmedValue);
            return new ParamValue(JSONArray.class, jsonArray);
        }
        JSONObject jsonObject = JSONUtil.parseObj(trimmedValue);
        return new ParamValue(JSONObject.class, jsonObject);
    }

    private static Method findMethod(Class<?> clazz, String methodName, Class<?>[] paramTypes, Object[] args) {
        try {
            return clazz.getMethod(methodName, paramTypes);
        } catch (NoSuchMethodException ignored) {
            // 尝试匹配兼容类型
        }
        for (Method method : clazz.getMethods()) {
            if (!method.getName().equals(methodName) || method.getParameterCount() != paramTypes.length) {
                continue;
            }
            Class<?>[] methodParamTypes = method.getParameterTypes();
            boolean matched = true;
            for (int i = 0; i < paramTypes.length; i++) {
                if (!isParameterCompatible(methodParamTypes[i], paramTypes[i], args[i])) {
                    matched = false;
                    break;
                }
            }
            if (matched) {
                return method;
            }
        }
        throw new EasyException("定时任务获取method[" + methodName + "]失败，请检查参数类型与顺序");
    }

    private static boolean isParameterCompatible(Class<?> methodParamType, Class<?> argType, Object argValue) {
        if (methodParamType.isAssignableFrom(argType)) {
            return true;
        }
        if (argValue == null) {
            return !methodParamType.isPrimitive();
        }
        if (JSONObject.class.isAssignableFrom(argType) && Map.class.isAssignableFrom(methodParamType)) {
            return true;
        }
        if (JSONArray.class.isAssignableFrom(argType) && List.class.isAssignableFrom(methodParamType)) {
            return true;
        }
        if (methodParamType.isPrimitive()) {
            return isWrapperOf(methodParamType, argType);
        }
        if (argType.isPrimitive()) {
            return isWrapperOf(argType, methodParamType);
        }
        return false;
    }

    private static boolean isWrapperOf(Class<?> primitiveType, Class<?> wrapperType) {
        if (primitiveType == int.class) {
            return wrapperType == Integer.class;
        }
        if (primitiveType == long.class) {
            return wrapperType == Long.class;
        }
        if (primitiveType == double.class) {
            return wrapperType == Double.class;
        }
        if (primitiveType == boolean.class) {
            return wrapperType == Boolean.class;
        }
        if (primitiveType == float.class) {
            return wrapperType == Float.class;
        }
        if (primitiveType == short.class) {
            return wrapperType == Short.class;
        }
        if (primitiveType == byte.class) {
            return wrapperType == Byte.class;
        }
        if (primitiveType == char.class) {
            return wrapperType == Character.class;
        }
        return false;
    }

    private static class ParamValue {
        private final Class<?> type;
        private final Object value;

        private ParamValue(Class<?> type, Object value) {
            this.type = type;
            this.value = value;
        }
    }
}
