package com.jwtsample.repositories;

import com.jwtsample.dtos.BasicUserInfoDTO;
import com.jwtsample.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsernameAndAccessId(String username, String accessId);
    Optional<User> findUserByUsername(String username);
    @Query("SELECT new com.jwtsample.dtos.BasicUserInfoDTO(user.id, user.username) FROM User user")
    List<BasicUserInfoDTO> findAllUsersWithBasicInfo();
}
