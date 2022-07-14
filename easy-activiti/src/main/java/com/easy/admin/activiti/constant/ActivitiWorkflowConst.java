package com.easy.admin.activiti.constant;

import java.awt.*;

/**
 * 工作流
 *
 * @author TengChongChong
 * @date 2020/3/13
 */
public class ActivitiWorkflowConst {
    /**
     * 系统管理员id
     */
    public static final String INTERFACE_SYSTEM_ID = "1";

    /**
     * 系统管理员名称
     */
    public static final String INTERFACE_SYSTEM_NAME = "系统管理员";

    /**
     * 系统管理员角色标识
     */
    public static final String SYS_ADMIN_ROLE = "sys:admin";

    /**
     * 字体
     */
    public static final String TYPEFACE = "宋体";

    /**
     * 流程图颜色 - 走过的节点
     */
    public static final Color COLOR_NORMAL = new Color(83, 195, 27);
    /**
     * 流程图颜色 - 当前节点
     */
    public static final Color COLOR_CURRENT = new Color(25, 144, 255);

    /**
     * 定义生成流程图时的边距（像素）
     */
    public static final int PROCESS_PADDING = 5;
}
