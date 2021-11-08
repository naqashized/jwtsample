package com.jwtsample.repositories;

import com.jwtsample.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsernameAndAccessId(String username, String accessId);
    Optional<User> findUserByUsername(String username);
}
