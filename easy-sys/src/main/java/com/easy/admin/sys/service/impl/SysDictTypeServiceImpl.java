package com.easy.admin.sys.service.impl;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.sys.dao.SysDictTypeMapper;
import com.easy.admin.sys.model.SysDictType;
import com.easy.admin.sys.service.SysDictTypeService;
import com.easy.admin.util.ToolUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 字典类型
 *
 * @author TengChongChong
 * @date 2018/11/4
 */
@Service
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeMapper, SysDictType> implements SysDictTypeService {

    @Override
    public Page<SysDictType> select(SysDictType sysDictType, Page<SysDictType> page) {
        QueryWrapper<SysDictType> queryWrapper = new QueryWrapper<>();
        if (sysDictType != null) {
            if (Validator.isNotEmpty(sysDictType.getName())) {
                queryWrapper.like("name", sysDictType.getName());
            }
            if (Validator.isNotEmpty(sysDictType.getType())) {
                queryWrapper.like("type", sysDictType.getType());
            }
            if (Validator.isNotEmpty(sysDictType.getStatus())) {
                queryWrapper.eq("status", sysDictType.getStatus());
            }
        }
        return page(page, queryWrapper);
    }

    @Override
    public List<SysDictType> selectAll() {
        QueryWrapper<SysDictType> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", CommonStatus.ENABLE.getCode());
        return baseMapper.selectList(queryWrapper);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        ToolUtil.checkParams(ids);
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        QueryWrapper<SysDictType> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("dt.id", idList);
        if (baseMapper.countDict(queryWrapper) > 0) {
            throw new EasyException("所选字典类型中包含字典，请删除字典后重试");
        }
        return removeByIds(idList);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SysDictType saveData(SysDictType object) {
        ToolUtil.checkParams(object);
        if (Validator.isEmpty(object.getName())) {
            throw new EasyException("字典类型不能为空");
        }
        if (Validator.isEmpty(object.getType())) {
            throw new EasyException("字典类型名称不能为空");
        }
        QueryWrapper<SysDictType> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", object.getType());
        if (Validator.isNotEmpty(object.getId())) {
            queryWrapper.ne("id", object.getId());
        }
        int count = baseMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new EasyException("字典类型代码 " + object.getType() + " 已存在");
        }
        return (SysDictType) ToolUtil.checkResult(saveOrUpdate(object), object);
    }
}