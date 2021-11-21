package com.easy.admin.generator.model;

import cn.hutool.core.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * *.vue 引入资源
 *
 * @author TengChongChong
 * @date 2021/1/25
 */
public class Import {
    /**
     * 资源地址
     */
    private String from;
    /**
     * 类型 eg: variable、method、component
     */
    private String type;
    /**
     * 引入对象
     */
    private List<String> imp;

    /**
     * 引入方式 eg: single、multiple
     */
    private String importType;

    private String imps;

    public Import() {
    }

    public Import(String from, String type, String importType) {
        this.from = from;
        this.type = type;
        this.importType = importType;
        this.imp = new ArrayList<>();
    }

    public Import(String from, String type, String importType, String imp) {
        this.from = from;
        this.type = type;
        this.imp = new ArrayList<>(Arrays.asList(imp.split(",")));
        this.importType = importType;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getImp() {
        return imp;
    }

    public void setImp(List<String> imp) {
        this.imp = imp;
    }

    public String getImportType() {
        return importType;
    }

    public void setImportType(String importType) {
        this.importType = importType;
    }

    public String getImps() {
        return ArrayUtil.join(this.imp.toArray(), ", ");
    }

    public void setImps(String imps) {
        this.imps = imps;
    }
}
