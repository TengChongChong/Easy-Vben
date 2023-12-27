package com.easy.admin.file.storage.model;

import java.util.Date;

/**
 * Bucket
 *
 * @author TengChongChong
 * @date 2023-12-18
 **/
public class Bucket {

    /**
     * 桶名称
     */
    private String name;

    /**
     * 创建时间
     */
    private Date creationDate;

    public Bucket() {
    }

    public Bucket(String name) {
        this.name = name;
    }

    public Bucket(String name, Date creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
