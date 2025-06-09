package com.basic.insta.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity{
    // 속성
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "user_id", nullable = false)
    private User user;

    @Column (nullable = false)
    private String title;

    @Column (nullable = false)
    private String content;

    @Column (nullable = false)
    private String userName;

    // 생성자
    /**
     * 기본 생성자 ( JPA에서 사용 )
     */
    public Post() {}


    // 기능
    // 게터
    public Long getPostId() {
        return postId;
    }

    public User getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getUserName() {
        return userName;
    }
}
