package com.easy.restful.common.security.util;

import com.easy.restful.common.security.model.SecurityUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.Instant;
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
    private static final String CLAIM_KEY_USERNAME = "sub";

    /**
     * 有效期 1天
     */
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24;
    /**
     * JWT密钥
     */
    private static final String SECRET = "secret";

    /**
     * 签发JWT
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>(16);
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(Instant.now().toEpochMilli() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    /**
     * 验证JWT
     *
     * @param token token
     * @param securityUser 系统用户
     * @return true/false
     */
    public Boolean validateToken(String token, SecurityUser securityUser) {
        String username = getUsernameFromToken(token);

        return (username.equals(securityUser.getUsername()) && !isTokenExpired(token));
    }

    /**
     * 获取token是否过期
     */
    public Boolean isTokenExpired(String token) {
        Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    /**
     * 根据token获取username
     */
    public String getUsernameFromToken(String token) {
        return getClaimsFromToken(token).getSubject();
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
    private Claims getClaimsFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }
}
