package com.easy.admin.sys.service.impl;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.auth.common.constant.SysRoleConst;
import com.easy.admin.auth.model.SysUser;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.util.ToolUtil;
import com.easy.admin.sys.common.constant.ImportConst;
import com.easy.admin.sys.common.constant.WhetherConst;
import com.easy.admin.sys.dao.SysDictTypeMapper;
import com.easy.admin.sys.model.SysDictType;
import com.easy.admin.sys.service.ImportService;
import com.easy.admin.sys.service.SysDictTypeService;
import com.easy.admin.util.ShiroUtil;
import com.easy.admin.util.office.ExcelUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 字典类型
 *
 * @author TengChongChong
 * @date 2018/11/4
 */
@Service
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeMapper, SysDictType> implements SysDictTypeService, ImportService {

    @Override
    public Page<SysDictType> select(SysDictType sysDictType, Page<SysDictType> page) {
        QueryWrapper<SysDictType> queryWrapper = getQueryWrapper(sysDictType);
        page.setDefaultAsc("t.type");
        page.setRecords(baseMapper.select(page, queryWrapper));
        return page;
    }

    private QueryWrapper<SysDictType> getQueryWrapper(SysDictType sysDictType) {
        QueryWrapper<SysDictType> queryWrapper = new QueryWrapper<>();
        if (sysDictType != null) {
            if (Validator.isNotEmpty(sysDictType.getName())) {
                queryWrapper.and(i -> i.like("t.name", sysDictType.getName()).or().like("t.type", sysDictType.getName()));
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
        return queryWrapper;
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

    @Override
    public String exportData(SysDictType sysDictType) {
        QueryWrapper<SysDictType> queryWrapper = getQueryWrapper(sysDictType);
        List<SysDictType> list = baseMapper.exportData(queryWrapper);
        return ExcelUtil.writeAndGetDownloadId("字典类型", "字典类型", list, SysDictType.class);
    }

    @Override
    public boolean verificationData(String templateId, String userId) {
        baseMapper.updateDuplicateData(templateId, ImportConst.VERIFICATION_STATUS_FAIL);
        return true;
    }

    @Override
    public boolean beforeImport(String templateId, String userId) {
        return verificationData(templateId, userId);
    }

    @Override
    public boolean afterImport() {
        // 导入成功后设置一些默认信息此处仅作示例
        UpdateWrapper<SysDictType> setDefaultValue = new UpdateWrapper<>();
        Date now = new Date();
        SysUser currentUser = ShiroUtil.getCurrentUser();
        setDefaultValue.set("create_date", now);
        setDefaultValue.set("edit_date", now);
        setDefaultValue.set("create_user", currentUser.getId());
        setDefaultValue.set("edit_user", currentUser.getId());
        update(setDefaultValue);
        return true;
    }
}
