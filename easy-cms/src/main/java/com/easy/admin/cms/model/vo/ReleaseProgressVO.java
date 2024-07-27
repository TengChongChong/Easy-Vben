package com.easy.admin.cms.model.vo;

import lombok.Data;

/**
 * 发布进度
 *
 * @author tengchong
 * @date 2023/7/12
 */
@Data
public class ReleaseProgressVO {
    /**
     * 是否结束
     */
    private Boolean end;
    /**
     * 发布成功数
     */
    private Long done;
    /**
     * 发布失败数
     */
    private Long fail;

    /**
     * 时间戳
     */
    private Long timeStamp;

    public ReleaseProgressVO(Boolean end, Long done, Long fail) {
        this.end = end;
        this.done = done;
        this.fail = fail;
        this.timeStamp = System.currentTimeMillis();
    }

}
