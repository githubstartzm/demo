/* Copyright (C) 2019-2019 Hangzhou HSH Co. Ltd.
 * All right reserved.*/
package com.ali.superbaby.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author ThatMan
 * @date 2019-04-10 11:46
 * @desc 用户登录实体类
 */
@Data
public class LoginForm implements Serializable {
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "用户名不能为空")
    private String password;
}
