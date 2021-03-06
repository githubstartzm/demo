package com.ali.superz.dao;

import com.ali.superz.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    Integer userRegister(UserEntity userEntity);

    String getUserIdByUsername(String username);

    UserEntity getUserByUsername(String username);
}
