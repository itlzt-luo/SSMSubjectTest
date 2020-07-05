package com.ssmTest;

import com.ssmTest.model.User;
import com.ssmTest.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class UserInsertTest {
    @Autowired
    private UserService userService;

    @Test
    public void insertTest() {
        userService.insertUser(new User("李华", "123456", "男", "1234@qq.com"));
    }

    @Test
    public void batchUser() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            users.add(new User("李华", "123456", "男", "1234@qq.com"));
        }
        userService.batchUser(users);
    }


}
