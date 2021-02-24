package com.easy.restful.sys.service;

import com.easy.restful.sys.model.SysFile;

import java.util.List;

/**
 * 文件 
 *
 * @author 系统管理员
 * @date 2021-02-21
 */
public interface SysFileService {
    /**
     * 查询文件
     *
     * @param pId 父id
     * @param type 类型
     * @return List<SysFile>
     */
    List<SysFile> select(String pId, String type);

    /**
     * 删除
     *
     * @param pId  父id
     * @param type 类型
     * @return true/false
     */
    boolean delete(String pId, String type);

    /**
     * 保存
     *
     * @param object 表单内容
     * @return List<SysFile>
     */
    List<SysFile> saveData(List<SysFile> object);
}