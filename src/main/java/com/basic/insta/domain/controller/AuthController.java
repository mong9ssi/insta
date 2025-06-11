package com.basic.insta.domain.controller;

import com.basic.insta.domain.service.AuthService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    // 속성
    private final AuthService authService;

    // 생성자
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // 기능
}
