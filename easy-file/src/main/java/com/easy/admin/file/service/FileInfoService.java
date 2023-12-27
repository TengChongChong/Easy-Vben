package com.easy.admin.file.service;


import com.easy.admin.file.model.FileInfo;

import java.util.List;

/**
 * 文件
 *
 * @author TengChongChong
 * @date 2021-02-21
 */
public interface FileInfoService {

    /**
     * 查询文件
     *
     * @param parentId 父id
     * @param type     类型
     * @return List<FileInfo>
     */
    List<FileInfo> select(String parentId, String type);

    /**
     * 查询已删除的文件
     *
     * @return List<FileInfo>
     */
    List<FileInfo> selectDeleted();

    /**
     * 查询文件
     *
     * @param parentId 父id
     * @param type     类型
     * @return FileInfo
     */
    FileInfo selectOne(String parentId, String type);

    /**
     * 删除数据相关文件（标记删除，由定时任务删除）
     *
     * @param parentId 父id，多条使用,隔开
     * @param type     类型
     * @return true/false
     */
    boolean delete(String parentId, String type);

    /**
     * 删除数据相关文件（标记删除，由定时任务删除）
     *
     * @param parentId 父id，多条使用,隔开
     * @return true/false
     */
    boolean delete(String parentId);

    /**
     * 删除数据
     *
     * @param ids ids
     * @return true/false
     */
    boolean deleteData(List<String> ids);

    /**
     * 保存
     *
     * @param fileInfoList 文件列表
     * @return List<FileInfo>
     */
    List<FileInfo> saveData(List<FileInfo> fileInfoList);

    /**
     * 保存
     *
     * @param fileInfo fileInfo
     * @return FileInfo
     */
    FileInfo saveData(FileInfo fileInfo);

    /**
     * 保存
     *
     * @param parentId 数据id
     * @param type     文件类型
     * @param fileInfo   fileInfo
     * @return FileInfo
     */
    FileInfo saveData(String parentId, String type, FileInfo fileInfo);

    /**
     * 保存
     *
     * @param parentId    数据id
     * @param type        文件类型
     * @param bucketName  根目录（local - 文件夹名称 / oss - bucket名称）
     * @param objectName  local - 文件路径 /  oss - objectName
     * @param displayName 显示名称
     * @return FileInfo
     */
    FileInfo saveData(String parentId, String type, String bucketName, String objectName, String displayName);

    /**
     * 保存
     *
     * @param parentId   数据id
     * @param type       文件类型
     * @param bucketName 根目录（local - 文件夹名称 / oss - bucket名称）
     * @param objectName local - 文件路径 /  oss - objectName
     * @return FileInfo
     */
    FileInfo saveData(String parentId, String type, String bucketName, String objectName);
}
