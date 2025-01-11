package com.easy.admin.file.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.file.model.FileDetail;
import org.dromara.x.file.storage.core.FileInfo;

import java.util.List;

/**
 * 文件信息
 *
 * @author 系统管理员
 * @date 2024-09-03
 */
public interface FileDetailService extends IService<FileDetail> {

    /**
     * 查询数据（无分页）
     *
     * @param fileDetail 查询条件
     * @return List<FileInfo>
     */
    List<FileInfo> select(FileDetail fileDetail);

    /**
     * 查询数据
     *
     * @param fileDetail 查询条件
     * @param page       分页
     * @return Page<FileInfo>
     */
    Page<FileInfo> select(FileDetail fileDetail, Page<FileInfo> page);

    /**
     * 查询数据（无分页）
     *
     * @param objectId   文件所属对象id
     * @param objectType 文件所属对象类型，例如用户头像 user-avatar，评价图片 - comment-image
     * @return List<FileInfo>
     */
    List<FileInfo> select(String objectId, String objectType);

    /**
     * 查询单个文件
     *
     * @param objectId   文件所属对象id
     * @param objectType 文件所属对象类型，例如用户头像 user-avatar，评价图片 - comment-image
     * @return FileInfo
     */
    FileInfo getOne(String objectId, String objectType);

    /**
     * 查询单个文件
     *
     * @param objectId 文件所属对象id
     * @return FileInfo
     */
    FileInfo getOne(String objectId);

    /**
     * 查询数据
     *
     * @param objectId   文件所属对象id
     * @param objectType 文件所属对象类型，例如用户头像 user-avatar，评价图片 - comment-image
     * @param page       分页
     * @return Page<FileDetail>
     */
    Page<FileInfo> select(String objectId, String objectType, Page<FileInfo> page);

    /**
     * 查询详情
     *
     * @param id id
     * @return FileDetail
     */
    FileInfo get(String id);

    /**
     * 查询详情
     *
     * @param url url
     * @return FileDetail
     */
    FileInfo getByUrl(String url);

    /**
     * 根据objectId删除
     *
     * @param objectId   文件所属对象id
     * @param objectType 文件所属对象类型，例如用户头像 user-avatar，评价图片 - comment-image
     * @return true/false
     */
    boolean removeByObjectIdAndObjectType(String objectId, String objectType);

    /**
     * 根据objectId删除
     *
     * @param objectId objectId
     * @return true/false
     */
    boolean removeByObjectId(String objectId);


    /**
     * 根据id删除
     *
     * @param ids ids
     * @return true/false
     */
    boolean removeByIds(String ids);

    /**
     * 查询已删除的文件
     *
     * @return List<FileInfo>
     */
    List<FileInfo> selectDeleted();

    /**
     * 保存到正式目录
     *
     * @param objectId   文件所属对象id
     * @param objectType 文件所属对象类型，例如用户头像 user-avatar，评价图片 - comment-image
     * @param fileInfo   文件信息
     * @return FileInfo
     */
    FileInfo saveToFormal(String objectId, String objectType, FileInfo fileInfo);

    /**
     * 批量保存到正式目录
     *
     * @param fileInfoList 表单内容
     * @return true/false
     */
    boolean saveBatchToFormal(List<FileInfo> fileInfoList);
}
