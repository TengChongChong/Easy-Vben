package com.easy.admin.activiti.controller;

import com.easy.admin.activiti.model.ActivitiProcess;
import com.easy.admin.activiti.service.ActivitiProcessService;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.core.annotation.ResponseResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 流程
 *
 * @author TengChongChong
 * @date 2019-07-12
 */
@RestController
public class ActivitiProcessController {

    @Autowired
    private ActivitiProcessService service;

    /**
     * 查询数据
     *
     * @param activitiProcess 查询条件
     * @return 数据
     */
    @GetMapping("/api/auth/activiti/process")
    @ResponseResult
    @RequiresPermissions("activiti:process:select")
    public Page<ActivitiProcess> select(ActivitiProcess activitiProcess, Page<ActivitiProcess> page) {
        return service.select(activitiProcess, page);
    }

    /**
     * 删除
     *
     * @param deploymentIds 部署ds
     * @return true/false
     */
    @DeleteMapping("/api/auth/activiti/process/{deploymentIds}")
    @ResponseResult
    @RequiresPermissions("activiti:process:remove")
    public boolean remove(@PathVariable("deploymentIds") String deploymentIds) {
        return service.remove(deploymentIds);
    }

    /**
     * 流程转模型
     *
     * @param activitiProcess process
     * @return true/false
     */
    @PostMapping("/api/auth/activiti/process/convert/to/model")
    @ResponseResult
    @RequiresPermissions("activiti:model:save")
    public boolean convertToModel(@RequestBody ActivitiProcess activitiProcess) {
        return service.convertToModel(activitiProcess);
    }

    /**
     * 查看流程图片
     *
     * @param deploymentId 部署id
     * @param resourceName 资源名称
     */
    @GetMapping("/api/activiti/process/{deploymentId}/{resourceName}/image/stream")
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
    @PostMapping("/api/auth/activiti/process/suspend/{processDefinitionId}/{suspendProcessInstances}")
    @ResponseResult
    @RequiresPermissions("activiti:process:suspend")
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
    @PostMapping("/api/auth/activiti/process/activation/{processDefinitionId}/{suspendProcessInstances}")
    @ResponseResult
    @RequiresPermissions("activiti:process:activation")
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
    @GetMapping("/api/auth/activiti/process/process/for/select")
    @ResponseResult
    public List<Select> selectProcessForSelect() {
        return service.selectProcessForSelect();
    }
}
