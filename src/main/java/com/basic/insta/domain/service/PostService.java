package com.basic.insta.domain.service;

import com.basic.insta.domain.dto.post.CreatePostRequestDto;
import com.basic.insta.domain.dto.post.CreatePostResponseDto;
import com.basic.insta.domain.entity.Post;
import com.basic.insta.domain.entity.User;
import com.basic.insta.domain.repository.PostRepository;
import com.basic.insta.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    // 속성
    private final PostRepository repository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    // 생성자
    public PostService(PostRepository repository, UserRepository userRepository, PostRepository postRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    // 기능
    /**
     * 게시물 생성 기능
     */
    public CreatePostResponseDto createPostService(Long userId, CreatePostRequestDto requestDto) {
        User foundUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("로그인 후 이용가능합니다."));
        Post foundPost = new Post(foundUser, requestDto);
        postRepository.save(foundPost);
        CreatePostResponseDto responseDto = new CreatePostResponseDto(foundPost);
        return responseDto;
    }

}
