/* Copyright (C) 2019-2019 Hangzhou HSH Co. Ltd.
 * All right reserved.*/
package com.ali.superbaby.service.impl;

import com.ali.superbaby.dao.UserDao;
import com.ali.superbaby.entity.LoginEntity;
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
    public boolean login(LoginForm loginForm) {
        LoginEntity loginEntity = userDao.login(loginForm);
        if (loginEntity == null) {
            return false;
        }
        return true;
    }
}
