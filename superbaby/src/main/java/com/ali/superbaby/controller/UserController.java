/* Copyright (C) 2019-2019 Hangzhou HSH Co. Ltd.
 * All right reserved.*/
package com.ali.superbaby.controller;


import com.ali.common.util.Result;
import com.ali.common.util.ValidatorUtils;
import com.ali.superbaby.entity.UserEntity;
import com.ali.superbaby.form.LoginForm;
import com.ali.superbaby.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Result login(@RequestBody LoginForm loginForm) {
        boolean flag = userService.login(loginForm);
        return flag ? Result.ok("登录成功") : Result.error("用户名或者密码错误");
    }

    /**
     * 用户注册
     *
     * @param userEntity
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result userRegister(@RequestBody UserEntity userEntity) {
        ValidatorUtils.validateEntity(userEntity);
        boolean flag = userService.userRegister(userEntity);
        return flag ? Result.ok("注册成功") : Result.error("注册失败");
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public Result login() {
        return  Result.ok("启动成功");
    }
}
