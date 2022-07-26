package com.easy.admin.sys.service.impl;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.auth.common.constant.SysRoleConst;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.sys.common.constant.WhetherConst;
import com.easy.admin.sys.dao.SysDictTypeMapper;
import com.easy.admin.sys.model.SysDictType;
import com.easy.admin.sys.service.SysDictTypeService;
import com.easy.admin.util.ShiroUtil;
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
                queryWrapper.like("t.name", sysDictType.getName());
            }
            if (Validator.isNotEmpty(sysDictType.getType())) {
                queryWrapper.like("t.type", sysDictType.getType());
            }
            if (Validator.isNotEmpty(sysDictType.getSys())) {
                queryWrapper.eq("t.sys", sysDictType.getSys());
            }
            if (Validator.isNotEmpty(sysDictType.getStatus())) {
                queryWrapper.eq("t.status", sysDictType.getStatus());
            }
        }
        // 非系统管理员，仅显示非系统数据
        if (!ShiroUtil.havRole(SysRoleConst.SYS_ADMIN)) {
            queryWrapper.eq("t.sys", WhetherConst.NO);
        }
        page.setDefaultDesc("t.create_date");
        page.setRecords(baseMapper.select(page, queryWrapper));
        return page;
    }

    @Override
    public List<Select> selectAll() {
        QueryWrapper<SysDictType> queryWrapper = new QueryWrapper<>();
        // 非系统管理员，仅显示非系统数据
        if (!ShiroUtil.havRole(SysRoleConst.SYS_ADMIN)) {
            queryWrapper.eq("sys", WhetherConst.NO);
        }
        queryWrapper.eq("status", CommonStatus.ENABLE.getCode());
        queryWrapper.orderByAsc("type");
        return baseMapper.selectType(queryWrapper);
    }

    @Override
    public SysDictType get(String id) {
        return getById(id);
    }

    @Override
    public SysDictType add() {
        SysDictType sysDictType = new SysDictType();
        sysDictType.setSys(WhetherConst.NO);
        sysDictType.setStatus(CommonStatus.ENABLE.getCode());
        return sysDictType;
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
    public SysDictType saveData(SysDictType sysDictType) {
        QueryWrapper<SysDictType> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", sysDictType.getType());
        if (Validator.isNotEmpty(sysDictType.getId())) {
            queryWrapper.ne("id", sysDictType.getId());
        }
        long count = baseMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new EasyException("字典类型代码 " + sysDictType.getType() + " 已存在");
        }
        return (SysDictType) ToolUtil.checkResult(saveOrUpdate(sysDictType), sysDictType);
    }
}
