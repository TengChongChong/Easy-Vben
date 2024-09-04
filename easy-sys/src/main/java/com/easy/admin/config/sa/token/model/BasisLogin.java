package com.easy.admin.config.sa.token.model;

import lombok.Data;

/**
 * BasisLogin
 *
 * @author TengChongChong
 * @date 2024-09-03
 **/
@Data
public class BasisLogin {

    /**
     * 设备类型，用于在同一类型设备上只允许单地点登录，在不同类型设备上允许同时在线
     */
    private String device;
}
