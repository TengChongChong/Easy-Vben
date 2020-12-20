package com.easy.restful.file.controller;

import com.easy.restful.common.core.util.Response;
import com.easy.restful.file.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 *
 * @author tengchong
 * @date 2019-03-08
 */
@RestController
@RequestMapping("/auth/file")
public class UploadController {

    @Autowired
    private UploadService service;

    /**
     * 文件上传
     *
     * @param file 文件
     * @return Tips
     */
    @PostMapping("upload")
    public Response upload(@RequestParam("file") MultipartFile file) {
        return Response.success(service.upload(file));
    }
}
