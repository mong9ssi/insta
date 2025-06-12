package com.basic.insta.domain.service;

import com.basic.insta.domain.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {
    // 속성
    private String SECRET_KEY;

    /**
     * 토큰 만들기
     */
    public String createJwt(User user) {
        // 1. 서명 만들기
        SECRET_KEY = user.getPassword();
        SecretKey secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        // 2. 데이터 준비
        String subject = user.getUserId().toString();
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 1000 * 60 * 60); // 1시간 뒤 만료

        // 3. 토큰 만들기
        String jwt = Jwts.builder()
                .subject(subject)
                .issuedAt(now)
                .claim("name", user.getUserName())
                .expiration(expiration)
                .signWith(secretKey)
                .compact();

        return jwt;
    }


    /**
     * 토큰 검증
     */
    public long verifyToken(String token) {
        // 1. 서명 만들기
        SecretKey secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        // 2. 검증
        Claims claims = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        // 3. 사용자 추출
        String subject = claims.getSubject();

        // 4. 타입 반환
        long userId = Long.parseLong(subject);

        return userId;
    }
}
