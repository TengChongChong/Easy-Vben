package com.easy.admin.file.controller;

import com.easy.admin.file.model.FileModel;
import com.easy.admin.file.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 *
 * @author TengChongChong
 * @date 2019-03-08
 */
@RestController
@RequestMapping("/api/auth/file")
public class UploadController {

    @Autowired
    private UploadService service;

    /**
     * 文件上传
     *
     * @param file 文件
     * @return FileModel
     */
    @PostMapping("upload")
    public FileModel upload(@RequestParam("file") MultipartFile file) {
        return service.upload(file);
    }
}
