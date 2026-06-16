package com.easy.admin.scheduler.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 定时任务方法选项
 *
 * @author TengChong
 */
@Data
public class SchedulerJobMethodOption {

    /**
     * 方法名
     */
    private String method;

    /**
     * 方法签名
     */
    private String signature;

    /**
     * 方法参数
     */
    private List<SchedulerJobParamOption> params = new ArrayList<>();
}
