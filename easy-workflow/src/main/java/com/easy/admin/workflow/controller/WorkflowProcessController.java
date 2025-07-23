package com.easy.admin.workflow.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import com.easy.admin.common.core.annotation.ResponseResult;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.workflow.model.vo.WorkflowProcessVO;
import com.easy.admin.workflow.service.WorkflowProcessService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 流程
 *
 * @author TengChongChong
 * @date 2025-07-12
 */
@RestController
public class WorkflowProcessController {

    @Autowired
    private WorkflowProcessService service;

    /**
     * 查询数据
     *
     * @param workflowProcess 查询条件
     * @return 数据
     */
    @GetMapping("/api/auth/workflow/process")
    @ResponseResult
    @SaCheckPermission("workflow:process:select")
    public Page<WorkflowProcessVO> select(WorkflowProcessVO workflowProcess, Page<WorkflowProcessVO> page) {
        return service.select(workflowProcess, page);
    }

    /**
     * 删除
     *
     * @param deploymentIds 部署ds
     * @return true/false
     */
    @DeleteMapping("/api/auth/workflow/process/{deploymentIds}")
    @ResponseResult
    @SaCheckPermission("workflow:process:remove")
    public boolean remove(@PathVariable("deploymentIds") String deploymentIds) {
        return service.remove(deploymentIds);
    }

    /**
     * 流程转模型
     *
     * @param workflowProcess process
     * @return true/false
     */
    @PostMapping("/api/auth/workflow/process/convert/to/model")
    @ResponseResult
    @SaCheckPermission("workflow:model:save")
    public boolean convertToModel(@RequestBody WorkflowProcessVO workflowProcess) {
        return service.convertToModel(workflowProcess);
    }

    /**
     * 查看流程图片
     *
     * @param deploymentId 部署id
     * @param resourceName 资源名称
     */
    @GetMapping("/api/workflow/process/{deploymentId}/{resourceName}/image/stream")
    public void getImageStream(@PathVariable("deploymentId") String deploymentId,
                               @PathVariable("resourceName") String resourceName, HttpServletResponse response) throws IOException {
        InputStream inputStream = service.getImageStream(deploymentId, resourceName);
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes, 0, CommonConst.BYTE1024)) != -1) {
            response.getOutputStream().write(bytes, 0, len);
        }
    }

    /**
     * 挂起流程
     *
     * @param processDefinitionId     流程id
     * @param suspendProcessInstances 如果为true，将同时挂起此流程正在进行的任务
     * @return true/false
     */
    @PostMapping("/api/auth/workflow/process/suspend/{processDefinitionId}/{suspendProcessInstances}")
    @ResponseResult
    @SaCheckPermission("workflow:process:suspend")
    public boolean suspend(@PathVariable("processDefinitionId") String processDefinitionId,
                           @PathVariable("suspendProcessInstances") boolean suspendProcessInstances) {
        service.suspend(processDefinitionId, suspendProcessInstances);
        return true;
    }

    /**
     * 激活流程
     *
     * @param processDefinitionId     流程id
     * @param suspendProcessInstances 如果为true，将同时激活此流程正在进行的任务
     * @return true/false
     */
    @PostMapping("/api/auth/workflow/process/activation/{processDefinitionId}/{suspendProcessInstances}")
    @ResponseResult
    @SaCheckPermission("workflow:process:activation")
    public boolean activation(@PathVariable("processDefinitionId") String processDefinitionId,
                              @PathVariable("suspendProcessInstances") boolean suspendProcessInstances) {
        service.activation(processDefinitionId, suspendProcessInstances);
        return true;
    }

    /**
     * 查询流程数据用于放到select的option中
     *
     * @return List<Select>
     */
    @GetMapping("/api/auth/workflow/process/process/for/select")
    @ResponseResult
    public List<Select> selectProcessForSelect() {
        return service.selectProcessForSelect();
    }
}
