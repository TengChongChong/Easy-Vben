package com.easy.restful.file.service;

import com.easy.restful.file.model.File;
import org.springframework.web.multipart.MultipartFile;


/**
 * 文件上传
 *
 * @author tengchong
 * @date 2019-03-08
 */
public interface UploadService {
    /**
     * 文件上传
     *
     * @param file 上传的文件
     * @return file
     */
    File upload(MultipartFile file);
}
