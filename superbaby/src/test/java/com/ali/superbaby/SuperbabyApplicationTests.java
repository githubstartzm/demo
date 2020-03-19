package com.ali.superbaby;

import com.ali.superbaby.entity.UserEntity;
import com.ali.superbaby.form.LoginForm;
import com.ali.superbaby.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SuperbabyApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
//        UserEntity userEntity = new UserEntity();
//        userEntity.set
//        userService.userRegister();


        LoginForm loginForm = new LoginForm();
        loginForm.setUsername("章大大");
        loginForm.setPassword("123");
        boolean login = userService.login(loginForm);
        System.out.println(login);
    }

}
