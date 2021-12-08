package com.easy.admin.cms.controller;

import com.easy.admin.cms.model.CmsReleaseQueue;
import com.easy.admin.cms.service.CmsReleaseQueueService;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.core.annotation.ResponseResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发布列队详情
 *
 * @author TengChongChong
 * @date 2021-12-08
 */
@RestController
@ResponseResult
@RequestMapping("/auth/cms/release/queue")
public class CmsReleaseQueueController {

    /**
     * 发布列队详情 service
     */
    @Autowired
    private CmsReleaseQueueService service;

    /**
     * 列表
     *
     * @param object 查询条件
     * @return Page<CmsReleaseQueue>
     */
    @GetMapping()
    @RequiresPermissions("cms:release:queue:select")
    public Page<CmsReleaseQueue> select(CmsReleaseQueue object, Page<CmsReleaseQueue> page){
        return service.select(object, page);
    }
}
