package com.easy.admin.cms.service;

import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.cms.model.CmsPage;
import com.easy.admin.common.core.common.select.Select;
import com.easy.admin.common.core.common.tree.Tree;

import java.util.List;

/**
 * 页面
 *
 * @author 系统管理员
 * @date 2023-06-27
 */
public interface CmsPageService {
    /**
     * 查询数据
     *
     * @param cmsPage 查询条件
     * @param page    分页
     * @return Page<CmsPage>
     */
    Page<CmsPage> select(CmsPage cmsPage, Page<CmsPage> page);

    /**
     * 查询所有页面，用于网站发布
     *
     * @return List<Tree>
     */
    List<Tree> selectAll();

    /**
     * 查询详情
     *
     * @param id id
     * @return CmsPage
     */
    CmsPage get(String id);

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
     * 保存/修改
     *
     * @param cmsPage 表单内容
     * @return CmsPage
     */
    CmsPage saveData(CmsPage cmsPage);

    /**
     * 查询主题中的页面模版
     *
     * @return 模版列表
     */
    List<Select> selectThemePageTemplate();

    /**
     * 查询页面数据 for 网站发布
     *
     * @param ids ids
     * @return List<CmsPage>
     */
    List<CmsPage> selectPages(String[] ids);
}
