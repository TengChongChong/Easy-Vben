package com.easy.admin.auth.model.vo.session;

import com.easy.admin.auth.model.vo.route.RouteVO;
import com.easy.admin.config.mybatis.plugins.model.DataPermission;
import com.easy.admin.file.model.FileInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 当前登录用户
 *
 * @author TengChongChong
 * @date 2018/9/4
 */
@Data
public class SessionUserVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 部门id
     */
    private String deptId;

    /**
     * 岗位id
     */
    private String postId;

    /**
     * 账号
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;
    /**
     * 密码盐
     */
    @JsonIgnore
    private String salt;

    /**
     * 性别
     */
    private String sex;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 邮箱是否验证
     */
    private boolean mailIsVerifies = true;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 账号来源
     */
    private String source;

    /**
     * 最后登录时间
     */
    private Date lastLoginDate;

    /**
     * 状态
     */
    private String status;

    /**
     * 头像
     */
    private FileInfo avatar;

    /**
     * 所属部门
     */
    private SessionDeptVO dept;

    /**
     * 角色集合
     */
    private List<SessionUserRoleVO> roleList = Collections.emptyList();

    /**
     * 用户数据权限
     */
    private List<DataPermission> dataPermissionList = Collections.emptyList();

    /**
     * 角色标识集合
     */
    private List<String> roleCodeList = Collections.emptyList();

    /**
     * 权限标识集合
     */
    private List<String> permissionCodeList = Collections.emptyList();

    /**
     * 用户路由
     */
    @JsonIgnore
    private List<RouteVO> routeList = Collections.emptyList();

}