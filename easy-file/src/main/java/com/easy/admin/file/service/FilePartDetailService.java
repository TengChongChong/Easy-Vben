package com.easy.admin.file.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.easy.admin.file.model.FilePartDetail;
import org.dromara.x.file.storage.core.upload.FilePartInfo;

/**
 * 文件分片信息表，仅在手动分片上传时使用
 *
 * @author 系统管理员
 * @date 2024-09-03
 */
public interface FilePartDetailService extends IService<FilePartDetail> {
    /**
     * 保存文件分片信息
     *
     * @param info 文件分片信息
     */
    void saveFilePart(FilePartInfo info);

    /**
     * 删除文件分片信息
     */
    void deleteFilePartByUploadId(String uploadId);

}
