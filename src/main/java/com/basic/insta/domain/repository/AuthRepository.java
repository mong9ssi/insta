package com.basic.insta.domain.repository;

import com.basic.insta.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<User, Long> {
}
