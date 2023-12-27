package com.easy.admin.file.task;

import com.easy.admin.file.model.FileInfo;
import com.easy.admin.file.service.FileInfoService;
import com.easy.admin.file.storage.FileStorageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 清理已删除的文件
 * 由于文件无法回滚，删除时仅被标记删除，在这里每小时删除已删除的文件
 *
 * @author TengChongChong
 * @date 2023-12-27
 */
@Component
public class CleanDeletedFile {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FileInfoService fileInfoService;

    @Autowired
    FileStorageFactory fileStorageFactory;

    public void clean() {
        // 清除已删除文件
        logger.info("清除临时文件");

        List<FileInfo> fileInfoList = fileInfoService.selectDeleted();
        if (fileInfoList == null || fileInfoList.isEmpty()) {
            return;
        }

        List<String> ids = new ArrayList<>();

        fileInfoList.forEach(fileInfo -> {
            ids.add(fileInfo.getId());
            fileStorageFactory.getFileStorage().removeFile(fileInfo.getBucketName(), fileInfo.getObjectName());
        });

        fileInfoService.deleteData(ids);
    }
}
