package com.trustscore.backend.util;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {
    private final String secret = "super_secret_jwt_key"; // 🔒 Use env var in production
    private final long expirationMs = 86400000; // 1 day

    public String generateToken(String username) {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser()
            .setSigningKey(secret)
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }

    public boolean validateToken(String token, String expectedUsername) {
        try {
            String username = getUsernameFromToken(token);
            return username.equals(expectedUsername);
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
