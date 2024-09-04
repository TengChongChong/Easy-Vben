package com.easy.admin.file.util.file;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.easy.admin.file.common.constant.FileStoragePathConstant;
import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Date;

/**
 * 文件存储
 *
 * @author TengChongChong
 * @date 2024-09-04
 **/
@Component
public class FileUtil {

    /**
     * 默认路径
     */
    private static final String DEFAULT_PATH = "default";

    public static FileStorageService fileStorageService;

    public static FileInfo upload(Object source, String path, String fileName, String name) {
        return fileStorageService.of(source)
                .setPath(path)
                .setOriginalFilename(fileName)
                .setSaveFilename(name)
                .upload();
    }

    public static FileInfo upload(Object source, String fileName, String name) {
        return upload(source, DEFAULT_PATH + File.separator + FileUtil.getTemporaryPath(), fileName, name);
    }

    /**
     * 根据 FileInfo 获取 byte
     *
     * @param fileInfo fileInfo
     * @return byte[]
     */
    public static byte[] getFileBytes(FileInfo fileInfo) {
        // 获取 InputStream
        return fileStorageService.download(fileInfo).bytes();
    }


    public static String getTemporaryPath() {
        return FileStoragePathConstant.TEMPORARY + File.separator + getDatePath() + File.separator;
    }

    public static String getFormalPath() {
        return FileStoragePathConstant.FORMAL + File.separator + getDatePath() + File.separator;
    }

    /**
     * 获取日期格式目录
     *
     * @return 目录 eg: 20200101
     */
    private static String getDatePath() {
        return DateUtil.format(new Date(), "yyyyMMdd");
    }

    /**
     * 检查文件是否在临时目录
     *
     * @param path 文件路径
     * @return true/false
     */
    public static boolean inTemporaryPath(String path) {
        return StrUtil.isNotBlank(path) && path.contains(FileStoragePathConstant.TEMPORARY);
    }

    /**
     * 检查文件是否在正式目录
     *
     * @param path 文件路径
     * @return true/false
     */
    public static boolean inFormalPath(String path) {
        return StrUtil.isNotBlank(path) && path.contains(FileStoragePathConstant.FORMAL);
    }

    @Autowired
    public void setFileStorageService(FileStorageService fileStorageService) {
        FileUtil.fileStorageService = fileStorageService;
    }
}
