package com.easy.admin.cms.controller;

import com.easy.admin.cms.model.CmsSite;
import com.easy.admin.cms.model.CmsSiteUser;
import com.easy.admin.cms.service.CmsSiteUserService;
import com.easy.admin.core.annotation.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 站点用户权限
 *
 * @author TengChongChong
 * @date 2021-11-18
 */
@RestController
@ResponseResult
@RequestMapping("/auth/cms/site/user")
public class CmsSiteUserController {

    /**
     * 站点用户权限 service
     */
    @Autowired
    private CmsSiteUserService service;

    /**
     * 查询有某站点权限的用户
     *
     * @param siteId     站点
     * @return List<CmsSiteUser>
     */
    @GetMapping("users/by/site/id/{siteId}")
    public List<CmsSiteUser> selectUsersBySiteId(@PathVariable("siteId") String siteId){
        return service.selectUsersBySiteId(siteId);
    }

    /**
     * 查询某用户拥有的站点权限
     *
     * @param userId     用户id
     * @return List<CmsSiteUser>
     */
    @GetMapping("site/by/user/id")
    public List<CmsSite> selectSitesByUserId(@RequestParam(value = "userId", required = false) String userId){
        return service.selectSitesByUserId(userId);
    }

    /**
     * 获取当前编辑的站点
     *
     * @return 站点id
     */
    @GetMapping("current/edit/site/id")
    public String getCurrentEditSiteId(){
        return service.getCurrentEditSiteId();
    }

    /**
     * 设置当前编辑的站点
     *
     * @param siteId 站点id
     * @return true/false
     */
    @PostMapping("current/edit/site/id/{siteId}")
    public boolean setCurrentEditSiteId(@PathVariable("siteId") String siteId){
        return service.setCurrentEditSiteId(siteId);
    }
}
