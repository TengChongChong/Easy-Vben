package com.easy.admin.sys.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.sys.common.constant.MessageConst;
import com.easy.admin.sys.dao.SysMessageMapper;
import com.easy.admin.sys.model.SysMessage;
import com.easy.admin.auth.model.SysUser;
import com.easy.admin.sys.service.SysMessageDetailService;
import com.easy.admin.sys.service.SysMessageService;
import com.easy.admin.util.ShiroUtil;
import com.easy.admin.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 消息
 *
 * @author TengChong
 * @date 2019-06-02
 */
@Service
public class SysMessageServiceImpl extends ServiceImpl<SysMessageMapper, SysMessage> implements SysMessageService {

    @Autowired
    private SysMessageDetailService sysMessageDetailsService;

    /**
     * 列表
     *
     * @param object 查询条件
     * @return 数据集合
     */
    @Override
    public Page<SysMessage> select(SysMessage object, Page<SysMessage> page) {
        QueryWrapper<SysMessage> queryWrapper = commonQuery(object);
        if (object != null && Validator.isNotEmpty(object.getStatus())) {
            queryWrapper.eq("m.status", object.getStatus());
        }
        queryWrapper.eq("m.create_user", ShiroUtil.getCurrentUser().getId());
        page.setRecords(baseMapper.selectSend(page, queryWrapper));
        return page;
    }

    @Override
    public Page<SysMessage> selectReceive(SysMessage object, Page<SysMessage> page) {
        SysUser currentUser = ShiroUtil.getCurrentUser();
        // 查询条件
        QueryWrapper<SysMessage> queryWrapper = commonQuery(object);
        // 只查询接收人为自己的
        queryWrapper.eq("d.receiver_user", currentUser.getId());
        // 已发送
        queryWrapper.eq("m.status", MessageConst.STATUS_HAS_BEEN_SENT);
        if (object != null) {
            if (object.getStar() != null) {
                queryWrapper.eq("d.star", object.getStar());
            }
            if (StrUtil.isNotBlank(object.getDetailsStatus())) {
                queryWrapper.eq("d.status", object.getDetailsStatus());
            }
        }
        if (object == null || StrUtil.isBlank(object.getDetailsStatus())) {
            // 默认查询收信
            queryWrapper.ne("d.status", MessageConst.RECEIVE_STATUS_DELETED);
        }
        page.setDefaultDesc("m.send_date");
        page.setRecords(baseMapper.selectReceive(page, queryWrapper));
        return page;
    }

    private QueryWrapper<SysMessage> commonQuery(SysMessage object) {
        QueryWrapper<SysMessage> queryWrapper = new QueryWrapper<>();
        if (object != null) {
            if (StrUtil.isNotBlank(object.getTitle())) {
                queryWrapper.and(i -> i.like("m.title", object.getTitle()).or().like("m.content", object.getTitle()));
            }
            // 类型
            if (Validator.isNotEmpty(object.getType())) {
                queryWrapper.eq("m.type", object.getType());
            }
        }
        return queryWrapper;
    }

    @Override
    public SysMessage get(String id) {
        SysMessage sysMessage = getById(id);
        if (sysMessage != null) {
            // 查询收信人信息
            sysMessage.setReceivers(sysMessageDetailsService.selectReceiverUser(id));
        }
        return sysMessage;
    }

    @Override
    public SysMessage info(String id) {
        return baseMapper.selectInfoById(id);
    }

    /**
     * 新增
     *
     * @return 默认值
     */
    @Override
    public SysMessage add() {
        SysMessage object = new SysMessage();
        // 设置默认值
        object.setType(MessageConst.TYPE_NOTICE);
        // 非重要
        object.setImportant(MessageConst.IMPORTANT_NO);
        // 草稿
        object.setStatus(MessageConst.STATUS_DRAFT);
        return object;
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return 是否成功
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        ToolUtil.checkParams(ids);
        List<String> idList = Arrays.asList(ids.split(","));
        return removeByIds(idList);
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return 保存后信息
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SysMessage saveData(SysMessage object) {
        ToolUtil.checkParams(object);
        boolean isAdd = StrUtil.isBlank(object.getId());
        if (MessageConst.STATUS_HAS_BEEN_SENT.equals(object.getStatus())) {
            object.setSendDate(new Date());
        }
        if (StrUtil.isBlank(object.getType())) {
            object.setType(MessageConst.TYPE_NOTICE);
        }
        boolean isSuccess = saveOrUpdate(object);
        if (isSuccess) {
            if (!isAdd) {
                // 清空上次设置的收信人
                sysMessageDetailsService.remove(String.valueOf(object.getId()));
            }
            // 保存收信人
            sysMessageDetailsService.saveData(object.getId(), object.getReceivers());
        }
        return object;
    }

    @Override
    public boolean send(String ids) {
        ToolUtil.checkParams(ids);
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        UpdateWrapper<SysMessage> send = new UpdateWrapper<>();
        send.set("status", MessageConst.STATUS_HAS_BEEN_SENT);
        send.set("send_date", new Date());
        send.in("id", idList);
        // 只能发送自己写的
        send.eq("create_user", ShiroUtil.getCurrentUser().getId());
        return update(send);
    }

    @Override
    public int selectUnreadCount() {
        // 查询条件
        QueryWrapper<SysMessage> queryWrapper = new QueryWrapper<>();
        // 只查询接收人为自己的
        queryWrapper.eq("d.receiver_user", ShiroUtil.getCurrentUser().getId());
        // 已发送
        queryWrapper.eq("m.status", MessageConst.STATUS_HAS_BEEN_SENT);
        // 未读
        queryWrapper.eq("d.status", MessageConst.RECEIVE_STATUS_UNREAD);
        return baseMapper.selectUnreadCount(queryWrapper);
    }
}