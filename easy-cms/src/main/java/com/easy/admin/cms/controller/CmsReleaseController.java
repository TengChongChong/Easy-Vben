package com.easy.admin.cms.controller;

import com.easy.admin.cms.model.CmsRelease;
import com.easy.admin.cms.model.vo.ReleaseProgressVO;
import com.easy.admin.cms.service.CmsReleaseService;
import com.easy.admin.cms.utils.CmsSiteUtil;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.core.annotation.ResponseResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 网站发布
 *
 * @author 系统管理员
 * @date 2023-07-12
 */
@Tag(name = "网站发布")
@RestController
@ResponseResult
@RequestMapping("/api/auth/cms/release")
public class CmsReleaseController {

    /**
     * 网站发布 service
     */
    @Autowired
    private CmsReleaseService service;

    /**
     * 查询数据
     *
     * @param cmsRelease 查询条件
     * @param page       分页
     * @return Page<CmsRelease>
     */
    @Operation(summary = "查询数据")
    @GetMapping()
    @RequiresPermissions("cms:release")
    public Page<CmsRelease> select(CmsRelease cmsRelease, Page<CmsRelease> page) {
        return service.select(cmsRelease, page);
    }

    /**
     * 获取发布资源
     *
     * @return List<Tree>
     */
    @Operation(summary = "获取发布资源")
    @GetMapping("assets")
    @RequiresPermissions("cms:release")
    public List<Tree> selectReleaseAssets() {
        return service.selectReleaseAssets();
    }

    /**
     * 保存/修改
     *
     * @param cmsRelease 表单内容
     * @return CmsRelease
     */
    @Operation(summary = "保存/修改")
    @PostMapping()
    @RequiresPermissions("cms:release")
    public CmsRelease saveData(@Valid @RequestBody CmsRelease cmsRelease) {
        return service.saveData(cmsRelease);
    }

    /**
     * 开始发布
     *
     * @param id id
     * @return true/false
     */
    @Operation(summary = "开始发布")
    @PostMapping("start/{id}")
    @RequiresPermissions("cms:release")
    public boolean startRelease(@PathVariable("id") String id) {
        service.startRelease(id, CmsSiteUtil.getUserActiveSiteId());
        return true;
    }

    /**
     * 取消发布
     *
     * @param id id
     * @return 发布进度
     */
    @Operation(summary = "取消发布")
    @PostMapping("cancel/{id}")
    @RequiresPermissions("cms:release")
    public ReleaseProgressVO cancelRelease(@PathVariable("id") String id) {
        return service.cancelRelease(id);
    }

    /**
     * 获取已发布数量
     *
     * @param id id
     * @return 发布进度
     */
    @Operation(summary = "获取已发布数量")
    @GetMapping("progress/{id}")
    @RequiresPermissions("cms:release")
    public ReleaseProgressVO getReleaseProgress(@PathVariable("id") String id) {
        return service.getReleaseProgress(id);
    }


    /**
     * 发布单个列队数据
     *
     * @param id id
     * @return true/false
     */
    @Operation(summary = "发布单个列队数据")
    @PostMapping("release/queue/{id}")
    @RequiresPermissions("cms:release")
    public boolean releaseQueue(@PathVariable("id") String id) {
        return service.releaseQueue(id);
    }
}
