package com.closet.SE8.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.closet.SE8.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
    Optional<UserEntity> findByUserId(String userId);
}
