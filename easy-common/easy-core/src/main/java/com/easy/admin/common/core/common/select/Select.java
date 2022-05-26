package com.easy.admin.common.core.common.select;

/**
 * select
 *
 * @author TengChongChong
 * @date 2018/11/16
 */
public class Select {
    private String value;
    private String label;

    public Select() {
    }

    public Select(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
