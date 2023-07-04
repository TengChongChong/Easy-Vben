package com.easy.admin.sys.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.ZipUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.config.properties.ProjectProperties;
import com.easy.admin.sys.common.constant.DownloadEffectiveTypeConst;
import com.easy.admin.sys.common.constant.DownloadExpireConst;
import com.easy.admin.sys.common.constant.SysConfigConst;
import com.easy.admin.sys.dao.SysDownloadMapper;
import com.easy.admin.sys.model.SysDownload;
import com.easy.admin.sys.model.SysFile;
import com.easy.admin.sys.service.SysDownloadService;
import com.easy.admin.sys.service.SysFileService;
import com.easy.admin.util.SysConfigUtil;
import com.easy.admin.util.ToolUtil;
import com.easy.admin.util.file.FileUtil;
import com.easy.admin.util.http.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 下载
 *
 * @author TengChong
 * @date 2019-11-11
 */
@Service
public class SysDownloadServiceImpl extends ServiceImpl<SysDownloadMapper, SysDownload> implements SysDownloadService {

    @Autowired
    private ProjectProperties projectProperties;

    @Autowired
    private SysFileService sysFileService;

    /**
     * 详情
     *
     * @param id id
     * @return 详细信息
     */
    @Override
    public SysDownload get(String id) {
        ToolUtil.checkParams(id);
        return getById(id);
    }

    @Override
    public SysDownload saveData(String path) {
        SysDownload object = new SysDownload();
        object.setPath(path);
        return saveData(object);
    }

    @Override
    public SysDownload saveData(String path, String name) {
        SysDownload object = new SysDownload();
        object.setPath(path);
        object.setName(name);
        return saveData(object);
    }

    /**
     * 获取系统参数中设置的常规下载链接有效时长
     *
     * @return 有效时长，单位：秒
     */
    private long getDownloadEffectiveExpire() {
        Long downloadEffectiveExpire = (Long) SysConfigUtil.get(SysConfigConst.DOWNLOAD_EFFECTIVE_EXPIRE);
        if (downloadEffectiveExpire != null) {
            return downloadEffectiveExpire;
        }
        // 默认有效期1天
        return 86400L;
    }

    @Override
    public SysDownload saveData(String path, String name, long expire) {
        SysDownload object = new SysDownload();
        object.setPath(path);
        object.setName(name);
        if (DownloadExpireConst.FOREVER == expire) {
            // 下载链接永不过期
            object.setEffectiveType(DownloadEffectiveTypeConst.FOREVER);
        } else {
            long downloadEffectiveExpire = getDownloadEffectiveExpire();
            // 设置过期时间
            object.setExpire(new Date(System.currentTimeMillis() + downloadEffectiveExpire));
        }
        return saveData(object);
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return 保存后信息
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public SysDownload saveData(SysDownload object) {
        if (StrUtil.isBlank(object.getPath())) {
            throw new EasyException("生成下载信息失败[path不可为空]");
        }
        File file = new File(object.getPath());
        // 安全限制，只能下载文件上传目录(project.file-upload-path)下文件
        if (!file.getPath().startsWith(projectProperties.getFileUploadPath())) {
            // 生成下载信息失败[只允许下载project.file-upload-path目录下文件
            throw new EasyException("生成下载信息失败[你无权访问此文件]");
        }

        if (!file.exists()) {
            throw new EasyException("生成下载信息失败[path指定的文件不存在]");
        }
        if (StrUtil.isBlank(object.getName())) {
            object.setName(file.getName());
        }
        if (StrUtil.isBlank(object.getType())) {
            object.setType(file.getName().substring(file.getName().indexOf(".") + 1));
        }
        // 字节
        object.setLength(file.length());
        // 类型
        if (StrUtil.isBlank(object.getEffectiveType())) {
            // 默认常规类型，过期时间12小时
            object.setEffectiveType(DownloadEffectiveTypeConst.GENERAL);
        }
        if (DownloadEffectiveTypeConst.GENERAL.equals(object.getEffectiveType()) && object.getExpire() == null) {
            // 常规下载默认12小时有效期
            object.setExpire(DateUtil.offsetHour(new Date(), 12));
        }
        return (SysDownload) ToolUtil.checkResult(saveOrUpdate(object), object);
    }

    @Override
    public ResponseEntity<FileSystemResource> download(String id, HttpServletRequest request) throws UnsupportedEncodingException {
        SysDownload sysDownload = getById(id);
        if (sysDownload == null) {
            throw new EasyException("链接不存在或已过期");
        }

        if (DownloadEffectiveTypeConst.GENERAL.equals(sysDownload.getEffectiveType()) && System.currentTimeMillis() > sysDownload.getExpire().getTime()) {
            throw new EasyException("链接已过期");
        }

        // 检查文件是否存在
        File file = new File(sysDownload.getPath());
        if (!file.exists()) {
            // 文件不存在
            throw new EasyException("下载链接已失效");
        }

        return HttpUtil.getResponseEntity(file, sysDownload.getName(), request);
    }

    @Override
    public ResponseEntity<FileSystemResource> downloadSysFileById(String parentId, String type, String displayName, HttpServletRequest request) throws UnsupportedEncodingException {
        List<SysFile> sysFileList = sysFileService.select(parentId, type);
        if (sysFileList == null || sysFileList.size() == 0) {
            throw new EasyException("获取文件数据失败");
        }

        if (sysFileList.size() == 1) {
            File file = new File(sysFileList.get(0).getPath());
            if (!file.exists()) {
                throw new EasyException("文件不存在");
            }
            if (StrUtil.isBlank(displayName)) {
                // 未指定文件名称
                if (StrUtil.isNotBlank(sysFileList.get(0).getDisplayName())) {
                    displayName = sysFileList.get(0).getDisplayName();
                } else {
                    displayName = file.getName();
                }
            } else {
                displayName = displayName + file.getName().substring(file.getName().lastIndexOf("."));
            }
            return HttpUtil.getResponseEntity(file, displayName, request);
        } else {
            // 多个文件打包后下载
            String zipPath = FileUtil.getTemporaryPath() + UUID.randomUUID() + ".zip";
            List<File> files = new ArrayList<>();
            for (SysFile sysFile : sysFileList) {
                File file = new File(sysFile.getPath());
                if (file.exists()) {
                    files.add(file);
                }
            }
            ZipUtil.zip(new File(zipPath), false, files.toArray(new File[]{}));
            File zipFile = new File(zipPath);
            if (StrUtil.isBlank(displayName)) {
                displayName = zipFile.getName();
            }
            return HttpUtil.getResponseEntity(zipFile, displayName, request);
        }
    }
}