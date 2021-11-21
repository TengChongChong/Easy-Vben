package com.easy.admin.cms.controller;

import com.easy.admin.cms.model.CmsColumn;
import com.easy.admin.cms.model.CmsColumnUser;
import com.easy.admin.cms.service.CmsColumnUserService;
import com.easy.admin.core.annotation.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 栏目用户权限
 *
 * @author TengChongChong
 * @date 2021-11-19
 */
@RestController
@ResponseResult
@RequestMapping("/auth/cms/column/user")
public class CmsColumnUserController {

    /**
     * 栏目用户权限 service
     */
    @Autowired
    private CmsColumnUserService service;

    /**
     * 查询有某栏目权限的用户
     *
     * @param columnId     栏目
     * @return List<CmsColumnUser>
     */
    @GetMapping("users/by/column/id/{columnId}")
    public List<CmsColumnUser> selectUsersByColumnId(@PathVariable("columnId") String columnId){
        return service.selectUsersByColumnId(columnId);
    }


    /**
     * 查询某用户拥有的栏目权限
     *
     * @param userId       用户id
     * @return List<CmsColumnUser>
     */
    @GetMapping("columns/by/user/id")
    public List<CmsColumn> selectColumnsByUserId(@RequestParam(value = "userId", required = false) String userId){
        return service.selectColumnsByUserId(userId);
    }
}
