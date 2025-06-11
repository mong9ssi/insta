package com.basic.insta.domain.service;

import com.basic.insta.config.PasswordEncoder;
import com.basic.insta.domain.dto.user.*;
import com.basic.insta.domain.entity.User;
import com.basic.insta.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public UserCreateResponseDto createUserService(UserCreateRequestDto requestDto) {
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

    /**
     * 회원 조회 기능
     */
    public UserGetDetailResponseDto getDetailUserService(Long userId) {
        Optional<User> optionalUser = repository.findById(userId);
        if (optionalUser.isPresent()) {
            User foundUser = optionalUser.get();
            UserGetDetailResponseDto responseDto = new UserGetDetailResponseDto(foundUser);
            return responseDto;
        } else {
            throw new IllegalArgumentException("회원이 존재하지 않습니다.");
        }
    }

    /**
     * 회원 정보 수정 기능
     */
    public UserUpdateResponseDto updateUserService(Long userId, UserUpdateRequestDto requestDto) {
        Optional<User> optionalUser = repository.findById(userId);
        if (optionalUser.isPresent()) {
            String userEmail = requestDto.getUserEmail();
            String password = requestDto.getPassword();
            User foundUser = optionalUser.get();
            if (foundUser.getUserEmail().equals(userEmail) && passwordEncoder.matches(password, foundUser.getPassword())) {
                foundUser.updateUser(requestDto);
                UserUpdateResponseDto responseDto = new UserUpdateResponseDto(foundUser);
                return responseDto;
            } else {
                throw new IllegalArgumentException("이메일 또는 비밀번호가 맞지 않습니다.");
            }
        } else {
            throw new IllegalArgumentException("회원이 존재하지 않습니다.");
        }
    }

}
