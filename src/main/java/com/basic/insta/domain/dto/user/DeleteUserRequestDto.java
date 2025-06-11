package com.basic.insta.domain.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class DeleteUserRequestDto {
    // 속성
    @NotBlank(message = "이메일은 필수 입렵 값 입니다.")
    @Email(message = "유효한 이메일 형식이 아닙니다.")
    private String userEmail;

    @NotBlank(message = "비밀번호는 필수 입력 값 입니다.")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[~`!@#$%^&*()\\-_=+\\[\\]{};:'\",.<>/?\\\\|]).{8,}$",
            message = "비밀번호는 최소 8자, 영문 대소문자, 숫자, 특수문자를 포함해야 합니다."
    )
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
