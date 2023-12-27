package com.easy.admin.file.controller;

import com.easy.admin.file.model.FileUploadResponse;
import com.easy.admin.file.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 *
 * @author TengChongChong
 * @date 2019-03-08
 */
@RestController
@RequestMapping("/api/auth/file")
public class FileUploadController {

    @Autowired
    private FileUploadService service;

    /**
     * 文件上传
     *
     * @param file 文件
     * @return FileUploadResponse
     */
    @PostMapping("/upload/{ruleSlug}")
    public FileUploadResponse upload(@PathVariable("ruleSlug") String ruleSlug, @RequestParam("file") MultipartFile file) {
        return service.upload(ruleSlug, file);
    }

}
