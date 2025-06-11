package com.basic.insta.domain.service;

import com.basic.insta.domain.repository.AuthRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    // 속성
    private AuthRepository repository;

    // 생성자
    public AuthService(AuthRepository repository) {
        this.repository = repository;
    }

    // 기능
    // 게터

}
