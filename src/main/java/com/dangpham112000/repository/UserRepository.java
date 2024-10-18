package com.dangpham112000.repository;

import com.dangpham112000.entity.user.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserNameAndUserEmail(String userName, String userEmail);

    Page<UserEntity> findByUserName(String name, Pageable pageable);
    Page<UserEntity> findByUserNameContaining(String name, Pageable pageable);
}



