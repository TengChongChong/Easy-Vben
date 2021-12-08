package com.easy.admin.cms.controller;

import com.easy.admin.cms.model.CmsColumn;
import com.easy.admin.cms.service.CmsColumnService;
import com.easy.admin.common.core.common.tree.Tree;
import com.easy.admin.core.annotation.ResponseResult;
import com.easy.admin.sys.model.DragVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 栏目
 *
 * @author TengChongChong
 * @date 2021-11-18
 */
@RestController
@ResponseResult
@RequestMapping("/auth/cms/column")
public class CmsColumnController {

    /**
     * 栏目 service
     */
    @Autowired
    private CmsColumnService service;

    /**
     * 新增
     *
     * @param pId 上级 id
     * @return CmsColumn
     */
    @GetMapping("/add/{pId}")
    public CmsColumn add(@PathVariable("pId") String pId) {
        return service.add(pId);
    }

    /**
     * 删除
     *
     * @param id id
     * @return true/false
     */
    @DeleteMapping("{id}")
    @RequiresPermissions("cms:site:remove")
    public boolean remove(@PathVariable("id") String id) {
        return service.remove(id);
    }

    /**
     * 设置状态
     *
     * @param ids    ids
     * @param status 状态
     * @return true/false
     */
    @PostMapping("{id}/status/{status}")
    @RequiresPermissions("cms:site:status")
    public boolean setStatus(@PathVariable("id") String ids, @PathVariable("status") String status) {
        return service.setStatus(ids, status);
    }

    /**
     * 复制节点到目标id
     *
     * @param nodeIds  复制的节点ids [1,2,3]
     * @param targetId 目标节点id
     * @return List<CmsColumn>
     */
    @PostMapping("copy/{nodeIds}/to/{targetId}")
    @RequiresPermissions("cms:site:save")
    public List<CmsColumn> copyNodes(@PathVariable("nodeIds") String nodeIds, @PathVariable("targetId") String targetId) {
        return service.copyNode(nodeIds, targetId);
    }

    /**
     * 保存
     *
     * @param object 表单内容
     * @return CmsColumn
     */
    @PostMapping
    @RequiresPermissions("cms:site:save")
    public CmsColumn save(@RequestBody @Valid CmsColumn object) {
        return service.saveData(object);
    }

    /**
     * 详情
     *
     * @param id id
     * @return CmsColumn
     */
    @GetMapping("{id}")
    public CmsColumn get(@PathVariable("id") String id) {
        return service.get(id);
    }

    /**
     * 根据pId获取数据
     *
     * @param pId 父id
     * @return List<JsTree>
     */
    @GetMapping("pId")
    @RequiresPermissions("cms:site:select")
    public List<Tree> selectByPId(@RequestParam(value = "pId", required = false) String pId) {
        return service.selectByPId(pId);
    }

    /**
     * 获取全部数据
     *
     * @return List<JsTree>
     */
    @GetMapping("all")
    @RequiresPermissions("cms:site:select")
    public List<Tree> selectAll() {
        return service.selectAll(true);
    }

    /**
     * 搜索
     *
     * @param title 标题
     * @return List<JsTree>
     */
    @GetMapping("title")
    @RequiresPermissions("cms:site:select")
    public List<Tree> selectByTitle(@RequestParam("title") String title) {
        return service.selectByTitle(title);
    }


    /**
     * 拖动改变目录或顺序
     *
     * @param dragVO 拖动信息
     * @return true/false
     */
    @PostMapping("move")
    @RequiresPermissions("cms:site:move")
    public boolean move(@RequestBody DragVO dragVO) {
        return service.move(dragVO.getId(), dragVO.getParent(), dragVO.getOldParent(), dragVO.getPosition(), dragVO.getOldPosition());
    }
}
