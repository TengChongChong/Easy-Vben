package com.easy.admin.file.service;

import com.easy.admin.file.model.FileUploadResponse;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 *
 * @author TengChongChong
 * @date 2019-03-08
 */
public interface FileUploadService {

    /**
     * 文件上传
     *
     * @param ruleSlug sh
     * @param file 上传的文件
     * @return file
     */
    FileUploadResponse upload(String ruleSlug, MultipartFile file);
}
