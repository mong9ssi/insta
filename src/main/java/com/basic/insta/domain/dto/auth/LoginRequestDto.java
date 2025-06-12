package com.basic.insta.domain.dto.auth;

public class LoginRequestDto {
    // 속성
    private String userEmail;
    private String password;

    // 생성자

    // 기능
    // 게터
    public String getUserEmail() {
        return userEmail;
    }

    public String getPassword() {
        return password;
    }
}
