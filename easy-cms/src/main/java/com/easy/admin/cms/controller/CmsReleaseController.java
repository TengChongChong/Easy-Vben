package com.easy.admin.cms.controller;

import cn.hutool.json.JSONObject;
import com.easy.admin.cms.model.CmsRelease;
import com.easy.admin.cms.service.CmsReleaseService;
import com.easy.admin.cms.utils.CmsSiteUtil;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.core.annotation.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 发布
 *
 * @author tengchong
 * @date 2021/11/24
 */
@RestController
@ResponseResult
@RequestMapping("/auth/cms/release")
public class CmsReleaseController {

    @Autowired
    private CmsReleaseService service;


    /**
     * 列表
     *
     * @param object 查询条件
     * @return Page<CmsRelease>
     */
    @GetMapping()
    public Page<CmsRelease> select(CmsRelease object, Page<CmsRelease> page){
        return service.select(object, page);
    }


    /**
     * 获取发布资源
     *
     * @return List<Tree>
     */
    @GetMapping("assets")
    public List<Tree> selectReleaseAssets(){
        return service.selectReleaseAssets();
    }


    /**
     * 保存发布
     *
     * @param cmsRelease 要发布的资源
     * @return CmsRelease
     */
    @PostMapping()
    public CmsRelease saveRelease(@RequestBody CmsRelease cmsRelease){
        return service.saveRelease(cmsRelease);
    }

    /**
     * 开始发布
     *
     * @param id id
     * @return true/false
     */
    @PostMapping("start/{id}")
    public boolean startRelease(@PathVariable("id") String id){
        service.startRelease(id, CmsSiteUtil.getCurrentEditSiteId());
        return true;
    }

    /**
     * 取消发布
     *
     * @param id id
     * @return {done: 0, fail: 0}
     */
    @PostMapping("cancel/{id}")
    public JSONObject cancelRelease(@PathVariable("id") String id){
        return service.cancelRelease(id);
    }

    /**
     * 获取已发布数量
     *
     * @param id id
     * @return {done: 0, fail: 0}
     */
    @GetMapping("progress/{id}")
    public JSONObject getReleaseProgress(@PathVariable("id") String id){
        return service.getReleaseProgress(id);
    }


    /**
     * 发布单个列队数据
     *
     * @param id    id
     * @return true/false
     */
    @PostMapping("release/queue/{id}")
    public boolean releaseQueue(@PathVariable("id") String id){
        return service.releaseQueue(id);
    }
}
