package com.basic.insta.domain.dto.user;

import com.basic.insta.domain.entity.User;

import java.time.LocalDateTime;

public class UserUpdateResponseDto {
    // 속성
    private Long userId;
    private String userEmail;
    private String userName;
    private String content;
    private LocalDateTime cratedAt;
    private LocalDateTime updatedAt;

    // 생성자
    public UserUpdateResponseDto(User user) {
        this.userId = user.getUserId();
        this.userEmail = user.getUserEmail();
        this.userName = user.getUserName();
        this.content = user.getContent();
        this.cratedAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
    }

    // 기능
    // 게터
    public Long getUserId() {
        return userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCratedAt() {
        return cratedAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
