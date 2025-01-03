package com.easy.admin.file.service.impl;

import cn.hutool.core.util.StrUtil;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.file.model.vo.FileUploadRuleVO;
import com.easy.admin.file.service.FileUploadRuleService;
import com.easy.admin.file.service.FileUploadService;
import com.easy.admin.file.util.file.FileUtil;
import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 文件上传
 *
 * @author TengChongChong
 * @date 2019-03-08
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    private FileUploadRuleService fileUploadRuleService;

    @Autowired
    private FileStorageService fileStorageService;

    @Override
    public FileInfo upload(String ruleKey, MultipartFile file) {
        FileUploadRuleVO uploadRule = fileUploadRuleService.getByKey(ruleKey);
        if (uploadRule == null) {
            throw new EasyException("文件上传规则不存在");
        }

        if (CommonStatus.DISABLE.getCode().equals(uploadRule.getStatus())) {
            throw new EasyException("文件上传规则已禁用");
        }

        if (file.isEmpty()) {
            throw new EasyException("获取文件信息失败，请重试");
        }
        return uploadFile(file, uploadRule);
    }

    private FileInfo uploadFile(MultipartFile file, FileUploadRuleVO uploadRule) {
        // 文件名
        String displayName = file.getOriginalFilename();

        // 检查 文件大小
        if (file.getSize() >= uploadRule.getUpperLimit() * 1024) {
            throw new EasyException("上传失败[文件大小超过限制，最大" + uploadRule.getUpperLimit() + "KB]");
        }
        if (file.getSize() < uploadRule.getLowerLimit() * 1024) {
            throw new EasyException("上传失败[文件大小低于最低限制，最小" + uploadRule.getUpperLimit() + "KB]");
        }

        if (StrUtil.isBlank(displayName)) {
            throw new EasyException("上传失败[获取OriginalFilename失败]");
        }
        // 检查 MimeType
        //if (!FileUtil.getMimeType(displayName).equals(file.getContentType())) {
        //    throw new EasyException("上传失败[拓展名与MimeType]不匹配");
        //}

        // 检查拓展名
        if (uploadRule.getSuffixArray() == null || uploadRule.getSuffixArray().isEmpty()) {
            throw new EasyException("上传失败[未设置允许上传的文件拓展名]");
        }
        String suffix = displayName.substring(displayName.lastIndexOf(".") + 1).toLowerCase();
        if (!uploadRule.getSuffixArray().contains(suffix)) {
            throw new EasyException("上传失败[不允许上传拓展名为" + suffix + "的文件]");
        }

        // 存放路径，以目录分隔符（/）结尾
        String path = uploadRule.getDirectory() + File.separator + FileUtil.getTemporaryPath();

        return fileStorageService.of(file).setPath(path).upload();
    }
}
