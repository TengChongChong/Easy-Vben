package com.easy.admin.file.service;

import com.easy.admin.file.model.FileDownload;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * 下载
 *
 * @author TengChong
 * @date 2019-11-11
 */
public interface FileDownloadService {
    /**
     * 详情
     *
     * @param id id
     * @return 详细信息
     */
    FileDownload get(String id);

    /**
     * 保存
     *
     * @param bucketName local - 文件夹名称 / oss - bucket名称
     * @param objectName local - 文件路径 /  oss - objectName
     * @param displayName 显示名称
     * @return FileDownload
     */
    FileDownload saveData(String bucketName, String objectName, String displayName);

    /**
     * 保存
     *
     * @param object 表单内容
     * @return FileDownload
     */
    FileDownload saveData(FileDownload object);

    /**
     * 下载
     *
     * @param id      文件id
     * @param request request
     * @return ResponseEntity<FileSystemResource>
     * @throws UnsupportedEncodingException ex
     */
    ResponseEntity<InputStreamResource> download(String id, HttpServletRequest request) throws UnsupportedEncodingException;

    /**
     * 下载FileInfo数据中文件
     *
     * @param parentId         数据id
     * @param type        类型
     * @param displayName 显示名称
     * @param request request
     * @return ResponseEntity
     * @throws UnsupportedEncodingException ex
     */
    ResponseEntity<InputStreamResource> downloadFileInfoById(String parentId, String type, String displayName, HttpServletRequest request) throws UnsupportedEncodingException;

    /**
     * 清除无效下载链接
     */
    void cleanInvalid();
}
