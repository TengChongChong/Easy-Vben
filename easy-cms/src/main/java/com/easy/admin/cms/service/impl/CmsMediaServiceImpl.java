package com.easy.admin.cms.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.cms.common.constant.CmsMediaType;
import com.easy.admin.cms.common.type.CmsFileType;
import com.easy.admin.cms.dao.CmsMediaMapper;
import com.easy.admin.cms.model.CmsMedia;
import com.easy.admin.cms.service.CmsMediaService;
import com.easy.admin.cms.utils.CmsSiteUtil;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.sys.service.SysFileService;
import com.easy.admin.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * 资源管理
 *
 * @author TengChongChong
 * @date 2021-11-21
 */
@Service
public class CmsMediaServiceImpl extends ServiceImpl<CmsMediaMapper, CmsMedia> implements CmsMediaService {

    @Autowired
    private SysFileService sysFileService;

    /**
     * 列表
     *
     * @param object 查询条
     * @param page   分页
     * @return Page<CmsMedia>
     */
    @Override
    public Page<CmsMedia> select(CmsMedia object, Page<CmsMedia> page) {
        QueryWrapper<CmsMedia> queryWrapper = new QueryWrapper<>();
        if (object != null) {
            // 查询条件
            // 名称
            if (Validator.isNotEmpty(object.getName())) {
                queryWrapper.like("t.name", object.getName());
            }
            // 类型
            if (Validator.isNotEmpty(object.getType())) {
                queryWrapper.eq("t.type", object.getType());
            }
            // 状态
            if (Validator.isNotEmpty(object.getStatus())) {
                queryWrapper.eq("t.status", object.getStatus());
            }
        }
        queryWrapper.eq("t.site_id", CmsSiteUtil.getCurrentEditSiteId());
        page.setDefaultDesc("t.create_date");
        page.setRecords(baseMapper.select(page, queryWrapper, CmsFileType.MEDIA_FILE.getCode()));
        return page;
    }

    /**
     * 详情
     *
     * @param id id
     * @return CmsMedia
     */
    @Override
    public CmsMedia get(String id) {
        ToolUtil.checkParams(id);
        return baseMapper.getById(id);
    }

    /**
     * 新增
     *
     * @return CmsMedia
     */
    @Override
    public CmsMedia add() {
        CmsMedia object = new CmsMedia();
        // 设置默认值
        return object;
    }

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean remove(String ids) {
        ToolUtil.checkParams(ids);
        List<String> idList = Arrays.asList(ids.split(","));
        boolean isSuccess = removeByIds(idList);
        if(isSuccess){
            for (String id : idList) {
                sysFileService.delete(id);
            }
        }
        return isSuccess;
    }

    @Override
    public boolean removeBySiteId(String siteId) {
        return baseMapper.deleteBySiteId(siteId) > 0;
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return CmsMedia
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public CmsMedia saveData(CmsMedia object) {
        // 只能新增，不能修改
        if (object.getFile() != null && StrUtil.isNotBlank(object.getFile().getPath())) {
            object.setName(object.getFile().getDisplayName());
            object.setSiteId(CmsSiteUtil.getCurrentEditSiteId());
            object.setType(getType(object.getFile().getPath()));
            boolean isSuccess = saveOrUpdate(object);
            if (isSuccess) {
                object.setFile(sysFileService.saveData(object.getId(), CmsFileType.MEDIA_FILE.getCode(), object.getFile().getPath(), object.getName()));
            }
            return object;
        }
        throw new EasyException("获取文件信息失败");
    }

    private String getType(String path){
        String type = FileUtil.getType(new File(path));
        switch (type){
            case "jpg":
            case "jpeg":
            case "png":
            case "gif":
            case "bmp":
            case "tif":
                return CmsMediaType.IMAGE;
            case "mp3":
            case "cda":
            case "wav":
            case "mid":
            case "wma":
            case "ape":
                return CmsMediaType.AUDIO;
            case "mpg":
            case "mpeg":
            case "avi":
            case "rm":
            case "rmvb":
            case "mov":
            case "wmv":
            case "mp4":
                return CmsMediaType.VIDEO;
            case "xls":
            case "xlsx":
            case "doc":
            case "docx":
            case "pptx":
            case "ppt":
            case "pdf":
            case "txt":
                return CmsMediaType.DOC;
            default:
                return CmsMediaType.OTHER;
        }
    }
}