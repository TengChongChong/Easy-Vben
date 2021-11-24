package com.easy.admin.cms.service;

import com.easy.admin.cms.model.CmsPage;
import com.easy.admin.common.core.common.pagination.Page;

/**
 * 页面管理
 *
 * @author TengChongChong
 * @date 2021-11-24
 */
public interface CmsPageService {
    /**
     * 列表
     * @param object 查询条件
     * @param page   分页
     * @return Page<CmsPage>
     */
    Page<CmsPage> select(CmsPage object, Page<CmsPage> page);

    /**
     * 详情
     *
     * @param id id
     * @return CmsPage
     */
    CmsPage get(String id);

    /**
     * 根据别名获取页面
     *
     * @param slug 别名
     * @return CmsPage
     */
    CmsPage getBySlug(String slug);

    /**
     * 新增
     *
     * @return CmsPage
     */
    CmsPage add();

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
     * @return CmsPage
     */
    CmsPage saveData(CmsPage object);

}
