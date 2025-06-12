package com.basic.insta.domain.service;

import com.basic.insta.config.PasswordEncoder;
import com.basic.insta.domain.dto.auth.LoginRequestDto;
import com.basic.insta.domain.entity.User;
import com.basic.insta.domain.repository.AuthRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    // 속성
    private AuthRepository repository;
    private PasswordEncoder passwordEncoder;

    // 생성자
    public AuthService(AuthRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    // 기능
    /**
     * 로그인 기능
     */
    public String loginService(LoginRequestDto requestDto) {
        String userEmail = requestDto.getUserEmail();
        String password = requestDto.getPassword();

        User foundUser = repository.findByUserEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));

        if (!passwordEncoder.matches(password, foundUser.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        } else {
            return "로그인 성공";
        }
    }

    /**
     * 로그아웃 기능
     */
    public String logoutService(String userEmail) {
        User user = repository.findByUserEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 사용자입니다."));
        return "로그아웃 성공";
    }

}
