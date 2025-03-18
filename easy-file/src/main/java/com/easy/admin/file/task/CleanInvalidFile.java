package com.easy.admin.file.task;

import com.easy.admin.file.service.FileDetailService;
import lombok.extern.slf4j.Slf4j;
import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.FileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 清理无效的文件
 * 1.用户上传的临时文件（未保存直接关闭页面）
 * 2.由于文件无法回滚，删除时仅被标记删除，延迟1小时删除
 *
 * @author TengChongChong
 * @date 2023-12-27
 */
@Slf4j
@Component
public class CleanInvalidFile {

    @Autowired
    private FileDetailService fileDetailService;

    @Autowired
    private FileStorageService fileStorageService;

    public void clean() {
        // 清除已删除文件
        log.info("清除临时文件");

        List<FileInfo> fileInfoList = fileDetailService.selectDeleted();
        if (fileInfoList == null || fileInfoList.isEmpty()) {
            return;
        }

        List<String> ids = new ArrayList<>();

        fileInfoList.forEach(fileInfo -> {
            ids.add(fileInfo.getId());
            fileStorageService.delete(fileInfo);
        });

        fileDetailService.removeByIds(ids);
    }
}
