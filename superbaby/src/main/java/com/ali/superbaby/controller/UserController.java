/* Copyright (C) 2019-2019 Hangzhou HSH Co. Ltd.
 * All right reserved.*/
package com.ali.superbaby.controller;


import com.ali.common.util.Result;
import com.ali.superbaby.form.LoginForm;
import com.ali.superbaby.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ThatMan
 * @date 2019-04-10 9:22
 * @desc
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Result login(LoginForm loginForm) {
        boolean flag = userService.login(loginForm);
        return flag ? Result.ok("登录成功") : Result.error("用户名或者密码错误");
    }
}
