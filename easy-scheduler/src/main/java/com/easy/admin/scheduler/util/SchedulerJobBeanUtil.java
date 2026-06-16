package com.easy.admin.scheduler.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.common.core.util.SpringContextHolder;
import com.easy.admin.scheduler.model.SchedulerJobMethodOption;
import com.easy.admin.scheduler.model.SchedulerJobParamOption;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 定时任务 Bean / 方法扫描工具
 *
 * @author TengChong
 */
public class SchedulerJobBeanUtil {

    private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String BUSINESS_PACKAGE_PREFIX = "com.easy.admin";
    private static final int MAX_BEAN_RESULT_SIZE = 100;

    private SchedulerJobBeanUtil() {
    }

    /**
     * 扫描候选 Bean
     *
     * @param historyBeans 历史任务中的 bean
     * @param keyword 关键字
     * @return Bean 选项
     */
    public static List<Select> selectBeans(List<String> historyBeans, String keyword) {
        Map<String, Select> beanMap = new LinkedHashMap<>();
        ApplicationContext applicationContext = SpringContextHolder.getApplicationContext();
        if (applicationContext != null) {
            for (String beanName : applicationContext.getBeanDefinitionNames()) {
                if (StrUtil.isBlank(beanName) || beanName.startsWith("org.springframework")) {
                    continue;
                }
                try {
                    Object bean = applicationContext.getBean(beanName);
                    Class<?> clazz = resolveTargetClass(bean);
                    if (clazz == null || clazz.isInterface() || Modifier.isAbstract(clazz.getModifiers())) {
                        continue;
                    }
                    String packageName = clazz.getPackage() == null ? "" : clazz.getPackage().getName();
                    if (!packageName.startsWith(BUSINESS_PACKAGE_PREFIX)) {
                        continue;
                    }
                    beanMap.put(beanName, new Select(beanName, beanName + " (" + clazz.getName() + ")"));
                } catch (Exception ignored) {
                    // 跳过无法获取的 Bean
                }
            }
        }
        if (historyBeans != null) {
            for (String beanName : historyBeans) {
                if (StrUtil.isBlank(beanName) || beanMap.containsKey(beanName)) {
                    continue;
                }
                String label = beanName;
                try {
                    Object bean = SpringContextHolder.getBean(beanName);
                    Class<?> clazz = resolveTargetClass(bean);
                    if (clazz != null) {
                        label = beanName + " (" + clazz.getName() + ")";
                    }
                } catch (Exception ignored) {
                    // 使用 bean 名称作为 label
                }
                beanMap.put(beanName, new Select(beanName, label));
            }
        }
        String normalizedKeyword = normalizeKeyword(keyword);
        List<Select> result = new ArrayList<>(beanMap.values());
        return result.stream()
                .filter(item -> matchesKeyword(item, normalizedKeyword))
                .sorted(Comparator.comparing(Select::getValue))
                .limit(MAX_BEAN_RESULT_SIZE)
                .collect(java.util.stream.Collectors.toList());
    }

    private static String normalizeKeyword(String keyword) {
        return StrUtil.isBlank(keyword) ? "" : keyword.trim().toLowerCase();
    }

    private static boolean matchesKeyword(Select item, String keyword) {
        if (StrUtil.isBlank(keyword)) {
            return true;
        }
        String value = item.getValue() == null ? "" : item.getValue().toLowerCase();
        String label = item.getLabel() == null ? "" : item.getLabel().toLowerCase();
        return value.contains(keyword) || label.contains(keyword);
    }

    /**
     * 扫描 Bean 可调用的方法
     *
     * @param beanName Bean 名称
     * @return 方法选项
     */
    public static List<SchedulerJobMethodOption> selectMethods(String beanName) {
        if (StrUtil.isBlank(beanName)) {
            return new ArrayList<>();
        }
        Object bean;
        try {
            bean = SpringContextHolder.getBean(beanName);
        } catch (Exception e) {
            return new ArrayList<>();
        }
        Class<?> clazz = resolveTargetClass(bean);
        if (clazz == null) {
            return new ArrayList<>();
        }
        Map<String, SchedulerJobMethodOption> methodMap = new LinkedHashMap<>();
        for (Method method : clazz.getMethods()) {
            if (method.getDeclaringClass() == Object.class || Modifier.isStatic(method.getModifiers())) {
                continue;
            }
            List<SchedulerJobParamOption> params = buildParams(method.getParameterTypes());
            if (params == null) {
                continue;
            }
            String signature = buildSignature(method.getName(), method.getParameterTypes());
            SchedulerJobMethodOption option = new SchedulerJobMethodOption();
            option.setMethod(method.getName());
            option.setSignature(signature);
            option.setParams(params);
            methodMap.put(signature, option);
        }
        List<SchedulerJobMethodOption> result = new ArrayList<>(methodMap.values());
        result.sort(Comparator.comparing(SchedulerJobMethodOption::getSignature));
        return result;
    }

    private static Class<?> resolveTargetClass(Object bean) {
        if (bean == null) {
            return null;
        }
        return AopUtils.isAopProxy(bean) ? AopUtils.getTargetClass(bean) : bean.getClass();
    }

    private static List<SchedulerJobParamOption> buildParams(Class<?>[] parameterTypes) {
        if (parameterTypes == null || parameterTypes.length == 0) {
            return new ArrayList<>();
        }
        List<SchedulerJobParamOption> params = new ArrayList<>();
        for (Class<?> parameterType : parameterTypes) {
            SchedulerJobParamOption paramOption = toParamOption(parameterType);
            if (paramOption == null) {
                return null;
            }
            params.add(paramOption);
        }
        return params;
    }

    private static SchedulerJobParamOption toParamOption(Class<?> parameterType) {
        if (parameterType == String.class) {
            return new SchedulerJobParamOption("String", "");
        }
        if (parameterType == int.class || parameterType == Integer.class) {
            return new SchedulerJobParamOption("Integer", "0");
        }
        if (parameterType == long.class || parameterType == Long.class) {
            return new SchedulerJobParamOption("Long", "0");
        }
        if (parameterType == double.class || parameterType == Double.class) {
            return new SchedulerJobParamOption("Double", "0");
        }
        if (parameterType == boolean.class || parameterType == Boolean.class) {
            return new SchedulerJobParamOption("Boolean", "true");
        }
        if (Date.class.isAssignableFrom(parameterType)) {
            return new SchedulerJobParamOption("Date", DateUtil.format(new Date(), DATE_PATTERN));
        }
        if (JSONObject.class.isAssignableFrom(parameterType) || Map.class.isAssignableFrom(parameterType)) {
            return new SchedulerJobParamOption("JSON", "{}");
        }
        if (JSONArray.class.isAssignableFrom(parameterType) || List.class.isAssignableFrom(parameterType)) {
            return new SchedulerJobParamOption("JSON", "[]");
        }
        return null;
    }

    private static String buildSignature(String methodName, Class<?>[] parameterTypes) {
        StringBuilder signature = new StringBuilder(methodName).append("(");
        if (parameterTypes != null) {
            for (int i = 0; i < parameterTypes.length; i++) {
                if (i > 0) {
                    signature.append(", ");
                }
                signature.append(getSimpleTypeName(parameterTypes[i]));
            }
        }
        signature.append(")");
        return signature.toString();
    }

    private static String getSimpleTypeName(Class<?> type) {
        if (!type.isPrimitive()) {
            return type.getSimpleName();
        }
        if (type == int.class) {
            return "Integer";
        }
        if (type == long.class) {
            return "Long";
        }
        if (type == double.class) {
            return "Double";
        }
        if (type == boolean.class) {
            return "Boolean";
        }
        if (type == float.class) {
            return "Float";
        }
        if (type == short.class) {
            return "Short";
        }
        if (type == byte.class) {
            return "Byte";
        }
        if (type == char.class) {
            return "Character";
        }
        return type.getSimpleName();
    }
}
