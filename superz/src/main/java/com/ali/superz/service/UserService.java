package com.ali.superz.service;


import com.ali.common.util.entityForm.UserEntity;

public interface UserService {
    Boolean userRegister(UserEntity userEntity);

    Boolean userLogin(UserEntity userEntity);
}
