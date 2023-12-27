package com.easy.admin.file.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.file.common.constant.FileInfoStatusConst;
import com.easy.admin.file.dao.FileInfoMapper;
import com.easy.admin.file.model.FileInfo;
import com.easy.admin.file.service.FileInfoService;
import com.easy.admin.file.storage.FileStorageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 文件
 *
 * @author TengChongChong
 * @date 2021-02-21
 */
@Service
public class FileInfoServiceImpl extends ServiceImpl<FileInfoMapper, FileInfo> implements FileInfoService {

    /**
     * 文件存储
     */
    @Autowired
    private FileStorageFactory fileStorageFactory;

    @Override
    public List<FileInfo> select(String parentId, String type) {
        QueryWrapper<FileInfo> queryWrapper = new QueryWrapper<>();
        if (parentId.contains(CommonConst.SPLIT)) {
            queryWrapper.in("parent_id", parentId.split(CommonConst.SPLIT));
        } else {
            queryWrapper.eq("parent_id", parentId);
        }
        if (StrUtil.isNotBlank(type)) {
            queryWrapper.eq("type", type);
        }
        // 只查询未删除
        queryWrapper.eq("status", FileInfoStatusConst.NORMAL);
        queryWrapper.orderByAsc("order_no");
        return baseMapper.select(queryWrapper);
    }

    @Override
    public List<FileInfo> selectDeleted() {
        QueryWrapper<FileInfo> queryWrapper = new QueryWrapper<>();
        // 只查询已删除
        queryWrapper.eq("status", FileInfoStatusConst.TO_BE_DELETED);
        return baseMapper.select(queryWrapper);
    }

    @Override
    public FileInfo selectOne(String parentId, String type) {
        QueryWrapper<FileInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", parentId);
        if (StrUtil.isNotBlank(type)) {
            queryWrapper.eq("type", type);
        }
        // 只查询未删除
        queryWrapper.eq("status", FileInfoStatusConst.NORMAL);
        queryWrapper.orderByAsc("order_no");
        return baseMapper.selectOne(queryWrapper);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean delete(String parentId, String type) {
        //List<FileInfo> fileInfoList = select(parentId, type);
        UpdateWrapper<FileInfo> setToBeDelete = new UpdateWrapper<>();
        if (parentId.contains(CommonConst.SPLIT)) {
            setToBeDelete.in("parent_id", parentId.split(CommonConst.SPLIT));
        } else {
            setToBeDelete.eq("parent_id", parentId);
        }
        if (StrUtil.isNotBlank(type)) {
            setToBeDelete.eq("type", type);
        }
        // 即将删除，防止事务回滚导致文件丢失
        setToBeDelete.set("status", FileInfoStatusConst.TO_BE_DELETED);
        return update(setToBeDelete);
        //if (isSuccess) {
        //    fileInfoList.forEach(fileInfo -> {
        //        File file = new File(fileInfo.getPath());
        //        if (file.exists()) {
        //            file.delete();
        //        }
        //    });
        //}
        //return isSuccess;
    }

    @Override
    public boolean delete(String parentId) {
        return delete(parentId, null);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean deleteData(List<String> ids) {
        return removeByIds(ids);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public List<FileInfo> saveData(List<FileInfo> fileInfoList) {
        fileInfoList.forEach(fileInfo -> {
            // 不使用前端生成的id
            fileInfo.setId(null);

            // 检查文件是否在临时目录
            if (fileStorageFactory.getFileStorage().inTemporaryPath(fileInfo.getObjectName())) {
                fileInfo.setObjectName(fileStorageFactory.getFileStorage().moveToFormal(fileInfo.getBucketName(), fileInfo.getObjectName()));
            }

            fileInfo.setStatus(FileInfoStatusConst.NORMAL);
        });
        saveBatch(fileInfoList);
        return fileInfoList;
    }

    @Override
    public FileInfo saveData(FileInfo fileInfo) {
        // 不使用前端生成的id
        fileInfo.setId(null);

        // 检查文件是否在临时目录
        if (fileStorageFactory.getFileStorage().inTemporaryPath(fileInfo.getObjectName())) {
            fileInfo.setObjectName(fileStorageFactory.getFileStorage().moveToFormal(fileInfo.getBucketName(), fileInfo.getObjectName()));
        }

        fileInfo.setStatus(FileInfoStatusConst.NORMAL);
        save(fileInfo);
        return fileInfo;
    }

    @Override
    public FileInfo saveData(String parentId, String type, FileInfo fileInfo) {
        fileInfo.setParentId(parentId);
        fileInfo.setType(type);
        return saveData(fileInfo);
    }

    @Override
    public FileInfo saveData(String parentId, String type, String bucketName, String objectName, String displayName) {
        FileInfo fileInfo = new FileInfo();
        fileInfo.setParentId(parentId);
        fileInfo.setType(type);
        fileInfo.setBucketName(bucketName);
        fileInfo.setObjectName(objectName);
        fileInfo.setDisplayName(displayName);
        return saveData(fileInfo);
    }

    @Override
    public FileInfo saveData(String parentId, String type, String bucketName, String objectName) {
        return saveData(parentId, type, bucketName, objectName, null);
    }
}