package com.easy.restful.activiti.service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 流程跟踪
 *
 * @author tengchong
 * @date 2020/4/29
 */
public interface ProcessTraceService {

    /**
     * 查看流程实例进度
     * @param processInstanceId 流程实例ID
     * @param response response
     * @throws IOException exception
     */
    void readProcessImg(String processInstanceId, HttpServletResponse response) throws IOException;
}
