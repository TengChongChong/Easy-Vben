package com.easy.admin.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.exception.GlobalException;
import com.easy.admin.sys.dao.SysQuickNavigationMapper;
import com.easy.admin.sys.model.SysQuickNavigation;
import com.easy.admin.sys.model.vo.SysQuickNavigationVO;
import com.easy.admin.sys.service.SysQuickNavigationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 快捷导航
 *
 * @author 系统管理员
 * @date 2025-07-09
 */
@Service
public class SysQuickNavigationServiceImpl extends ServiceImpl<SysQuickNavigationMapper, SysQuickNavigation> implements SysQuickNavigationService {


    @Override
    public List<SysQuickNavigationVO> select(SysQuickNavigationVO sysQuickNavigation) {
        QueryWrapper<SysQuickNavigation> queryWrapper = getQueryWrapper(sysQuickNavigation);
        //page.setDefaultAsc("t.order_no");
        //queryWrapper.orderByAsc("t.order_no");
        return baseMapper.select(queryWrapper);
    }

    @Override
    public List<SysQuickNavigationVO> selectQuickNavigationByRole(List<String> roleIds) {
        QueryWrapper<SysQuickNavigation> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("srqn.role_id", roleIds);
        queryWrapper.eq("t.status", CommonStatus.ENABLE.getCode());
        return baseMapper.selectQuickNavigationByRole(queryWrapper);
    }

    private QueryWrapper<SysQuickNavigation> getQueryWrapper(SysQuickNavigationVO sysQuickNavigation) {
        QueryWrapper<SysQuickNavigation> queryWrapper = new QueryWrapper<>();
        if (sysQuickNavigation != null) {
            // 查询条件
            // 名称
            if (Validator.isNotEmpty(sysQuickNavigation.getName())) {
                queryWrapper.like("t.name", sysQuickNavigation.getName());
            }
            // 颜色
            if (Validator.isNotEmpty(sysQuickNavigation.getColor())) {
                queryWrapper.like("t.color", sysQuickNavigation.getColor());
            }
            // 状态
            if (Validator.isNotEmpty(sysQuickNavigation.getStatus())) {
                if (sysQuickNavigation.getStatus().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.status", sysQuickNavigation.getStatus().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.status", sysQuickNavigation.getStatus());
                }
            }
        }
        return queryWrapper;
    }

    @Override
    public SysQuickNavigationVO get(String id) {
        SysQuickNavigation sysQuickNavigation = baseMapper.getById(id);
        if (sysQuickNavigation == null) {
            return null;
        }
        SysQuickNavigationVO sysQuickNavigationVO = new SysQuickNavigationVO();
        BeanUtil.copyProperties(sysQuickNavigation, sysQuickNavigationVO);
        // 查询其他相关业务数据
        return sysQuickNavigationVO;
    }

    @Override
    public SysQuickNavigationVO add() {
        SysQuickNavigationVO sysQuickNavigation = new SysQuickNavigationVO();
        // 设置默认值
        sysQuickNavigation.setStatus(CommonStatus.ENABLE.getCode());
        sysQuickNavigation.setOrderNo(baseMapper.getMaxOrderNo() + 1);
        return sysQuickNavigation;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        return removeByIds(idList);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SysQuickNavigationVO saveData(SysQuickNavigationVO sysQuickNavigationVO) {
        if (Validator.isEmpty(sysQuickNavigationVO.getId())) {
            // 新增,设置默认值
        }
        SysQuickNavigation sysQuickNavigation = new SysQuickNavigation();
        BeanUtil.copyProperties(sysQuickNavigationVO, sysQuickNavigation);
        boolean isSuccess = saveOrUpdate(sysQuickNavigation);
        if (!isSuccess) {
            throw new EasyException(GlobalException.LOCK_ERROR);
        }
        // 同步保存后的id到VO
        sysQuickNavigationVO.setId(sysQuickNavigation.getId());

        // 保存其他相关业务数据

        return sysQuickNavigationVO;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean saveOrderNo(List<SysQuickNavigation> sysQuickNavigationList) {
        if (sysQuickNavigationList.isEmpty()) {
            return true;
        }
        List<SysQuickNavigation> saveOrderList = new ArrayList<>();
        int index = 0;
        for (SysQuickNavigation sysQuickNavigation : sysQuickNavigationList) {
            index++;
            SysQuickNavigation navigation = new SysQuickNavigation();
            navigation.setId(sysQuickNavigation.getId());
            navigation.setOrderNo(index);
            saveOrderList.add(navigation);
        }

        return updateBatchById(saveOrderList);
    }
}