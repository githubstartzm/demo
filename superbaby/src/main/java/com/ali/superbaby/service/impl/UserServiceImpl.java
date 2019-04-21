/* Copyright (C) 2019-2019 Hangzhou HSH Co. Ltd.
 * All right reserved.*/
package com.ali.superbaby.service.impl;

import com.ali.common.util.EntityForm.UserEntity;
import com.ali.superbaby.dao.UserDao;
import com.ali.superbaby.entity.LoginEntity;
import com.ali.superbaby.form.LoginForm;
import com.ali.superbaby.service.UserService;
import com.ali.superbaby.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author ThatMan
 * @date 2019-04-10 11:51
 * @desc 用户
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean userRegister(UserEntity userEntity) {
        if (null != userDao.getUserIdByUsername(userEntity.getUsername())) {
            return false;
        }
        UUID uuid = UUID.randomUUID();
        userEntity.setUserId(uuid.toString());
        userEntity.setPassword(MD5Utils.encodeByMD5(userEntity.getPassword()));
        userEntity.setStatus("NORMAL");
        System.out.println(userEntity.getPassword().length());
        Integer result = userDao.userRegister(userEntity);
        boolean flag = false;
        if (result != null && result > 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean login(LoginForm loginForm) {
        LoginEntity loginEntity = userDao.login(loginForm);
        if (loginEntity == null) {
            return false;
        }
        return true;
    }
}
