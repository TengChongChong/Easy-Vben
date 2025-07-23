package com.easy.admin.workflow.model.vo;

import lombok.Data;
import org.activiti.engine.impl.persistence.entity.ModelEntityImpl;
import org.dromara.x.file.storage.core.FileInfo;

/**
 * 流程模型
 *
 * @author TengChongChong
 * @date 2025-07-14
 */
@Data
public class WorkflowModelVO extends ModelEntityImpl {

    /**
     * 模型分类名称
     */
    private String categoryName;

    /**
     * 描述
     */
    private String description;

    /**
     * 模型路径
     */
    private FileInfo modelFile;


    public ModelEntityImpl getModelEntity() {
        ModelEntityImpl modelEntity = new ModelEntityImpl();
        modelEntity.setName(this.name);
        modelEntity.setKey(this.key);
        modelEntity.setCategory(this.category);
        modelEntity.setMetaInfo(this.metaInfo);
        return modelEntity;
    }


}
