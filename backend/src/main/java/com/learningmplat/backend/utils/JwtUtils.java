package com.learningmplat.backend.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.Map;

/**
 * JWT 工具类 (专门负责发放和校验 VIP 手环)
 */
public class JwtUtils {

    // 1. 签名密钥 (极其重要！绝密！这是验证手环真伪的唯一标准，必须超过 256 位)
    // 这里我随便敲了一串很长的字符串，在真实项目中会放在 application.properties 里
    private static final String SECRET_KEY_STRING = "LearningMPlatSecureKeyForGraduationProject2026SpringBoot3";
    private static final Key SECRET_KEY = Keys.hmacShaKeyFor(SECRET_KEY_STRING.getBytes());

    // 2. 过期时间：这里设置为 24 小时 (毫秒)
    private static final long EXPIRE_TIME = 24 * 60 * 60 * 1000L;

    /**
     * 发放手环：根据用户的 ID 和 用户名，生成一个 Token 字符串
     */
    public static String generateToken(Long userId, String username) {
        return Jwts.builder()
                // 手环里存点非敏感信息：用户的 ID 和名字
                .claim("userId", userId)
                .claim("username", username)
                // 签发时间
                .setIssuedAt(new Date())
                // 过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                // 用我们的绝密钥匙盖个章！
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * 验手环：解析传过来的 Token，把里面的 userId 等信息拿出来
     */
    public static Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY) // 拿出咱们的钥匙去比对
                .build()
                .parseClaimsJws(token) // 如果手环是伪造的或者过期了，这一步会直接报错！
                .getBody();
    }
}