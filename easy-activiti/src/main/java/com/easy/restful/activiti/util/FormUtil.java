package com.easy.restful.activiti.util;

import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.TaskFormData;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Activiti 表单工具类
 *
 * @author tengchong
 * @date 2020/3/31
 */
public class FormUtil {
    public static Map<String, String> getFormData(TaskFormData taskFormData, HttpServletRequest request){
        // 获取提交表单数据
        Map<String, String> formValues;

        // 获取表单数据
        if (taskFormData.getFormKey() != null) {
            Map<String, String[]> parameterMap = request.getParameterMap();
            Set<Map.Entry<String, String[]>> entrySet = parameterMap.entrySet();
            formValues = new HashMap<>(entrySet.size());
            for (Map.Entry<String, String[]> entry : entrySet) {
                String key = entry.getKey();
                formValues.put(key, entry.getValue()[0]);
            }
        } else {
            // 动态表单
            formValues = new HashMap<>(taskFormData.getFormProperties().size());
            for (FormProperty formProperty : taskFormData.getFormProperties()) {
                formValues.put(formProperty.getId(), request.getParameter(formProperty.getId()));
            }
        }
        return formValues;
    }
}
