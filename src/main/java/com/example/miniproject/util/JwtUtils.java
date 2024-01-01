package com.example.miniproject.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtils {
    public static String generateAccessToken(String username, String key,int expiredTimeMs) {
        Claims claims = Jwts.claims();
        claims.put("username", username);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiredTimeMs))
                .signWith(getSignKey(key), SignatureAlgorithm.HS256)
                .compact();
    }

    public static Boolean validate(String token, String username, String key) {
        String usernameByToken = getUsername(token, key);
        Date expireTime = extractAllClaims(token, key).getExpiration();

        Boolean result = expireTime.before(new Date(System.currentTimeMillis()));

        return usernameByToken.equals(username) && !result;
    }

    public static Claims extractAllClaims(String token, String key) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey(key))
                .build()
                .parseClaimsJwt(token)
                .getBody();
    }

    public static String getUsername(String token, String key) {
        return extractAllClaims(token, key).get("username", String.class);
    }

    public static Key getSignKey(String secretKey) {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }
}
