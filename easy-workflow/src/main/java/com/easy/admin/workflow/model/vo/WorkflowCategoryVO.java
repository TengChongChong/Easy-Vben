package com.easy.admin.workflow.model.vo;

import com.easy.admin.workflow.model.WorkflowCategory;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 流程分类
 *
 * @author 系统管理员
 * @date 2025-07-12
 */
@Data
public class WorkflowCategoryVO extends WorkflowCategory implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // 非表字段
}
