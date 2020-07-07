package com.ssmTest.mapper;

import com.ssmTest.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper {

    /**
     * 根据账户ID查询绑定学生信息
     * @param accountId
     * @return
     */
    Student selectByAccountId(Integer accountId);
}
