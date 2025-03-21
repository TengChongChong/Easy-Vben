package com.easy.admin.file.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.common.core.util.ToolUtil;
import com.easy.admin.common.core.util.http.HttpUtil;
import com.easy.admin.file.common.constant.FileDownloadEffectiveTypeConst;
import com.easy.admin.file.dao.FileDownloadMapper;
import com.easy.admin.file.model.FileDownload;
import com.easy.admin.file.service.FileDetailService;
import com.easy.admin.file.service.FileDownloadService;
import com.easy.admin.file.util.file.FileUtil;
import org.dromara.x.file.storage.core.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

/**
 * 下载
 *
 * @author TengChong
 * @date 2019-11-11
 */
@Service
public class FileDownloadServiceImpl extends ServiceImpl<FileDownloadMapper, FileDownload> implements FileDownloadService {

    @Autowired
    private FileDetailService fileDetailService;

    /**
     * 详情
     *
     * @param id id
     * @return 详细信息
     */
    @Override
    public FileDownload get(String id) {
        return getById(id);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public FileDownload saveData(FileInfo fileInfo) {
        return saveData(new FileDownload(fileInfo.getId()));
    }

    /**
     * 保存
     *
     * @param fileDownload 表单内容
     * @return 保存后信息
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public FileDownload saveData(FileDownload fileDownload) {
        if (StrUtil.isBlank(fileDownload.getFileId())) {
            throw new EasyException("生成下载信息失败[FileId不可为空]");
        }

        // 类型
        if (StrUtil.isBlank(fileDownload.getEffectiveType())) {
            // 默认常规类型，过期时间12小时
            fileDownload.setEffectiveType(FileDownloadEffectiveTypeConst.GENERAL);
        }
        if (FileDownloadEffectiveTypeConst.GENERAL.equals(fileDownload.getEffectiveType()) && fileDownload.getExpire() == null) {
            // 常规下载默认12小时有效期
            fileDownload.setExpire(DateUtil.offsetHour(new Date(), 12));
        }
        fileDownload.setStatus(CommonStatus.ENABLE.getCode());
        return (FileDownload) ToolUtil.checkResult(saveOrUpdate(fileDownload), fileDownload);
    }

    @Override
    public ResponseEntity<Resource> download(String id, HttpServletRequest request) throws UnsupportedEncodingException {
        FileDownload fileDownload = getById(id);
        if (fileDownload == null) {
            throw new EasyException("链接不存在或已过期");
        }

        if (FileDownloadEffectiveTypeConst.GENERAL.equals(fileDownload.getEffectiveType()) && System.currentTimeMillis() > fileDownload.getExpire().getTime()) {
            throw new EasyException("链接已过期");
        }

        FileInfo fileInfo = fileDetailService.get(fileDownload.getFileId());

        return HttpUtil.getResponseEntity(
                FileUtil.getFileBytes(fileInfo),
                fileInfo.getOriginalFilename(),
                fileInfo.getSize(),
                request
        );

    }

    @Override
    public ResponseEntity<Resource> downloadFileInfoById(String objectId, String objectType, String displayName, HttpServletRequest request) throws UnsupportedEncodingException {
        List<FileInfo> fileInfoList = fileDetailService.select(objectId, objectType);
        if (fileInfoList == null || fileInfoList.isEmpty()) {
            throw new EasyException("获取文件数据失败");
        }

        if (fileInfoList.size() == 1) {
            FileInfo fileInfo = fileInfoList.get(0);
            return HttpUtil.getResponseEntity(
                    FileUtil.getFileBytes(fileInfo),
                    fileInfo.getOriginalFilename(),
                    fileInfo.getSize(),
                    request
            );
        } else {
            // todo: 多个文件打包后下载
            //String zipPath = FileUtil.getTemporaryPath() + UUID.randomUUID() + ".zip";
            //List<File> files = new ArrayList<>();
            //for (FileInfo fileInfo : fileInfoList) {
            //    File file = new File(fileInfo.getObjectName());
            //    if (file.exists()) {
            //        files.add(file);
            //    }
            //}
            //ZipUtil.zip(new File(zipPath), false, files.toArray(new File[]{}));
            //File zipFile = new File(zipPath);
            //if (StrUtil.isBlank(displayName)) {
            //    displayName = zipFile.getName();
            //}
            //return HttpUtil.getResponseEntity(zipFile, displayName, request);
            throw new EasyException("待调整");
        }
    }

    @Override
    public void cleanInvalid() {
        QueryWrapper<FileDownload> clean = new QueryWrapper<>();
        clean.eq("effective_type", FileDownloadEffectiveTypeConst.GENERAL).lt("expire", new Date());
        remove(clean);
    }
}