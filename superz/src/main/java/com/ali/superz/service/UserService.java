package com.ali.superz.service;


import com.ali.common.util.EntityForm.UserEntity;

public interface UserService {
    Boolean userRegister(UserEntity userEntity);

    Boolean userLogin(UserEntity userEntity);
}
