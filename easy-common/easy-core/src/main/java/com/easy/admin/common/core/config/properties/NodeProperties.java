package com.easy.admin.common.core.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 服务节点名称
 *
 * @author TengChongChong
 * @date 2020/8/20
 */
@Configuration
public class NodeProperties {

    @Value("${project.node}")
    private String node;

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }
}
