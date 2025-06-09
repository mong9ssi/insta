package com.basic.insta.controller;

import com.basic.insta.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    // 속성
    private final UserService service;

    // 생성자
    public UserController(UserService service) {
        this.service = service;
    }
}
