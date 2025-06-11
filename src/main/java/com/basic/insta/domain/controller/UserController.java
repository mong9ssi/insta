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
    public ResponseEntity<?> createUserAPI(@Valid @RequestBody CreateUserRequestDto requestDto) {
        try {
            CreateUserResponseDto responseDto = service.createUserService(requestDto);
            ResponseEntity<CreateUserResponseDto> response = new ResponseEntity<>(responseDto , HttpStatus.OK);
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
            GetDetailUserResponseDto responseDto = service.getDetailUserService(userId);
            ResponseEntity<GetDetailUserResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
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
            @Valid @RequestBody UpdateUserRequestDto requestDto
    ) {
        try {
            UpdateUserResponseDto responseDto = service.updateUserService(userId, requestDto);
            ResponseEntity<UpdateUserResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
            return response;
        } catch (IllegalArgumentException e) {
            ResponseEntity<String> response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            return response;
        }
    }

    /**
     * 비밀번호 수정 API
     */
    @PatchMapping("/password/{userId}")
    public ResponseEntity<?> updateUserPasswordAPI(
            @PathVariable("userId") Long userId,
            @Valid @RequestBody UpdateUserPasswordRequestDto requestDto
    ) {
        try {
            UpdateUserPasswordResponseDto responseDto = service.updateUserPasswordService(userId, requestDto);
            ResponseEntity<UpdateUserPasswordResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
            return response;
        } catch (IllegalArgumentException e) {
            ResponseEntity<String> response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            return response;
        }

    }

    /**
     * 회원 탈퇴 API
     */
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUserAPI(
            @PathVariable("userId") Long userId,
            @Valid @RequestBody DeleteUserRequestDto requestDto
    ) {
        try {
            DeleteUserResponseDto responseDto = service.deleteUserService(userId, requestDto);
            ResponseEntity<DeleteUserResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
            return response;
        } catch (IllegalArgumentException e) {
            ResponseEntity<String> response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            return response;
        }
    }
}
