package com.ssmTest.model;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private String sex;
    private String email;

    public User(String name, String password, String sex, String email) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.email = email;
    }
}
