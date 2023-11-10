package com.easy.admin.common.core.constant.helper;

import com.easy.admin.common.core.config.properties.NodeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * NodeProperties Helper
 *
 * @author tengchong
 * @date 2022/4/14
 */
@Component
public class NodePropertiesConstantsHelper {
    public static String node;

    @Autowired
    public void setNode(NodeProperties nodeProperties) {
        node = nodeProperties.getNode();
    }
}
