package com.ali.common.util.entityForm;

import org.hibernate.validator.constraints.Length;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserEntity {
    private String userId;

    @NotBlank(message = "username not be null")
    @Length(min = 6, max = 32, message = "the username length should be 6 - 32")
    @Pattern(regexp = "^[0-9a-zA-Z_]{1,}$", message = "username must be English, Number or _")
    @Valid
    private String username;

    @NotBlank(message = "password not be null")
    @Length(min = 8, max = 36, message = "the password length should be 8 - 36")
    @Valid
    private String password;

    @NotBlank(message = "phone number not be null")
    @Pattern(regexp =  "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0-9])|(18[0-9])|166|198|199|147)\\d{8}$",message = "请输入正确的手机号")
    @Valid
    private String phone;

    private String email;

    private String adress;

    private String idCard;

    private String status;

    public UserEntity() {
    }

    public UserEntity(String userId, String username, String password, String phone, String email, String adress, String idCard, String status) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.adress = adress;
        this.idCard = idCard;
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
