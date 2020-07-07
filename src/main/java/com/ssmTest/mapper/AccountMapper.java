package com.ssmTest.mapper;

import com.ssmTest.model.Account;
import com.ssmTest.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper {

    /**
     * 查找
     * @param account
     * @return
     */
    Account selectByPassword(Account account);

    /**
     * 查询账户完整信息
     * @param id
     * @return
     */
    User selectById(Integer id);



}
