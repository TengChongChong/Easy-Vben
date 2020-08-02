package com.easy.restful.common.security.constant;

/**
 * Jwt 相关
 *
 * @author tengchong
 * @date 2020/7/8
 */
public class JwtConst {
    /**
     * 自动刷新 Refresh Token
     */
    public static final boolean AUTO_REFRESH_REFRESH_TOKEN = true;

    /**
     * 被踢出的token
     */
    public static final String REDIS_PREFIX = "jwt:kick:out";

    /**
     * 存放Token的Header Key
     */
    public static final String HEADER_STRING = "Authorization";

    /**
     * Token Type
     */
    public static final String ACCESS_TYPE = "accessType";

    /**
     * 认证 Token
     */
    public static final String ACCESS_TOKEN = "accessToken";

    /**
     * 刷新 Token
     */
    public static final String REFRESH_TOKEN = "refreshToken";

    /**
     * 用户名
     */
    public static final String CLAIM_KEY_USERNAME = "username";

    /**
     * 用户 ID
     */
    public static final String CLAIM_KEY_USER_ID = "userId";

    /**
     * 部门 ID
     */
    public static final String CLAIM_KEY_DEPT_ID = "deptId";

    /**
     * 部门类型
     */
    public static final String CLAIM_KEY_DEPT_TYPE_CODE = "deptTypeCODE";

    /**
     * 角色
     */
    public static final String CLAIM_KEY_ROLES = "roles";


}
