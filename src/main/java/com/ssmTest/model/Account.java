package com.ssmTest.model;

import lombok.Data;

/**
 * 账户
 */
@Data
public class Account {
    private Integer id;
    private String loginName;
    private String password;

    public Account(String loginName, String password) {
        this.loginName = loginName;
        this.password = password;
    }
}
