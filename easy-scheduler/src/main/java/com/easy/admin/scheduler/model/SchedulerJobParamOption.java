package com.easy.admin.scheduler.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 定时任务方法参数选项
 *
 * @author TengChong
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchedulerJobParamOption {

    /**
     * 参数类型
     */
    private String type;

    /**
     * 默认参数值
     */
    private String value;
}
