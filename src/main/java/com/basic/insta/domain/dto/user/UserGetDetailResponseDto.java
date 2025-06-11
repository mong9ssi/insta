package com.basic.insta.domain.dto.user;

import com.basic.insta.domain.entity.User;

import java.time.LocalDateTime;

public class UserGetDetailResponseDto {
    // 속성
    private String userName;
    private String content;
    private LocalDateTime updatedAt;

    // 생성자
    public UserGetDetailResponseDto(User user) {
        this.userName = user.getUserName();
        this.content = user.getContent();
        this.updatedAt = user.getUpdatedAt();
    }

    // 기능
    // 게터
    public String getUserName() {
        return userName;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

}
