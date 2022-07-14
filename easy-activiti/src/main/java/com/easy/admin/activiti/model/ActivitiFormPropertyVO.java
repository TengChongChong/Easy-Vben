package com.easy.admin.activiti.model;

import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.FormType;
import org.activiti.engine.impl.form.DateFormType;
import org.activiti.engine.impl.form.EnumFormType;

/**
 * 流程动态表单
 *
 * @author TengChongChong
 * @date 2021/1/18
 */
public class ActivitiFormPropertyVO implements FormProperty {

    protected String id;
    protected String name;
    protected String typeCode;
    protected FormType type;
    protected Boolean required;
    protected Boolean readable;
    protected Boolean writable;

    protected String value;
    private String datePattern;
    protected Object values;

    public ActivitiFormPropertyVO(FormProperty formProperty) {
        this.id = formProperty.getId();
        this.name = formProperty.getName();
        this.type = formProperty.getType();
        this.typeCode = formProperty.getType().getName();
        this.required = formProperty.isRequired();
        this.readable = formProperty.isReadable();
        this.writable = formProperty.isWritable();
        if (formProperty.getType() instanceof EnumFormType) {
            this.values = formProperty.getType().getInformation("values");
        } else if (formProperty.getType() instanceof DateFormType) {
            this.datePattern = (String) formProperty.getType().getInformation("datePattern");
        }
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public FormType getType() {
        return type;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean isRequired() {
        return required;
    }

    @Override
    public boolean isReadable() {
        return readable;
    }

    @Override
    public boolean isWritable() {
        return writable;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public Object getValues() {
        return values;
    }

    public String getDatePattern() {
        return datePattern;
    }

    @Override
    public String toString() {
        return "FormPropertyVO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", typeCode='" + typeCode + '\'' +
                ", type=" + type +
                ", required=" + required +
                ", readable=" + readable +
                ", writable=" + writable +
                ", value='" + value + '\'' +
                ", datePattern='" + datePattern + '\'' +
                ", values=" + values +
                '}';
    }
}
