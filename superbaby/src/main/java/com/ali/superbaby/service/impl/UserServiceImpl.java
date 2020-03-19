/* Copyright (C) 2019-2019 Hangzhou HSH Co. Ltd.
 * All right reserved.*/
package com.ali.superbaby.service.impl;

import com.ali.common.util.EncryptUtil;
import com.ali.superbaby.dao.UserDao;
import com.ali.superbaby.entity.LoginEntity;
import com.ali.superbaby.entity.UserEntity;
import com.ali.superbaby.form.LoginForm;
import com.ali.superbaby.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        //通过手机号作为盐对密码进行加密
        EncryptUtil.getPassword(userEntity.getPassword(), userEntity.getPhone());
        int result = userDao.userRegister(userEntity);
        return result == 0 ? false : true;
    }

    @Override
    public boolean login(LoginForm loginForm) {
        LoginForm login = userDao.login(loginForm);
        if (login == null) {
            return false;
        }
        return true;
    }
}
