package com.basic.insta.domain.service;

import com.basic.insta.config.PasswordEncoder;
import com.basic.insta.domain.entity.User;
import com.basic.insta.domain.dto.user.UserCreateRequestDto;
import com.basic.insta.domain.dto.user.UserCreateResponseDto;
import com.basic.insta.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    // 속성
    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;

    // 생성자
    public UserService(PasswordEncoder passwordEncoder, UserRepository repository) {
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
    }

    // 기능
    /**
     * 회원가입 기능
     */
    @Transactional
    public UserCreateResponseDto CreateUserService(UserCreateRequestDto requestDto) {
        String userEmail = requestDto.getUserEmail();
        String encodePassword = passwordEncoder.encode(requestDto.getPassword());
        String userName = requestDto.getUserName();
        String content = requestDto.getContent();

        if (repository.findByUserEmail(userEmail).isPresent()) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        } else {
            User foundUser = new User(userEmail, encodePassword, userName, content);
            User saveUser = repository.save(foundUser);
            UserCreateResponseDto responseDto = new UserCreateResponseDto(saveUser);
            return responseDto;
        }
    }
}
