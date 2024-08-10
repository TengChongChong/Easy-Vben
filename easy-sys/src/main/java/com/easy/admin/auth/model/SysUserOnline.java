package com.easy.admin.auth.model;

import com.easy.admin.auth.model.vo.session.SessionUserVO;
import lombok.Data;

import java.util.Date;

/**
 * 当前在线用户
 *
 * @author TengChongChong
 * @date 2018/9/12
 */
@Data
public class SysUserOnline extends SessionUserVO {
    /**
     * 用户所属部门
     */
    private String deptName;
    /**
     * sessionId
     */
    private String sessionId;
    /**
     * 用户主机地址
     */
    private String host;
    /**
     * 用户登录时系统IP
     */
    private String systemHost;
    /**
     * session创建时间
     */
    private Date startTimestamp;
    /**
     * session最后访问时间
     */
    private Date lastAccessTime;
    /**
     * 超时时间
     */
    private Long timeout;
}
