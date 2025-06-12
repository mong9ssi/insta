package com.basic.insta.domain.dto.user;

public class UpdateUserPasswordResponseDto {
    // 속성
    private String message;

    // 생성자
    public UpdateUserPasswordResponseDto(String message) {
        this.message = message;
    }

    // 기능
    // 게터
    public String getMessage() {
        return message;
    }
}
