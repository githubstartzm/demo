package com.ali.superz.service.impl;


import com.ali.common.util.EntityForm.UserEntity;
import com.ali.superz.dao.UserMapper;
import com.ali.superz.service.UserService;
import com.ali.superz.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean userRegister(UserEntity userEntity) {
        if (null != userMapper.getUserIdByUsername(userEntity.getUsername())) {
            return false;
        }
        UUID uuid = UUID.randomUUID();
        userEntity.setUserId(uuid.toString());
        userEntity.setPassword(MD5Utils.encodeByMD5(userEntity.getPassword()));
        userEntity.setStatus("NORMAL");
        System.out.println(userEntity.getPassword().length());
        Integer result = userMapper.userRegister(userEntity);
        boolean flag = false;
        if (result != null && result > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public Boolean userLogin(UserEntity userEntity) {
        UserEntity user = userMapper.getUserByUsername(userEntity.getUsername());
        return MD5Utils.encodeByMD5(userEntity.getPassword()).equals(user.getPassword());
    }


}
