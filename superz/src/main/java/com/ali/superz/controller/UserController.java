package com.ali.superz.controller;


import com.ali.superz.entity.Result;
import com.ali.superz.entity.UserEntity;
import com.ali.superz.service.UserService;
import com.ali.superz.utils.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * 用户接口
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    //用户注册
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Result userRegister(@Valid @RequestBody UserEntity userEntity, BindingResult bindingResult) {

      /*if (bindingResult.hasErrors()) {
            return new ResultEntity(400,bindingResult.getAllErrors().get(0).getDefaultMessage());
        }

        if(userService.userRegister(userEntity)){
            return new ResultEntity(200,"register success");
        }

        return new ResultEntity(400,"register failed");*/

        ValidatorUtils.validateEntity(userEntity);
        Boolean flag = userService.userRegister(userEntity);
        return  flag ? Result.ok("success") : Result.error("failed");
    }

    //用户注册
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result userLogin(@Validated @RequestBody UserEntity userEntity, BindingResult bindingResult) {
        Boolean flag = userService.userLogin(userEntity);
        return flag ? Result.ok(): Result.error("");
    }

}
