package com.easy.restful.common.security.util;

import com.easy.restful.common.core.exception.EasyException;
import com.easy.restful.common.security.common.response.Token;
import com.easy.restful.common.security.constant.JwtConst;
import com.easy.restful.common.security.exception.EasyTokenException;
import com.easy.restful.common.security.model.SecurityUser;
import com.easy.restful.sys.model.SysDept;
import com.easy.restful.sys.model.SysUser;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Jwt 工具
 *
 * @author tengchong
 * @date 2020/7/8
 */
@Component
public class JwtTokenUtils implements Serializable {
    /**
     * 主题
     */
    private static final String CLAIM_KEY_SUB = "sub";

    /**
     * access_token有效期 5 分钟
     */
    private static final Long ACCESS_TOKEN_EXPIRATION_TIME = 300000L;

    /**
     * refresh_token有效期 1天
     */
    private static final Long REFRESH_TOKEN_EXPIRATION_TIME = 86400000L;

    /**
     * JWT密钥
     */
    private static final String SECRET = "nje7ESnAM5upEWV5DEWXBGnIntXyZvOY";

    /**
     * 签发JWT
     */
    public String generateToken(SecurityUser userDetails, String type) {
        // play load
        Map<String, Object> claims = new HashMap<>(16);
        claims.put(JwtConst.CLAIM_KEY_USER_ID, userDetails.getSysUser().getId());
        claims.put(JwtConst.CLAIM_KEY_USERNAME, userDetails.getSysUser().getUsername());
        claims.put(JwtConst.CLAIM_KEY_DEPT_ID, userDetails.getSysUser().getDept().getId());
        claims.put(JwtConst.CLAIM_KEY_DEPT_TYPE_CODE, userDetails.getSysUser().getDept().getTypeCode());
        claims.put(JwtConst.CLAIM_KEY_ROLES, userDetails.getSysUser().getRoles());
        // Token Type
        claims.put(JwtConst.ACCESS_TYPE, type);
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(getExpirationTime(type))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    /**
     * 获取失效时间
     *
     * @param type token type
     * @return 失效时间
     */
    private Date getExpirationTime(String type) {
        if (JwtConst.ACCESS_TOKEN.equals(type)) {
            return new Date(Instant.now().toEpochMilli() + ACCESS_TOKEN_EXPIRATION_TIME);
        } else {
            return new Date(Instant.now().toEpochMilli() + REFRESH_TOKEN_EXPIRATION_TIME);
        }
    }

    /**
     * 验证JWT
     *
     * @param token        token
     * @param securityUser 系统用户
     * @return true/false
     */
    public Boolean validateToken(String token, SecurityUser securityUser) {
        String userId = getUserIdFromToken(token);
        return userId.equals(securityUser.getSysUser().getId()) &&
                !isTokenExpired(token);
    }

    /**
     * 获取token是否过期
     */
    public Boolean isTokenExpired(String token) {
        Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    /**
     * 从token获取userId
     */
    public String getUserIdFromToken(String token) {
        return getValueFromToken(token, JwtConst.CLAIM_KEY_USER_ID);
    }

    /**
     * 从token获取username
     */
    public String getUsernameFromToken(String token) {
        return getValueFromToken(token, JwtConst.CLAIM_KEY_USERNAME);
    }

    /**
     * 从token获取指定key
     */
    public String getValueFromToken(String token, String key) {
        return getClaimsFromToken(token).get(key, String.class);
    }

    /**
     * 获取token的过期时间
     */
    public Date getExpirationDateFromToken(String token) {
        return getClaimsFromToken(token).getExpiration();
    }

    /**
     * 解析JWT
     */
    private Claims getClaimsFromToken(String token) throws EasyException {
        try {
            return Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new EasyTokenException(Token.EXPIRED_JWT);
        } catch (UnsupportedJwtException e) {
            throw new EasyTokenException(Token.UNSUPPORTED_JWT);
        } catch (MalformedJwtException e) {
            throw new EasyTokenException(Token.MALFORMED_JWT);
        } catch (SignatureException e) {
            throw new EasyTokenException(Token.SIGNATURE);
        } catch (IllegalArgumentException e) {
            throw new EasyTokenException(Token.ILLEGAL_ARGUMENT);
        }
    }

    /**
     * 提取token中的信息封装成 SecurityUser
     *
     * @param token token
     * @return SecurityUser
     */
    public SecurityUser convert(String token) {
        SysUser sysUser = new SysUser();
        SysDept sysDept = new SysDept();

        Claims claims = getClaimsFromToken(token);

        sysUser.setId(claims.get(JwtConst.CLAIM_KEY_USER_ID, String.class));
        sysUser.setUsername(claims.get(JwtConst.CLAIM_KEY_USERNAME, String.class));
        sysUser.setUsername(claims.get(JwtConst.CLAIM_KEY_USERNAME, String.class));
        sysUser.setDeptId(claims.get(JwtConst.CLAIM_KEY_DEPT_ID, String.class));
        sysUser.setRoles(claims.get(JwtConst.CLAIM_KEY_ROLES, ArrayList.class));

        sysDept.setId(sysUser.getDeptId());
        sysDept.setTypeCode(claims.get(JwtConst.CLAIM_KEY_DEPT_TYPE_CODE, String.class));

        sysUser.setDept(sysDept);
        return new SecurityUser(sysUser);
    }

    /**
     * 是否被踢出
     *
     * @param token token
     * @return true/false
     */
    public boolean isKickOut(String token) {
        return false;
    }
}
