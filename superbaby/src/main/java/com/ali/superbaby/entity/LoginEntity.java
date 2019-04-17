/* Copyright (C) 2019-2019 Hangzhou HSH Co. Ltd.
 * All right reserved.*/
package com.ali.superbaby.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ThatMan
 * @date 2019-04-10 11:47
 * @desc 用户
 */
@Data
public class LoginEntity implements Serializable {
    private String userid;
    private String phone;
    private String address;
    private String email;
    private String age;
    private String sex;
    private String birthday;
}
