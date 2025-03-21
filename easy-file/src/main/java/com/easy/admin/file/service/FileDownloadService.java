package com.easy.admin.file.service;

import com.easy.admin.file.model.FileDownload;
import org.dromara.x.file.storage.core.FileInfo;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import jakarta.servlet.http.HttpServletRequest;
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
     * @param fileInfo fileInfo
     * @return FileDownload
     */
    FileDownload saveData(FileInfo fileInfo);

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
     * @return ResponseEntity<Resource>
     * @throws UnsupportedEncodingException ex
     */
    ResponseEntity<Resource> download(String id, HttpServletRequest request) throws UnsupportedEncodingException;

    /**
     * 下载FileInfo数据中文件
     *
     * @param objectId    数据id
     * @param objectType  类型
     * @param displayName 显示名称
     * @param request     request
     * @return ResponseEntity
     * @throws UnsupportedEncodingException ex
     */
    ResponseEntity<Resource> downloadFileInfoById(String objectId, String objectType, String displayName, HttpServletRequest request) throws UnsupportedEncodingException;

    /**
     * 清除无效下载链接
     */
    void cleanInvalid();
}
