package com.easy.admin.sample.service.impl;

import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.file.model.FileInfo;
import com.easy.admin.file.service.FileInfoService;
import com.easy.admin.file.service.FileDownloadService;
import com.easy.admin.file.storage.FileStorageFactory;
import com.easy.admin.sample.dao.SampleFileMapper;
import com.easy.admin.sample.model.SampleFile;
import com.easy.admin.sample.service.SampleFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 文件示例
 *
 * @author tengchongchong
 * @date 2023-12-22
 */
@Service
public class SampleFileServiceImpl extends ServiceImpl<SampleFileMapper, SampleFile> implements SampleFileService {

    /**
     * 文件存储
     */
    @Autowired
    private FileStorageFactory fileStorageFactory;

    /**
     * 文件数据
     */
    @Autowired
    private FileInfoService fileInfoService;

    /**
     * 文件下载
     */
    @Autowired
    private FileDownloadService fileDownloadService;

    @Override
    public Page<SampleFile> select(SampleFile sampleFile, Page<SampleFile> page) {
        QueryWrapper<SampleFile> queryWrapper = getQueryWrapper(sampleFile);
        page.setRecords(baseMapper.select(page, queryWrapper));
        return page;
    }

    private QueryWrapper<SampleFile> getQueryWrapper(SampleFile sampleFile) {
        QueryWrapper<SampleFile> queryWrapper = new QueryWrapper<>();
        if (sampleFile != null) {
            // 查询条件
            // 文件名
            if (Validator.isNotEmpty(sampleFile.getDisplayName())) {
                queryWrapper.like("sf.display_name", sampleFile.getDisplayName());
            }
        }
        return queryWrapper;
    }

    @Override
    public SampleFile get(String id) {
        SampleFile sampleFile = baseMapper.getById(id);
        if (sampleFile != null) {
            sampleFile.setFile(fileInfoService.selectOne(sampleFile.getId(), "file"));
        }
        return sampleFile;
    }

    @Override
    public SampleFile add() {
        SampleFile sampleFile = new SampleFile();
        // 设置默认值
        return sampleFile;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        boolean isSuccess = removeByIds(idList);
        if (isSuccess) {
            fileInfoService.delete(ids, "file");
        }
        return isSuccess;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SampleFile saveData(SampleFile sampleFile) {
        if (Validator.isEmpty(sampleFile.getId())) {
            // 新增,设置默认值
        }
        boolean isSuccess = saveOrUpdate(sampleFile);
        if (isSuccess) {
            saveFile(sampleFile.getId(), "file", sampleFile.getFile());
        }
        return sampleFile;
    }

    private void saveFile(String parentId, String type, FileInfo file) {
        if (file == null) {
            fileInfoService.delete(parentId, type);
            return;
        }

        if (fileStorageFactory.getFileStorage().inTemporaryPath(file.getObjectName())) {
            fileInfoService.delete(parentId, type);
            fileInfoService.saveData(parentId, type, file);
        }
    }

    @Override
    public String download(String id) {
        FileInfo fileInfo = fileInfoService.selectOne(id, "file");
        if (fileInfo == null) {
            throw new EasyException("请上传文件后重试");
        }

        return fileDownloadService.saveData(fileInfo.getBucketName(), fileInfo.getObjectName(), fileInfo.getDisplayName()).getId();
    }
}