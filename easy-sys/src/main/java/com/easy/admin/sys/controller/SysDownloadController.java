package com.easy.admin.sys.controller;

import com.easy.admin.sys.service.SysDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * 文件下载
 *
 * @author TengChongChong
 * @date 2019-11-11
 */
@Controller
public class SysDownloadController {
    @Autowired
    private SysDownloadService service;

    /**
     * 下载
     *
     * @param id 资源id
     * @return ResponseEntity
     */
    @RequestMapping("/download/{id}")
    @ResponseBody
    public ResponseEntity<FileSystemResource> downloadTemplate(@PathVariable("id") String id, HttpServletRequest request) throws UnsupportedEncodingException {
        return service.download(id, request);
    }

    /**
     * 下载SysFile数据中文件
     *
     * @param parentId         数据id
     * @param type        类型
     * @param displayName 显示名称
     * @return ResponseEntity
     */
    @RequestMapping("/download/sys/file")
    @ResponseBody
    public ResponseEntity<FileSystemResource> downloadSysFileById(
            @RequestParam("parentId") String parentId,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "displayName", required = false) String displayName,
            HttpServletRequest request
    ) throws UnsupportedEncodingException {
        return service.downloadSysFileById(parentId, type, displayName, request);
    }
}
