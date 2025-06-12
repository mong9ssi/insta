package com.basic.insta.domain.repository;

import com.basic.insta.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserEmail(String userEmail);
}
