package com.easy.restful.sys.controller;

import cn.hutool.json.JSONObject;
import com.easy.restful.common.core.base.BaseController;
import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.common.core.util.Response;
import com.easy.restful.sys.model.SysMessage;
import com.easy.restful.sys.service.SysMessageDetailsService;
import com.easy.restful.sys.service.SysMessageService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 消息
 *
 * @author TengChong
 * @date 2019-06-02
 */
@RestController
@RequestMapping("/auth/sys/message")
public class SysMessageController extends BaseController {

    /**
     * 通知  service
     */
    @Autowired
    private SysMessageService service;

    @Autowired
    private SysMessageDetailsService sysMessageDetailsService;

    /**
     * 列表
     *
     * @param object 查询条件
     */
    @GetMapping
    @RequiresPermissions("sys:message:select")
    public Response select(SysMessage object, Page<SysMessage> page) {
        return Response.success(service.select(object, page));
    }

    /**
     * 收信列表
     *
     * @param object 查询条件
     */
    @GetMapping("receive")
    @RequiresPermissions("sys:message:select")
    public Response selectReceive(SysMessage object, Page<SysMessage> page) {
        return Response.success(service.selectReceive(object, page));
    }

    /**
     * 详情
     *
     * @param id id
     */
    @GetMapping("{id}")
    @RequiresPermissions("sys:message:select")
    public Response get(@PathVariable("id") String id) {
        return Response.success(service.get(id));
    }

    /**
     * 阅读消息
     *
     * @param id        消息 id
     * @param messageId 收信id
     */
    @GetMapping("info/{id}/{messageId}")
    public Response info(@PathVariable("id") String id,
                         @PathVariable("messageId") String messageId) {
        // 标记已读
        sysMessageDetailsService.setRead(messageId);
        // 获取消息详情
        return Response.success(service.getBySysMessageId(id));
    }

    /**
     * 新增
     */
    @GetMapping("add")
    @RequiresPermissions("sys:message:add")
    public Response add(Model model) {
        return Response.success(service.add());
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     */
    @DeleteMapping("{ids}")
    @RequiresPermissions("sys:message:remove")
    public Response remove(@PathVariable("ids") String ids) {
        return Response.success(service.remove(ids));
    }

    /**
     * 保存
     *
     * @param object 表单内容
     */
    @PostMapping
    @RequiresPermissions("sys:message:save")
    public Response save(@RequestBody @Valid SysMessage object) {
        return Response.success(service.saveData(object));
    }

    /**
     * 发送
     * @param json {ids: ''}
     */
    @PostMapping("send")
    @RequiresPermissions("sys:message:save")
    public Response send(@RequestBody JSONObject json) {
        return Response.success(service.send(json.getStr("ids")));
    }

    /**
     * 获取当前登录用户查询未读消息数量
     */
    @GetMapping("unread/count")
    @RequiresPermissions("sys:message:select")
    public Response selectUnreadCount() {
        return Response.success(service.selectUnreadCount());
    }
}
