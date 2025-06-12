package com.basic.insta.domain.service;

import com.basic.insta.domain.dto.post.CreatePostRequestDto;
import com.basic.insta.domain.entity.Post;
import com.basic.insta.domain.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    // 속성
    private final PostRepository repository;

    // 생성자
    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    // 기능
    public void createPostService(CreatePostRequestDto requestDto) {
        Post foundPost = new Post(requestDto);
        Post savePost = repository.save(foundPost);
    }

}
