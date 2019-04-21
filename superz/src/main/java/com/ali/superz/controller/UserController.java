package com.ali.superz.controller;



import com.ali.common.util.EntityForm.UserEntity;
import com.ali.common.util.Result;
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

    /**
     *  用户注册
     * @param userEntity
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public Result userRegister(@RequestBody UserEntity userEntity, BindingResult bindingResult) {


        ValidatorUtils.validateEntity(userEntity);
        Boolean flag = userService.userRegister(userEntity);
        return  flag ? Result.ok("success") : Result.error("failed");
    }

    /**
     * 用户登录
     * @param userEntity
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result userLogin(@RequestBody UserEntity userEntity, BindingResult bindingResult) {
        Boolean flag = userService.userLogin(userEntity);
        return flag ? Result.ok(): Result.error("");
    }

}
