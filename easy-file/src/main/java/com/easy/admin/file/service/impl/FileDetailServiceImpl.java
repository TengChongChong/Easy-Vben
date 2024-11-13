package com.easy.admin.file.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.file.common.constant.FileInfoStatusConst;
import com.easy.admin.file.common.constant.FileStoragePathConstant;
import com.easy.admin.file.dao.FileDetailMapper;
import com.easy.admin.file.model.FileDetail;
import com.easy.admin.file.service.FileDetailService;
import com.easy.admin.file.service.FilePartDetailService;
import com.easy.admin.file.util.file.FileUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.hash.HashInfo;
import org.dromara.x.file.storage.core.recorder.FileRecorder;
import org.dromara.x.file.storage.core.upload.FilePartInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 文件信息
 *
 * @author 系统管理员
 * @date 2024-09-03
 */
@Service
public class FileDetailServiceImpl extends ServiceImpl<FileDetailMapper, FileDetail> implements FileRecorder, FileDetailService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private FilePartDetailService filePartDetailService;


    @Override
    public List<FileInfo> select(FileDetail fileDetail) {
        QueryWrapper<FileDetail> queryWrapper = getQueryWrapper(fileDetail);
        List<FileDetail> fileDetailList = baseMapper.selectWithoutPage(queryWrapper);
        List<FileInfo> fileInfoList = new ArrayList<>();
        for (FileDetail detail : fileDetailList) {
            fileInfoList.add(toFileInfo(detail));
        }
        return fileInfoList;
    }

    @Override
    public Page<FileInfo> select(FileDetail fileDetail, Page<FileInfo> page) {
        QueryWrapper<FileDetail> queryWrapper = getQueryWrapper(fileDetail);
        List<FileDetail> fileDetailList = baseMapper.select(page, queryWrapper);
        List<FileInfo> fileInfoList = new ArrayList<>();
        for (FileDetail detail : fileDetailList) {
            fileInfoList.add(toFileInfo(detail));
        }
        page.setRecords(fileInfoList);
        return page;
    }

    private QueryWrapper<FileDetail> getQueryWrapper(FileDetail fileDetail) {
        QueryWrapper<FileDetail> queryWrapper = new QueryWrapper<>();
        if (fileDetail != null) {
            // 查询条件
            queryWrapper.eq("status", FileInfoStatusConst.NORMAL);
            // 文件所属对象id
            if (Validator.isNotEmpty(fileDetail.getObjectId())) {
                queryWrapper.eq("object_id", fileDetail.getObjectId());
            }
            // 文件所属对象类型，例如用户头像 user-avatar，评价图片 - comment-image
            if (Validator.isNotEmpty(fileDetail.getObjectType())) {
                queryWrapper.eq("object_type", fileDetail.getObjectType());
            }
        }
        return queryWrapper;
    }

    @Override
    public List<FileInfo> select(String objectId, String objectType) {
        return select(new FileDetail(objectId, objectType));
    }

    @Override
    public Page<FileInfo> select(String objectId, String objectType, Page<FileInfo> page) {
        return select(new FileDetail(objectId, objectType), page);
    }

    @Override
    public FileInfo getOne(String objectId, String objectType) {
        QueryWrapper<FileDetail> queryWrapper = getQueryWrapper(new FileDetail(objectId, objectType));
        return toFileInfo(getOne(queryWrapper));
    }

    @Override
    public FileInfo getOne(String objectId) {
        QueryWrapper<FileDetail> queryWrapper = getQueryWrapper(new FileDetail(objectId));
        return toFileInfo(getOne(queryWrapper));
    }

    @Override
    public FileInfo get(String id) {
        return toFileInfo(getById(id));
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean removeByObjectId(String objectId) {
        UpdateWrapper<FileDetail> updateWrapper = new UpdateWrapper<>();
        if (objectId.contains(CommonConst.SPLIT)) {
            updateWrapper.eq("object_id", objectId.split(CommonConst.SPLIT));
        } else {
            updateWrapper.eq("object_id", objectId);
        }
        // 待删除
        updateWrapper.set("status", FileInfoStatusConst.TO_BE_DELETED);
        update(updateWrapper);
        return true;
    }

    @Override
    public boolean removeByObjectIdAndObjectType(String objectId, String objectType) {
        UpdateWrapper<FileDetail> updateWrapper = new UpdateWrapper<>();
        if (objectId.contains(CommonConst.SPLIT)) {
            updateWrapper.in("object_id", objectId.split(CommonConst.SPLIT));
        } else {
            updateWrapper.eq("object_id", objectId);
        }
        updateWrapper.eq("object_type", objectType);
        // 待删除
        updateWrapper.set("status", FileInfoStatusConst.TO_BE_DELETED);
        update(updateWrapper);
        return true;
    }

    @Override
    public List<FileInfo> selectDeleted() {
        QueryWrapper<FileDetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", FileInfoStatusConst.TO_BE_DELETED)
                .lt("delete_date", DateUtil.offsetHour(new Date(), -12));
        return baseMapper.selectDeleted(queryWrapper);
    }

    @Override
    public boolean removeByIds(String ids) {
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        return removeByIds(idList);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public FileInfo saveToFormal(String objectId, String objectType, FileInfo fileInfo) {
        if (FileUtil.inFormalPath(fileInfo.getPath())) {
            // 文件在正式目录，无需保存
            return fileInfo;
        }
        fileInfo.setObjectId(objectId);
        fileInfo.setObjectType(objectType);
        if (StrUtil.isBlank(fileInfo.getObjectId())) {
            throw new EasyException("文件保存到正式目录必须设置文件所属对象id");
        }
        return FileUtil.fileStorageService.copy(fileInfo)
                .setPath(fileInfo.getPath().replace(FileStoragePathConstant.TEMPORARY, FileStoragePathConstant.FORMAL))
                .copy();

    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean saveBatchToFormal(List<FileInfo> fileInfoList) {
        for (FileInfo fileInfo : fileInfoList) {
            saveToFormal(fileInfo.getObjectId(), fileInfo.getObjectType(), fileInfo);
        }
        return true;
    }

    /**
     * 保存文件信息到数据库
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean save(FileInfo fileInfo) {
        FileDetail detail = toFileDetail(fileInfo);
        if (StrUtil.isBlank(fileInfo.getObjectId())) {
            // 此时还未关联文件所属对象id，标记为待删除，防止用户不保存直接关闭页面
            detail.setStatus(FileInfoStatusConst.TO_BE_DELETED);
            detail.setDeleteDate(new Date());
        } else {
            detail.setStatus(FileInfoStatusConst.NORMAL);
        }

        boolean isSuccess = save(detail);
        if (isSuccess) {
            fileInfo.setId(detail.getId());
        }
        return isSuccess;
    }

    /**
     * 更新文件记录，可以根据文件 ID 或 URL 来更新文件记录，
     * 主要用在手动分片上传文件-完成上传，作用是更新文件信息
     */
    @Override
    public void update(FileInfo info) {
        FileDetail detail = toFileDetail(info);
        QueryWrapper<FileDetail> queryWrapper = new QueryWrapper<FileDetail>()
                .eq(detail.getUrl() != null, "url", detail.getUrl())
                .eq(detail.getId() != null, "id", detail.getId());
        update(detail, queryWrapper);
    }

    /**
     * 根据 url 查询文件信息
     */
    @Override
    public FileInfo getByUrl(String url) {
        return toFileInfo(getOne(new QueryWrapper<FileDetail>().eq("url", url)));
    }

    /**
     * 根据 url 删除文件信息
     */
    @Override
    public boolean delete(String url) {
        remove(new QueryWrapper<FileDetail>().eq("url", url));
        return true;
    }

    /**
     * 保存文件分片信息
     *
     * @param filePartInfo 文件分片信息
     */
    @Override
    public void saveFilePart(FilePartInfo filePartInfo) {
        filePartDetailService.saveFilePart(filePartInfo);
    }

    /**
     * 删除文件分片信息
     */
    @Override
    public void deleteFilePartByUploadId(String uploadId) {
        filePartDetailService.deleteFilePartByUploadId(uploadId);
    }

    /**
     * 将 FileInfo 转为 FileDetail
     */
    private FileDetail toFileDetail(FileInfo info) {
        if (info == null) {
            return null;
        }
        FileDetail detail = BeanUtil.copyProperties(info, FileDetail.class, "metadata", "userMetadata", "thMetadata", "thUserMetadata", "attr", "hashInfo");
        // 这里手动获 元数据 并转成 json 字符串，方便存储在数据库中
        try {
            detail.setMetadata(valueToJson(info.getMetadata()));
            detail.setUserMetadata(valueToJson(info.getUserMetadata()));
            detail.setThMetadata(valueToJson(info.getThMetadata()));
            detail.setThUserMetadata(valueToJson(info.getThUserMetadata()));
            // 这里手动获 取附加属性字典 并转成 json 字符串，方便存储在数据库中
            detail.setAttr(valueToJson(info.getAttr()));
            // 这里手动获 哈希信息 并转成 json 字符串，方便存储在数据库中
            detail.setHashInfo(valueToJson(info.getHashInfo()));
        } catch (JsonProcessingException e) {
            throw new EasyException("convert FileInfo to FileDetail fail, " + e.getMessage());
        }
        return detail;
    }

    /**
     * 将 FileDetail 转为 FileInfo
     */
    private FileInfo toFileInfo(FileDetail detail) {
        if (detail == null) {
            return null;
        }

        FileInfo info = BeanUtil.copyProperties(detail, FileInfo.class, "metadata", "userMetadata", "thMetadata", "thUserMetadata", "attr", "hashInfo");
        try {
            // 这里手动获取数据库中的 json 字符串 并转成 元数据，方便使用
            info.setMetadata(jsonToMetadata(detail.getMetadata()));
            info.setUserMetadata(jsonToMetadata(detail.getUserMetadata()));
            info.setThMetadata(jsonToMetadata(detail.getThMetadata()));
            info.setThUserMetadata(jsonToMetadata(detail.getThUserMetadata()));
            // 这里手动获取数据库中的 json 字符串 并转成 附加属性字典，方便使用
            info.setAttr(jsonToDict(detail.getAttr()));
            // 这里手动获取数据库中的 json 字符串 并转成 哈希信息，方便使用
            info.setHashInfo(jsonToHashInfo(detail.getHashInfo()));
        } catch (JsonProcessingException e) {
            throw new EasyException("convert FileInfo to FileDetail fail, " + e.getMessage());
        }
        return info;
    }

    /**
     * 将指定值转换成 json 字符串
     */
    private String valueToJson(Object value) throws JsonProcessingException {
        if (value == null) {
            return null;
        }
        return objectMapper.writeValueAsString(value);
    }

    /**
     * 将 json 字符串转换成元数据对象
     */
    private Map<String, String> jsonToMetadata(String json) throws JsonProcessingException {
        if (StrUtil.isBlank(json)) {
            return null;
        }
        return objectMapper.readValue(json, new TypeReference<Map<String, String>>() {
        });
    }

    /**
     * 将 json 字符串转换成字典对象
     */
    private Dict jsonToDict(String json) throws JsonProcessingException {
        if (StrUtil.isBlank(json)) {
            return null;
        }
        return objectMapper.readValue(json, Dict.class);
    }

    /**
     * 将 json 字符串转换成哈希信息对象
     */
    private HashInfo jsonToHashInfo(String json) throws JsonProcessingException {
        if (StrUtil.isBlank(json)) {
            return null;
        }
        return objectMapper.readValue(json, HashInfo.class);
    }
}