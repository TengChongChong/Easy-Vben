package com.easy.admin.sys.controller;

import com.easy.admin.common.core.annotation.ResponseResult;
import com.easy.admin.sys.model.vo.SysRedisVO;
import com.easy.admin.sys.service.SysRedisService;
import cn.dev33.satoken.annotation.SaCheckPermission;
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
    @SaCheckPermission("sys:redis:select")
    @ResponseBody
    public Set<String> selectByPrefix(@PathVariable("prefix") String prefix) {
        return service.selectByPrefix(prefix);
    }

    /**
     * 根据键获取信息
     *
     * @param key 键
     * @return SysRedisVO
     */
    @GetMapping("key/{key}")
    @SaCheckPermission("sys:redis:select")
    @ResponseBody
    public SysRedisVO get(@PathVariable("key") String key) {
        return service.get(key);
    }

    /**
     * 根据键删除信息
     *
     * @param key 键
     * @return true/false
     */
    @DeleteMapping("{key}")
    @SaCheckPermission("sys:redis:remove")
    @ResponseBody
    public boolean remove(@PathVariable("key") String key) {
        return service.remove(key);
    }

    /**
     * 保存
     *
     * @param sysRedis redis信息
     * @return true/false
     */
    @PutMapping()
    @SaCheckPermission("sys:redis:save")
    @ResponseBody
    public boolean save(SysRedisVO sysRedis) {
        return service.save(sysRedis);
    }

}
