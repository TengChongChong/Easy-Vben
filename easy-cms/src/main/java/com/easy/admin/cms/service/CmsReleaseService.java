package com.easy.admin.cms.service;

import com.easy.admin.cms.model.CmsRelease;
import com.easy.admin.cms.model.vo.ReleaseProgressVO;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.tree.Tree;

import java.util.List;

/**
 * 网站发布
 *
 * @author 系统管理员
 * @date 2023-07-12
 */
public interface CmsReleaseService {
    /**
     * 查询数据
     *
     * @param cmsRelease 查询条件
     * @param page       分页
     * @return Page<CmsRelease>
     */
    Page<CmsRelease> select(CmsRelease cmsRelease, Page<CmsRelease> page);

    /**
     * 获取发布资源
     *
     * @return List<Tree>
     */
    List<Tree> selectReleaseAssets();

    /**
     * 保存/修改
     *
     * @param cmsRelease 表单内容
     * @return CmsRelease
     */
    CmsRelease saveData(CmsRelease cmsRelease);

    /**
     * 开始发布
     *
     * @param id     id
     * @param siteId 站点id
     */
    void startRelease(String id, String siteId);

    /**
     * 发布单个列队数据
     *
     * @param id id
     * @return true/false
     */
    boolean releaseQueue(String id);

    /**
     * 取消发布
     *
     * @param id id
     * @return 发布进度
     */
    ReleaseProgressVO cancelRelease(String id);

    /**
     * 获取已发布数量
     *
     * @param id id
     * @return 发布进度
     */
    ReleaseProgressVO getReleaseProgress(String id);

    /**
     * 发布资源
     *
     * @param siteId 站点id
     * @return true/false
     */
    boolean releaseAssets(String siteId);

    /**
     * 发布首页
     *
     * @param siteId 站点id
     * @return true/false
     */
    boolean releaseHome(String siteId);

    /**
     * 发布页面
     *
     * @param siteId 站点id
     * @param id     id
     * @return true/false
     */
    boolean releasePage(String siteId, String id);

    /**
     * 发布栏目列表
     *
     * @param siteId 站点id
     * @param slug   别名
     * @return true/false
     */
    boolean releaseColumn(String siteId, String slug);

    /**
     * 发布栏目列表
     *
     * @param siteId   站点id
     * @param columnId 栏目id
     * @return true/false
     */
    boolean releaseColumnById(String siteId, String columnId);

    /**
     * 发布文章
     *
     * @param siteId    站点id
     * @param articleId 文章id
     * @return true/false
     */
    boolean releaseArticle(String siteId, String articleId);

}
