package com.ssmTest;

import com.alibaba.fastjson.JSONArray;
import com.ssmTest.model.Account;
import com.ssmTest.model.Student;
import com.ssmTest.service.AccountService;
import com.ssmTest.service.StudentService;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class SelectTest {
    @Autowired
    private StudentService studentService;
    @Autowired
    private AccountService accountService;

    @Test
    public void studentTest() {
        Student student = studentService.selectByAccountId(1);
        System.out.println(student);
    }


    @Test
    /**
     * 查询账号完整绑定学生信息
     * 关联映射测试
     */
    public void userTest() {
        System.out.println(accountService.selectById(1));
    }

    @Test
    public void fastjsonTest() {
        Map<Object, Object> map = new HashMap<>();
        map.put("student", new Account("123", "123"));
        String string = JSONArray.toJSONString(map);
        System.out.println(string);

    }
}
