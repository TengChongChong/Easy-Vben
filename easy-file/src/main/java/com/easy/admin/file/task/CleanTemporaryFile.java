package com.easy.admin.file.task;

import cn.hutool.core.date.DateUtil;
import com.easy.admin.file.service.FileUploadRuleService;
import com.easy.admin.file.storage.FileStorageFactory;
import com.easy.admin.file.storage.model.StorageObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * 清理临时目录下文件
 * 由于有文件上传的业务在保存之后才会将上传的文件移动到正式目录,
 * 导致未保存的文件为为无效文件,在这里每天0点删除前天上传的文件
 *
 * @author TengChongChong
 * @date 2019-06-26
 */
@Component
public class CleanTemporaryFile {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FileUploadRuleService fileUploadRuleService;

    @Autowired
    private FileStorageFactory fileStorageFactory;

    /**
     * 清理48小时前的文件夹
     */
    private static final long TIME_STAMP = 2 * 24 * 60 * 60 * 1000L;

    public void clean() {
        // 清除临时文件
        logger.info("清除临时文件");
        List<String> bucketList = fileUploadRuleService.selectAllBucket();
        if (bucketList == null || bucketList.isEmpty()) {
            return;
        }
        bucketList.forEach(this::clean);
    }

    /**
     * 清理文件夹
     *
     * @param bucket local - 文件夹名称 / oss - bucket名称
     */
    private void clean(String bucket) {
        List<StorageObject> objectList = fileStorageFactory.getFileStorage().getAllObjectsByPrefix(bucket, "temporary", false);
        for (StorageObject storageObject : objectList) {
            clean(bucket, storageObject.getObjectName());
        }
    }

    /**
     * 清理文件
     *
     * @param bucket     local - 文件夹名称 / oss - bucket名称
     * @param objectName local - 文件路径 /  oss - objectName
     */
    private void clean(String bucket, String objectName) {
        String date = new File(objectName).getName();
        if (date.length() != 8) {
            // 非日期格式，忽略
            return;
        }
        Date createDate = DateUtil.parse(date, "yyyyMMdd");
        if ((DateUtil.beginOfDay(new Date()).getTime() - createDate.getTime()) > TIME_STAMP) {
            fileStorageFactory.getFileStorage().removeFile(bucket, objectName);
        }
    }
}
