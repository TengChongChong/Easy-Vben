package com.easy.admin.file.service;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.file.model.FileUploadRule;
import com.easy.admin.file.model.vo.FileUploadRuleVO;

import java.util.List;

/**
 * 文件上传规则
 *
 * @author tengchongchong
 * @date 2023-11-17
 */
public interface FileUploadRuleService {
    /**
     * 查询数据
     *
     * @param fileUploadRule 查询条件
     * @param page           分页
     * @return Page<FileUploadRule>
     */
    Page<FileUploadRule> select(FileUploadRule fileUploadRule, Page<FileUploadRule> page);

    /**
     * 获取上传规则
     *
     * @param key 规则别名
     * @return FileUploadRuleVO
     */
    FileUploadRuleVO getByKey(String key);

    /**
     * 查询所有文件夹
     *
     * @return 存放目录
     */
    List<String> selectAllDirectory();

    /**
     * 查询详情
     *
     * @param id id
     * @return FileUploadRule
     */
    FileUploadRule get(String id);

    /**
     * 新增
     *
     * @return FileUploadRule
     */
    FileUploadRule add();

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    boolean remove(String ids);

    /**
     * 保存/修改
     *
     * @param fileUploadRule 表单内容
     * @return FileUploadRule
     */
    FileUploadRule saveData(FileUploadRule fileUploadRule);

    /**
     * 设置状态
     *
     * @param id     id
     * @param status 状态
     * @return true/false
     */
    boolean setStatus(String id, String status);
}
