package com.easy.admin.sys.controller;

import com.easy.admin.common.core.base.BaseController;
import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.sys.service.SysMessageDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 消息-收信
 *
 * @author TengChongChong
 * @date 2019-06-13
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/sys/message/detail")
public class SysMessageDetailController extends BaseController {

    @Autowired
    private SysMessageDetailService service;

    /**
     * 设置消息标星/取消标星
     *
     * @param id   接受消息id
     * @param type true/false 是否标星
     * @return true/false
     */
    @PostMapping("star/{id}/{type}")
    public boolean setStar(@PathVariable("id") String id,
                           @PathVariable("type") boolean type) {
        return service.setStar(id, type);
    }

    /**
     * 根据接收消息id删除
     *
     * @param ids              消息ids
     * @return true/false
     */
    @DeleteMapping("{ids}")
    public boolean removeByIds(@PathVariable("ids") String ids) {
        return service.removeByIds(ids);
    }

    /**
     * 设置消息已读
     *
     * @param ids 消息ids
     * @return true/false
     */
    @PostMapping("read/{ids}")
    public boolean setRead(@PathVariable("ids") String ids) {
        return service.setRead(ids);
    }

    /**
     * 设置消息已读
     *
     * @return true/false
     */
    @PostMapping( "read")
    public boolean setRead() {
        return service.setRead(null);
    }

}
