package com.zakariyya.security01.util;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtUtils {
    private static final String secret = "5R8^n&Zy%TZ$J#ATQSNF";
    /**
     * 生成Token
     */
    public String generateToken(Map<String,Object> map) {
        return Jwts.builder()
                .setClaims(map)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS384, secret)
                .compact();
    }

    /**
     * 根据Token解析出用户信息
     */
    public Claims parseToken(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

    }
}
