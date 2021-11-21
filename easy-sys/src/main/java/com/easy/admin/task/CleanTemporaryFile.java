package com.easy.admin.task;

import cn.hutool.core.date.DateUtil;
import com.easy.admin.util.file.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Date;

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

    /**
     * 目录检查深度
     */
    private static final int INSPECTION_DEPTH = 3;

    /**
     * 清理48小时前的文件夹
     */
    private static final long TIME_STAMP = 2 * 24 * 60 * 60 * 1000L;

    public void clean() {
        logger.info("清除临时文件");
        File temporary = new File(FileUtil.TEMPORARY_PATH);
        if (temporary.exists() && temporary.isDirectory()) {
            clean(temporary.listFiles(), 1);
        }
    }

    /**
     * 清理文件夹
     *
     * @param subdirectories 文件列表
     * @param lev 目录深度
     */
    private void clean(File[] subdirectories, int lev) {
        if (subdirectories != null && subdirectories.length > 0) {
            for (File file : subdirectories) {
                if (file != null && file.isDirectory()) {
                    if (INSPECTION_DEPTH == lev) {
                        // 到达检查深度目录
                        clean(file);
                    } else {
                        clean(file.listFiles(), lev + 1);
                        File[] listFiles = file.listFiles();
                        if(listFiles == null || listFiles.length == 0){
                            cn.hutool.core.io.FileUtil.del(file);
                        }
                    }
                }
            }
        }
    }

    /**
     * 清理文件
     *
     * @param file 文件夹
     */
    private void clean(File file) {
        String date = file.getParentFile().getParentFile().getName() + "-" + file.getParentFile().getName() + "-" + file.getName();
        Date createDate = DateUtil.parseDate(date);
        if ((DateUtil.beginOfDay(new Date()).getTime() - createDate.getTime()) > TIME_STAMP) {
            cn.hutool.core.io.FileUtil.del(file);
        }
    }
}
