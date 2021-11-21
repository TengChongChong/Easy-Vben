package com.easy.admin.activiti.config.manager;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.image.ProcessDiagramGenerator;

import java.awt.*;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

/**
 * 重写ProcessDiagramGenerator接口中的generateDiagram方法，增加color参数
 *
 * @author TengChongChong
 * @date 2020/6/3
 */
public interface CustomProcessDiagramGenerator extends ProcessDiagramGenerator {
    /**
     * 生成流程图
     *
     * @param bpmnModel 模型
     * @param imageType 图片类型
     * @param highLightedActivities 高亮事件
     * @param highLightedFlows 高亮箭头
     * @param activityFontName 字体
     * @param labelFontName label 字体
     * @param annotationFontName annotation 字体
     * @param customClassLoader classLoader
     * @param scaleFactor 比例
     * @param colors 颜色
     * @param currIds id
     * @return InputStream
     */
    InputStream generateDiagram(BpmnModel bpmnModel, String imageType, List<String> highLightedActivities,
                                List<String> highLightedFlows, String activityFontName, String labelFontName, String annotationFontName,
                                ClassLoader customClassLoader, double scaleFactor, Color[] colors, Set<String> currIds);
}
