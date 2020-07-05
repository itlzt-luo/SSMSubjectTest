package com.ssmTest.mapper;

import com.ssmTest.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    //添加数据
    int insertUser(User user);

}
