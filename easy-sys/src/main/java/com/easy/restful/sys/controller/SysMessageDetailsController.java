package com.easy.restful.sys.controller;

import com.easy.restful.common.core.base.BaseController;
import com.easy.restful.common.core.util.Response;
import com.easy.restful.sys.service.SysMessageDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 消息-收信
 *
 * @author tengchong
 * @date 2019-06-13
 */
@RestController
@RequestMapping("/auth/sys/message/details")
public class SysMessageDetailsController extends BaseController {

    @Autowired
    private SysMessageDetailsService service;

    /**
     * 设置消息标星/取消标星
     *
     * @param id   接受消息id
     * @param type true/false 是否标星
     */
    @PostMapping("star/{id}/{type}")
    public Response setStar(@PathVariable("id") String id,
                            @PathVariable("type") boolean type) {
        return Response.success(service.setStar(id, type));
    }

    /**
     * 根据接收消息id删除
     *
     * @param ids              消息ids
     * @param removeCompletely true/false 是否彻底删除
     */
    @DeleteMapping("{ids}/{removeCompletely}")
    public Response removeByIds(@PathVariable("ids") String ids,
                                @PathVariable("removeCompletely") boolean removeCompletely) {
        return Response.success(service.removeByIds(ids, removeCompletely));
    }

    /**
     * 根据接收消息id恢复
     *
     * @param ids 消息ids
     */
    @PostMapping("reduction/{ids}")
    public Response reductionByIds(@PathVariable("ids") String ids) {
        return Response.success(service.reductionByIds(ids));
    }

    /**
     * 设置消息已读
     *
     * @param ids 消息ids
     */
    @PostMapping("read/{ids}")
    public Response setRead(@PathVariable("ids") String ids) {
        return Response.success(service.setRead(ids));
    }

}
