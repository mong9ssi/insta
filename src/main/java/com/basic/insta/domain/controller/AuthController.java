package com.basic.insta.domain.controller;

import com.basic.insta.domain.dto.auth.LoginRequestDto;
import com.basic.insta.domain.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    // 속성
    private final AuthService service;

    // 생성자
    public AuthController(AuthService service) {
        this.service = service;
    }

    // 기능

    /**
     * 로그인 API
     */
    @PostMapping("/login")
    public ResponseEntity<String> loginAPI(@RequestBody LoginRequestDto requestDto) {
        String loginMessage = service.loginService(requestDto);
        ResponseEntity<String> response = new ResponseEntity<>(loginMessage, HttpStatus.OK);
        return response;
    }

    /**
     * 로그아웃 API
     */
    @PostMapping("/logout")
    public ResponseEntity<?> logoutAPI(@RequestParam String userEmail) {
        String logoutMessage = service.logoutService(userEmail);
        ResponseEntity<String> response = new ResponseEntity<>(logoutMessage, HttpStatus.OK);
        return response;
    }
}
