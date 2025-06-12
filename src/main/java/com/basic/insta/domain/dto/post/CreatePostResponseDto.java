package com.basic.insta.domain.dto.post;

import com.basic.insta.domain.entity.Post;
import org.springframework.objenesis.SpringObjenesis;

import java.time.LocalDateTime;

public class CreatePostResponseDto {
    // 속성
    private Long userId;
    private Long postId;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 생성자
    public CreatePostResponseDto(Post post) {
        this.userId = post.getUser().getUserId();
        this.postId = post.getPostId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.createdAt = post.getCreatedAt();
        this.updatedAt = post.getUpdatedAt();
    }


    // 기능
    // 게터
    public Long getUserId() {
        return userId;
    }

    public Long getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
