package com.easy.admin.activiti.model;

import com.baomidou.mybatisplus.annotation.TableField;
import org.activiti.engine.impl.persistence.entity.ModelEntity;

/**
 * Activiti 流程模型
 *
 * @author TengChongChong
 * @date 2019-07-02
 */
public class ActivitiModel extends ModelEntity {

    /**
     * 描述
     */
    @TableField(exist=false)
    private String description;

    /**
     * 模型路径
     */
    private String path;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ModelEntity getModelEntity(){
        ModelEntity modelEntity = new ModelEntity();
        modelEntity.setName(this.name);
        modelEntity.setKey(this.key);
        modelEntity.setCategory(this.category);
        modelEntity.setMetaInfo(this.metaInfo);
        return modelEntity;
    }


}
