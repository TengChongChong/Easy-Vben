package com.easy.admin.activiti.model;

import com.baomidou.mybatisplus.annotation.TableField;
import org.activiti.engine.impl.persistence.entity.ModelEntity;
import org.dromara.x.file.storage.core.FileInfo;

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
    @TableField(exist = false)
    private String description;

    /**
     * 模型路径
     */
    private FileInfo modelFile;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FileInfo getModelFile() {
        return modelFile;
    }

    public void setModelFile(FileInfo modelFile) {
        this.modelFile = modelFile;
    }

    public ModelEntity getModelEntity() {
        ModelEntity modelEntity = new ModelEntity();
        modelEntity.setName(this.name);
        modelEntity.setKey(this.key);
        modelEntity.setCategory(this.category);
        modelEntity.setMetaInfo(this.metaInfo);
        return modelEntity;
    }


}
