package com.easy.admin.sys.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.easy.admin.common.core.base.BaseController;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.sys.model.SysMessage;
import com.easy.admin.sys.service.SysMessageDetailService;
import com.easy.admin.sys.service.SysMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 消息
 *
 * @author TengChong
 * @date 2019-06-02
 */
@RestController
@ResponseResult
@RequestMapping("/api/auth/sys/message")
public class SysMessageController extends BaseController {

    /**
     * 通知  service
     */
    @Autowired
    private SysMessageService service;

    @Autowired
    private SysMessageDetailService sysMessageDetailsService;

    /**
     * 列表
     *
     * @param sysMessage 查询条件
     * @return Page<SysMessage>
     */
    @GetMapping
    public Page<SysMessage> select(SysMessage sysMessage, Page<SysMessage> page) {
        return service.select(sysMessage, page);
    }

    /**
     * 收信列表
     *
     * @param sysMessage 查询条件
     * @return Page<SysMessage>
     */
    @GetMapping("receive")
    public Page<SysMessage> selectReceive(SysMessage sysMessage, Page<SysMessage> page) {
        return service.selectReceive(sysMessage, page);
    }

    /**
     * 详情
     *
     * @param id id
     * @return SysMessage
     */
    @GetMapping("{id}")
    public SysMessage get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 阅读消息
     *
     * @param id        消息 id
     * @param messageId 收信id
     * @return SysMessage
     */
    @GetMapping("info")
    public SysMessage info(@RequestParam(value = "id", required = false) String id,
                           @RequestParam(value = "messageId") String messageId) {
        if(StrUtil.isNotBlank(id)){
            // 标记已读
            sysMessageDetailsService.setRead(id);
        }
        // 获取消息详情
        return service.info(messageId);
    }

    /**
     * 新增
     *
     * @return SysMessage
     */
    @GetMapping("add")
    public SysMessage add() {
        return service.add();
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    @DeleteMapping("{ids}")
    public boolean remove(@PathVariable("ids") String ids) {
        return service.remove(ids);
    }

    /**
     * 保存
     *
     * @param sysMessage 表单内容
     * @return SysMessage
     */
    @PostMapping
    public SysMessage save(@RequestBody @Valid SysMessage sysMessage) {
        return service.saveData(sysMessage);
    }

    /**
     * 发送
     *
     * @param json {ids: ''}
     * @return true/false
     */
    @PostMapping("send")
    public boolean send(@RequestBody JSONObject json) {
        return service.send(json.getStr("ids"));
    }

    /**
     * 获取当前登录用户查询未读消息数量
     *
     * @return 未读消息数量
     */
    @GetMapping("unread/count")
    public int selectUnreadCount() {
        return service.selectUnreadCount();
    }
}
