package com.basic.insta.domain.dto.user;

public class UserUpdateRequestDto {
    // 속성
    private String userEmail;
    private String password;
    private String userName;
    private String content;

    // 생성자

    // 기능
    // 게터
    public String getUserEmail() {
        return userEmail;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public String getContent() {
        return content;
    }
}
