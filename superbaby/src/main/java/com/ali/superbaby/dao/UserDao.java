/* Copyright (C) 2019-2019 Hangzhou HSH Co. Ltd.
 * All right reserved.*/
package com.ali.superbaby.dao;


import com.ali.superbaby.entity.LoginEntity;
import com.ali.superbaby.form.LoginForm;

/**
 * @author ThatMan
 * @date 2019-04-10 11:53
 * @desc
 */
public interface UserDao {
    LoginEntity login(LoginForm loginForm);
}
