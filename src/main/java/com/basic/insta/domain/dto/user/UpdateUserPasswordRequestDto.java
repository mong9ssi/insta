package com.basic.insta.domain.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UpdateUserPasswordRequestDto {
    // 속성
    @NotBlank(message = "비밀번호는 필수 입력 값 입니다.")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[~`!@#$%^&*()\\-_=+\\[\\]{};:'\",.<>/?\\\\|]).{8,}$",
            message = "비밀번호는 최소 8자, 영문 대소문자, 숫자, 특수문자를 포함해야 합니다."
    )
    private String password;

    @NotBlank(message = "새로운 비밀번호는 필수 입력 값 입니다.")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[~`!@#$%^&*()\\-_=+\\[\\]{};:'\",.<>/?\\\\|]).{8,}$",
            message = "비밀번호는 최소 8자, 영문 대소문자, 숫자, 특수문자를 포함해야 합니다."
    )
    private String newPassword;


    // 생성자

    // 기능
    // 게터
    public String getPassword() {
        return password;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
