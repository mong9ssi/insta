package com.basic.insta.domain.controller;

import com.basic.insta.domain.dto.post.CreatePostRequestDto;
import com.basic.insta.domain.service.PostService;
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

    // 생성자
    public PostController(PostService service) {
        this.service = service;
    }

    // 기능
    /**
     * 뉴스피드 생성 API
     */
    @PostMapping
    public ResponseEntity<?> createPostAPI (@RequestBody CreatePostRequestDto requestDto) {
        ResponseEntity<String> response = new ResponseEntity<>("success", HttpStatus.OK);
        return response;
    }
}
