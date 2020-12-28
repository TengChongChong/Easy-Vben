package com.easy.restful.sys.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.restful.common.core.common.pagination.Page;
import com.easy.restful.common.core.common.select.Select;
import com.easy.restful.common.core.common.status.CommonStatus;
import com.easy.restful.common.core.constant.CommonConst;
import com.easy.restful.common.core.exception.EasyException;
import com.easy.restful.sys.common.constant.SysConst;
import com.easy.restful.sys.dao.SysDictMapper;
import com.easy.restful.sys.dao.SysDictTypeMapper;
import com.easy.restful.sys.model.SysDict;
import com.easy.restful.sys.service.SysDictService;
import com.easy.restful.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.List;

/**
 * 字典管理
 *
 * @author tengchong
 * @date 2018/11/4
 */
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements SysDictService {


    @Autowired
    private SysDictTypeMapper dictTypeMapper;


    @Override
    public Page<SysDict> select(SysDict sysDict, Page<SysDict> page) {
        QueryWrapper<SysDict> queryWrapper = new QueryWrapper<>();
        if (sysDict != null) {
            if (Validator.isNotEmpty(sysDict.getName())) {
                queryWrapper.like("t.name", sysDict.getName());
            }
            if (Validator.isNotEmpty(sysDict.getDictType())) {
                queryWrapper.eq("t.dict_type", sysDict.getDictType());
            }
            if (Validator.isNotEmpty(sysDict.getStatus())) {
                queryWrapper.eq("t.status", sysDict.getStatus());
            }
            if (Validator.isNotEmpty(sysDict.getCode())) {
                queryWrapper.like("t.code", sysDict.getCode());
            }
            throw new EasyException("123");
        }
        page.setDefaultAsc("t.dict_type, t.order_no");
        page.setRecords(getBaseMapper().select(page, queryWrapper));
        return page;
    }

    @Override
    public List<Select> selectByDictType(String dictType) {
        ToolUtil.checkParams(dictType);
        return getBaseMapper().selectByDictType(dictType, CommonStatus.ENABLE.getCode());
    }

    @Override
    public List<SysDict> selectDictType(List<String> dictTypes) {
        if (dictTypes == null || dictTypes.size() == 0) {
            return null;
        }
        QueryWrapper<SysDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("code, name, dict_type");
        queryWrapper.in("dict_type", dictTypes);
        return list(queryWrapper);
    }

    @Override
    public SysDict get(String id) {
        ToolUtil.checkParams(id);
        return getBaseMapper().selectById(id);
    }

    @Override
    public SysDict getDictByCode(String type, String code) {
        QueryWrapper<SysDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code", code);
        queryWrapper.eq("dict_type", type);
        return getOne(queryWrapper);
    }

    @Override
    public SysDict add(String pId, String dictType) {
        SysDict object = new SysDict();
        object.setStatus(CommonStatus.ENABLE.getCode());
        object.setDictType(dictType);
        if (pId != null) {
            SysDict parentDict = getBaseMapper().selectById(pId);
            object.setpCode(parentDict.getCode());
            // 如果点击的是新增下级字典,字典类型默认为父字典的字典类型
            object.setDictType(parentDict.getDictType());
        }
        if (Validator.isNotEmpty(object.getDictType())) {
            // 有字典类型,自动设置排序值
            object.setOrderNo(getBaseMapper().getMaxOrderNo(object.getDictType()) + 1);
        }
        return object;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        ToolUtil.checkParams(ids);
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        return removeByIds(idList);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SysDict saveData(SysDict object) {
        ToolUtil.checkParams(object);
        // 同一类型下字典编码不能重复
        QueryWrapper<SysDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dict_type", object.getDictType());
        queryWrapper.eq("code", object.getCode());
        if (object.getId() != null) {
            queryWrapper.ne("id", object.getId());
        }
        int count = getBaseMapper().selectCount(queryWrapper);
        if (count > 0) {
            throw new EasyException("字典类型 " + object.getDictType() + " 中已存在编码为 " + object.getCode() + " 的字典，请修改后重试");
        }
        if (object.getOrderNo() == null) {
            object.setOrderNo(getBaseMapper().getMaxOrderNo(object.getDictType()) + 1);
        }

        return (SysDict) ToolUtil.checkResult(saveOrUpdate(object), object);
    }

    @Override
    public List<Select> selectDictType() {
        return dictTypeMapper.selectType(CommonStatus.ENABLE.getCode());
    }

    @Override
    public boolean generateDictData() {
        String dir = SysConst.projectProperties.getFileUploadPath() + CommonConst.STATIC_DATA_PATH + File.separator + "js" + File.separator + "sys-dict.js";
        File file = FileUtil.touch(dir);
        RandomAccessFile write;
        FileChannel channel;
        FileLock lock = null;
        try {
            write = new RandomAccessFile(file, "rws");
            channel = write.getChannel();
            try {
                lock = channel.lock();
            } catch (IOException e) {
                // 文件被其他线程锁定
            }
            if(lock != null){
                String content = getDictContent();
                //替换原有文件内容
                write.setLength(0);
                if (StrUtil.isNotBlank(content)) {
                    write.write(content.getBytes());
                }
                lock.release();
            }
            channel.close();
            write.close();
        } catch (IOException e) {
            // 忽略，上方已验证文件是否存在
        }
        return true;
    }

    /**
     * 获取字典内容
     */
    private String getDictContent() {
        List<SysDict> sysDictionaries = getBaseMapper().generateDictData(CommonStatus.ENABLE.getCode());
        if (Validator.isNotEmpty(sysDictionaries)) {
            JSONObject sysDictData = new JSONObject();
            String previousDictType = null;
            JSONArray temp = null;
            for (SysDict sysDict : sysDictionaries) {
                if (!sysDict.getDictType().equals(previousDictType)) {
                    if (temp != null) {
                        sysDictData.set(previousDictType, temp);
                    }
                    temp = new JSONArray();
                    previousDictType = sysDict.getDictType();
                }
                temp.add(sysDict);
            }
            sysDictData.set(previousDictType, temp);
            return "const SYS_DICT = " + sysDictData.toJSONString(0);
        }
        return null;
    }
}
