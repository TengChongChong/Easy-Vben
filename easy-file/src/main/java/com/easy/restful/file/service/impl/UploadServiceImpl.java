package com.easy.restful.file.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.easy.restful.common.core.exception.EasyException;
import com.easy.restful.file.model.File;
import com.easy.restful.file.service.UploadService;
import com.easy.restful.util.file.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 文件上传
 *
 * @author tengchong
 * @date 2019-03-08
 */
@Service
public class UploadServiceImpl implements UploadService {

    @Override
    public File upload(MultipartFile file) {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            // todo: 检查文件后缀白名单
            if (StrUtil.isNotBlank(fileName)) {
                String suffix = fileName.substring(fileName.lastIndexOf("."));
                File result = new File();
                String path = FileUtil.getTemporaryPath() + IdUtil.randomUUID() + suffix;
                java.io.File dest = new java.io.File(path);
                try {
                    file.transferTo(dest);
                } catch (IOException e) {
                    throw new EasyException("写入文件失败");
                }
                result.setPath(path);
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
