package com.ali.superbaby.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import static com.ali.superbaby.constant.Constant.REGEX_PHONE;
import static com.ali.superbaby.constant.Constant.REGEX_USERNAME;

@Data
public class UserEntity {
    private String userId;

    @Pattern(regexp = REGEX_USERNAME, message = "请输入正确的用户名")
    private String username;

    @Length(min = 8, max = 36, message = "请输入正确的密码")
    private String password;

    @Pattern(regexp = REGEX_PHONE, message = "请输入正确的手机号")
    private String phone;

    private String email;

    private String adress;

    private String idCard;

    private String status;

}
