package com.basic.insta.domain.controller;

import com.basic.insta.domain.dto.post.CreatePostRequestDto;
import com.basic.insta.domain.dto.post.CreatePostResponseDto;
import com.basic.insta.domain.service.JwtService;
import com.basic.insta.domain.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {
    // 속성
    private final PostService service;
    private final JwtService jwtService;

    // 생성자
    public PostController(PostService service, JwtService jwtService) {
        this.service = service;
        this.jwtService = jwtService;
    }

    // 기능
    /**
     * 뉴스피드 생성 API
     */
    @PostMapping
    public ResponseEntity<?> createPostAPI (HttpServletRequest request, @RequestBody CreatePostRequestDto requestDto) {

        // 1. 헤더에서 토큰 추출
        String authHeader = request.getHeader("Authorization");
        String token = authHeader.substring(7);

        // 2. 토큰 검증
        Long userId = jwtService.verifyToken(token);

        try{
            CreatePostResponseDto responseDto = service.createPostService(userId, requestDto);
            ResponseEntity<CreatePostResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
            return response;
        } catch (RuntimeException e) {
            ResponseEntity<String> response = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            return response;
        }

    }
}
