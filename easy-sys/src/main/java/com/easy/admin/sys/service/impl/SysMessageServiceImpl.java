package com.easy.admin.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.auth.model.vo.session.SessionUserVO;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.config.sa.token.util.SessionUtil;
import com.easy.admin.file.service.FileDetailService;
import com.easy.admin.file.util.file.EditorUtil;
import com.easy.admin.sys.common.constant.MessageConst;
import com.easy.admin.sys.dao.SysMessageMapper;
import com.easy.admin.sys.model.SysMessage;
import com.easy.admin.sys.model.vo.SysMessageVO;
import com.easy.admin.sys.service.SysMessageDetailService;
import com.easy.admin.sys.service.SysMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Autowired
    private FileDetailService fileDetailService;

    /**
     * 列表
     *
     * @param sysMessage 查询条件
     * @return 数据集合
     */
    @Override
    public Page<SysMessage> select(SysMessageVO sysMessage, Page<SysMessage> page) {
        QueryWrapper<SysMessage> queryWrapper = commonQuery(sysMessage);
        if (sysMessage != null) {
            if (Validator.isNotEmpty(sysMessage.getStatus())) {
                queryWrapper.eq("m.status", sysMessage.getStatus());
            }
            // 发送时间 - 开始
            if (Validator.isNotEmpty(sysMessage.getStartSendDate())) {
                queryWrapper.ge("m.send_date", sysMessage.getStartSendDate());
            }
            // 发送时间 - 结束
            if (Validator.isNotEmpty(sysMessage.getEndSendDate())) {
                queryWrapper.le("m.send_date", sysMessage.getEndSendDate());
            }
        }
        queryWrapper.eq("m.create_user", SessionUtil.getCurrentUser().getId());
        page.setRecords(baseMapper.selectSend(page, queryWrapper));
        return page;
    }

    @Override
    public Page<SysMessageVO> selectReceive(SysMessageVO sysMessage, Page<SysMessageVO> page) {
        SessionUserVO currentUser = SessionUtil.getCurrentUser();
        // 查询条件
        QueryWrapper<SysMessage> queryWrapper = commonQuery(sysMessage);
        // 只查询接收人为自己的
        queryWrapper.eq("d.receiver_user", currentUser.getId());
        // 已发送
        queryWrapper.eq("m.status", MessageConst.STATUS_HAS_BEEN_SENT);
        if (sysMessage != null) {
            if (sysMessage.getStar() != null) {
                queryWrapper.eq("d.star", sysMessage.getStar());
            }
            if (StrUtil.isNotBlank(sysMessage.getDetailsStatus())) {
                queryWrapper.eq("d.status", sysMessage.getDetailsStatus());
            }
        }
        page.setDefaultDesc("m.send_date");
        page.setRecords(baseMapper.selectReceive(page, queryWrapper));
        return page;
    }

    private QueryWrapper<SysMessage> commonQuery(SysMessage sysMessage) {
        QueryWrapper<SysMessage> queryWrapper = new QueryWrapper<>();
        if (sysMessage != null) {
            if (StrUtil.isNotBlank(sysMessage.getTitle())) {
                queryWrapper.and(i -> i.like("m.title", sysMessage.getTitle()).or().like("m.content", sysMessage.getTitle()));
            }
            // 类型
            if (Validator.isNotEmpty(sysMessage.getType())) {
                queryWrapper.eq("m.type", sysMessage.getType());
            }
        }
        return queryWrapper;
    }

    @Override
    public SysMessageVO get(String id) {
        SysMessage sysMessage = getById(id);
        SysMessageVO sysMessageVO = new SysMessageVO();
        BeanUtil.copyProperties(sysMessage, sysMessageVO);
        if (sysMessage != null) {
            // 查询收信人信息
            sysMessageVO.setReceivers(sysMessageDetailsService.selectReceiverUser(id));
        }
        return sysMessageVO;
    }

    @Override
    public SysMessageVO info(String id) {
        return baseMapper.selectInfoById(id);
    }

    /**
     * 新增
     *
     * @return 默认值
     */
    @Override
    public SysMessageVO add() {
        SysMessageVO sysMessage = new SysMessageVO();
        // 设置默认值
        sysMessage.setType(MessageConst.TYPE_NOTICE);
        // 非重要
        sysMessage.setImportant(MessageConst.IMPORTANT_NO);
        // 草稿
        sysMessage.setStatus(MessageConst.STATUS_DRAFT);
        sysMessage.setReceivers(new ArrayList<>());
        return sysMessage;
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
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        boolean isSuccess = removeByIds(idList);
        if (isSuccess) {
            fileDetailService.removeByObjectId(ids);
        }
        return isSuccess;
    }

    /**
     * 保存
     *
     * @param sysMessageVO 表单内容
     * @return 保存后信息
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SysMessageVO saveData(SysMessageVO sysMessageVO) {
        boolean isAdd = StrUtil.isBlank(sysMessageVO.getId());
        if (isAdd) {
            if (StrUtil.isBlank(sysMessageVO.getStatus())) {
                sysMessageVO.setStatus(MessageConst.STATUS_DRAFT);
            }
        }
        if (MessageConst.STATUS_HAS_BEEN_SENT.equals(sysMessageVO.getStatus())) {
            sysMessageVO.setSendDate(new Date());
        }
        if (StrUtil.isBlank(sysMessageVO.getType())) {
            sysMessageVO.setType(MessageConst.TYPE_NOTICE);
        }

        SysMessage sysMessage = new SysMessage();
        BeanUtil.copyProperties(sysMessageVO, sysMessage);
        boolean isSuccess = saveOrUpdate(sysMessage);
        sysMessageVO.setId(sysMessage.getId());
        if (isSuccess) {
            if (!isAdd) {
                // 清空上次设置的收信人
                sysMessageDetailsService.remove(String.valueOf(sysMessageVO.getId()));
            }
            // 保存收信人
            sysMessageDetailsService.saveData(sysMessageVO.getId(), sysMessageVO.getReceivers());

            // 处理内容中的文件
            saveContentImage(sysMessageVO.getId(), sysMessageVO.getContent());
        }
        return sysMessageVO;
    }

    private void saveContentImage(String id, String content) {
        if (StrUtil.isBlank(content)) {
            return;
        }
        String realContent = EditorUtil.moveToFormal(content);
        UpdateWrapper<SysMessage> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id)
                .set("content", realContent);
        update(updateWrapper);
    }


    @Override
    public boolean send(String ids) {
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        UpdateWrapper<SysMessage> send = new UpdateWrapper<>();
        send.set("status", MessageConst.STATUS_HAS_BEEN_SENT);
        send.set("send_date", new Date());
        send.in("id", idList);
        // 只能发送自己写的
        send.eq("create_user", SessionUtil.getCurrentUser().getId());
        return update(send);
    }

    @Override
    public int selectUnreadCount() {
        // 查询条件
        QueryWrapper<SysMessage> queryWrapper = new QueryWrapper<>();
        // 只查询接收人为自己的
        queryWrapper.eq("d.receiver_user", SessionUtil.getCurrentUser().getId());
        // 已发送
        queryWrapper.eq("m.status", MessageConst.STATUS_HAS_BEEN_SENT);
        // 未读
        queryWrapper.eq("d.status", MessageConst.RECEIVE_STATUS_UNREAD);
        return baseMapper.selectUnreadCount(queryWrapper);
    }
}