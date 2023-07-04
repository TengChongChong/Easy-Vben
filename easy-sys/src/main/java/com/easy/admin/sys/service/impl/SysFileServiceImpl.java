package com.easy.admin.sys.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.sys.dao.SysFileMapper;
import com.easy.admin.sys.model.SysFile;
import com.easy.admin.sys.service.SysFileService;
import com.easy.admin.util.file.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

/**
 * 文件
 *
 * @author TengChongChong
 * @date 2021-02-21
 */
@Service
public class SysFileServiceImpl extends ServiceImpl<SysFileMapper, SysFile> implements SysFileService {

    @Override
    public List<SysFile> select(String parentId, String type) {
        QueryWrapper<SysFile> queryWrapper = new QueryWrapper<>();
        if (parentId.contains(CommonConst.SPLIT)) {
            queryWrapper.in("parent_id", parentId.split(CommonConst.SPLIT));
        } else {
            queryWrapper.eq("parent_id", parentId);
        }
        if (StrUtil.isNotBlank(type)) {
            queryWrapper.eq("type", type);
        }
        queryWrapper.orderByAsc("order_no");
        return baseMapper.select(queryWrapper);
    }

    @Override
    public SysFile selectOne(String parentId, String type) {
        QueryWrapper<SysFile> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", parentId);
        if (StrUtil.isNotBlank(type)) {
            queryWrapper.eq("type", type);
        }
        queryWrapper.orderByAsc("order_no");
        return baseMapper.selectOne(queryWrapper);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean delete(String parentId, String type) {
        List<SysFile> sysFileList = select(parentId, type);
        QueryWrapper<SysFile> remove = new QueryWrapper<>();
        if (parentId.contains(CommonConst.SPLIT)) {
            remove.in("parent_id", parentId.split(CommonConst.SPLIT));
        } else {
            remove.eq("parent_id", parentId);
        }
        if (StrUtil.isNotBlank(type)) {
            remove.eq("type", type);
        }
        boolean isSuccess = remove(remove);
        if (isSuccess) {
            sysFileList.forEach(sysFile -> {
                File file = new File(sysFile.getPath());
                if (file.exists()) {
                    file.delete();
                }
            });
        }
        return isSuccess;
    }

    @Override
    public boolean delete(String parentId) {
        return delete(parentId, null);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public List<SysFile> saveData(List<SysFile> object) {
        object.forEach(sysFile -> {
            File file = new File(sysFile.getPath());
            if (!file.exists()) {
                throw new EasyException("保存文件失败，文件不存在[" + sysFile.getPath() + "]");
            }
            sysFile.setSize(file.length());
            sysFile.setName(file.getName());
            // 检查文件是否在临时目录
            if (FileUtil.inTemporaryPath(sysFile.getPath())) {
                sysFile.setPath(FileUtil.moveToFormal(sysFile.getPath()));
            }
        });
        saveBatch(object);
        return object;
    }

    @Override
    public SysFile saveData(SysFile object) {
        File file = new File(object.getPath());
        if (!file.exists()) {
            throw new EasyException("保存文件失败，文件不存在[" + object.getPath() + "]");
        }
        // 不使用前端生成的id
        object.setId(null);
        object.setSize(file.length());
        object.setName(file.getName());
        // 检查文件是否在临时目录
        if (FileUtil.inTemporaryPath(object.getPath())) {
            object.setPath(FileUtil.moveToFormal(object.getPath()));
        }
        save(object);
        return object;
    }

    @Override
    public SysFile saveData(String parentId, String type, String path, String displayName) {
        SysFile sysFile = new SysFile();
        sysFile.setParentId(parentId);
        sysFile.setType(type);
        sysFile.setPath(path);
        sysFile.setDisplayName(displayName);
        return saveData(sysFile);
    }

    @Override
    public SysFile saveData(String parentId, String type, String path) {
        return saveData(parentId, type, path, null);
    }
}