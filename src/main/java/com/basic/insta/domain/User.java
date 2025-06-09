package com.basic.insta.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User extends BaseEntity{
    // 속성
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String content;

    // 생성자
    /**
     * 기본 생성자 ( JPA에서 사용 )
     */
    public User() {}

    // 기능
    // 게터
    public Long getUserId() {
        return userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public String getContent() {
        return content;
    }
}
