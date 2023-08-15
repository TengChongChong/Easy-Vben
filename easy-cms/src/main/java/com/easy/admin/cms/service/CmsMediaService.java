package com.easy.admin.cms.service;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.cms.model.CmsMedia;

/**
 * 资源
 *
 * @author 系统管理员
 * @date 2023-06-21
 */
public interface CmsMediaService {
    /**
     * 查询数据
     *
     * @param cmsMedia 查询条件
     * @param page     分页
     * @return Page<CmsMedia>
     */
    Page<CmsMedia> select(CmsMedia cmsMedia, Page<CmsMedia> page);

    /**
     * 查询指定站点下资源数量
     *
     * @param siteIds 站点ids
     * @return 文章数量
     */
    long countBySiteId(String siteIds);

    /**
     * 查询详情
     *
     * @param id id
     * @return CmsMedia
     */
    CmsMedia get(String id);

    /**
     * 新增
     *
     * @return CmsMedia
     */
    CmsMedia add();

    /**
     * 删除
     *
     * @param ids 数据ids
     * @return true/false
     */
    boolean remove(String ids);

    /**
     * 保存/修改
     *
     * @param cmsMedia 表单内容
     * @return CmsMedia
     */
    CmsMedia saveData(CmsMedia cmsMedia);

}
