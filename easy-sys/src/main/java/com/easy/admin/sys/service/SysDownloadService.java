package com.easy.admin.sys.service;

import com.easy.admin.sys.model.SysDownload;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * 下载
 *
 * @author TengChong
 * @date 2019-11-11
 */
public interface SysDownloadService {
    /**
     * 详情
     *
     * @param id id
     * @return 详细信息
     */
    SysDownload get(String id);

    /**
     * 保存
     *
     * @param path 文件路径
     * @return 保存后信息
     */
    SysDownload saveData(String path);

    /**
     * 保存
     *
     * @param path 文件路径
     * @param name 显示名称
     * @return 保存后信息
     */
    SysDownload saveData(String path, String name);

    /**
     * 保存
     *
     * @param path   文件路径
     * @param name   显示名称
     * @param expire 过期时间 -1为永久
     * @return 保存后信息
     */
    SysDownload saveData(String path, String name, long expire);

    /**
     * 保存
     *
     * @param object 表单内容
     * @return 保存后信息
     */
    SysDownload saveData(SysDownload object);

    /**
     * 下载
     *
     * @param id      文件id
     * @param request request
     * @return ResponseEntity<FileSystemResource>
     * @throws UnsupportedEncodingException ex
     */
    ResponseEntity<FileSystemResource> download(String id, HttpServletRequest request) throws UnsupportedEncodingException;


    /**
     * 下载SysFile数据中文件
     *
     * @param parentId         数据id
     * @param type        类型
     * @param displayName 显示名称
     * @param request request
     * @return ResponseEntity
     * @throws UnsupportedEncodingException ex
     */
    ResponseEntity<FileSystemResource> downloadSysFileById(String parentId, String type, String displayName, HttpServletRequest request) throws UnsupportedEncodingException;


}
