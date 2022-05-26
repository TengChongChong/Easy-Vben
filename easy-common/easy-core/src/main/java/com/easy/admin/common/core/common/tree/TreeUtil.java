package com.easy.admin.common.core.common.tree;


import com.easy.admin.common.core.constant.CommonConst;

/**
 * jstree 工具
 *
 * @author TengChongChong
 * @date 2019-01-22
 */
public class TreeUtil {
    /**
     * 根节点id
     */
    public final static String BASE_ID = "0";

    /**
     * 获取根节点
     *
     * @return 根节点 jstree
     */
    public static Tree getBaseNode(){
        Tree tree = new Tree();
        tree.setTitle("./");
        tree.setId(BASE_ID);
        tree.setParentId("#");
        tree.setIcon(CommonConst.DEFAULT_FOLDER_ICON);
        return tree;
    }
}
