package com.easy.admin.sys.service;

import com.easy.admin.sys.model.SysFile;

import java.util.List;

/**
 * 文件
 *
 * @author TengChongChong
 * @date 2021-02-21
 */
public interface SysFileService {
    /**
     * 查询文件
     *
     * @param parentId  父id
     * @param type 类型
     * @return List<SysFile>
     */
    List<SysFile> select(String parentId, String type);

    /**
     * 删除
     *
     * @param parentId  父id
     * @param type 类型
     * @return true/false
     */
    boolean delete(String parentId, String type);

    /**
     * 删除
     *
     * @param parentId  父id
     * @return true/false
     */
    boolean delete(String parentId);


    /**
     * 保存
     *
     * @param object 表单内容
     * @return List<SysFile>
     */
    List<SysFile> saveData(List<SysFile> object);

    /**
     * 保存
     *
     * @param object 表单内容
     * @return SysFile
     */
    SysFile saveData(SysFile object);

    /**
     * 保存
     *
     * @param parentId         数据id
     * @param type        类型
     * @param path        路径
     * @param displayName 显示名称
     * @return SysFile
     */
    SysFile saveData(String parentId, String type, String path, String displayName);
    /**
     * 保存
     *
     * @param parentId         数据id
     * @param type        类型
     * @param path        路径
     * @return SysFile
     */
    SysFile saveData(String parentId, String type, String path);
}
