package com.easy.admin.cms.service.impl;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.pinyin.PinyinUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.admin.cms.dao.CmsPageMapper;
import com.easy.admin.cms.model.CmsPage;
import com.easy.admin.cms.service.CmsPageService;
import com.easy.admin.cms.utils.CmsSiteUtil;
import com.easy.admin.common.core.common.pagination.Page;
import com.easy.admin.common.core.common.status.CommonStatus;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.common.core.constant.CommonConst;
import com.easy.admin.common.core.exception.EasyException;
import com.easy.admin.util.ToolUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 页面管理
 *
 * @author TengChongChong
 * @date 2021-11-24
 */
@Service
public class CmsPageServiceImpl extends ServiceImpl<CmsPageMapper, CmsPage> implements CmsPageService {

    /**
     * 列表
     *
     * @param object 查询条
     * @param page   分页
     * @return Page<CmsPage>
     */
    @Override
    public Page<CmsPage> select(CmsPage object, Page<CmsPage> page) {
        QueryWrapper<CmsPage> queryWrapper = new QueryWrapper<>();
        if (object != null) {
            // 查询条件
            // 标题
            if (Validator.isNotEmpty(object.getTitle())) {
                queryWrapper.like("t.title", object.getTitle());
            }
            // 别名
            if (Validator.isNotEmpty(object.getSlug())) {
                queryWrapper.like("t.slug", object.getSlug());
            }
        }
        if (object == null || StrUtil.isBlank(object.getSiteId())) {
            queryWrapper.eq("t.site_id", CmsSiteUtil.getCurrentEditSiteId());
        } else {
            queryWrapper.eq("t.site_id", object.getSiteId());
        }
        page.setDefaultDesc("t.create_date");
        page.setRecords(baseMapper.select(page, queryWrapper));
        return page;
    }

    @Override
    public List<Tree> selectAll() {
        return baseMapper.selectAll(CmsSiteUtil.getCurrentEditSiteId(), CommonStatus.ENABLE.getCode());
    }

    @Override
    public List<CmsPage> selectPages(String[] ids) {
        QueryWrapper<CmsPage> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("t.id", ids);
        queryWrapper.eq("t.status", CommonStatus.ENABLE.getCode());
        return baseMapper.selectPages(queryWrapper);
    }

    /**
     * 详情
     *
     * @param id id
     * @return CmsPage
     */
    @Override
    public CmsPage get(String id) {
        ToolUtil.checkParams(id);
        return baseMapper.getById(id);
    }

    @Override
    public CmsPage getBySlug(String siteId, String slug) {
        return baseMapper.getBySlug(siteId, slug);
    }

    /**
     * 新增
     *
     * @return CmsPage
     */
    @Override
    public CmsPage add() {
        CmsPage object = new CmsPage();
        object.setStatus(CommonStatus.ENABLE.getCode());
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
        List<String> idList = Arrays.asList(ids.split(CommonConst.SPLIT));
        return removeByIds(idList);
    }

    @Override
    public boolean removeBySiteId(String siteId) {
        return baseMapper.deleteBySiteId(siteId) > 0;
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return CmsPage
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public CmsPage saveData(CmsPage object) {
        ToolUtil.checkParams(object);
        if (StrUtil.isBlank(object.getSiteId())) {
            object.setSiteId(CmsSiteUtil.getCurrentEditSiteId());
        }
        if (StrUtil.isBlank(object.getSlug())) {
            object.setSlug(PinyinUtil.getPinyin(object.getTitle()));
        }
        // 统一小写空格替换为 "-"
        object.setSlug(object.getSlug().toLowerCase().replaceAll(" ", "-"));
        checkSlug(object);
        return (CmsPage) ToolUtil.checkResult(saveOrUpdate(object), object);
    }

    /**
     * 检查别名是否重复
     *
     * @param object 表单信息
     */
    private void checkSlug(CmsPage object) {
        QueryWrapper<CmsPage> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("slug", object.getSlug());
        if (Validator.isNotEmpty(object.getId())) {
            queryWrapper.ne("id", object.getId());
        }
        // 站点内栏目别名禁止重复
        queryWrapper.eq("site_id", object.getSiteId());
        long count = baseMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new EasyException("页面别名 " + object.getSlug() + " 已存在");
        }
    }
}