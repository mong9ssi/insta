package com.basic.insta.controller;

import com.basic.insta.dto.user.UserCreateRequestDto;
import com.basic.insta.dto.user.UserCreateResponseDto;
import com.basic.insta.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

    // 기능
    @PostMapping
    public ResponseEntity<?> createUserAPI(@Valid @RequestBody UserCreateRequestDto requestDto) {
            UserCreateResponseDto responseDto = service.CreateUserService(requestDto);
            ResponseEntity<UserCreateResponseDto> response = new ResponseEntity<>(responseDto , HttpStatus.OK);
            return response;
    }
}
