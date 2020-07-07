package com.ssmTest.model;

import lombok.Data;

/**
 * 用户信息
 */
@Data
public class Student {
    private Integer id;
    private Integer studentNumber;
    private String name;
    private String major;
    private String collage;
    private Long birthday;
    private String email;
    private String sex;
    private Integer accountId;
}
