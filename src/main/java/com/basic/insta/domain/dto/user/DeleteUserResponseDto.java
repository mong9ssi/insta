package com.basic.insta.domain.dto.user;

public class DeleteUserResponseDto {
    // 속성
    private String message;

    // 생성자
    public DeleteUserResponseDto(String message) {
        this.message = message;
    }

    // 기능
    // 게터
    public String getMessage() {
        return message;
    }
}
