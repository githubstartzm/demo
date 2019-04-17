package com.ali.superz.service;


import com.ali.superz.entity.UserEntity;

public interface UserService {
    Boolean userRegister(UserEntity userEntity);

    Boolean userLogin(UserEntity userEntity);
}
