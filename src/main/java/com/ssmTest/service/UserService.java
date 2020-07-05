package com.ssmTest.service;

import com.ssmTest.mapper.UserMapper;
import com.ssmTest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;


    //添加数据
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    //批量添加数据
    public void batchUser(List<User> userList) {
        for (User user : userList) {
            userMapper.insertUser(user);
        }
    }

}
