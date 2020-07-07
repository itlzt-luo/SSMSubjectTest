package com.ssmTest.service;

import com.ssmTest.mapper.StudentMapper;
import com.ssmTest.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
    public Student selectByAccountId(int accountId) {
        return studentMapper.selectByAccountId(accountId);
    }
}
