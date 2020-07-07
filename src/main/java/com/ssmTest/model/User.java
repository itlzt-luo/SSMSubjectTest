package com.ssmTest.model;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String loginName;
    private String password;
    private Student student;
}
