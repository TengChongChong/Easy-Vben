package com.easy.admin.common.core.common.tree;

import com.easy.admin.common.core.constant.CommonConst;
import lombok.Data;

/**
 * Tree 插件数据
 *
 * @author TengChongChong
 * @date 2020/10/27
 */
@Data
public class Tree {

    /**
     * 整个树范围内的所有节点的 key 值不能重复
     */
    private String id;

    /**
     * 父id
     */
    private String parentId;

    /**
     * key
     */
    private String key;

    /**
     * 标题
     */
    private String title;

    /**
     * 节点的 class
     */
    private String clazz;

    /**
     * 节点的 style
     */
    private String style;

    /**
     * 当树为 checkable 时，设置独立节点是否展示 Checkbox
     */
    private Boolean checkable;

    /**
     * 禁掉 checkbox
     */
    private boolean disableCheckbox = false;

    /**
     * 禁掉响应
     */
    private boolean disabled = false;

    /**
     * 自定义图标。可接收组件，props 为当前节点 props
     */
    private String icon;

    /**
     * 设置为叶子节点(设置了loadData时有效)
     */
    private Object isLeaf;

    /**
     * 设置节点是否可被选中
     */
    private boolean selectable = true;

    private String type;
    private String data;

    public Tree() {
    }

    public Tree(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public Tree(String id, String parentId, String title) {
        this.id = id;
        this.parentId = parentId;
        this.title = title;
    }

    public Tree(String id, String parentId, String title, String type) {
        this.id = id;
        this.parentId = parentId;
        this.title = title;
        this.type = type;
    }

    public void setIsLeaf(Object isLeaf) {
        if (isLeaf instanceof String) {
            this.isLeaf = !CommonConst.FALSE.equals(isLeaf);
        } else {
            this.isLeaf = isLeaf;
        }
    }
}
