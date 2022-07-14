package com.easy.admin.file.service;

import com.easy.admin.file.model.FileModel;
import org.springframework.web.multipart.MultipartFile;


/**
 * 文件上传
 *
 * @author TengChongChong
 * @date 2019-03-08
 */
public interface UploadService {
    /**
     * 文件上传
     *
     * @param file 上传的文件
     * @return file
     */
    FileModel upload(MultipartFile file);
}
