package com.basic.insta.domain.controller;

import com.basic.insta.domain.dto.user.*;
import com.basic.insta.domain.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 회원 가입 API
     */
    @PostMapping
    public ResponseEntity<?> createUserAPI(@Valid @RequestBody UserCreateRequestDto requestDto) {
        try {
            UserCreateResponseDto responseDto = service.createUserService(requestDto);
            ResponseEntity<UserCreateResponseDto> response = new ResponseEntity<>(responseDto , HttpStatus.OK);
            return response;
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * 회원 조회 API
     */
    @GetMapping("/{userId}")
    public ResponseEntity<?> getDetailUserAPI(@PathVariable("userId") Long userId) {
        try {
            UserGetDetailResponseDto responseDto = service.getDetailUserService(userId);
            ResponseEntity<UserGetDetailResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
            return response;
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * 회원 정보 수정 API
     */
    @PatchMapping("/{userId}")
    public ResponseEntity<?> updateUserAPI(
            @PathVariable("userId") Long userId,
            @Valid @RequestBody UserUpdateRequestDto requestDto
    ) {
        try {
            UserUpdateResponseDto responseDto = service.updateUserService(userId, requestDto);
            ResponseEntity<UserUpdateResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
            return response;
        } catch (IllegalArgumentException e) {
            ResponseEntity<String> response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            return response;
        }
    }

}
