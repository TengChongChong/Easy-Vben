package com.easy.admin.cms.service;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.cms.model.CmsMedia;

/**
 * 资源管理
 *
 * @author TengChongChong
 * @date 2021-11-21
 */
public interface CmsMediaService {
    /**
     * 列表
     * @param object 查询条件
     * @param page   分页
     * @return Page<CmsMedia>
     */
    Page<CmsMedia> select(CmsMedia object, Page<CmsMedia> page);

    /**
     * 详情
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
     * 根据站点id删除
     *
     * @param siteId 站点id
     * @return true/false
     */
    boolean removeBySiteId(String siteId);

    /**
     * 保存
     *
     * @param object 表单内容
     * @return CmsMedia
     */
    CmsMedia saveData(CmsMedia object);

}
