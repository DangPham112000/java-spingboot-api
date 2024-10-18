package com.dangpham112000.service;

import com.dangpham112000.entity.user.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserEntity createUser(UserEntity user);

    UserEntity findByUserNameAndUserEmail(String userName, String userEmail);

    // get all by limit offet
    Page<UserEntity> findAllUsers(Pageable pageable);

    // get search by limit offet
    Page<UserEntity> findByUserName(String userName, Pageable pageable);
}
