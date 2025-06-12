package com.basic.insta.domain.controller;

import com.basic.insta.domain.dto.auth.LoginRequestDto;
import com.basic.insta.domain.entity.User;
import com.basic.insta.domain.service.AuthService;
import com.basic.insta.domain.service.JwtService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    // 속성
    private final AuthService authService;
    private final JwtService jwtService;

    // 생성자
    public AuthController(AuthService authService, JwtService jwtService) {
        this.authService = authService;
        this.jwtService = jwtService;
    }


    // 기능

    /**
     * 로그인 API
     */
    @PostMapping("/login")
    public ResponseEntity<String> loginAPI(@RequestBody LoginRequestDto requestDto) {
        try {
            // Email , Password 검증
            User foundUser = authService.loginService(requestDto);
            // 토큰 생성
            String token = jwtService.createJwt(foundUser);

            // 응답 헤더 설정
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Authorization", "Bearer " + token);

            ResponseEntity<String> response = new ResponseEntity<>("로그인 성공", httpHeaders, HttpStatus.OK);
            return response;
        } catch (RuntimeException e) {
            ResponseEntity<String> response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            return response;
        }

    }

    /**
     * 로그아웃 API
     */
    @PostMapping("/logout")
    public ResponseEntity<?> logoutAPI(@RequestParam String userEmail) {


        String logoutMessage = authService.logoutService(userEmail);
        ResponseEntity<String> response = new ResponseEntity<>(logoutMessage, HttpStatus.OK);
        return response;
    }
}
