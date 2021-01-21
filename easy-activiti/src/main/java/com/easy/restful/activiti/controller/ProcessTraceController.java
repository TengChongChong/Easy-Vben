package com.easy.restful.activiti.controller;

import com.easy.restful.activiti.service.ProcessTraceService;
import com.easy.restful.core.annotation.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 流程跟踪
 *
 * @author tengchong
 * @date 2019-07-12
 */
@RestController
@ResponseResult
@RequestMapping("/activiti/process/trace")
public class ProcessTraceController {

    @Autowired
    ProcessTraceService service;

    /**
     * 查看流程实例进度
     *
     * @param processInstanceId 流程实例ID
     * @param response response
     * @throws IOException ex
     */
    @GetMapping(value = "process/progress/image/{processInstanceId}")
    public void processProgressImage(@PathVariable("processInstanceId") String processInstanceId, HttpServletResponse response) throws IOException {
        service.readProcessImg(processInstanceId, response);
    }
}
