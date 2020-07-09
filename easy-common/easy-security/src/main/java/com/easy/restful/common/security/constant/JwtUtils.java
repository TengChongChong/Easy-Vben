package com.easy.restful.common.security.constant;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Jwt 相关
 *
 * @author tengchong
 * @date 2020/7/8
 */
public class JwtUtils {
    /**
     * 默认 header
     */
    public static final String DEFAULT_HEADER = "{\"alg\": \"HS256\", \"typ\": \"JWT\"}";

    /**
     * HmacSha256 加密算法 密钥
     */
    public static final String SECRET = "123456";

    /**
     * token 有效期
     */
    public static final long EXPIRE_TIME = 1000 * 60 * 60 * 24;

    /**
     * token在header中的名字
     */
    public static final String HEADER_TOKEN_NAME = "Authorization";

    /**
     * Base64URL 编码
     *
     * @param input 需要编码的字符
     * @return 编码后字符
     */
    public static String encode(String input) {
        return Base64.getUrlEncoder().encodeToString(input.getBytes());
    }

    /**
     * Base64URL 解码
     *
     * @param input 要解码的字符
     * @return 解码后的字符
     */
    public static String decode(String input) {
        return new String(Base64.getUrlDecoder().decode(input));
    }

    /**
     * HmacSHA256 加密算法
     * @param data 要加密的数据
     * @param secret 秘钥
     */
    public static String HMACSHA256(String data, String secret) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte item : array) {
            sb.append(Integer.toHexString((item & 0xFF) | 0x100), 1, 3);
        }
        return sb.toString().toUpperCase();
    }

    /**
     * 读取签名
     *
     * @param payload
     * @return
     */
    public static String getSignature(String payload) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        return HMACSHA256(decode(DEFAULT_HEADER) + "." + decode(payload), SECRET);
    }

    /**
     * 验证jwt
     *
     * @param jwt
     * @return
     */
    public static String testJwt(String jwt) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        String[] jwts = jwt.split("\\.");

        if(!HMACSHA256(jwts[0] + "." + jwts[1], SECRET).equals(jwts[2])){
            return null;
        }

        if(!jwts[0].equals(decode(DEFAULT_HEADER))){
            return null;
        }

        return decode(jwts[1]);
    }

}
