package com.easy.admin.sys.model;

/**
 * redis
 *
 * @author TengChongChong
 * @date 2019-01-25
 */
public class SysRedisVO {
    /**
     * 键
     */
    private String key;

    /**
     * 有效期
     * 单位: 秒
     */
    private Long expire;

    /**
     * 值
     */
    private Object value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getExpire() {
        return expire;
    }

    public void setExpire(Long expire) {
        this.expire = expire;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SysRedisVO{" +
                "key='" + key + '\'' +
                ", expire=" + expire +
                ", value=" + value +
                '}';
    }
}
