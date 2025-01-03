package com.easy.admin.file.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.redis.constant.RedisPrefix;
import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.file.dao.FileUploadRuleMapper;
import com.easy.admin.file.model.FileUploadRule;
import com.easy.admin.file.model.vo.FileUploadRuleVO;
import com.easy.admin.file.service.FileUploadRuleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 文件上传规则
 *
 * @author tengchongchong
 * @date 2023-11-17
 */
@Service
public class FileUploadRuleServiceImpl extends ServiceImpl<FileUploadRuleMapper, FileUploadRule> implements FileUploadRuleService {

    @Override
    public Page<FileUploadRule> select(FileUploadRule fileUploadRule, Page<FileUploadRule> page) {
        QueryWrapper<FileUploadRule> queryWrapper = getQueryWrapper(fileUploadRule);
        page.setDefaultAsc("t.category, t.rule_key");
        page.setRecords(baseMapper.select(page, queryWrapper));
        return page;
    }

    private QueryWrapper<FileUploadRule> getQueryWrapper(FileUploadRule fileUploadRule) {
        QueryWrapper<FileUploadRule> queryWrapper = new QueryWrapper<>();
        if (fileUploadRule != null) {
            // 查询条件
            // 名称
            if (Validator.isNotEmpty(fileUploadRule.getName())) {
                queryWrapper.like("t.name", fileUploadRule.getName());
            }
            // 别名
            if (Validator.isNotEmpty(fileUploadRule.getRuleKey())) {
                queryWrapper.like("t.rule_key", fileUploadRule.getRuleKey());
            }
            // 分类
            if (Validator.isNotEmpty(fileUploadRule.getCategory())) {
                if (fileUploadRule.getCategory().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.category", fileUploadRule.getCategory().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.category", fileUploadRule.getCategory());
                }
            }
            // 存放目录
            if (Validator.isNotEmpty(fileUploadRule.getDirectory())) {
                queryWrapper.like("t.directory", fileUploadRule.getDirectory());
            }
            // 文件后缀
            if (Validator.isNotEmpty(fileUploadRule.getSuffix())) {
                queryWrapper.like("t.suffix", fileUploadRule.getSuffix());
            }
            // 状态
            if (Validator.isNotEmpty(fileUploadRule.getStatus())) {
                if (fileUploadRule.getStatus().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.status", fileUploadRule.getStatus().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.status", fileUploadRule.getStatus());
                }
            }
        }
        return queryWrapper;
    }

    @Override
    public FileUploadRuleVO getByKey(String key) {
        FileUploadRuleVO rule = (FileUploadRuleVO) RedisUtil.get(RedisPrefix.FILE_UPLOAD_RULE + key);
        if (rule == null) {
            rule = baseMapper.getByKey(key);
            if (rule != null && StrUtil.isNotBlank(rule.getSuffix())) {
                rule.setSuffixArray(Arrays.asList(rule.getSuffix().split(CommonConst.SPLIT)));
            }
            RedisUtil.set(RedisPrefix.FILE_UPLOAD_RULE + key, rule);
        }
        return rule;
    }

    @Override
    public List<String> selectAllDirectory() {
        return baseMapper.selectAllDirectory();
    }

    @Override
    public FileUploadRule get(String id) {
        return baseMapper.getById(id);
    }

    @Override
    public FileUploadRule add() {
        FileUploadRule fileUploadRule = new FileUploadRule();
        // 设置默认值
        // 1kb
        fileUploadRule.setLowerLimit(1);
        // 10mb
        fileUploadRule.setUpperLimit(10240);
        //fileUploadRule.setCategory("default");
        fileUploadRule.setStatus(CommonStatus.ENABLE.getCode());
        return fileUploadRule;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        return removeByIds(idList);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public FileUploadRule saveData(FileUploadRule fileUploadRule) {
        if (Validator.isEmpty(fileUploadRule.getId())) {
            // 新增,设置默认值
        }

        // 规则别名不能重复
        QueryWrapper<FileUploadRule> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("rule_key", fileUploadRule.getRuleKey());
        if (fileUploadRule.getId() != null) {
            queryWrapper.ne("id", fileUploadRule.getId());
        }
        long count = baseMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new EasyException("已存在别名为 " + fileUploadRule.getRuleKey() + " 的上传规则，请修改后重试");
        }

        // 统一小写
        fileUploadRule.setSuffix(fileUploadRule.getSuffix().toLowerCase());

        boolean isSuccess = saveOrUpdate(fileUploadRule);
        if (isSuccess) {
            RedisUtil.del(RedisPrefix.FILE_UPLOAD_RULE + fileUploadRule.getRuleKey());
        }

        return fileUploadRule;
    }

    @Override
    public boolean setStatus(String id, String status) {
        UpdateWrapper<FileUploadRule> setStatus = new UpdateWrapper<>();
        setStatus.set("status", status).eq("id", id);
        return update(setStatus);
    }
}