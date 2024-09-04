package com.easy.admin.sys.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.util.ToolUtil;
import com.easy.admin.sys.common.constant.MessageConst;
import com.easy.admin.sys.dao.SysMessageDetailMapper;
import com.easy.admin.sys.model.SysMessageDetail;
import com.easy.admin.sys.service.SysMessageDetailService;
import com.easy.admin.config.sa.token.util.SessionUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 消息详情
 *
 * @author TengChong
 * @date 2019-06-06
 */
@Service
public class SysMessageDetailServiceImpl extends ServiceImpl<SysMessageDetailMapper, SysMessageDetail> implements SysMessageDetailService {

    @Override
    public Page<SysMessageDetail> selectMessageReceiverUserDetail(SysMessageDetail sysMessage, Page<SysMessageDetail> page) {
        if (sysMessage == null || StrUtil.isBlank(sysMessage.getMessageId())) {
            throw new EasyException("未指定消息ID");
        }
        QueryWrapper<SysMessageDetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("d.message_id", sysMessage.getMessageId());

        if (Validator.isNotEmpty(sysMessage.getStatus())) {
            queryWrapper.eq("d.status", sysMessage.getStatus());
        }
        // 接收人
        if (Validator.isNotEmpty(sysMessage.getReceiverUser())) {
            queryWrapper.like("su.nickname", sysMessage.getReceiverUser());
        }
        // 接收人所在部门
        if (Validator.isNotEmpty(sysMessage.getReceiverUserDeptName())) {
            queryWrapper.like("sd.name", sysMessage.getReceiverUserDeptName());
        }
        page.setRecords(baseMapper.selectMessageReceiverUserDetail(page, queryWrapper));
        return page;
    }

    @Override
    public List<String> selectReceiverUser(String messageId) {
        return baseMapper.selectReceiverUser(messageId);
    }

    /**
     * 删除
     *
     * @param messageIds 消息ids
     * @return 是否成功
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String messageIds) {
        List<String> idList = Arrays.asList(messageIds.split(","));
        QueryWrapper<SysMessageDetail> delete = new QueryWrapper<>();
        delete.in("message_id", idList);
        return remove(delete);
    }

    @Override
    public boolean removeByIds(String ids) {
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        QueryWrapper<SysMessageDetail> delete = new QueryWrapper<>();
        delete.in("id", idList);
        delete.eq("receiver_user", SessionUtil.getCurrentUser().getId());
        return remove(delete);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean saveData(String messageId, List<String> receivers) {
        List<SysMessageDetail> detailsList = new ArrayList<>();
        for (String receiverUser : receivers) {
            SysMessageDetail details = new SysMessageDetail();
            details.setMessageId(messageId);
            // 收信人
            details.setReceiverUser(receiverUser);
            // 未标星
            details.setStar(MessageConst.STAR_NO);
            // 未读
            details.setStatus(MessageConst.RECEIVE_STATUS_UNREAD);
            detailsList.add(details);
        }
        return saveBatch(detailsList);
    }


    @Override
    public boolean setStar(String id, boolean type) {
        if (StrUtil.isNotBlank(id)) {
            UpdateWrapper<SysMessageDetail> updateStar = new UpdateWrapper<>();
            updateStar.eq("id", id);
            // 接收人必须是当前登录用户
            updateStar.eq("receiver_user", SessionUtil.getCurrentUser().getId());
            updateStar.set("star", type ? MessageConst.STAR_YES : MessageConst.STAR_NO);
            return update(updateStar);
        }
        return false;
    }

    @Override
    public boolean setRead(String ids) {
        UpdateWrapper<SysMessageDetail> updateRead = new UpdateWrapper<>();
        if (StrUtil.isNotBlank(ids)) {
            List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
            updateRead.in("id", idList);
        }
        // 接收人必须是当前登录用户
        updateRead.eq("receiver_user", SessionUtil.getCurrentUser().getId());
        // 阅读时间
        updateRead.set("read_date", new Date());
        // 已读
        updateRead.set("status", MessageConst.RECEIVE_STATUS_ALREADY_READ);
        return update(updateRead);
    }
}