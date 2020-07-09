package com.easy.restful.common.core.common.select;

/**
 * select
 *
 * @author tengchong
 * @date 2018/11/16
 */
public class Select {
    private String value;
    private String text;

    public Select() {
    }

    public Select(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
