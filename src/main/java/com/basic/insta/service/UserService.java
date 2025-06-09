package com.basic.insta.service;

import com.basic.insta.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    // 속성
    private final UserRepository repository;

    // 생성자
    public UserService(UserRepository repository) {
        this.repository = repository;
    }
}
