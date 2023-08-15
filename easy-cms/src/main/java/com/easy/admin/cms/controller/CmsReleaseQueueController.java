package com.easy.admin.cms.controller;

import com.easy.admin.cms.model.CmsReleaseQueue;
import com.easy.admin.cms.service.CmsReleaseQueueService;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.core.annotation.ResponseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发布列队详情
 *
 * @author 系统管理员
 * @date 2023-07-12
 */
@Tag(name = "发布列队详情")
@RestController
@ResponseResult
@RequestMapping("/api/auth/cms/release/queue")
public class CmsReleaseQueueController {

    /**
     * 发布列队详情 service
     */
    @Autowired
    private CmsReleaseQueueService service;

    /**
     * 查询数据
     *
     * @param cmsReleaseQueue 查询条件
     * @param page            分页
     * @return Page<CmsReleaseQueue>
     */
    @Operation(summary = "查询数据")
    @GetMapping()
    @RequiresPermissions("cms:release")
    public Page<CmsReleaseQueue> select(CmsReleaseQueue cmsReleaseQueue, Page<CmsReleaseQueue> page) {
        return service.select(cmsReleaseQueue, page);
    }

}
