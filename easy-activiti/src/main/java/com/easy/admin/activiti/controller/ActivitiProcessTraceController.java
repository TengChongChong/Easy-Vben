package com.easy.admin.activiti.controller;

import com.easy.admin.activiti.service.ActivitiProcessTraceService;
import com.easy.admin.core.annotation.ResponseResult;
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
 * @author TengChongChong
 * @date 2019-07-12
 */
@RestController
@ResponseResult
@RequestMapping("/api/activiti/process/trace")
public class ActivitiProcessTraceController {

    @Autowired
    ActivitiProcessTraceService service;

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
