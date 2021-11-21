package com.easy.admin.activiti.controller;

import com.easy.admin.activiti.model.Process;
import com.easy.admin.activiti.service.ProcessService;
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
public class ProcessController {

    @Autowired
    private ProcessService service;

    /**
     * 查询数据
     *
     * @param process 查询条件
     * @return 数据
     */
    @GetMapping("/auth/activiti/process")
    @ResponseResult
    @RequiresPermissions("activiti:process:select")
    public Page<Process> select(Process process, Page<Process> page) {
        return service.select(process, page);
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    @DeleteMapping("/auth/activiti/process/{ids}")
    @ResponseResult
    @RequiresPermissions("activiti:process:remove")
    public boolean remove(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 流程转模型
     *
     * @param process process
     * @return true/false
     */
    @PostMapping("/auth/activiti/process/convert/to/model")
    @ResponseResult
    @RequiresPermissions("activiti:model:save")
    public boolean convertToModel(@RequestBody Process process) {
        return service.convertToModel(process);
    }

    /**
     * 查看流程图片
     *
     * @param id           流程id
     * @param resourceName 资源名称
     */
    @GetMapping("/activiti/process/{id}/{resourceName}/image/stream")
    public void getImageStream(@PathVariable("id") String id,
                               @PathVariable("resourceName") String resourceName, HttpServletResponse response) throws IOException {
        InputStream inputStream = service.getImageStream(id, resourceName);
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes, 0, CommonConst.BYTE1024)) != -1) {
            response.getOutputStream().write(bytes, 0, len);
        }
    }

    /**
     * 添加流程
     *
     * @param path 流程模型文件路径
     * @return true/false
     */
    @PostMapping("/auth/activiti/process")
    @ResponseResult
    @RequiresPermissions("activiti:process:save")
    public boolean add(String path) {
        return service.add(path);
    }

    /**
     * 挂起流程
     *
     * @param processDefinitionId     流程id
     * @param suspendProcessInstances 如果为true，将同时挂起此流程正在进行的任务
     * @return true/false
     */
    @PostMapping("/auth/activiti/process/suspend/{processDefinitionId}/{suspendProcessInstances}")
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
    @PostMapping("/auth/activiti/process/activation/{processDefinitionId}/{suspendProcessInstances}")
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
    @GetMapping("/auth/activiti/process/process/for/select")
    @ResponseResult
    public List<Select> selectProcessForSelect() {
        return service.selectProcessForSelect();
    }
}
