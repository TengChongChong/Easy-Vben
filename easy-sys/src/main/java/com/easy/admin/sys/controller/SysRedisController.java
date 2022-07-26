package com.easy.admin.sys.controller;

import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.sys.model.SysRedisVO;
import com.easy.admin.sys.service.SysRedisService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * redis 管理
 *
 * @author TengChongChong
 * @date 2019-01-25
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/sys/redis")
public class SysRedisController {

    @Autowired
    private SysRedisService service;

    /**
     * 根据前缀查询redis列表
     *
     * @param prefix 前缀
     * @return Set<String>
     */
    @GetMapping("prefix/{prefix}")
    @RequiresPermissions("sys:redis:select")
    @ResponseBody
    public Set<String> selectByPrefix(@PathVariable("prefix") String prefix){
        return service.selectByPrefix(prefix);
    }

    /**
     * 根据键获取信息
     *
     * @param key 键
     * @return SysRedisVO
     */
    @GetMapping("key/{key}")
    @RequiresPermissions("sys:redis:select")
    @ResponseBody
    public SysRedisVO get(@PathVariable("key") String key){
        return service.get(key);
    }

    /**
     * 根据键删除信息
     *
     * @param key 键
     * @return true/false
     */
    @DeleteMapping("{key}")
    @RequiresPermissions("sys:redis:remove")
    @ResponseBody
    public boolean remove(@PathVariable("key") String key){
        return service.remove(key);
    }

    /**
     * 保存
     *
     * @param sysRedis redis信息
     * @return true/false
     */
    @PutMapping()
    @RequiresPermissions("sys:redis:save")
    @ResponseBody
    public boolean save(SysRedisVO sysRedis){
        return service.save(sysRedis);
    }

}
