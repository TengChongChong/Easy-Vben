package com.easy.admin.cms.model.vo;

/**
 * 发布进度
 *
 * @author tengchong
 * @date 2023/7/12
 */
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

    public Boolean getEnd() {
        return end;
    }

    public void setEnd(Boolean end) {
        this.end = end;
    }

    public Long getDone() {
        return done;
    }

    public void setDone(Long done) {
        this.done = done;
    }

    public Long getFail() {
        return fail;
    }

    public void setFail(Long fail) {
        this.fail = fail;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "ReleaseProgressVO{" +
                "end=" + end +
                ", done=" + done +
                ", fail=" + fail +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
