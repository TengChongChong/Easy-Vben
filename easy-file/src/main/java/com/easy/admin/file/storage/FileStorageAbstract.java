package com.easy.admin.file.storage;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.easy.admin.file.storage.common.constant.FileStoragePathConstant;

import java.util.Date;

/**
 * 文件存储
 *
 * @author TengChongChong
 * @date 2023-10-25
 **/
public abstract class FileStorageAbstract implements FileStorage {

    /**
     * 获取日期格式目录
     *
     * @return 目录 eg: 20200101
     */
    protected String getDatePath() {
        return DateUtil.format(new Date(), "yyyyMMdd");
    }

    /**
     * 检查文件是否在临时目录
     *
     * @param path 文件路径
     * @return true/false
     */
    public boolean inTemporaryPath(String path) {
        return StrUtil.isNotBlank(path) && path.contains(FileStoragePathConstant.TEMPORARY);
    }

    /**
     * 检查文件是否在正式目录
     *
     * @param path 文件路径
     * @return true/false
     */
    public boolean inFormalPath(String path) {
        return StrUtil.isNotBlank(path) && path.contains(FileStoragePathConstant.FORMAL);
    }

}
