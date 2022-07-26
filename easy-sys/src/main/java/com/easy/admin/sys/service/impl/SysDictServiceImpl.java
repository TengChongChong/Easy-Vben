package com.easy.admin.sys.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.auth.common.constant.SysRoleConst;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.exception.GlobalException;
import com.easy.admin.common.redis.constant.RedisPrefix;
import com.easy.admin.common.redis.util.RedisUtil;
import com.easy.admin.sys.common.constant.WhetherConst;
import com.easy.admin.sys.dao.SysDictMapper;
import com.easy.admin.sys.model.SysDict;
import com.easy.admin.sys.service.SysDictService;
import com.easy.admin.util.ShiroUtil;
import com.easy.admin.util.ToolUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 字典管理
 *
 * @author TengChongChong
 * @date 2018/11/4
 */
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements SysDictService {

    @Override
    public Page<SysDict> select(SysDict sysDict, Page<SysDict> page) {
        QueryWrapper<SysDict> queryWrapper = new QueryWrapper<>();
        if (sysDict != null) {
            if (Validator.isNotEmpty(sysDict.getName())) {
                queryWrapper.like("t.name", sysDict.getName());
            }
            if (Validator.isNotEmpty(sysDict.getCode())) {
                queryWrapper.like("t.code", sysDict.getCode());
            }
            if (Validator.isNotEmpty(sysDict.getDictType())) {
                queryWrapper.eq("t.dict_type", sysDict.getDictType());
            }
            if (Validator.isNotEmpty(sysDict.getStatus())) {
                if (sysDict.getStatus().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.status", sysDict.getStatus().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.status", sysDict.getStatus());
                }
            }
        }
        // 非系统管理员，仅显示非系统数据
        if (!ShiroUtil.havRole(SysRoleConst.SYS_ADMIN)) {
            queryWrapper.eq("dt.sys", WhetherConst.NO);
        }
        page.setDefaultAsc("t.dict_type, t.order_no");
        page.setRecords(baseMapper.select(page, queryWrapper));
        return page;
    }

    @Override
    public List<Select> selectByDictType(String dictType) {
        if (StrUtil.isBlank(dictType)) {
            return Collections.emptyList();
        }
        return baseMapper.selectByDictType(dictType, CommonStatus.ENABLE.getCode());
    }

    @Override
    public List<SysDict> selectDictType(List<String> dictTypes) {
        if (dictTypes == null || dictTypes.isEmpty()) {
            return Collections.emptyList();
        }
        QueryWrapper<SysDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("code, name, dict_type");
        queryWrapper.in("dict_type", dictTypes);
        return list(queryWrapper);
    }

    @Override
    public SysDict get(String id) {
        ToolUtil.checkParams(id);
        return baseMapper.selectById(id);
    }

    @Override
    public SysDict getDictByCode(String type, String code) {
        QueryWrapper<SysDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code", code);
        queryWrapper.eq("dict_type", type);
        return getOne(queryWrapper);
    }

    @Override
    public SysDict add(String parentId, String dictType) {
        SysDict object = new SysDict();
        object.setStatus(CommonStatus.ENABLE.getCode());
        object.setDictType(dictType);
        if (parentId != null) {
            SysDict parentDict = baseMapper.selectById(parentId);
            object.setParentCode(parentDict.getCode());
            // 如果点击的是新增下级字典,字典类型默认为父字典的字典类型
            object.setDictType(parentDict.getDictType());
        }
        if (Validator.isNotEmpty(object.getDictType())) {
            // 有字典类型,自动设置排序值
            object.setOrderNo(baseMapper.getMaxOrderNo(object.getDictType()) + 1);
        }
        return object;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        ToolUtil.checkParams(ids);
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        boolean isSuccess = removeByIds(idList);
        if (isSuccess) {
            RedisUtil.del(RedisPrefix.SYS_DICT);
        }
        return isSuccess;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SysDict saveData(SysDict sysDict) {
        ToolUtil.checkParams(sysDict);
        // 同一类型下字典编码不能重复
        QueryWrapper<SysDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dict_type", sysDict.getDictType());
        queryWrapper.eq("code", sysDict.getCode());
        if (sysDict.getId() != null) {
            queryWrapper.ne("id", sysDict.getId());
        }
        long count = baseMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new EasyException("字典类型 " + sysDict.getDictType() + " 中已存在编码为 " + sysDict.getCode() + " 的字典，请修改后重试");
        }
        if (sysDict.getOrderNo() == null) {
            sysDict.setOrderNo(baseMapper.getMaxOrderNo(sysDict.getDictType()) + 1);
        }

        boolean isSuccess = saveOrUpdate(sysDict);
        if (!isSuccess) {
            throw new EasyException(GlobalException.LOCK_ERROR);
        }
        refresh();
        return sysDict;
    }

    /**
     * 获取字典内容
     */
    public List<SysDict> selectAll() {
        if (RedisUtil.hasKey(RedisPrefix.SYS_DICT)) {
            return (List<SysDict>) RedisUtil.get(RedisPrefix.SYS_DICT);
        } else {
            List<SysDict> sysDictionaries = baseMapper.selectAll(CommonStatus.ENABLE.getCode());
            RedisUtil.set(RedisPrefix.SYS_DICT, sysDictionaries);
            return sysDictionaries;
        }
    }

    @Override
    public Map<String, List<SysDict>> selectDictionaries(String[] dictTypes) {
        QueryWrapper<SysDict> queryWrapper = new QueryWrapper<>();
        // 状态
        queryWrapper.eq("status", CommonStatus.ENABLE.getCode());
        queryWrapper.in("dict_type", dictTypes);
        queryWrapper.orderByAsc("dict_type, order_no");

        Map<String, List<SysDict>> dictionaries = new HashMap<>(dictTypes.length);

        for (String dictType : dictTypes) {
            dictionaries.put(dictType, new ArrayList<>());
        }

        List<SysDict> dictList = list(queryWrapper);
        if (dictList != null && !dictList.isEmpty()) {
            dictList.forEach(dict -> {
                dictionaries.get(dict.getDictType()).add(dict);
            });
        }

        return dictionaries;
    }

    @Override
    public boolean refresh() {
        RedisUtil.del(RedisPrefix.SYS_DICT);
        return true;
    }
}
