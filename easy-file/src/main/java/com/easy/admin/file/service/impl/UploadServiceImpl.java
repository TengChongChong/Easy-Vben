package com.easy.admin.file.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.file.model.FileModel;
import com.easy.admin.file.service.UploadService;
import com.easy.admin.util.file.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 文件上传
 *
 * @author TengChongChong
 * @date 2019-03-08
 */
@Service
public class UploadServiceImpl implements UploadService {

    @Override
    public FileModel upload(MultipartFile file) {
        if (!file.isEmpty()) {
            String displayName = file.getOriginalFilename();
            // todo: 检查文件后缀白名单
            if (StrUtil.isNotBlank(displayName)) {
                String suffix = displayName.substring(displayName.lastIndexOf("."));
                String fileName = IdUtil.randomUUID() + suffix;
                FileModel result = new FileModel();
                String path = FileUtil.getTemporaryPath() + fileName;
                java.io.File dest = new java.io.File(path);
                try {
                    file.transferTo(dest);
                } catch (IOException e) {
                    throw new EasyException("写入文件失败");
                }
                result.setPath(path);
                result.setDisplayName(displayName);
                result.setName(fileName);
                result.setLength(dest.length());
                result.setSuffix(suffix);
                result.setUrl(FileUtil.getUrl(path));
                return result;
            }
        }
        throw new EasyException("获取文件信息失败，请重试");
    }
}
