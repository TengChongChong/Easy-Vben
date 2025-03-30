package com.easy.admin.sample.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.exception.GlobalException;
import com.easy.admin.sample.dao.SampleGeneralMapper;
import com.easy.admin.sample.model.SampleGeneral;
import com.easy.admin.sample.model.vo.SampleGeneralVO;
import com.easy.admin.sample.service.SampleGeneralService;
import com.easy.admin.sys.service.ImportService;
import com.easy.admin.util.office.ExcelUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 代码生成示例
 *
 * @author 系统管理员
 * @date 2025-03-21
 */
@Service
public class SampleGeneralServiceImpl extends ServiceImpl<SampleGeneralMapper, SampleGeneral> implements SampleGeneralService, ImportService {


    @Override
    public Page<SampleGeneralVO> select(SampleGeneralVO sampleGeneral, Page<SampleGeneralVO> page) {
        QueryWrapper<SampleGeneral> queryWrapper = getQueryWrapper(sampleGeneral);
        page.setRecords(baseMapper.select(page, queryWrapper));
        return page;
    }

    private QueryWrapper<SampleGeneral> getQueryWrapper(SampleGeneralVO sampleGeneral) {
        QueryWrapper<SampleGeneral> queryWrapper = new QueryWrapper<>();
        if (sampleGeneral != null) {
            // 查询条件
            // 姓名
            if (Validator.isNotEmpty(sampleGeneral.getName())) {
                queryWrapper.like("t.name", sampleGeneral.getName());
            }
            // 性别
            if (Validator.isNotEmpty(sampleGeneral.getSex())) {
                if (sampleGeneral.getSex().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.sex", sampleGeneral.getSex().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.sex", sampleGeneral.getSex());
                }
            }
            // 手机号码
            if (Validator.isNotEmpty(sampleGeneral.getPhone())) {
                queryWrapper.like("t.phone", sampleGeneral.getPhone());
            }
            // 状态
            if (Validator.isNotEmpty(sampleGeneral.getStatus())) {
                if (sampleGeneral.getStatus().contains(CommonConst.SPLIT)) {
                    queryWrapper.in("t.status", sampleGeneral.getStatus().split(CommonConst.SPLIT));
                } else {
                    queryWrapper.eq("t.status", sampleGeneral.getStatus());
                }
            }
            // 地址
            if (Validator.isNotEmpty(sampleGeneral.getAddress())) {
                queryWrapper.like("t.address", sampleGeneral.getAddress());
            }
        }
        return queryWrapper;
    }

    @Override
    public SampleGeneralVO get(String id) {
        SampleGeneral sampleGeneral = baseMapper.getById(id);
        if (sampleGeneral == null) {
            return null;
        }
        SampleGeneralVO sampleGeneralVO = new SampleGeneralVO();
        BeanUtil.copyProperties(sampleGeneral, sampleGeneralVO);
        // 查询其他相关业务数据
        return sampleGeneralVO;
    }

    @Override
    public SampleGeneralVO add() {
        SampleGeneralVO sampleGeneral = new SampleGeneralVO();
        // 设置默认值
        return sampleGeneral;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        return removeByIds(idList);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SampleGeneralVO saveData(SampleGeneralVO sampleGeneralVO) {
        if (Validator.isEmpty(sampleGeneralVO.getId())) {
            // 新增,设置默认值
        }
        
        SampleGeneral sampleGeneral = new SampleGeneral();
        BeanUtil.copyProperties(sampleGeneralVO, sampleGeneral);
        boolean isSuccess = saveOrUpdate(sampleGeneral);
        if (!isSuccess) {
            throw new EasyException(GlobalException.LOCK_ERROR);
        }
        // 同步保存后的id到VO
        sampleGeneralVO.setId(sampleGeneral.getId());

        // 保存其他相关业务数据

        return sampleGeneralVO;
    }

    /**
     * 验证数据，插入临时表后调用
     * 注: 返回false会触发异常回滚
     *
     * @param templateId 模板id
     * @param userId     用户id
     * @return true/false
     */
    @Override
    public boolean verificationData(String templateId, String userId) {
        return true;
    }

    /**
     * 导入前回调，插入正式表之前会调用此方法，建议导入正式表之前使用次方法再次验证数据，防止验证 ~ 导入之间数据发送变动
     * 注: 返回false会触发异常回滚
     *
     * @param templateId 模板id
     * @param userId     用户id
     * @return true/false
     */
    @Override
    public boolean beforeImport(String templateId, String userId) {
        return verificationData(templateId, userId);
    }

    /**
     * 导入后回调，插入正式表后会调用此方法
     * 注: 返回false会触发异常回滚
     *
     * @return true/false
     */
    @Override
    public boolean afterImport() {
        return true;
    }

    @Override
    public String exportData(SampleGeneralVO sampleGeneral) {
        QueryWrapper<SampleGeneral> queryWrapper = getQueryWrapper(sampleGeneral);
        List<SampleGeneralVO> list = baseMapper.exportData(queryWrapper);
        return ExcelUtil.writeAndGetDownloadId("代码生成示例", "代码生成示例", list, SampleGeneralVO.class);
    }
}