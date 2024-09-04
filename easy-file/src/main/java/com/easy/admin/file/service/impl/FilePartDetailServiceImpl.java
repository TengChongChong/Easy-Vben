package com.easy.admin.file.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.file.dao.FilePartDetailMapper;
import com.easy.admin.file.model.FilePartDetail;
import com.easy.admin.file.service.FilePartDetailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.dromara.x.file.storage.core.upload.FilePartInfo;
import org.springframework.stereotype.Service;

/**
 * 文件分片信息表，仅在手动分片上传时使用
 *
 * @author 系统管理员
 * @date 2024-09-03
 */
@Service
public class FilePartDetailServiceImpl extends ServiceImpl<FilePartDetailMapper, FilePartDetail> implements FilePartDetailService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 保存文件分片信息
     *
     * @param info 文件分片信息
     */
    @SneakyThrows
    @Override
    public void saveFilePart(FilePartInfo info) {
        FilePartDetail detail = toFilePartDetail(info);
        if (save(detail)) {
            info.setId(detail.getId());
        }
    }

    /**
     * 删除文件分片信息
     */
    @Override
    public void deleteFilePartByUploadId(String uploadId) {
        remove(new QueryWrapper<FilePartDetail>().eq("upload_id", uploadId));
    }

    /**
     * 将 FilePartInfo 转成 FilePartDetail
     *
     * @param info 文件分片信息
     */
    private FilePartDetail toFilePartDetail(FilePartInfo info) throws JsonProcessingException {
        FilePartDetail detail = new FilePartDetail();
        detail.setPlatform(info.getPlatform());
        detail.setUploadId(info.getUploadId());
        detail.setETag(info.getETag());
        detail.setPartNumber(info.getPartNumber());
        detail.setPartSize(info.getPartSize());
        detail.setHashInfo(valueToJson(info.getHashInfo()));
        detail.setCreateDate(info.getCreateTime());
        return detail;
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
}