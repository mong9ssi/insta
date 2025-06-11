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
    public CreateUserResponseDto createUserService(CreateUserRequestDto requestDto) {
        String userEmail = requestDto.getUserEmail();
        String encodePassword = passwordEncoder.encode(requestDto.getPassword());
        String userName = requestDto.getUserName();
        String content = requestDto.getContent();

        if (repository.findByUserEmail(userEmail).isPresent()) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        } else {
            User foundUser = new User(userEmail, encodePassword, userName, content);
            User saveUser = repository.save(foundUser);
            CreateUserResponseDto responseDto = new CreateUserResponseDto(saveUser);
            return responseDto;
        }
    }

    /**
     * 회원 조회 기능
     */
    public GetDetailUserResponseDto getDetailUserService(Long userId) {
        Optional<User> optionalUser = repository.findById(userId);
        if (optionalUser.isPresent()) {
            User foundUser = optionalUser.get();
            GetDetailUserResponseDto responseDto = new GetDetailUserResponseDto(foundUser);
            return responseDto;
        } else {
            throw new IllegalArgumentException("회원이 존재하지 않습니다.");
        }
    }

    /**
     * 회원 정보 수정 기능
     */
    @Transactional
    public UpdateUserResponseDto updateUserService(Long userId, UpdateUserRequestDto requestDto) {
        Optional<User> optionalUser = repository.findById(userId);
        if (optionalUser.isPresent()) {
            String userEmail = requestDto.getUserEmail();
            String password = requestDto.getPassword();
            User foundUser = optionalUser.get();
            if (foundUser.getUserEmail().equals(userEmail) && passwordEncoder.matches(password, foundUser.getPassword())) {
                foundUser.updateUser(requestDto);
                UpdateUserResponseDto responseDto = new UpdateUserResponseDto(foundUser);
                return responseDto;
            } else {
                throw new IllegalArgumentException("이메일 또는 비밀번호가 맞지 않습니다.");
            }
        } else {
            throw new IllegalArgumentException("회원이 존재하지 않습니다.");
        }
    }

    /**
     * 비밀번호 수정 기능
     */
    @Transactional
    public UpdateUserPasswordResponseDto updateUserPasswordService(Long userId, UpdateUserPasswordRequestDto requestDto) {
        Optional<User> optionalUser = repository.findById(userId);
        if (optionalUser.isPresent()) {
            String password = requestDto.getPassword();
            String newPassword = requestDto.getNewPassword();
            User foundUser = optionalUser.get();
            if (password.equals(newPassword)) {
                throw new IllegalArgumentException("동일한 비밀번호로 수정 불가능합니다.");
            }
            if (passwordEncoder.matches(password, foundUser.getPassword())) {
                foundUser.updateUserPassword(passwordEncoder.encode(newPassword));
                UpdateUserPasswordResponseDto responseDto = new UpdateUserPasswordResponseDto("비밀번호 변경 성공");
                return responseDto;
            } else {
                throw new IllegalArgumentException("비밀번호가 올바르지 않습니다.");
            }
        } else {
            throw new IllegalArgumentException("회원이 존재하지 않습니다.");
        }
    }
}
